import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.io.input.NullInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.zip.Deflater;

public class ZipCompressorDemo {

    /**
     * 压缩文件夹
     *
     * @param zipArchiveOutputStream zip输出路径
     * @param paths      将要压缩的路径
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void compressFiles(ZipArchiveOutputStream zipArchiveOutputStream, String... paths) throws Exception {
//        创建一个线程池对象
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
//        压缩等级默认为速度优先
        compressFiles(zipArchiveOutputStream, executor, Deflater.BEST_SPEED, paths);
    }

    public static void main(String[] args) throws Exception {

        ZipArchiveOutputStream zipArchiveOutputStream=new ZipArchiveOutputStream(new FileOutputStream("E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1"));
        String filePath="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        long begin = System.currentTimeMillis();
        compressFiles(zipArchiveOutputStream,filePath);
        long end = System.currentTimeMillis();
        System.out.println((end-begin));
    }

    /**
     * 自定义线程池
     *
     * @param zipArchiveOutputStream
     * @param executorService 线程池实现对象
     * @param paths
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void compressFiles(ZipArchiveOutputStream zipArchiveOutputStream, ExecutorService executorService, int level, String... paths) throws IOException, ExecutionException, InterruptedException {
//      创建用于多线程压缩文件的对象
        ParallelScatterZipCreator parallelScatterZipCreator = new ParallelScatterZipCreator(executorService);

//        设置压缩等级
        zipArchiveOutputStream.setLevel(level);
//        设置压缩的字符编码
        zipArchiveOutputStream.setEncoding("UTF-8");
//        循环压缩各个路径的文件
        for (String path : paths) {
            File temp = new File(path);
            compress(parallelScatterZipCreator, temp, temp.getName());
        }
//        将数据写入zip输出流
        parallelScatterZipCreator.writeTo(zipArchiveOutputStream);
//        相关流的关闭
       /* zipArchiveOutputStream.close();
        outputStream.close();*/
    }

    /**
     * 自定义线程创建工厂
     *
     * @param zipOutName
     * @param factory    线程创建工厂
     * @param level      压缩等级
     * @param paths
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void compressFiles(ZipArchiveOutputStream zipOutName, ThreadFactory factory, int level, String... paths) throws IOException, ExecutionException, InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), factory, new ThreadPoolExecutor.CallerRunsPolicy());
        compressFiles(zipOutName, executor, level, paths);
    }


    /**
     * 遍历压缩
     *
     * @param parallelScatterZipCreator 线程池压缩对象
     * @param inputFile                 将要压缩的文件路径,绝对路径
     * @param relativePath              相对与压缩包内的路径
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    protected static void compress(ParallelScatterZipCreator parallelScatterZipCreator, File inputFile, String relativePath) throws IOException, ExecutionException, InterruptedException {
//        文件流为空，返回
        if (inputFile == null) {
            return;
        }
//        文件为文件夹，递归遍历文件
        if (inputFile.isDirectory()) {
//            获取文件内的所有文件
            File[] files = inputFile.listFiles();
            if (files == null) {
                return;
            }
//            遍历处理文件
            for (File file : files) {
                if (file.isDirectory()) {
                    compress(parallelScatterZipCreator, new File(inputFile.getAbsolutePath() + "/" + file.getName()), relativePath + "/" + file.getName());
                } else {
//                    转化为InputStreamSupplier对象
                    final InputStreamSupplier inputStreamSupplier = () -> {
                        try {
                            return new FileInputStream(file);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            return new NullInputStream(0);
                        }
                    };
//                    添加ZipArchiveEntity对象，这里的构造函数的值，name属性，是相对于zip文件内的路径
                    ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(relativePath + "/" + file.getName());
//                    设置压缩算法
                    zipArchiveEntry.setMethod(ZipArchiveEntry.DEFLATED);
//                    设置未压缩文件的大小
                    zipArchiveEntry.setSize(file.length());
//                    添加添加ZipArchiveEntity对象到多线程压缩中
                    parallelScatterZipCreator.addArchiveEntry(zipArchiveEntry, inputStreamSupplier);
                }
            }
        } else {
//            当是文件时，直接处理
            final InputStreamSupplier inputStreamSupplier = () -> {
                try {
                    return new FileInputStream(inputFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return new NullInputStream(0);
                }
            };
            ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(relativePath + "/" + inputFile.getName());
            zipArchiveEntry.setMethod(ZipArchiveEntry.DEFLATED);
            zipArchiveEntry.setSize(inputFile.length());
            parallelScatterZipCreator.addArchiveEntry(zipArchiveEntry, inputStreamSupplier);
        }
    }
}

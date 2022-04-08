package stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        //文件拷贝
        //创建文件的输入流将文件读入到程序
        //创建文件的输出流将读取到的文件数据写入到指定的文件
        String srcFilePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        String destFilePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\new1.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组提高读取效率
            byte[] bytes = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes,0,readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

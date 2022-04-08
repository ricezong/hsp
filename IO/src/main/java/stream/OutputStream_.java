package stream;

import java.io.*;

/**
 * 输出流相关操作
 */
public class OutputStream_ {

    public static void main(String[] args) {

        OutputStream_ outputStream_=new OutputStream_();
        //FileOutputStream_ fileOutputStream_ = outputStream_.new FileOutputStream_();
        //fileOutputStream_.writeFile();
        outputStream_.new BufferedCopy().copyFile();
    }

    /**
     * 演示FileOutputStream文件输出流的使用
     */
    //在成员内部类中可以无条件访问外部类的任何成员
    class FileOutputStream_{

        /**
         * 演示使用FileOutputStream将数据写到文件中
         * 如果文件不存在则创建该文件
         */
        public void writeFile(){
            //创建FileOutputStream对象
            String filePath="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new2.txt";
            FileOutputStream fileOutputStream=null;
            try {
                //new FileOutputStream(filePath)这种方式当写入内容时会覆盖原来的内容
                //new FileOutputStream(filePath,true)这种方式当写入内容时会追加到文件后面
                fileOutputStream=new FileOutputStream(filePath,true);
                //写入一个字节
                //fileOutputStream.write('z');
                //写入字符串（俩种方式）
                String str="gao zong";
                //方式一  str.getBytes()可以把字符串转换成字节数组
                //fileOutputStream.write(str.getBytes());
                //方式二 off为起始位置，len为偏移量
                fileOutputStream.write(str.getBytes(),2,5);

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 演示使用BufferedOutputStream和BufferedInputStream使用
     */
    class BufferedCopy{

        public void copyFile(){
            String srcFilePath="C:\\Users\\admin\\Documents\\WeChat Files\\All Users\\1bf067ea0486619ee10c4498d68d0f7f.jpg";
            String destFilePath="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\t.jpg";

            BufferedInputStream bufferedInputStream=null;
            BufferedOutputStream bufferedOutputStream=null;
            byte[] bytes=new byte[1024];
            int readLen=0;
            try {
                bufferedInputStream=new BufferedInputStream(new FileInputStream(srcFilePath));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
                while ((readLen=bufferedInputStream.read(bytes))!=-1){
                    bufferedOutputStream.write(bytes,0,readLen);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

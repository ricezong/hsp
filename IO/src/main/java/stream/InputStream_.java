package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 输入流相关操作
 */
public class InputStream_ {
    public static void main(String[] args) {
        InputStream_ input=new InputStream_();
        //调用内部类
        FileInputStream_ fileInput = input.new FileInputStream_();
        //读取文件
        //fileInput.readFile01();
        fileInput.readFile02();
    }

    /**
     * 演示FileInputStream文件输入流的使用
     */
    //在成员内部类中可以无条件访问外部类的任何成员
    class FileInputStream_{

        /**
         * 演示使用read()读取文件
         */
        public void readFile01(){
            String filePath="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\Reference.txt";
            FileInputStream fileInputStream=null;
            int readData=0;
            try {
                //创建FileInputStream对象用于读取文件
                fileInputStream=new FileInputStream(filePath);
                //read()从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
                //如果返回-1，表示读取完毕
                while ((readData=fileInputStream.read())!=-1){
                    System.out.print(((char) readData));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 演示使用read(byte[] b)读取文件
         */
        public void readFile02(){
            String filePath="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\Reference.txt";
            FileInputStream fileInputStream=null;
            int readLen=0;
            //一次读取8个字节
            byte[] bytes=new byte[22];
            try {
                //创建FileInputStream对象用于读取文件
                fileInputStream=new FileInputStream(filePath);
                //read(byte[] b)从该输入流读取最多b.length字节的数据到字节数组。此方法将阻塞，直到某些输入可用
                //如果返回-1，表示读取完毕
                //如果读取正常返回实际读取的字节数
                while ((readLen=fileInputStream.read(bytes))!=-1){
                    System.out.print(new String(bytes,0,readLen));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

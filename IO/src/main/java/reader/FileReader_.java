package reader;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * 文件读相关操作
 */
public class FileReader_ {
    public static void main(String[] args) {
    }

    /**
     * 单个字符读取文件
     */
    @Test
    public void fileReader01(){
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        FileReader fileReader=null;
        int data=' ';
        try {
            //创建FileReader对象
            fileReader=new FileReader(filePath);
            //循环读取(一个一个读)
            while ((data=fileReader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符数组读取文件
     */
    @Test
    public void fileReader02(){
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        FileReader fileReader=null;
        int readLen=0;
        char[] chars=new char[2];
        try {
            //创建FileReader对象
            fileReader=new FileReader(filePath);
            //循环读取(多个多个读)
            while ((readLen=fileReader.read(chars))!=-1){
                System.out.print(new String(chars,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

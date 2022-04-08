package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式一  new File(String pathName)  //根据路径构建一个File对象
    @Test
    public void create01(){
        String filePath="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        File file=new File(filePath);
        try {
            //创建新文件
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式二  new File(File parent,String child) //根据父目录文件+子路径构建
    @Test
    public void create02(){
        String fileName="new2.txt";
        String parentURL="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file";
        File parentFile=new File(parentURL);
        //此file仅仅是一个Java对象
        File file=new File(parentFile,fileName);
        try {
            //该方法才会在磁盘创建文件
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式三  new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03(){
        String fileName="new3.txt";
        String parentURL="E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file";
        File file=new File(parentURL,fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

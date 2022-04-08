package file;

import org.junit.Test;

import java.io.File;

/**
 * 文件基本操作
 */
public class FileInfo {
    public static void main(String[] args) {

    }
    //获取文件信息
    @Test
    public void info(){
        //创建文件对象
        File file=new File("E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt");
        System.out.println("文件名字"+file.getName());
        System.out.println("文件绝对路径"+file.getAbsolutePath());
        System.out.println("文件父级目录"+file.getParent());
        System.out.println("文件大小(字节)"+file.length());
        System.out.println("文件是否存在"+file.exists());
        System.out.println("是不是一个文件"+file.isFile());
        System.out.println("是不是一个目录"+file.isDirectory());
    }
}

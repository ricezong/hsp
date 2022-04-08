package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 目录操作
 */
public class Directory_ {

    public static void main(String[] args) {

    }

    @Test
    public void mkdir1() {
        File file = new File("E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt");
        if (file.exists()) {
            boolean b = file.delete();
            if (b) {
                System.out.println("文件删除成功");
            }
        } else {
            System.out.println("该文件不存在");
            try {
                boolean b = file.createNewFile();
                if (b) {
                    System.out.println("文件创建成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //在Java编程中，目录也被当做文件
    public void mkdir2() {
        File file = new File("E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\mkdir");
        if (file.exists()) {
            boolean b = file.delete();
            if (b) {
                System.out.println("目录删除成功");
            }
        } else {
            System.out.println("该目录不存在");
            boolean b = file.mkdir();
            if (b) {
                System.out.println("目录创建成功");
            }
        }
    }

    @Test
    public void mkdir3() {
        File file = new File("E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\mkdir\\m1\\m2\\m3");
        if (file.exists()) {
            boolean b = file.delete();
            if (b) {
                System.out.println("目录删除成功");
            }
        } else {
            System.out.println("该目录不存在");
            boolean b = file.mkdirs();//创建多级目录
            if (b) {
                System.out.println("目录创建成功");
            }
        }
    }
}

package homework;

import java.io.File;

/**
 * @ClassName HomeWork
 * @Description TODO
 * @Author 孔明灯
 * @Data 2022/4/4 20:36
 * @Version 1.0
 */
public class HomeWork {
    public static void main(String[] args) {
        HomeWork homeWork=new HomeWork();
        homeWork.test1();
    }

    public void test1(){
        String pathName="F:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file";
        String fileName="F:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        File file=new File(pathName);
        if (!file.exists()){
            if (file.mkdir()) {
                System.out.println("目录创建成功！");
            }else
                System.out.println("目录创建失败！");
        }
    }

    public void test2(){

    }

    public void test3(){

    }
}

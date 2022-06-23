package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 演示BufferedReader的使用
 */
public class BufferedReader_ {
    public static void main(String[] args) {
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\Reference.txt";
        BufferedReader bufferedReader=null;
        String line;
        try {
            bufferedReader=new BufferedReader(new FileReader(filePath));
            //按行读取 当返回为空时文件读取结束
            while ((line=bufferedReader.readLine())!=null){
                String[] split = line.split("\t");
                for (int i = 0; i <split.length ; i++) {
                    System.out.print(split[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //只需关闭外层流
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

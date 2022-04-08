package transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 演示一个中文乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }
}

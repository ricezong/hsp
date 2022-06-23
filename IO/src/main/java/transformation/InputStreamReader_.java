package transformation;

import java.io.*;

/**
 * 演示使用InputStreamReader转换流解决中文乱码问题
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\Reference.txt";
        //把FileInputStream转成InputStreamReader并指定编码gbk
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "utf-8");
        //把InputStreamReader传入BufferReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
    }
}

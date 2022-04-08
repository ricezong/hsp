package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 演示BufferedWriter的使用
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new4.txt";
        BufferedWriter bufferedWriter=null;
        bufferedWriter=new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("孔明灯");
        //插入一个换行符
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}

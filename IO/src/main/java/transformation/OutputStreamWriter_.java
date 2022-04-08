package transformation;

import java.io.*;

/**
 * 演示OutputStreamWriter使用
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("哈哈哈哈哈哈吧");
        bufferedWriter.newLine();
        bufferedWriter.close();


        //演示PrintStream打印流
        //PrintStream默认输出位置为显示器
        PrintStream out=System.out;
        out.print("哈哈哈哈哈哈哈吧");
        out.close();
    }
}

package writer;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        String destFilePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\new1.txt";
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        String line;
        bufferedReader=new BufferedReader(new FileReader(srcFilePath));
        bufferedWriter=new BufferedWriter(new FileWriter(destFilePath));
        while ((line=bufferedReader.readLine())!=null){
            //没读一行就写入
            bufferedWriter.write(line);
            //换行
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}

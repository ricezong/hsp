package writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件写相关操作
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        FileWriter fileWriter=null;
        char[] chars={'o','m','g'};
        try {
            fileWriter=new FileWriter(filePath,true);//追加写入
            //write(int):写入单个字符
            fileWriter.write("K");
            //write(char[]):写入指定数组
            fileWriter.write(chars);
            //write(char[],off,len):写入指定数组的指定部分
            fileWriter.write(chars,0,2);
            //write(String):写入整个字符串
            fileWriter.write("孔明灯".toCharArray());
            //write(String,off,len):写入字符串的指定部分
            fileWriter.write("孔明灯".toCharArray(),0,2);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //对应FileWriter一定要关闭流，或者flush才能真正的把数据写到文件里
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

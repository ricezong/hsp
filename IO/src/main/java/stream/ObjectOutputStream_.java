package stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 演示ObjectOutputStream的使用，完成数据的序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后保存的文件格式是按照它的格式来保存
        String filePath = "E:\\WorkSpace\\IdeaProjects\\hsp\\IO\\src\\main\\resources\\file\\new1.txt";
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100);
        oos.writeByte(3);
        oos.close();


    }
}

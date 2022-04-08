package properties_;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName Properties_
 * @Description TODO
 * @Author 孔明灯
 * @Data 2022/4/4 19:37
 * @Version 1.0
 */
public class Properties_ {
    public static void main(String[] args) throws IOException {
        //Properties_.properties01();
        //Properties_.properties02();
        Properties_.properties03();
    }

    /**
     * 读取配置文件信息
     * @throws IOException
     */
    public static void properties01() throws IOException {
        //读取配置文件信息
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\WorkSpace\\IdeaProjects\\murong\\hsp\\IO\\src\\main\\resources\\mysql.properties"));
        String line="";
        while ((line=bufferedReader.readLine())!=null){
            String[] split = line.split("=");
            //只读取ip
            if ("ip".equals(split[0])){
                System.out.println(split[0]+":"+split[1]);
            }
        }
        bufferedReader.close();
    }

    /**
     * 使用properties类读取配置文件
     * @throws IOException
     */
    public static void properties02() throws IOException {
        //创建对象
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileReader("F:\\WorkSpace\\IdeaProjects\\murong\\hsp\\IO\\src\\main\\resources\\mysql.properties"));
        //把键值对显示到控制台
        properties.list(System.out);
        //根据key获取值
        String user = properties.getProperty("user");
        System.out.println(user);
    }

    /**
     * 使用properties类创建配置文件，修改配置文件内容
     * @throws IOException
     */
    public static void properties03() throws IOException {
        Properties properties=new Properties();
        //创建属性
        //如果属性存在会修改属性，不存在就创建
        properties.setProperty("charset","utf-8");
        properties.setProperty("user","kong");
        properties.setProperty("pwd","123");
        //将配置好的属性存储到文件中
        properties.store(new FileWriter("F:\\WorkSpace\\IdeaProjects\\murong\\hsp\\IO\\src\\main\\resources\\mysql.properties"),"null");
    }

}

package upload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 */
public class StreamUtils {

    /**
     * 将输入流转换成byte[] 即可以把文件的内容读入到byte[]
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static byte[] streamToByteArray(InputStream inputStream) throws Exception{
        //创建输出流对象
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] b=new byte[1024];
        int len;
        while ((len=inputStream.read(b))!=-1){//循环读取
            byteArrayOutputStream.write(b,0,len);//将读取到的数据写入byteArrayOutputStream
        }
        //将byteArrayOutputStream转换成字节数组
        byte[] array=byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return array;
    }

    public static String streamToString(InputStream inputStream) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder=new StringBuilder();
        String line;
        while ((line=reader.readLine())!=null){
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}

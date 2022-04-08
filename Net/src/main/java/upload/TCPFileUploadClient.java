package upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 文件上传客户端
 */
public class TCPFileUploadClient {

    public static void main(String[] args) throws Exception {
        //客户端连接服务端8888端口
        Socket socket=new Socket(InetAddress.getLocalHost(),8888);
        //创建读取磁盘文件的输入流
        String filePath="C:\\Users\\admin\\Documents\\WeChat Files\\All Users\\1bf067ea0486619ee10c4498d68d0f7f.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        //bytes就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //通过socket获取到输出流，将bytes数组发送到服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        //将文件对应的字节数组的内容写入到数据通道
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        socket.shutdownOutput();
        bufferedOutputStream.close();
        socket.close();
    }
}

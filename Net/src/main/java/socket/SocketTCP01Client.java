package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class SocketTCP01Client {

    public static void main(String[] args) throws IOException {
        //连接服务端(ip,端口)
        //解读：连接本机的9999端口，如果连接成功，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //连接上后，生成socket，通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        outputStream.write("狗女人".getBytes());
        //设置结束标记
        socket.shutdownOutput();
        //获取和socket关联的输入流，读取数据（字节）并显示
        InputStream inputStream = socket.getInputStream();
        byte[] bytes= new byte[1024];
        int readLen=0;
        while ((readLen=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }
        //关闭流对象和socket
        inputStream.close();
        outputStream.close();
        socket.close();
    }

}

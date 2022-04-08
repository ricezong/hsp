package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听，等待连接(要求在本机没有其他服务在占用9999)
        //serverSocket可以通过accept返回多个socket
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听，等待连接");
        //当没有客户端连接9999端口时，程序会阻塞，等待连接
        //如果有客户端连接则会返回socket对象，程序继续
        Socket socket = serverSocket.accept();
        //通过socket.getInputStream()读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //IO读取
        byte[] bytes= new byte[1024];
        int readLen=0;
        while ((readLen=inputStream.read(bytes))!=-1){
            //根据读取到的十几家长度显示内容
            System.out.println(new String(bytes,0,readLen));
        }
        //获取socket相关联的输出流
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("狗男人".getBytes());
        //设置结束标记
        socket.shutdownOutput();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

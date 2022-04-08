package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketTCP02Server {
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
        //IO读取,使用字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //获取socket相关联的输出流
        OutputStream outputStream=socket.getOutputStream();
        //使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("狗男人");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //关闭外层流
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}

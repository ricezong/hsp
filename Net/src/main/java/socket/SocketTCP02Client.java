package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class SocketTCP02Client {

    public static void main(String[] args) throws IOException {
        //连接服务端(ip,端口)
        //解读：连接本机的9999端口，如果连接成功，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //连接上后，生成socket，通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        //通过字符流，写入数据到数据通道
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("狗女人");
        //插入一个换行符，表示写入的内容结束
        bufferedWriter.newLine();
        //如果使用的是字符流需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();
        //获取和socket关联的输入流，读取数据（字节）并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭外层流
        bufferedReader.close();
        bufferedWriter.close();
        //关闭流对象和socket
        socket.close();
    }

}

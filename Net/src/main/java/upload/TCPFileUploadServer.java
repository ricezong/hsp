package upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传服务端
 */
public class TCPFileUploadServer {

    public static void main(String[] args) throws Exception {

        //服务端在本机监听8888端口
        ServerSocket serverSocket=new ServerSocket(8888);
        //等待连接
        Socket socket = serverSocket.accept();
        //读取客户端发送的数据
        BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //将得到的bytes数组写入到指定的路径
        String destFilePath="E:\\WorkSpace\\IdeaProjects\\hsp\\net\\src\\main\\java\\upload\\1.jpg";
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(destFilePath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}

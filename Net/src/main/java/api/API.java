package api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localhost=InetAddress.getLocalHost();
        System.out.println(localhost);
        //根据主机名称获取InetAddress对象
        InetAddress host1=InetAddress.getByName("DESKTOP-22QNPMP");
        System.out.println(host1);
        //根据域名返回InetAddress对象，比如www.baidu.com
        InetAddress host2=InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
        //通过InetAddress对象获取对应的地址
        String hostAddress = host2.getHostAddress();//IP
        System.out.println(hostAddress);
        //通过InetAddress对象获取对应的主机名或者域名
        String hostName = host2.getHostName();
        System.out.println(hostName);
    }
}

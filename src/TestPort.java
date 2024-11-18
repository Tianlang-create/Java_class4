//IP地址用来标识一台计算机，但是一台计算机上可能提供多种网络应用程序，
// 如何来区分这些不同的程序呢？这就要用到端口。端口号是用来区分一台机器上不同的应用程序的


//记住一点，我们编写的程序要占用端口号的话占用1024以上的端口号，
// 1024以下的端口号不要去占用，因为系统有可能会随时征用。端口号本身又分为TCP端口和UDP端口，
// TCP的8888端口和UDP的8888端口是完全不同的两个端口。TCP端口和UDP端口都有65536个

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class TestPort {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8082);
        System.out.println(inetSocketAddress);
        //返回主机名
        System.out.println(inetSocketAddress.getHostName());
        //获得InetSocketAddress的端口
        System.out.println(inetSocketAddress.getPort());
        //返回一个InetAddress对象（IP对象）
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address);
    }
}

import java.net.*;

public class IP_study1 {
    //获取本机IP 使用异常包括
        public static void main(String[] args) {
            InetAddress address= null;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            System.out.println(address.getHostAddress());
            //主机名
            System.out.println(address.getHostName());
            //其他主机
            InetAddress address1= null;
            try {
                address1 = InetAddress.getByName("www.baidu.com");
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            System.out.println(address1.getHostAddress());
            System.out.println(address1.getHostName());
        }
}

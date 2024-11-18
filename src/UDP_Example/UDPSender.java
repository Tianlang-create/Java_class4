package UDP_Example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        //1、创建一个socket
        DatagramSocket socket = new DatagramSocket();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        String msg="你好，很高兴认识你！";
        byte[] buffer = msg.getBytes();
        //2、创建一个包（要发送给谁）
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length,inet,9090);
        //3、发送包
        socket.send(packet);
        //4、释放资源
        socket.close();
    }
}

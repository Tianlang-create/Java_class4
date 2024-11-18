package UDP_Example;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // 1、创建一个socket
        DatagramSocket socket = new DatagramSocket(9090);
        // 2、创建一个包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 3、接收包
        socket.receive(packet);
        // 4、解析包
        String msg = new String(packet.getData(), 0, packet.getLength());
        System.out.println("接收到的数据：" + msg);
        // 5、释放资源
        socket.close();
    }
}
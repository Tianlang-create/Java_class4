package UDP_Example_create;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver implements Runnable{
    //创建一个socket
    DatagramSocket socket=null;
    //接收方自己所在的端口
    private int fromPort;
    //数据发送者的姓名
    private String msgFrom;

    public UDPReceiver(int fromPort,String msgFrom) {
        this.fromPort = fromPort;
        this.msgFrom=msgFrom;
        try {
            socket=new DatagramSocket(fromPort);//创建一个socket
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){//循环接收
            try {
                byte[] buffer = new byte[1024 * 8];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println(msgFrom+":"+msg);
                if (msg.equals("拜拜")){//如果接收到的数据为拜拜，则退出接收
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //释放资源
        socket.close();
    }
}

package UDP_Example_create;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender implements Runnable{
    //创建一个socket
    DatagramSocket socket=null;
    //创建一个流 用于录入键盘的数据
    BufferedReader bfr=null;
    //发送数据目的地的IP
    private String toIP;
    //发送数据目的地的端口
    private int toPort;

    public UDPSender(String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket=new DatagramSocket();//创建一个socket
        } catch (SocketException e) {
            e.printStackTrace();
        }
        bfr=new BufferedReader(new InputStreamReader(System.in));//从键盘录入数据到流中
    }

    @Override
    public void run() {
        while (true){//循环发送数据
            try {
                String msg = bfr.readLine();//从流中读取数据
                byte[] buffer = msg.getBytes();
                InetAddress inet = InetAddress.getByName(toIP);
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, inet, toPort);
                socket.send(packet);
                //如果发送了拜拜，则退出发送
                if(msg.equals("拜拜")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //释放资源
        if(socket!=null){
            socket.close();
        }
        if (bfr!=null){
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

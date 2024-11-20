package TCP_SocketExampleTest1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1、创建Socket对象，它的第一个参数需要的是服务端的IP，第二个参数是服务端的端口
            InetAddress inet = InetAddress.getByName("172.17.10.144");
            socket = new Socket(inet,9999);//可以直接写
            //socket = new Socket("127.0.0.1",8090);//可以直接写
            //2、获取一个输出流，用于写出要发送的数据
            os = socket.getOutputStream();
            //3、写出数据
            os.write("你好，我是客户端！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//4、释放资源
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

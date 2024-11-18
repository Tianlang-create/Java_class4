package Tesst;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1、创建服务端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8090);
            //2、调用accept接收到来自于客户端的socket
            socket = serverSocket.accept();//阻塞式监听，会一直等待客户端的接入
            //3、获取socket的输入流
            is = socket.getInputStream();

//        不建议这样写：因为如果我们发送的数据有汉字，用String的方式输出可能会截取汉字，产生乱码
//        int len=0;
//        byte[] buffer = new byte[1024];
//        while ((len=is.read(buffer))!=-1){
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }

            //4、读取输入流中的数据
            //ByteArrayOutputStream的好处是它可以根据数据的大小自动扩充
            baos = new ByteArrayOutputStream();
            int len=0;
            byte[] buffer = new byte[1024];
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println("收到了来自于客户端"+socket.getInetAddress().getHostName()
                    +"的消息："+baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//5、关闭资源
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


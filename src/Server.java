import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        // 创建 ServerSocket 对象
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("服务器启动，等待客户端连接...");

        // 等待客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");

        // 获取输入流和输出流
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // 接收客户端发送的数据
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        String message = new String(buffer, 0, len);
        System.out.println("客户端发送的数据：" + message);

        // 发送数据给客户端
        String response = "Hello, client!";
        out.write(response.getBytes());

        // 关闭 Socket
        socket.close();
    }
}
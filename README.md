Date in 18/11/2024
Tianlang
# Java网络编程

## 计算机网络

## 网络通信协议及接口





## IP协议

code、IP概念、实际代码、非本机IP获取

```Java
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
# Java网络编程

## 计算机网络

## 网络通信协议及接口





## IP协议 

 code、IP概念、实际代码、非本机IP获取

```Java
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

```



## 端口

### InetAddress类

```Java
//构造方法
//创建Socket对象，它的第一个参数需要的是服务端的IP(Inet实现)，第二个参数是服务端的端口
 InetAddress inet = InetAddress.getByName("127.0.0.1");
 socket = new Socket(inet,8888);
```



## TCP网络编程

### 客户端（Client）

*此时客户端为访问写入状态，服务器端接收输入文字*

```java
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
 //1、创建Socket对象，它的第一个参数需要的是服务端的IP，第二个参数是服务端的端口
 InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8090);
            //2、获取一个输出流，用于写出要发送的数据
            os = socket.getOutputStream();
            //3、写出数据
            os.write("你好，我是客户端！".getBytes());
```



### 服务器端(Server)·

~~~java
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

  //1、创建服务端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8090);
  //2、调用accept接收到来自于客户端的socket
            socket = serverSocket.accept();//阻塞式监听
  //3、获取socket的输入流
            is = socket.getInputStream();
~~~

**注意使用完后的关闭！**



##  UDP网络编程

## 端一

```Java
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
```



## 端二

```Java
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
```

如果是TCP中先启动客户端会报错：
![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/a4fa7514e11cd9835489949f02c0cf6e.png)
而如果是UDP中先启动发送方不会报错，但会正常退出。

## 多线程实例 Teacher&Student(Code)



# 小结

![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/e56124e729ab4aca64f4917ee7e2ff1b.png)


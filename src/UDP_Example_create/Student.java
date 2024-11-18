package UDP_Example_create;

public class Student {
    public static void main(String[] args) {
        new Thread(new UDPSender("127.0.0.1",8888)).start();
        new Thread(new UDPReceiver(7777,"老师")).start();
    }
}

package java_0620;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClinent {
    //客户端主要流程
    //1.进行初始化操作（实例化 Socket 对象）
    //2.进入主循环，接收并处理请求，（主循环就是死循环）
    //    a.读取用户输入数据
    //    b.构造请求发送给服务器
    //    c.从服务器读取响应
    //    d.显示响应数据

    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    //需要在启动客户端的时候来指定需要连接哪个服务器
    public UdpEchoClinent(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
        //客户端创建socket时，不需要绑定端口（由操作系统自动分配一个空闲端口）
        //如果客户端绑定端口，就只能启动指定端口，没有办法一台主机启动多个端口了
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            //a.   读取用户输入数据
            System.out.println("->");
            String request = scanner.nextLine();
            if (request.equals("exit")){
                break;
            }

            //b.   构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            //c.   从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4090],4090);
            socket.receive(requestPacket);
            String response = new String(requestPacket.getData(),
                    0,requestPacket.getLength()).trim();
            //4.显示响应数据
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
       // UdpEchoClinent client = new UdpEchoClinent("47.98.116.42", 9090);
        UdpEchoClinent client = new UdpEchoClinent("127.0.0.1",9090);
        //"127.0.0.1"：这是一个特殊的ip（环回ip）自己访问自己；如果服务器和客户端在一台主机上就写环回IP，如果不在就写服务器的ip
        //9090：这个端口要和的服务器绑定端口匹配
        client.start();
    }
}

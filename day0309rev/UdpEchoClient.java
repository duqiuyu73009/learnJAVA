package day0309rev;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    //客户端的主要流程分为4步
    //1.从用户这里读取输入的数据
    //2.构造一个请求发送给服务器
    //3.从服务器读取响应
    //4.把响应写回给客户端

    private DatagramSocket socket = null;
    private String socketIP;
    private int socketPort;

    public UdpEchoClient(String socketIP, int socketPort) throws SocketException {
        this.socketIP = socketIP;
        this.socketPort = socketPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        System.out.println("客户端去启动");
        Scanner scanner = new Scanner(System.in);
        while (true){
            //从用户这里输入数据
            System.out.print("->");
            String request = scanner.nextLine();
            if ("exit".equals(request)){
                break;
            }

            //2.构造一个发送请求的服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length,InetAddress.getByName(socketIP),socketPort);
            socket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength()).trim();

            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}

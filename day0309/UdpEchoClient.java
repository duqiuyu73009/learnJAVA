package day0309;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP 客户端
 */
public class UdpEchoClient {
    //客户端的主要流程分为4步
    //1.从用户这里读取输入的数据
    //2.构造一个请求发送给服务器
    //3.从服务器读取响应
    //4.把响应写回给客户端

    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    //需要在启动客户端的时候指定需要连接哪个服务器
    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        socket = new DatagramSocket();//客户端创建socket的时候不需要绑定端口号，由操作系统自动分配一个空闲端口
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            //1.读取用户输入的数据
            System.out.print("->");//提示符：提示用户输入字符
            String request = scanner.nextLine();//作为请求
            if (request.equals("exit")){
                //结束
                break;
            }

            //2.构造一个请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIP), serverPort);
            //InetAddress.getByName(serverIP), serverPort： 要把数据报发给哪个服务器：指定IP和端口号
            socket.send(requestPacket);

            //3.从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);//也会阻塞，等待服务器返回
            String response = new String(responsePacket.getData(),0,responsePacket.getLength()).trim();

            //4.把响应写回给客户端
            System.out.println(response);
        }
    }


    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        //"127.0.0.1":是环回IP，因为此时客户端和服务器在一台主机上
        //9090：这个端口要和服务器绑定的端口相匹配
        client.start();
    }
}

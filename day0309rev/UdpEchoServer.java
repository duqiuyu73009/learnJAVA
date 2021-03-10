package day0309rev;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP的服务器
 */
public class UdpEchoServer {
    //对于一个服务器程序，核心流程分成两步
    //1.进行初始化操作
    //2，进入主循环，接收并处理请求（主循环就是死循环）
    //  a）读取数据并解析
    //  b）根据请求计算响应
    //  c）把响应结果写回到客户端

    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1.读取并解析数据
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0, requestPacket.getLength()).trim();

            //2.根据请求计算响应
            String response = process(request);

            //3.向客户端返回响应
            DatagramPacket responsePacket =new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            System.out.printf("[%s:%d] req: %s; resp: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}

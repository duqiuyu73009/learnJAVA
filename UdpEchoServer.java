package java_0620;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * 客户端——服务器
 *     Socket API
 *
 *     java标准库中提供了两种风格
 *     1.【UDP】DatagramSocket：面向数据报（发送接收数据，必须以一定的数据为单位进行传输）
 *     2.【TCP】ServerSocket：面向字节流
 *     UDP和TCP是传输层中两个最重要的协议
 *
 */

/**
 * 写一个程序，服务器原分不动的返回
 */

public class UdpEchoServer {
    //服务器主要流程分为四步
    //1.进行初始化操作（实例化 Socket 对象）
    //2.进入主循环，接收并处理请求，（主循环就是死循环）
    //    a）读取数据并解析
    //    b）根据请求计算响应
    //    c)把响应结果写回客户端
    private DatagramSocket socket = null;//标准库

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        //port是端口号
        //new这个 Socket 对象的时候，会让当前的的Socket对象和一个IP地址以及一个端口号关联在一起（绑定端口）
        //未来客户端就按照这个IP + 端口来访问服务器
        //构造 socket 的时候没写IP，默认为0.0.0.0
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //    a）读取数据并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //receive是阻塞的方法，直到真的有数据来了解除阻塞才会向下执行
            String request = new String(requestPacket.getData(),
                    0,requestPacket.getLength()).trim();
            //此处是把请求数据转换成String （原来是byte[]）
            //此处getLength得到的长度就是4096，有很多空白区间，可以通过trim来去掉

            //    b）根据请求计算响应
            String response = process(request);

            //    c)把响应结果写回客户端,响应数据就是response，需要包装成packet对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());
            //requestPacket.getSocketAddress()表示这个包要发给谁，此处的地址就是客户端的地址和端口
            //length这个长度是字节数（length（）代表字符数）
            socket.send(responsePacket);

            //打印一条请求日志
            System.out.printf("[%s:%d] req: %s; resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        //由于此处是一个 echo server ，请求内容是啥，相应内容就是啥
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}

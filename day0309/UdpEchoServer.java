package day0309;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP 服务器
 */
public class UdpEchoServer {
    //对于一个服务器程序，核心流程分成两步
    //1.进行初始化操作
    //2，进入主循环，接收并处理请求（主循环就是死循环）
    //  a）读取数据并解析
    //  b）根据请求计算响应
    //  c）把响应结果写回到客户端
    private DatagramSocket socket = null;
    //DatagramSocket 本质上是一个文件，这个文件是网卡的抽象

    //构造方法
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        //new的时候就会让socket对象和一个端口号和一个IP地址关联在一起（绑定端口）
        //未来的客户端就按照这个IP和端口号来访问服务器
        //如果在构造socket的时候没有写IP，就是 0.0.0.0（会关联到这个主机的所有网卡IP）
        //IP是决定互联网的某个主机的位置，port是决定数据交给这个主机的哪个位置
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //  a）读取数据并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            //new byte[4096],4096  相当于关联了缓冲区
            // DatagramPacket是发送和接收数据的基本单位
            socket.receive(requestPacket);
            //程序启动之后马上就能执行到receive
            //大多时候调用receive的时候，客户端还没有发送请求，这时receive就会阻塞，当真的有客户端数据过来之后，就会把收到的数据放入缓冲区
            String request = new String(requestPacket.getData(), 0,requestPacket.getLength()).trim();
            //此处需要把请求数据转成string（本来是byte[]）
            //requestPacket.getData()获取到缓冲区，也就是byte数组，然后从0开始，到缓冲区长度处结束
            //.trim()：用户实际发送的数据可能远远小于4096，此时getLength()获取到的都是4096，此时就可以通过trim来去掉一些空白空间

            //  b）根据请求计算响应
            String response = process(request);
            //  c）把响应结果写回到客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //response.getBytes():响应数据就是response，需要包装成一个Packet对象
            //request.getBytes().length：获取长度,得到的是字符数
            //requestPacket.getSocketAddress()：指定当前数据发给谁，这个方法就把IP端口号全部获取到，就设置到了responsePacket里面
            socket.send(responsePacket);

            //以下部分可省略
            System.out.printf("[%s:%d] req: %s; resp: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    public String process(String request) {
        //由于此处是一个回显服务器，所以只需要原分不动的返回
        //但是如果是其他复杂的服务器，就需要在这里有更多的逻辑
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}

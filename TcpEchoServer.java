package java_0620;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1.初始化服务器
    //2.进入主循环
    //     a.先去从内核中获取到一个TCP的连接
    //     b.处理这个TCP的连接
    //          a）读取请求并解析
    //          b）根据请求计算响应
    //          c）把响应协会客户端

    // ServerSocket  处理客户端连接
    // Socket  和客户进行具体交互

    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //a.先从内核中取到一个TCP连接
            Socket clientSocket = serverSocket.accept();//这句话不能放到多线程中，一次性会创建太多太多线程了，进程分分钟就挂了
            //如果服务器启动之后，没有客户端建立连接，accept就会阻塞，直到真的有客户端连接之后为止

            Thread t = new Thread(){
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            t.start();
            //b. 处理这个连接
           // processConnection(clientSocket);  //如果放到多线程外面，那么一次只能连接一个客户端
            //一个链接中，客户端和服务器交互
            //1.短连接：一个连接中，客户端和服务器之交互一次，就断开连接
            //2.长连接：一个连接中，客户端和服务器之间交互N次，直到满足一定条件再断开连接
        }
    }

    private void processConnection(Socket clientSocket)  {
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //通过 clientSocket 来和客户端交互，先做好准备工作，获取到 clientSocket 中的流对象
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            //此处实现一个”长连接’版本的服务器
            //这个循环当客户端断开连接的时候，就结束
            //把while循环一去掉，就是 “短连接‘
            while (true){
                //进一步就可以完成后面的逻辑
                //1.读取请求并判断
                String request = bufferedReader.readLine();//此处暗含：客户端发送的数据一定是按行发送的（每一条数据占一行）
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应写回到客户端（客户端要按行来读）
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();

                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }
        }catch (IOException e){
            //e.printStackTrace();
            System.out.printf("[%s:%d] 客户端下线\n", clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}

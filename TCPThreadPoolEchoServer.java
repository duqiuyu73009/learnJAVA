package java_0620;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPThreadPoolEchoServer {

    private ServerSocket serverSocket = null;

    public TCPThreadPoolEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();

        //创建了线程池   节省了平凡创建和销毁线程的开销
        while (true){
            //a.先从内核中取到一个TCP连接
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
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
        TCPThreadPoolEchoServer server = new TCPThreadPoolEchoServer(9090);
        server.start();
    }
}

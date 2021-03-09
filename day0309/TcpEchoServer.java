package day0309;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1.初始化服务器
    //2.进入主循环
    //  1）先去从内核中获取到一个TCP的连接
    //  2）处理这个TCP的连接
    //    a）读取请求并解析
    //    b）根据请求计算响应
    //    c）把响应写回给客户端

    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //  1）先去从内核中获取到一个TCP的连接
            //TCP的连接管理是由操作系统内核来管理的（先描述，再组织【使用一个阻塞队列来组织若干个连接对象】）
            //当连接建立成功，内核已经把这个连接对象放到了阻塞队列中了，代码中调用到accept就是从阻塞队列中取出一个连接对象
            //在应用程序中就是Socket对象
            //如果服务器启动后，没有客户端建立连接，此时代码中的accept就会阻塞，直到有客户建立连接了才停止阻塞
            Socket clientSocket = serverSocket.accept();

            //  2）处理这个TCP的连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //clientSocket.getInetAddress().toString():获得出IP
        //clientSocket.getPort())：获得端口号
        //通过 clientSocket 来和客户端交互，先做好准备工作，获取到clientSocket中流对象
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //getInputStream()；getOutputStream()：字节流
            //InputStreamReader;OutputStreamWriter:把字节流转成字符流，
            //BufferedReader；BufferedWriter：套上缓冲区

            //此处是长连接版本：一次连接的过程中，需要处理多个请求和响应
            //短连接就是去掉while循环
            while (true) {
                //    a）读取请求并解析
                String request = bufferedReader.readLine();
                //此处暗含一个信息（协议）：
                //客户端发的数据必须是一个按行发送的数据（每一条数据占一行）

                //    b）根据请求计算响应
                String response = process(request);

                //    c）把响应写回给客户端(客户端要按行来读)
                bufferedWriter.write(response+"\n");
                bufferedWriter.flush();

                System.out.printf("[%s:%d] req: %s; resp: %s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("[%s:%d] 客户端下线\n",clientSocket.getInetAddress().toString(),
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

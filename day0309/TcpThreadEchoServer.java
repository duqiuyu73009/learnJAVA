package day0309;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            Socket clientSocket = serverSocket.accept();
            //针对这个连接，单独创建一个线程负责处理
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
            t.start();
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            while (true) {
                //    a）读取请求并解析
                String request = bufferedReader.readLine();

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
        TcpThreadEchoServer server = new TcpThreadEchoServer(9090);
        server.start();
    }

}

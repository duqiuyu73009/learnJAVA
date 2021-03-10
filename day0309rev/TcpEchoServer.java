package day0309rev;

import java.io.*;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket socket = null;

    public TcpEchoServer(int port) throws IOException {
        socket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = socket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            while (true) {
                String request = bufferedReader.readLine();

                String response = process(request);

                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();

                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress().toString(),
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

package java_0620;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClinent {
    //客户端
    //1.启动客户端（不能绑定端口号）
    //2.进入主循环
    //   a）读取用户输入内容
    //   b）构造一个请求发给服务器
    //   c）读取服务器响应数据
    //   d）把响应数据显示到界面上

    private Socket socket = null;

    public TcpEchoClinent(String serverIp, int serverPort) throws IOException {
        //此处的实例化Socket是建立TCP连接
        socket = new Socket(serverIp, serverPort);
    }

    public void start(){
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true){
                //1。读取用户数据
                System.out.println("->");
                String request = scanner.nextLine();//此处也可能会阻塞（用户不一定就立刻输入内容）
                if ("exit".equals(request)){
                    break;
                }
                //2.构造请求发送(对应服务器中的readLine相对应)
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();//刷新缓冲区,否则服务器没有响应
                //3.读取响应数据
                String response = bufferedReader.readLine();
                //4.把相应数据显示到界面上
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClinent clinent = new TcpEchoClinent("127.0.0.1",9090);
        clinent.start();
    }
}

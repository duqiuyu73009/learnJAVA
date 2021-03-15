package day0314;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主逻辑:HttpRequest和 HttpResponse已经梳理的逻辑，在这里完成调用
 */
public class HttpServerV2 {
    private ServerSocket serverSocket = null;

    public HttpServerV2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    public void process(Socket clientSocket){
        try {
            //1.读取并解析请求
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            System.out.println("request:"+request);
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type","text.html");

            //2.根据请求计算响应
            if (request.getUrl().startsWith("/hello")){
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>hello</h1>");
            }else if (request.getUrl().startsWith("/calc")){
                //根据这个逻辑进行计算
                //先获取到a b两个值
                String aStr = request.getParameters("a");
                String bStr = request.getParameters("b");
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int result = a+b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1> result = "+result+"</h1>");
            } else if (request.getUrl().startsWith("/cookie")){
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Set-Cookie","I am cookie");
                response.writeBody("<h1>set cookie</h1>");
            }else{
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>default</h1>");
            }

            //3.吧响应写回客户端
            response.flush();

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }finally {
            try {
                //这个操作可以同时关闭getInputStream和getOutputStream
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV2 serverV2 = new HttpServerV2(9090);
        serverV2.start();

    }
}

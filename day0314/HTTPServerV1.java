package day0314;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * HTTP服务器(最简单的)
 *
 * 底层要基于TCP来实现，要按照TCP的基本格式来先进行开发
 */
public class HTTPServerV1 {
    private ServerSocket serverSocket = null;

    public HTTPServerV1(int port) throws IOException {
       serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true){
            //1.获取连接
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //2.处理连接(采用短连接)
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket)  {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            //下面的操作要严格按照HTTP协议来进行操作
            //1.读取请求并解析
            //  a）解析首行  三部分使用空格切分
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");//切分
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            //  b)解析header  按行读取，然后按照冒号空格来分割字符
            Map<String,String> headers = new HashMap<>();
            String line = "";
            //readLine()读到的一行内容，时会自动去掉换行符的
            while ((line = bufferedReader.readLine()) != null && line.length() !=0){
                //还没读完并且读到的不是空字符串
                String[] headerTokens = line.split(": ");//用冒号空格来切分
                headers.put(headerTokens[0],headerTokens[1]);
            }
            //  c）解析body（暂时先不考虑）
            //请求解析完毕，加上一个日志看看请求的内容是否正确
            System.out.printf("%s %s %s\n",method,url,version);
            for (Map.Entry<String,String> entry : headers.entrySet()){
                System.out.print(entry.getKey() + ": " + entry.getValue()+"\n");
            }
            System.out.println();

            //2.根据请求计算响应
            //假设不管是啥样的请求，都返回一个hello这样的html
            String resp = "";
            if(url.equals("/ok")){
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>hello</h1>";
            }else if (url.equals("/notfound")){
                bufferedWriter.write(version+" 404 Not Found\n");
                resp = "<h1>not found</h1>";
            }else if (url.equals("/seeother")){
                bufferedWriter.write(version+" 303 See Other\n");
                bufferedWriter.write("Location: http://www.baidu.com\n");
            }else {
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>else</h1>";
            }

            //3.把响应写回客户端
            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-Length: "+resp.getBytes().length+"\n");//此处的长度这样写是得到的字节的数目
            //resp.length是字符数目
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            bufferedWriter.flush();//刷新

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();//短连接，一次交互之后服务器客户端主动断开连接
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HTTPServerV1 serverV1 = new HTTPServerV1(9090);
        serverV1.start();
    }
}


















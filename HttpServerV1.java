package day0314rev;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            Socket clientSocket = serverSocket.accept();
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            //1.解析获得的请求
            //解析首行
            String firstLine = bufferedReader.readLine();
            String[] firstLineToken = firstLine.split(" ");
            String method = firstLineToken[0];
            String url = firstLineToken[1];
            String version = firstLineToken[2];

            Map<String,String> parmenters = new HashMap<>();
            int post = url.indexOf("?");
            if (post != -1){
                //如果url中有？，那么就执行里面的操作
                String parmenter = url.substring(post+1);
                KVStart(parmenter,parmenters);
            }

            //解析header
            Map<String,String> headers = new HashMap<>();
            String line = "";
            while ((line = bufferedReader.readLine()) != null && line.length() != 0){
                String[] headerToken = line.split(": ");
                headers.put(headerToken[0],headerToken[1]);
            }

            System.out.printf("%s %s %s\n", method,url,version);
            for (Map.Entry<String,String> entry : headers.entrySet()){
                System.out.print(entry.getKey()+": "+entry.getValue()+"\n");
            }
            System.out.println();

            //2.计算请求
            String resp = "";
            if (url.equals("/hello")){
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>hello</h1>";
            }else if (url.startsWith("/clar")){
                //计算a+b的值
                bufferedWriter.write(version+" 200 OK\n");
                String aStr = parmenters.get("a");
                String bStr = parmenters.get("b");
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int sum = a+b;
                resp = "<h1>"+sum+"</h1>";

            }else  {
                bufferedWriter.write(version + " 200 OK\n");
                resp = "<h1>defualt</h1>";
            }
            //3.把请求返回给客户端

            bufferedWriter.write("Content-Type: text.html\n");
            bufferedWriter.write("Content-Length: "+resp.getBytes().length+"\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void KVStart(String parmenter, Map<String, String> parmenters) {
        String[] KVToken = parmenter.split("&");
        for (String KV : KVToken){
            String[] result = KV.split("=");
            parmenters.put(result[0],result[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 server = new HttpServerV1(9090);
        server.start();
    }

}

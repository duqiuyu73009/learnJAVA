package day0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    static class User{
        public String name;
        public int age;
        public String school;
    }

    private ServerSocket serverSocket = null;

    Map<String,User> sessions = new HashMap<>();

    public HttpServerV3(int port) throws IOException {
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

    private void process(Socket clientSocket) {
        try {
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type", "text.html");

            if ("GET".equalsIgnoreCase(request.getMethod())){
                doGet(request,response);
            }else if ("POST".equalsIgnoreCase(request.getMethod())){
                doPost(request,response);
            }else {
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }

            //3.把响应写回到客户端
            response.flash();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        if (request.getUrl().startsWith("/index.html")){
            String sessionId = request.geCookie("sessionId");
            User user = sessions.get(sessionId);
            if (sessionId == null || user == null){
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type","text/html; charset=utf-8");
                InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    response.writeBody(line+"\n");
                }
            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type","text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>");
                response.writeBody("您已经登陆过");
                response.writeBody("</div>");
                response.writeBody("</html>");

            }
        }

    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.getUrl().startsWith("/login")){
            String userName = request.getParameter("username");
            String passWord = request.getParameter("password");
            if ("dqy".equals(userName) && "123".equals(passWord)){
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type","text/html; charset=utf-8");

                String sessionId = UUID.randomUUID().toString();

                User user = new User();
                user.name = "dqy";
                user.age = 20;
                user.school = "大学";
                sessions.put(sessionId,user);
                response.setHeaders("Set-Cookie","sessionId="+sessionId);

                //在响应中添加一个cookie，浏览器就会自动存储这个cookie
                response.writeBody("<html>");
                response.writeBody("<div>欢迎您!"+userName+"</div>");
                response.writeBody("</html>");
            }else {
                //登陆失败
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeaders("Content-Type","text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>登陆失败</div>");
                response.writeBody("</html>");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        day0318.HttpServerV3 serverV3 = new day0318.HttpServerV3(9090);
        serverV3.start();
    }
}

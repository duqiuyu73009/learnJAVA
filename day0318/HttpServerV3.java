package day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.让服务器支持返回一个静态的html文件
 * 2.解析处理cookie，把cookie处理成键值对保存好
 * 3.解析body，把body中的数据成键值对结构
 * 4.完成一个登录功能，session的简单实现
 */
public class HttpServerV3 {
    static class User{
        //保存用户的相关信息
        public String userName;
        public int age;
        public String school;
    }

    private ServerSocket serverSocket = null;

    //session 会话，指的是同一个用户的一组访问服务操作，归类到一起，就是一个会话
    //每个键值对就是一个会话
    private HashMap<String,User> sessions = new HashMap<String, User>();

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
                    try {
                        process(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void process(Socket clientSocket) throws IOException {
        try {
            //1.读取并解析请求
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type", "text.html");

            //2.根据请求计算相应
            //此处按照不同的HTTP方法拆分成多个不同的逻辑
            if ("GET".equalsIgnoreCase(request.getMethod())){
                doGet(request,response);
            }else if ("POST".equalsIgnoreCase(request.getMethod())){
                doPost(request,response);
            }else {
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }

            //3.把响应写回到客户端
            response.flush();

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }finally {
            clientSocket.close();
        }
    }



    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        //1.能够支持返回一个HTML文件
        if (request.getUrl().startsWith("/index.html")){
            String sessionId = request.geCookie("sessionId");
            User user = sessions.get(sessionId);
            if (sessionId == null || user == null) {
                //说明当前用户尚未登陆，就返回一个登陆页面

                //这种情况下，就让代码读取一个index.html这样的文件
                //此时可以自己来约定路径

                //把这个文件内容写入到响应的body中
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type","text/html; charset=utf-8");

                InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //HttpServerV3.class: 获取到一个类的类对象
                //getClassLoader()： 获取到当前类的“类加载器”，
                //一个类想要工作，需要先由JVM把这个类的.class文件找到，然后读取内容，加载到内存中（类加载过程）
                //.getResourceAsStream("index.html"): 根据文件名，在Resources目录中找到对应的文件并打开
                //返回这个文件的InputStream对象

                //按行读取
                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    response.writeBody(line+"\n");
                }
                bufferedReader.close();
            }else {
                //已经登陆了，就不需要再登陆了
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type","text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>您已经登录了无需再次登录，用户名为："+user.userName+"</div>");
                response.writeBody("<div>"+user.age+"</div>");
                response.writeBody("<div>"+user.school+"</div>");
                response.writeBody("</html>");
            }
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        //2.实现一个/login的处理
        if (request.getUrl().startsWith("/login")){
            //读取用户提交的用户名和密码
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
//            System.out.println("username: "+userName);
//            System.out.println("password: "+password);
            //验证用户名密码是否正确
            if ("dqy".equals(userName) && "123".equals(password)){
                //登陆成功
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type","text/html; charset=utf-8");
                //原来登陆成功是给浏览器写了一个cookie，cookie中保存的是用户名
               // response.setHeaders("Set-Cookie","userName="+userName);

                String sessionId = UUID.randomUUID().toString();//会生成一个随机字符串，能保证每次调用这个方法生成的字符串都不一样
                //此时身份信息保存在服务器中，就不会再有泄露的问题了，
                //给浏览器返回cookie中包含sessionId即可
                User user = new User();
                user.userName = "tz";
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
        HttpServerV3 serverV3 = new HttpServerV3(9090);
        serverV3.start();
    }
}

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //无需进行考虑如何解析请求，如何构造请求
        //请求以及你个被解析成了HttpServletRequest对象
        //响应对象就是HttpServletResponse对象，后续的序列化也不用关注
        //要考虑的就是如何根据不同的Request对象生成Response对象即可

        //先写一个简单的helloworld
        //请求不管是啥，都会返回一个helloworld
        resp.getWriter().write("<h1>hello Servlet</h1>");
    }

}

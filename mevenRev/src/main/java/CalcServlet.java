import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取 url中的参数内容，a和b的内容
        //然后针对a和b进行相加
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");

        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int result = a+b;
        resp.getWriter().write(String.format("<h1>result = %d</h1>",result));//format格式化方法

    }
}

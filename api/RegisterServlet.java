package api;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    //浏览器是通过POST方法来提交数据的
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取到前端提交的数据（用户名，密码）校验是否合法
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(name == null || "".equals(name)||password==null||"".equals(password)){
            String html = HtmlGenerator.getMessagePage("用户名或者密码为空","register.html");
            resp.getWriter().write(html);
            return;
        }
        //2.拿着用户名在数据库中查一下，看看当前用户是否已经存在，如果存在，认为注册失败
        UserDao userDao = new UserDao();
        User existUser = userDao.selectByName(name);
        if (existUser != null){
            //说明已经存在，提示用户注册失败，用户名重复
            String html = HtmlGenerator.getMessagePage("用户名重复！请换个名字！","register.html");
            resp.getWriter().write(html);
            return;
        }
        //3.根据前端提交的数据构造user对象，并插入到数据库中
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.add(user);
        //4.返回一个结果页面，提示当前注册成功
        String html = HtmlGenerator.getMessagePage("注册成功！点击这里跳转到登陆页面！","login.html");
        resp.getWriter().write(html);

    }
}

package org.example.controller;

import org.example.config.AppConfig;
import org.example.exception.AppException;
import org.example.model.Response;
import org.example.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Object login(HttpServletRequest req, @RequestBody User user){
        //模拟数据库校验用户名密码
        if("abc".equals(user.getUsername()) && "123".equals(user.getPassword())){
            //校验通过，设置session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            return null;
        }
        throw new AppException("USR001", "用户名或密码错误");
    }

    @GetMapping("/1")
    public Object u1(){
        Response r = new Response();
        r.setCode("1");
        return r;
    }

    @GetMapping("/2")
    public Object u2(){
        User u = new User();
        u.setUsername("张三");
        return u;
    }

    @GetMapping("/3")
    public Object u3(){
        return "u3";
    }

    @GetMapping("/4")
    public String u4(){
        return "u4";
    }

    /**
     * 返回类型为Object，且返回值为null时，不会进入统一数据格式封装的方法
     * 解决方案：
     * 参考 {@link AppConfig#afterPropertiesSet()}
     */
    @GetMapping("/5")
    public Object u5(){
        return null;
    }

    @GetMapping("/6")
    public String u6(){
        return null;
    }
}

package frank.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller //Web请求响应处理类
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public Object login(){
        Map<String,String> map = new HashMap<>();
        map.put("dog", "小狗");
        map.put("cat", "小猫");
        return map;
    }
}

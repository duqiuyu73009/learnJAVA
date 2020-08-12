package frank.springbootstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//@Configuration 配置类，去哦董事做配置工作
@Configuration
public class AppConfig {
    // @Bean  配置类方法上的，已返回值作为Bean的实例对象，注册到容器中
    //同一个类型，要实例化多个对象时，这个方法很合适
    @Bean
    public Map<Integer,Integer> test(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        return map;
    }
}

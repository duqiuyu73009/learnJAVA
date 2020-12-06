package day20_12_5;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"haha");
        map.put(2,"gege");
        map.put(3,"yiyi");
        map.put(4,"rere");

        System.out.println(map.size());
        System.out.println(map.isEmpty());

        System.out.println(map.get(3));
        map.getOrDefault(5,"miid");

        map.remove(3);

        System.out.println(map.containsKey(5));

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }






    public static void main1(String[] args) {
        //创建map实例
        //泛型参数有两个  <key, value>   根据key找到对应的value
        Map<String,String> map = new HashMap<>();

        //使用size获取到元素个数（键值对个数）
        System.out.println(map.size());

        //使用isEmpty（）看是否为空
        System.out.println(map.isEmpty());

        //添加键值对
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");

        //取值
        //get()里的是key的值
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("大刀"));//key不存在，得到null

        //map.getOrDefault  是查找key的值，如果存在就返回已存在的值，如果不存在添加当前的值
        System.out.println(map.getOrDefault("行者","武松"));

        //判断值是否存在
        System.out.println(map.containsKey("及时雨"));//执行效率高
        System.out.println(map.containsValue("吴用"));

        //遍历
        //map中的元素顺序与插入的顺序无关，取决于具体的实现方式
        for (Map.Entry<String,String> entry : map.entrySet()){
            //Entry表示一个键值对
            //map.entryset()
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }

    }
}

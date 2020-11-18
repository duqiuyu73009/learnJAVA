package day1118;

import java.lang.reflect.Field;

public class TestDemo {
    public static void main(String[] args) {
        //判定字符串字串
        String str1 = "hello world";
        String str2 = "wor";
        System.out.println(str1.contains(str2));

        //不光能判断是否为字串，还能确定字串所处的位置
        System.out.println(str1.indexOf(str2));
        //返回-1表示str1不包含str2
        //返回结果是str2再str1中第一次出现的下标
    }

    public static void main7(String[] args) {
        //忽略大小写
        String str1 = "hehe";
        String str2 = "Haha";

        System.out.println(str1.equalsIgnoreCase(str2));//忽略大小写比较
    }

    public static void main6(String[] args) {
        //比较字符串大小
        String str1 = "hehe";
        String str2 = "haha";
        System.out.println(str1.compareTo(str2));
        //compareTo 返回值 >0时，认为str1比str2大
        //compareTo 返回值 <0时，认为str1比str2小
        //compareTo 返回值 ==0时，认为str1与str2相等（内容）
    }

    public static void main5(String[] args) {
        //字符串与字节数组转换

        //字符串转字节数组
        String str = "hello";
        byte[] array = str.getBytes();
        //字节数组转字符串
        String str2 = new String(array);
        System.out.println(str2);
    }

    public static void main4(String[] args) {
        //字符串与字符数组的转化
        //字符串=》字符数组
        String str = "hehe";
        //toCharArray()是把string中包含的字符数组拷贝过来
        char[] data = str.toCharArray();

        //字符数组=》字符串
        //借助String的构造方法即可
        char[] array = {'z','v','v'};
        String str2 = new String(array);
        System.out.println(str);
    }

    public static void main3(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hello";

        //以下方法是反射，可以直接获取到内部结构
        Field field = String.class.getDeclaredField("value");
        //由于String中的value这个字符数组是private的不能直接访问
        field.setAccessible(true);//这就把这个字段改成可访问的了
        char[] value = (char[])field.get(str);//获取到str中的value数组操作
//        for (int i = 0; i < value.length; i++){
//            System.out.println(value[i]);
//        }
        value[0] = 'a';
        System.out.println(str);
    }

    public static void main2(String[] args) {
        //字符串是一个不可变的
//       String str = "hello";
//       str = "HH";//这种赋值只对引用进行赋值而没有对字符串本身进行覆盖
    }

    public static void main1(String[] args) {
        String str1 = "Hello";//最主要的方式
        String str = new String("Hello").intern();//通过intern()方法可以重复利用池中的对象，不需要重新申请一个空间
        //再次执行intern()方法，此时就会再池中查找内容相同的字符常量，如果在池中没有找到，就把当前字符串加到池中，如果已经找到了
        //就返回这个池中的对象
        //节省了空间（但实际开发中很少遇到）
        System.out.println(str.equals(str1));
    }
}

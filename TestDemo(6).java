import javax.xml.soap.SAAJResult;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:String
 * User: Duqiuyu
 * Date: 2020-04-07
 * Time: 18:33
 */
//String  引用类型——>引用的低配指针
public class TestDemo {
    public static void main(String[] args) {
        String str1 = "hello" ;
        String str2 = "Hello" ;
        System.out.println(str1.equals(str2)); // false
        System.out.println(str1.equalsIgnoreCase(str2)); //比较的时候不区分大小写 // true

        //compareTo 比较字符串大小（字典序）
        System.out.println("HEllo".compareTo("hello"));//返回小于0的数

        System.out.println("A".compareTo("a")); // -32
        System.out.println("a".compareTo("A")); // 32
        System.out.println("A".compareTo("A")); // 0
        System.out.println("AB".compareTo("AC")); // -1
    }

    //字符数组与字符串转换
    public static void main6(String[] args) {
        //字符转字符串
        char[] array = {'g', 'e', 'r'};
        String str = new String(array);
        System.out.println(str);

        //字符串转成字符
        char[] array2 = str.toCharArray();//需要字符串拷贝-——效率低
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("========也可以=========");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        //charAt 获取到某个下表对应的字符
        System.out.println(str.charAt(0));

    }

    //那么如果实在需要修改字符串, 例如, 现有字符串 str = "Hello" , 想改成 str = "hello" , 该怎么办
    public static void main5(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //方法二:反射
        String str = "hehe";
        //1.获取到String图纸
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        //2.根据str图纸找到value
        char[] value = (char[])field.get(str);
        value[0] = 'a';
        System.out.println(str);

        //方法一：常规
        /*String str = "Hello";
        str = "h" + str.substring(1);
        System.out.println(str);
         */
    }

    //字符串不可变
    //修改了引用保存的地址，而不是值
    public static void main4(String[] args) {
        String str = "hehe";
        str = "haha";
        System.out.println(str);
    }

    //池
    public static void main3(String[] args) {
        //以下str1~4都在池中
        String str1 = "hehe";
        String str2 = "hehe";
        String str3 = "hehe";
        String str4 = "hehe";
        //intern方法可以主动去池中查找，看看当前这个String是否存在
        //如果不存在，就把这个String加到池中
        //如果已经存在就可以舍弃当前引用，直接获取到池中的对应对象的引用
        String str5 = new String("hehe").intern();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str5);
    }

    /*引用类型比较
      1.比较身份是否相同 (==)
      2.比较值是否相同（XX.equals(XX)）
     */
    public static void main2(String[] args) {
        String str1 = "hehe";
        String str2 = new String("hehe");
        String str3 = "hehe";
        //对于引用类型来说，==比较的是对象的身份，（比较两个引用是不是指向一个地址）
        System.out.println(str1 == str2);//打印false
        System.out.println(str1 == str3);//打印true
        //要想比较值的化，需要使用equals
        System.out.println(str1.equals(str2));//打印true
        System.out.println("hehe".equals(str2));//推荐这种方法（避免空指针异常）
    }

    //创建几个String对象
    public static void main1(String[] args) {

        String str1 = "hehe";//最常用
        String str2 = new String("hehe");
        char[] buffer = {'a','b','c'};
        String str3 = new String(buffer);
    }
}

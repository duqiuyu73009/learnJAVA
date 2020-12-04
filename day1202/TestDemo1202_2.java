package day1202;

public class TestDemo1202_2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello" );//用append来添加字符串
        stringBuilder.append("c");

        stringBuilder.append("hello").append("c");//支持链式调用

    }

    public static void main08(String[] args) {
        String str = "    hello world     ";
        System.out.println(str.trim());//可以去掉前后两端的空白符
    }

    public static void main01(String[] args) {
        //split的实际应用
        String string = "name=zhangsan&age=14&sex=male";
        //1.先按照&进行拆分
        String[] result = string.split("&");
        for (String tmp : result){
            //现在已经按照&拆分好了，开始进行=的拆分
            String[] ret = tmp.split("=");
            if (ret.length != 2){
                continue;
            }
            System.out.println(ret[0] + ": " + ret[1]);
        }
    }

    public static void main0(String[] args) {
        String str = "192.43.67";
        //想按照“.”来切分
        //在这个例子中，split看起来没有找到“.”
        //.在正则表达式中是一种特殊符号，为了让split识别出源字符串中的“.”，就需要进行转意义“\\.”
        String[] result1 = str.split("\\.");//两个转义，一个是在java中进行转义，一个是在正则中表示转义
        String[] result = str.split(".");
        for (String x : result){
            System.out.println(x);
        }
    }
}

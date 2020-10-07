package day1007;

public class TestDemo1007_2 {
    //String[] args  运行时命令行参数
    //当执行循环命令的时候，在运行的cmd窗口时输入就可以直接输出
    //相当于一个数组
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
        System.out.println("kaixin");
    }
}

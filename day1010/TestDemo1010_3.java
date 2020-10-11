package day1010;

/**方法的重载
 * 1.方法名相同
 * 2.返回值不做要求
 * 3.参数列表不同（参数的个数和参数的类型9 ）
 * 4.在同一个类中
 */
public class TestDemo1010_3 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        sum(a,b);

        double d1 = 1.2;
        double d2 = 2.3;
        sum(d1,d2);
    }

    public static int sum(int a, int b){
        return a+b;
    }

    public static double sum(double a, double b){
        return a+b;
    }

    public static double sum(double a, double b, int c){
        return a+b+c;
    }
}

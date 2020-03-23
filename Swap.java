/**
 * Created with IntelliJ IDEA.
 * Description:交换两个数的值
 * User: Duqiuyu
 * Date: 2020-03-21
 * Time: 18:12
 */
class SwapNum{
    public int val;
}
public class Swap {
    public static void swapm(SwapNum swap1 , SwapNum swap2){
        int tmp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = tmp;
        //System.out.println("交换后为："+ a +" , " + b);
    }
    public static void main(String[] args) {
        SwapNum swap1 = new SwapNum();
        swap1.val = 10;
        SwapNum swap2 = new SwapNum();
        swap2.val = 20;
        System.out.println("交换前为：" + swap1.val + " , " + swap2.val);
        swapm(swap1 , swap2);
        System.out.println("交换后为：" + swap1.val  +" , " + swap2.val);

    }
}

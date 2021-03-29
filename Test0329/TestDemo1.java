package Test0329;

public class TestDemo1 {
    //9. 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //n=1时有1种跳法
    //n=2时有2种跳法
    //n=3时有4种跳法
    //n=4时有8种跳法
    public int JumpFloorII(int target) {
        int sum = 1;
        if(target == 0){
            return 0;
        }
        for(int i = 1; i < target; i++){
            sum = 2* sum;
        }
        return sum;
    }

    public int JumpFloorII1(int target) {
        return (int)Math.pow(2, target - 1);
    }

    public int JumpFloorII2(int target) {
        if(target <= 0){
            return -1;
        }else if(target == 1){
            return 1;
        }else{
            return 2*JumpFloorII2(target-1);
        }
    }


    //10.我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    //比如n=3时，2*3的矩形块有3种覆盖方法：
    //n = 1 的时候
    //只能横着覆盖，一种
    //n = 2 的时候
    //可以横着和竖着覆盖，两种
    //n = 3 的时候
    //第三级横着覆盖，用了一级，剩下 n = 2，有两种覆盖方法
    //第三季竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法
    //总共有 3 种
    //n = 4 的时候
    //第 4 级横着覆盖，用了一级，剩下 n = 3，有三种覆盖方法
    //第 4 级竖着覆盖，用了两级，剩下 n = 2，有两种覆盖方法
    //总共有 5 种方法
    //n = n 的时候
    //第 n 级横着覆盖，用了一级，剩下 n = n - 1，所以关注第 n - 1 种有几种覆盖方法
    //第 n 级竖着覆盖，用了两级，剩下 n = n - 2，所以关注第 n - 2 种有几种覆盖方法
    //总和为两种情况的总和
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        int pre1 = 2; // n 最后使用一块，剩下 n-1 块的写法
        int pre2 = 1; // n 最后使用两块，剩下 n-2 块的写法
        for (int i = 3; i <= target; i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1; //相对于 n+1 块来说，第 n 种的方法
    }

    public int rectCover(int target) {

        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }




}

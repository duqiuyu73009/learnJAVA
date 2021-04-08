package day0408;

/**
 * 题目描述
 * 给定一个 double类型的浮点数 base和 int类型的整数 exponent。求 base的 exponent次方。
 *
 * 保证 base和 exponent不同时为 0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面 0的位数。
 *
 * 示例1
 * 输入
 * 2.00000,3
 * 返回值
 * 8.00000
 *
 * 示例2
 * 输入
 * 2.10000,3
 * 返回值
 * 9.26100
 *
 * 示例3
 * 输入
 * 2.00000,-2
 * 返回值
 * 0.25000
 *
 * 说明
 * 2的-2次方等于1/4=0.25
 */
public class TestDemo0408_1 {
    //测试用例73.3%
    public double Power(double base, int exponent) {
        double ret = 1;
        if (base != 0 || exponent != 0) {
            if (exponent > 0) {
                //exponent是大于0的数
                for (int i = 0; i < exponent; i++) {
                    ret *= base;
                }
            } else if (exponent < 0 || base != 0) {
                //exponent是小于0的数
                for (int i = 1; i < Math.abs(exponent); i++) {
                    base *= base;
                }
                ret /= base;
            }else if (exponent == 0 && base != 0){
                ret = 1;
            }
        }
        return ret;
    }



    //测试用例80%
    public double Power1(double base, int exponent) {
        double ret = 1;
        if (exponent > 0){
            //exponent是大于0的数
            for (int i = 0; i < exponent; i++){
                ret *= base;
            }
        }else if (exponent < 0){
            //exponent是小于0的数
            for (int i = 1; i < Math.abs(exponent); i++){
                base *= base;
            }
            ret /= base;
        }
        return ret;
    }
    public double Power2(double base, int exponent) {
        if (base == 0.0){
            return 0.0;
        }
        double ret = 1.0;
        if (exponent > 0){
            //exponent是大于0的数
            for (int i = 0; i < exponent; i++){
                ret *= base;
            }
        }else if (exponent < 0){
            //exponent是小于0的数
            for (int i = 1; i < Math.abs(exponent); i++){
                base *= base;
            }
            ret /= base;
        }else {
            ret = 1;
        }
        return ret;
    }


    //100%
    public double Power3(double base, int exponent) {
        if (base == 0.0){
            return 0.0;
        }
        // 前置结果设为1.0，即当exponent=0 的时候，就是这个结果
        double result = 1.0d;
        // 获取指数的绝对值
        int e = exponent > 0 ? exponent : -exponent;
        // 根据指数大小，循环累乘
        for(int i = 1 ; i <= e; i ++){
            result *= base;
        }
        // 根据指数正负，返回结果
        return exponent > 0 ? result : 1 / result;
    }
}

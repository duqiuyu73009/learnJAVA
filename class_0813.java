package day1;

/**
第3题 最大连续子数组和(Maximum Subarray)
难度：Easy 备注：出自《剑指oﬀer》 题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
在古老的一维模式 识别中,常常需要计算连续子向量的大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是 否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的大和为8(从第0 个开始,到第3个为止)。
给一个数组，返回它的大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少 是1)


 方法：动态规划
 状态：  
 子状态：长度为1，2，3，...,n的子数组和的大值
 F(i):长度为i的子数组和的大值，这种定义不能形成递推关系，舍弃  
 F(i):以array[i]为末尾元素的子数组和的大值
 状态递推：  
 F(i) = max(F(i-1) + array[i]，array[i])  
 F(i) = （F(i-1) > 0）? F(i-1) + array[i] : array[i]
 初始值：
 F(0) = array[0]
 返回结果：
 maxsum：所有F(i)中的大值  
 maxsum = max(maxsum，F(i))
 */
public class class_0813 {
     public int FindGreatestSumOfSubArray(int[] array) {
         // F(i)初始化 maxsum初始化      
         int maxSum = array[0], curSum = array[0];
         for(int i = 1; i < array.length; ++i) {
             //F(i) = max(F(i-1) + array[i]，array[i])            
             curSum = Math.max(curSum + array[i], array[i]);
             // maxsum = max( maxsum，F(i))            
             if(curSum > maxSum) {
                 maxSum = curSum;
             }
         }
         return maxSum;
     }

    public int FindGreatestSumOfSubArray2(int[] array){
         int maxSum = array[0];
         int curSum = array[0];
         for (int i = 1; i < array.length; i++){
             curSum = Math.max(curSum + array[i] , array[i]);
             if (curSum > maxSum){
                 maxSum = curSum;
             }
         }
         return maxSum;
    }

}

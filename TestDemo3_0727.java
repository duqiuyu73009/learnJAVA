package day6_class;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出 来的所有字符串 abc,acb,bac,bca,cab 和 cba
 *
 * //OJ链接：https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?
 * tpId=13&tqId=11180&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //全排列问题，可以看做如下多叉树形态
 * //                ________________ 开始 _______________
 * //              /                   |                  \
 * //        ____ a ____           ___ b ___            ___ c ___           ->    第一阶段
 * //       /           \        /           \        /           \
 * //      b             c      a             c      a             b        ->    第二阶段
 * //      |             |      |             |      |             |
 * //      c             b      c             a      b             a        ->    第三阶段
 * // 很明显，我们想要得到合适的排列组合，一定是深度优先的
 * //该问题可以把目标串理解成两部分：第一部分：以哪个字符开头，第二部分：剩下的是子问题 /
 * /所以，我们要让每个字符都要做一遍开头，然后在求解子问题
 */
//biaojiyixia*****


public class TestDemo3_0727 {
        public void Swap(char[] str, int i, int j){    
            char temp = str[i];        
            str[i] = str[j];        
            str[j] = temp;   
        }
        
        public boolean IsExist(ArrayList<String> result, char[] str){
            return result.contains(String.valueOf(str));
        }     
        
        public void PermutationHelper(char[] str, int start, ArrayList<String> result){
            if(start == str.length - 1){
                if(!IsExist(result, str)){
                    result.add(new String(str));
                }
                return;
            }
            for(int i = start; i < str.length; i++){
                Swap(str, start, i);
                PermutationHelper(str, start+1, result);
                Swap(str, start, i);
            }
        }    
        
        public java.util.ArrayList<String> Permutation(String str) {    
            ArrayList<String> result = new ArrayList<>();
            if(str != null && str.length() > 0){
                PermutationHelper(str.toCharArray(), 0, result);
                Collections.sort(result);      
            }
            return result;
        }
}

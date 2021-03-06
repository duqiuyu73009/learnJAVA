//题目描述
//读入一个字符串str，输出字符串str中的连续最长的数字串
//输入描述:
//个测试输入包含1个测试用例，一个字符串str，长度不超过255。
//输出描述:
//在一行内输出str中里连续最长的数字串。

import java.util.Scanner;

public class TestDemo0306_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String ret = Helper(str);
        System.out.println(ret);
    }

    private static String Helper(String str) {
        //先将字符串转化为数组
        char[] chars = str.toCharArray();
        int count = 0;
        int set = 0;
        //先准备一个备用字符串
        String ret = "";
        for (int i= 0; i < chars.length; i++){
            if (chars[i] <= '9' && chars[i] >= '0'){
                //如果在0-9之间
                count = 1;//用于长度计数
                for (int j = i+1; j < chars.length; j++){
                    if (chars[j] <= '9' && chars[j] >= '0'){
                        count++;
                        set = j;
                    } else {
                        break;
                    }
                }
                if (count > ret.length()){
                    ret = str.substring(i,set+1);
                }
            }
        }
        return ret;
    }




    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String ressult = "";
        int count = 0;
        char [] arr = string.toCharArray();
        for (int i= 0 ;i<arr.length;i++){
            if('0'<=arr[i] && '9'>= arr[i]){//当前的是数字
                count = 1;//初始化计算器
                int index = i;//在后面的循环存储截至索引
                for(int j=i+1;j<arr.length;j++){
                    if('0'<=arr[j] && '9'>= arr[j]){
                        count++;
                        index =j;
                    }else {
                        break;
                    }
                }if(count>ressult.length()){
                    ressult = string.substring(i,index+1);
                }
            }else {
                continue;
            }

        }
        System.out.println(ressult);
    }
}



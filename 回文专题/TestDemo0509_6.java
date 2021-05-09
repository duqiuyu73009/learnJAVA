package 回文专题;

//提供一个字符串和一个字符数组，求最长的回文字符串的长度，要求不包含字符数组中的元素。
//输入：“abbaca” [b,x]
//输出：3
//解释：aca

public class TestDemo0509_6 {
    public static int specialStr (String inputStr, char[] cList) {
        // write code here
        String str = "";
        String max = "";
        if (inputStr.length() == 0 || inputStr == null){
            return 0;
        }
        for (int i = 0; i < inputStr.length(); i++){
            //先将左右两边的字符记录下来
            int left = i;
            int right = inputStr.length()-1;
            while (left <= right){
                int tmp_l = left;
                int tmp_r = right;
                while (tmp_l <= tmp_r){
                    if (inputStr.charAt(tmp_l) != inputStr.charAt(tmp_r)){
                        break;//不是回文
                    }
                    tmp_l++;
                    tmp_r--;
                }
                if (tmp_l >= tmp_r){
                    int count= 0;
                    //取出当前判断出来的回文
                    str = inputStr.substring(left,right+1);
                    // System.out.println("回文为 = "+str);
                    String s = new String(cList);
                    for (int j = 0; j < s.length(); j++){
                        if (str.contains(s.charAt(j)+"")){
                            //如果包含字符数组中的字符
                            count++;
                        }
                    }
                    if (count == 0){
                        //将str和max做对比
                        if (max.length() < str.length()){
                            max = str;
                        }
                    }
                }
                right--;
            }
        }
        return max.length();
    }

    public static void main(String[] args) {
        char[] chars ={'b','x'};
        String s = "abbaca";
        int n = specialStr(s,chars);
        System.out.println(n);
    }
}

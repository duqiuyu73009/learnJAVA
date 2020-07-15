package day_25;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {//字符串长度整数部分不超过13位
        Scanner in = new Scanner(System.in);
        String[] numStrs = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String[] unitStrs1 = {"角","分"};
        String[] unitStrs2 = {"","拾","佰","仟"};
        String[] unitStrs3 = {"","万","亿","万亿"};
        while(in.hasNext()){
            String n = in.nextLine();
            if(n.split("\\.")[0].length() >13){
                System.out.println("字符串长度整数部分不超过13位");
            }
            String result = "";
            String strs2 =n.split("\\.")[1];
            //小数点之后
            if((strs2.length()==1 && strs2.charAt(0)=='0')||(strs2.length()>1&& strs2.charAt(0)=='0'&& strs2.charAt(1)=='0')){//整数
                result += "整";
            }else {//非整数
                for (int i = 0; i < Math.min(2, strs2.length()); i++) {
                    int tmp = strs2.charAt(i) - '0';
                    if (tmp != 0) {
                        result += numStrs[tmp] + unitStrs1[i];
                    }
                }
            }
            char[] chars = n.split("\\.")[0].toCharArray();
            //0元时不写元
            if(!(chars.length == 1 && chars[0]=='0')){
                result = "元"+result;
            }
            //小数点之前
            int count = -1;
            for(int j=chars.length-1; j>=0;){//以四个为一组
                String str = "";
                for(int i=0; i<4 &&j>=0;i++){
                    String num = numStrs[chars[j]-'0'];//当前位的数字
                    if(num.equals("零")){
                        //这个零不能出现在最后一位（10.05）
                        //下一位不是零（100），连续中间有零时只读一个（1001）
                        if(chars.length-1-j != 0 && chars[j+1]!='0' && str.charAt(0)!='零'){
                            str = num + str;
                        }
                    }else if(j==0 && i== 1 &&num.equals("壹")){//防止壹拾壹元等情况的出现
                        str = unitStrs2[i] + str;
                    }else{
                        str = num + unitStrs2[i] + str;
                    }
                    j--;
                }
                count++;
                result = str + unitStrs3[count] + result;
            }
            result = "人民币"+ result;
            System.out.println(result);
        }
    }
}

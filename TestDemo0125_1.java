package day_21_1_24;

//题目描述
//考试题目和要点:
//1、中文大写金额数字前应标明“人民币"字样。中文大写金额数字应用壹、贰、参、肆、伍、陆、染、刻、玫、拾、佰、任、万、亿、元、角、分、零、整等字样填写。(30分)
//2、中文大写金额数字到“元"为止的，在“元"之后，应写“整字，如￥ 532.00应写成“人民币伍佰参拾贰元整”。在"角“和"分“后面不写”整字。(30分)
//3、阿拉伯数字中间有“0"时，中文大写要写“零"字，阿拉伯数字中间连续有几个“0"时，中文大写金额中间只写一个“零"字，
// 如  ￥6007.14，应写成“人民币陆任零染元壹角肆分“。

import java.util.Scanner;

//输入
//151121.15
//输出
//人民币拾伍万壹任壹佰贰拾壹元壹角伍分
public class TestDemo0125_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] s = str.split("\\.");
            int len = s[0].length();
            String s1 = "";
            String s2 = s[0];
            if(s[0].charAt(0) != '0'){//判断整数位
                while(len >0){
                    if(len < 5){
                        s1 += main1(s2);
                        s1+="元";
                        len = 0;
                    }else if(len <= 8){
                        s1 += main1(s2.substring(0,len-4));
                        s2 = s2.substring(len-4);
                        s1+= "万";
                        len = s2.length();
                    }else{
                        s1 += main1(s2.substring(0,len-8));
                        s2 = s2.substring(len-8);
                        s1 +="亿";
                        len = s2.length();
                    }

                }
            }
            if(s[1].charAt(0) == s[1].charAt(1) && s[1].charAt(0) == '0'){
                System.out.println("人民币"+s1+"整");
                return;
            }
            for(int i =0;i<2;i++){//判断小数位
                String[] ss = {"分","角"};
                switch(s[1].charAt(i)){
                    case '0':break;
                    case '1':
                        s1 = s1+ "壹"+ss[2-i-1];break;
                    case '2': s1 = s1 + "贰"+ss[2-i-1];break;
                    case '3': s1+=("叁"+ss[2-i-1]);break;
                    case '4': s1+=("肆"+ss[2-i-1]);break;
                    case '5': s1+=("伍"+ss[2-i-1]);break;
                    case '6': s1+=("陆"+ss[2-i-1]);break;
                    case '7': s1+=("柒"+ss[2-i-1]);break;
                    case '8': s1+=("捌"+ss[2-i-1]);break;
                    case '9': s1+=("玖"+ss[2-i-1]);break;

                }
            }
            System.out.println("人民币"+s1);
        }
    }
    public static String main1(String s){
        int len = s.length();
        int len1 = len;
        String s1 = "";
        String[] ss = {"","拾","佰","仟"};
        for(int i = 0;i<len;i++){
            while(i!= len-1 && s.charAt(i) == '0'&&s.charAt(i+1) == '0'){
                i++;
            }
            switch(s.charAt(i)){
                case '0': s1+="零";break;
                case '1': if(len1 == 2){
                    s1 += ss[len -i-1];
                }else{
                    s1 = s1+ "壹"+ss[len-i-1];
                }break;
                case '2': s1 = s1 + "贰"+ss[len-i-1];break;
                case '3': s1+=("叁"+ss[len-i-1]);break;
                case '4': s1+=("肆"+ss[len-i-1]);break;
                case '5': s1+=("伍"+ss[len-i-1]);break;
                case '6': s1+=("陆"+ss[len-i-1]);break;
                case '7': s1+=("柒"+ss[len-i-1]);break;
                case '8': s1+=("捌"+ss[len-i-1]);break;
                case '9': s1+=("玖"+ss[len-i-1]);break;
            }
            len1 --;
        }
        return s1;
    }
}

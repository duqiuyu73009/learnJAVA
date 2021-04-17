package Test0416;
//题目描述
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
//输入描述:
//输入一个字符串,包括数字字母符号,可以为空
//返回值描述:
//如果是合法的数值表达则返回该数字，否则返回0
//示例1
//输入
//"+2147483647"
//返回值
//2147483647

public class TestDemo0416_1 {
    public int StrToInt(String str) {
        if(str == null || str.length()<=0){
            return 0;
        }
        char[] chars = str.toCharArray();
        long num=0;  //先用long来存储，以防止越界。换算出来的数可能整型溢出
        boolean minus=false;
        for(int i=0; i < chars.length; i++){
            if(i==0 && chars[i]=='-'){
                minus=true;
            }else if(i==0 && chars[i]=='+'){
                minus=false;
            }else{
                int a = (int)(chars[i]-'0');
                if(a<0 || a>9){
                    return 0;
                }
                num= (minus==false) ? num*10+a : num*10-a;

                if((!minus && num>Integer.MAX_VALUE)//Integer.MAX_VALUE  0x7FFFFFFF
                        ||(minus && num<Integer.MIN_VALUE)){//Integer.MIN_VALUE  0x80000000
                    return 0;
                }
            }
        }
        return (int)num;
    }
}

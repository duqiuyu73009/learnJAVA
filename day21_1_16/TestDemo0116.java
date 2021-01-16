package day21_1_16;
////实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
public class TestDemo0116 {
    public String toLowerCase2(String str) {
        if (str == null || str.length() == 0){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : str.toCharArray()){
            if (ch >= 'A' && ch <='Z'){
                stringBuilder.append(ch+32);
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public String toLowerCase1(String str) {
        if (str == null || str.length() == 0){
            return str;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++){
            if (ch[i] >= 'A' && ch[i] <= 'Z'){
                ch[i] += 32;
            }
        }
        return String.valueOf(ch);
    }
}

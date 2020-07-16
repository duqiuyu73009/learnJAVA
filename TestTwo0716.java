package day_38;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class TestTwo0716 {
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuffer str1=new StringBuffer();
        for(int i=0;i<length;i++){
            if(iniString.charAt(i)!=' '){
                str1.append(iniString.charAt(i));
            }else{
                str1.append("%20");
            }
        }
        return str1.toString();
    }
}

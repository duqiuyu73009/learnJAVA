package JZ0526;


/**
 * JZ1   空格替换
 *
 * 描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 示例1
 * 输入：
 * "We Are Happy"
 * 复制
 * 返回值：
 * "We%20Are%20Happy"
 */


public class Test_02 {
    public static String replaceSpace (String s){
        String ret = "";
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                ret += "%20";
            }else {
                ret += s.charAt(i);
            }
        }
        return ret;
    }

    public String replaceSpace2 (String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        return s.replaceAll(" ", "%20");
    }


}

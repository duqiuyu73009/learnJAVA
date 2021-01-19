package day21_1_19;
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，
// 那么最后一个单词就是最后出现的单词。
//
//如果不存在最后一个单词，请返回 0 。
//
//说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/length-of-last-word

public class TestDemo0119_3 {
    public int lengthOfLastWord(String s) {
        if (s == null){
            return 0;
        }
        //先将字符串分隔开
        String[] strings= s.split(" ");
        //取出最后一个单词
        String ret = strings[strings.length-1];
        //转为char类型
        char[] chars = ret.toCharArray();
        return chars.length;

        /*
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ' ') {
            if (count == 0) {
                // 跳过末尾的空格
                continue;
            } else {
                // 结束统计
                break;
            }
        }
        count++;
    }
    return count;
         */
    }
}

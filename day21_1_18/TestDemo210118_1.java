package day21_1_18;

//给定一个赎金信( ransom)字符串和一个杂志( magazine )字符串，
// 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回true ;否则返回false 。
//(题目说明:为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
// 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
public class TestDemo210118_1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        if (chars1.length > chars2.length) {
            return false;
        }
        int[] rans = new int[26];
        int[] maga = new int[26];
        for (char c : chars1) {
            rans[c - 'a']++;
        }
        for (char c : chars2) {
            maga[c - 'a']++;
        }
        for (int i = 0; i < rans.length ; i++) {
            if (rans[i] > maga[i]) {
                return false;
            }
        }
        return true;
    }
}

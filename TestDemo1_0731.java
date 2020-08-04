package day10_class;

/**
 * 公司近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇 感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把 句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助 他么？
 *
 * //OJ链接：https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3? tpId=13&tqId=11197&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //又是一个字符串逆置的问题，我们可以参考上面的思路。不过这里要考虑自己划分子串的问题
 */
public class TestDemo1_0731 {
    public String ReverseSentence(String str){
        if (str == null || str.length() == 0){
            return str;
        }
        char[] list = str.toCharArray();
        int len = list.length;
        int i = 0;
        int j = i;
        while (i < len){
            //让i一直往后走，碰到第一个空格
            while (i < len && !Character.isSpace(list[i])){
                //Character.isSpace(list[i]) 是判断有没有空格
                //如果遇到空格
                i++;
            }
            //逆置当前有效子串，我们采用闭区间
            Reverse(list, j, i-1);
            //过滤所有空格，指向下一个有效子串的开始
            while (i < len && Character.isSpace(list[i])){
                i++;
            }
            j = i;//保存起始位置
        }
        //走到这里，一定是 i == str.size()了，但是后一个有效子串并没有被逆置,逆置之
        Reverse(list, j, i-1);
        Reverse(list, 0, i-1);
        return new String(list);
    }

    private void Reverse(char[] list, int start, int end) {
        while(start < end){
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }
    }

}

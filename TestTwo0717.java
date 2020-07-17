package day_40;
import java.util.*;

/**
 * 使用Java写一个程序：将一个英文语句以单词为单位逆序排放。
 * 例如“I am a boy”，逆序排放后为“boy a am I” 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class TestTwo0717{
    public static void toReverse(String sentence){
        String[] senString = sentence.split(" ");
        for(int i=senString.length-1; i>=0; i--){
            if(i == 0) {
                System.out.print(senString[i]);
            }else {
                System.out.print(senString[i]+" ");
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        toReverse(sentence);
    }
}
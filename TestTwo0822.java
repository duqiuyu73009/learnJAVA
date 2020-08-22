package day_44;
//单词倒排

//这个问题是包含了字符串常见操作的 切分 和 合并
// 核心是在于 split 的用法
import java.util.*;
public class TestTwo0822{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            // 使用正则表达式作为分割符.
            String []strArray=str.split("[^a-zA-Z]+");
            for(int i=strArray.length-1;i>=2;i--){
                System.out.print(strArray[i]+' ');
            }
            if(strArray[0].length()==0)//如果字符串数组的第一个元素是空串，那么下标为1的元素就是最后一个
            //要输出的元素，末尾不要再加空格
            {System.out.println(strArray[1]);}
            else {
                System.out.println(strArray[1] + ' ' + strArray[0]);
            }
        }
    }
}

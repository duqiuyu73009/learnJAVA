package day21_1_22;

//小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
//下，某串珠子里是否包含了全部自己想要的珠子?如果是，那么告诉她有多少多余的珠子;如果不是，那么告诉她缺了多少珠子。
//为方便起见，我们用[O-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串;
// 那么ppRYYGrrYBR2258可以买，因为包含了
//全部她想要的珠子，还多了8颗不需要的珠子;ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
//输入描述:
//每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
//输出描述:
//如果可以买，则在一行中输出"Yes"以及有多少多余的珠子;如果不可以买，则在一行中输出"No”以及缺了多少珠子。其间以1个空格分隔。

//示例1输入输出示例仅供调试，后台判题数据一般不包含示例
//输入
//ppRYYGrrYBR2258
//YrR8RrY
//输出
//Yes 8

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo0122_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            //先输入摊主的珠子，和小红想要的珠子
            String shop = scanner.nextLine();
            String hong = scanner.nextLine();

            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < shop.length(); i++){
                //遍历珠子，如果珠子不存在就添加，存在就将value的值加一
                int l = map.getOrDefault(shop.charAt(i),0);
                //如果不存在，l的值就为 0；如果存在，l的值就为之前的l值
                map.put(shop.charAt(i),l+1);
            }

            int count = 0;

            //接着遍历小红需要的珠子
            for (int j = 0; j < hong.length(); j++){
                int le = map.getOrDefault(hong.charAt(j),0);
                if (le <= 0){
                    //这时，map里面没有这个珠子，就让count++
                    count++;
                }
                map.put(shop.charAt(j), le - 1);
            }
            if (count == 0){
                System.out.println("Yes "+ (shop.length() - hong.length()));
            }else {
                System.out.println("No "+ count);
            }
        }
    }
}

package Test0320;

//题目描述
//nowcoder有两盒(A、B)乒乓球，有红双喜的、有亚力亚的......现在他需要判别A盒是否包含了B盒中所有的种类，
// 并且每种球的数量不少于B盒中的数量，该怎么办呢?

//输入描述:
//输入有多组数据。
//每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
//字符串长度不大于10000。

//输出描述:
//每一组输入对应一行输出:如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出"Yes";否则输出"No”
//

import java.sql.Connection;
import java.util.*;

//ABCDFYE CDE
//ABCDGEAS CDECDE
//
//Yes
//No。
public class TestDemo0320_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            String[] sA = str[0].split("");
            String[] sB = str[1].split("");
            HashMap<String,Integer> mapA = new HashMap<>();
            HashMap<String,Integer> mapB = new HashMap<>();
            for (String s1:sA){
                if (!mapA.containsKey(s1)){
                    mapA.put(s1,1);
                }else {
                    mapA.put(s1,mapA.get(s1)+1);
                }
            }
            for (String s1:sB){
                if (!mapB.containsKey(s1)){
                    mapB.put(s1,1);
                }else {
                    mapB.put(s1,mapB.get(s1)+1);
                }
            }
            int count=0;
            for (int i = 0;i<sB.length;i++){
                if (mapA.containsKey(sB[i])){
                    mapA.put(sB[i],mapA.get(sB[i])-1);
                    if (mapA.get(sB[i])<0){
                        System.out.println("No");
                        break;
                    }
                    count++;
                }else {
                    System.out.println("No");
                    break;
                }
            }
            if (count==sB.length){
                System.out.println("Yes");
            }
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            boolean contain = true;
            StringBuffer input = new StringBuffer(in.next());
            char[] find = in.next().toCharArray();
            for (char c : find) {
                int index = input.indexOf(String.valueOf(c));
                if (index != -1){
                    input.deleteCharAt(index);
                } else {
                    System.out.println("No");
                    contain = false;
                    break;
                }
            }
            if (contain){
                System.out.println("Yes");
            }
        }
    }

    //有错误！！！
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> listA = new ArrayList<>();
        List<Character> listB = new ArrayList<>();
        while (scanner.hasNext()){
            //输入A和B字符串
            String s = scanner.nextLine();
            String[] src = s.split(" ");
            String srcA = src[0];
            String srcB = src[1];

            for (int i = 0; i < srcA.length(); i++){
                listA.add(srcA.charAt(i));
            }
            for (int j = 0; j < srcB.length(); j++){
                listB.add(srcB.charAt(j));
            }

            //把两个字符串进行排序
            Collections.sort(listA);
            Collections.sort(listB);
            if (srcA.length() < srcB.length()){
                //如果判断出来A的String长度没有B的长，那么就已经不满足题目条件了
                System.out.println("No");
                return;
            }
            int lenA = listA.size();
            int lenB = listB.size();
            for (int j = 0; j < lenB; j++){
                for (int i = 0; i < lenA; i++){
//                    if (listB.isEmpty()){
//                        break;
//                    }
                    if (listA.get(i).equals(listB.get(j))){
                        //如果相等，就移出链表
                        listA.remove(i);
                        listB.remove(j);
                        continue;
                    }else {
                        //如果不相等，就移除listA中的一个数
                        listA.remove(i);
                    }
                }

            }
            if (listA.isEmpty()&&(!listB.isEmpty())){
                //如果上面循环结束之后，listA走完了，而listB没走完，就说明A中不全包含B
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}

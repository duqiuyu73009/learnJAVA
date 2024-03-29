package day_45;
import java.util.*;

public class TestOne0824 {
    // 基本思路
    // 借助 哈希表 保存每个盒子中的每种球的类别和数目.
    // 然后遍历其中的一个 map 和另外一个 map 进行对比即可.
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String boxA=sc.next();
            String boxB=sc.next();
            // 创建两个 hash 表. key 为球的种类, value 为球的数量
            HashMap<String,Integer> hashMapBoxA=new HashMap<String,Integer>();
            HashMap<String,Integer> hashMapBoxB=new HashMap<String,Integer>();
            // 初始化 BoxA
            for(int i=0;i<boxA.length();i++){
                if(hashMapBoxA.containsKey(boxA.charAt(i)+"")){
                    hashMapBoxA.put(boxA.charAt(i)+"",hashMapBoxA.get(boxA.charAt(i)+"")+1);
                }else{
                    hashMapBoxA.put(boxA.charAt(i)+"",1);
                }
            }
            // 初始化 BoxB
            for(int i=0;i<boxB.length();i++){
                if(hashMapBoxB.containsKey(boxB.charAt(i)+"")){
                    hashMapBoxB.put(boxB.charAt(i)+"",hashMapBoxB.get(boxB.charAt(i)+"")+1);
                }else{
                    hashMapBoxB.put(boxB.charAt(i)+"",1);
                }
            }
            // 遍历 BoxB, 和 BoxA 中的元素进行对比. flag 表示是否是满足包含关系
            int flag=0;
            for(String key:hashMapBoxB.keySet()){
                if(!hashMapBoxA.containsKey(key)){
                    flag=1;
                    break;
                }else{
                    if(hashMapBoxA.get(key)<hashMapBoxB.get(key)){
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==1){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
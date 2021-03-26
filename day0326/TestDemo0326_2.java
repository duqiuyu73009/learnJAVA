package day0326;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 复习
 */
//class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//}

public class TestDemo0326_2 {
    //1.题目描述
//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
//每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//示例1
//输入
//复制
//7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
//返回值
//复制
//true
    public boolean Find(int target, int [][] array){
        if (array.length == 0 || array == null){
            return false;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    // for(int[] i : array){
    //           for(int j : i){
    //               if(j == target){
    //                   return true;
    //               }
    //           }



    //2.题目描述
    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
    // 则经过替换之后的字符串为We%20Are%20Happy。
    //示例1
    //输入
    //复制
    //"We Are Happy"
    //返回值
    //复制
    //"We%20Are%20Happy"
    public static String replaceSpace (String s) {
        return s.replaceAll("s\\","%20");
    }
    public static String replaceSpace1 (String s){
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


    //3.题目描述
    //输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    //示例1
    //输入
    //复制
    //{67,0,24,58}
    //返回值
    //复制
    //[58,24,0,67]
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (listNode != null){
//            arrayList.add(listNode.val);
//            listNode = listNode.next;
//        }
//        Collections.reverse(arrayList);//将整个链表反转
//        return arrayList;
//    }

}

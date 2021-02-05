package day21_2_5;

import java.util.*;

//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//
//要求返回这个链表的 深拷贝。 
//
//我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
//
//val：一个表示 Node.val 的整数。
//random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class TestDemoSet {
    public Node copyRandomList(Node head) {
        //1.遍历旧链表，把旧链表这里的每个节点一次插入到map中，key是旧节点，value是新的节点
        Map<Node,Node> map = new HashMap<>();
        for (Node cur = head; cur!= null; cur = cur.next){
            map.put(cur,new Node(cur.val));
        }
        //2.再次遍历链表，修改新链表节点中的next和random
        for (Node cur = head; cur!= null; cur = cur.next){
            //先从map中找到cur对应的新链表节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        //需要返回新链表的头节点
        return map.get(head);

    }

    // 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    //
    //J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
    //
    //示例 1:
    //
    //输入: J = "aA", S = "aAAbbbb"
    //输出: 3
    //示例 2:
    //
    //输入: J = "z", S = "ZZ"
    //输出: 0

    public int numJewelsInStones(String jewels, String stones) {
        //先遍历，把所有的宝石类型加到Set中
        Set<Character> set = new HashSet<>();
        for (char i : jewels.toCharArray()){
            set.add(i);
        }
        int ret = 0;
        for (char i : stones.toCharArray()){
            if (set.contains(i)){
                ret++;
            }
        }
        return ret;
    }

    //链接：https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
    //来源：牛客网
    //
    //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
    //肯定坏掉的那些键。
    //
    //输入描述:
    //输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
    //以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
    //
    //
    //输出描述:
    //按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
    //示例1
    //输入
    //7_This_is_a_test<br/>_hs_s_a_es
    //输出
    //7TI
    public static void main(String[] args) {
        //1.循环输入两个字符串
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String expected = scanner.next();
            String actual = scanner.next();
            //2.把读入的两个字符串全部转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //3.创建一个set保存实际那些字符输出了
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++){
                //如果add的时候发现这个元素已经存在，那么就没有add成功
                actualSet.add(actual.charAt(i));
            }
            //4.遍历预期输出的字符串，看看哪个字符没有被实际输出
            Set<Character> brokenKeySet = new HashSet<>();
            for (int i = 0; i < expected.length(); i++){
                char c = expected.charAt(i);//取到当前字符
                if (actualSet.contains(c)){
                    //没坏
                    continue;
                }
                //坏了
                if (brokenKeySet.contains(c)){
                    //这个坏键已经被打印过了
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }

    }

    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序
    //输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    //输出: ["i", "love"]
    //解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    //    注意，按字母顺序 "i" 在 "love" 之前。
    //
    static class MyComparator implements Comparator<String>{
        private Map<String,Integer> map;

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2){
                return o1.compareTo(o2);
            }
            return count2-count1;//降序排列
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        //1.先统计每个单词出现的个数
        Map<String,Integer> map = new HashMap<>();
        for (String s : words){
            Integer count = map.getOrDefault(s,0);
            map.put(s,count+1);
        }
        //2.需要把刚才的内容放到ArrayList中
        //keySet相当于得到了一个Set，Set中存放的就是所有的key
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        //3.按照刚才的字符串出现次数，进行排序
        //sort 默认按照升序排列
        //此处需要按照字符串出现次数降序排列，也就是通过比较器来自定制比较规则
        Collections.sort(arrayList,new MyComparator(map));
        return arrayList.subList(0,k);//获取到前k个元素
    }


    public List<String> topKFrequent2(String[] words, int k) {
        //1.先统计每个单词出现的个数
        Map<String,Integer> map = new HashMap<>();
        for (String s : words){
            Integer count = map.getOrDefault(s,0);
            map.put(s,count+1);
        }
        //2.需要把刚才的内容放到ArrayList中
        //keySet相当于得到了一个Set，Set中存放的就是所有的key
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        //3.按照刚才的字符串出现次数，进行排序
        //sort 默认按照升序排列
        //此处需要按照字符串出现次数降序排列，也就是通过比较器来自定制比较规则

        //匿名内部类
        //一般就是这个类只需要用一次，用完就丢了，这个时候可以用匿名内部类
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2){
                    return o1.compareTo(o2);
                }
                return count2-count1;//降序排列
            }
        });
        return arrayList.subList(0,k);//获取到前k个元素
    }
    
}

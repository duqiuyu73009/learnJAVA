package day21_2_4;

//关于对象值大于、等于、小于的比较-基于比较器
//使用Comparator的时候，需要重新创建一个新的类实现Comparator接口，不需要修改待比较类的代码（可以实现自定义的多个比较规则）

//equals和Comparable互不相干

import java.util.Comparator;

class Card2 implements Comparable<Card2> {
    //指定泛型参数，编译器自动完成类型校验工作
    //如果不屑泛型参数，默认的compareTo方法的参数类型就是Object类型，需要程序员手动进行类型转换
    public String rank;
    public String suit;

    public Card2(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        //按照值来比较this 和 obj
        //1.自己和自己比较的情况
        if (this == obj){
            return true;
        }
        //2.obj为null的情况，
        if (obj == null){
            return false;
        }
        //3.obj这个类型是不是当前的Card类型
        if (!(obj instanceof  Card2)){
            return false;
        }
        //4.比较内容
        Card2 other = (Card2)obj;
        return this.rank.equals(other.rank) && this.suit.equals(other.suit);
    }

    @Override
    public int compareTo(Card2 o) {
        //如果this比o小，返回<0;
        //如果this比o大,返回>0；
        //如果this和o相等，返回0；
        if (o == null){
            //一般认为null的值比较小
            return 1;
        }
        //点数的取值有2——10整数，J Q K A
        int rank1 = this.getValue();
        int rank2 = o.getValue();
        return rank1-rank2;
    }

    public int getValue(){
        int value = 0;
        if ("J".equals(rank)){
            value = 11;
        }else if("Q".equals(rank)){
            value = 12;
        }else if ("K".equals(rank)){
            value = 13;
        }else if ("A".equals(rank)){
            value = 14;
        }else {
            value = Integer.parseInt(rank);//吧字符串转成数字
        }
        return value;

    }
}

class CardComparator implements Comparator<Card2>{
    @Override
    public int compare(Card2 o1, Card2 o2) {
        if (o1 == o2){
            return 0;
        }
        if (o1 == null){
            return -1;
        }
        if (o2 == null){
            return 1;
        }
        int value1 = o1.getValue();
        int value2 = o2.getValue();
        return value1-value2;
    }
}

public class TestDemo0203_3 {
    public static void main(String[] args) {
        Card2 p = new Card2("3","♠");
        Card2 q = new Card2("3","♥");
        Card2 o = p;

        CardComparator cardComparator = new CardComparator();
        System.out.println(cardComparator.compare(p,q));
    }
}

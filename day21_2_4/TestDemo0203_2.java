package day21_2_4;

//关于对象值大于、等于、小于的比较-基于自然顺序
//Comparable在使用的时候，必须要让比较的类实现Comparable接口，（需要改变这个类的代码）(不是所有的类都能修改)（只能定义一种比较规则）
//耦合性就更强一些(不愿意看到的事情)
//Comparable<E>
class Card1 implements Comparable<Card1> {
    //指定泛型参数，编译器自动完成类型校验工作
    //如果不屑泛型参数，默认的compareTo方法的参数类型就是Object类型，需要程序员手动进行类型转换
    public String rank;
    public String suit;

    public Card1(String rank, String suit) {
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
        if (!(obj instanceof  Card1)){
            return false;
        }
        //4.比较内容
        Card1 other = (Card1)obj;
        return this.rank.equals(other.rank) && this.suit.equals(other.suit);
    }

    @Override
    public int compareTo(Card1 o) {
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

    private int getValue(){
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

public class TestDemo0203_2 {
    public static void main(String[] args) {
        Card1 p = new Card1("3","♠");
        Card1 q = new Card1("3","♥");
        Card1 o = p;

        System.out.println(p.compareTo(q));
        System.out.println(p.compareTo(o));

    }
}
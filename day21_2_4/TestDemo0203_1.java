package day21_2_4;

//对象的比较--------------比较相等
//比较身份： ==
//比较值：  equals
//比较类型：  instanceof
class Card{
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
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
        if (!(obj instanceof  Card)){
            return false;
        }
        //4.比较内容
        Card other = (Card)obj;
        return this.rank.equals(other.rank) && this.suit.equals(other.suit);
    }
}

public class TestDemo0203_1 {
    public static void main(String[] args) {
        Card p = new Card("3","♠");
        Card q = new Card("3","♠");
        Card o = p;

        System.out.println(p == o);//true
        System.out.println(p == q);//false

        System.out.println("========================");

        System.out.println(p.equals(o));//true
        System.out.println(p.equals(q));//false
        //如果equals没有手动重写，默认执行的就是Object版本的equals，比较规则也是比较身份
        //当重写了之后，打印结果就均为true

    }
}

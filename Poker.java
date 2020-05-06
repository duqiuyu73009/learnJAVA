
//创建一副牌，洗牌，发牌

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Poker {
    //不加static 的内部类，当我们创建Card的对象时候，就必须依赖Pocker 的实例
    //加上static 的内部类，当我们创建Card的时候， 就不依赖Pocker的实例

    //描述一张扑克牌
    static class Card {
        public String suit;
        public String rank;

        public Card(String suit, String rank){
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString(){
            return "("+ suit + rank +")";
            //或者 String.format("(%s%s)",suit,rank);
        }
    }

    //构建一副牌
    public static List<Card> buyPoker(){
        String[] suits = {"♥","♠","♣","♦"};
        List<Card> poker = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            //先处理简单的部分 2——10
            for(int j = 2; j<=10 ; j++){
                Card card = new Card(suits[i],"" + j);
                poker.add(card);
            }
            poker.add(new Card(suits[i], "J"));
            poker.add(new Card(suits[i], "Q"));
            poker.add(new Card(suits[i], "K"));
            poker.add(new Card(suits[i], "A"));
        }
        return poker;
    }

    public static void shuffle(List<Card> poker){
        //从后往前遍历，每次取到一个牌后，就和前面一个随机位置进行交换
        Random random = new Random();
        //访问每一个元素
        for(int i = poker.size() - 1 ; i > 0 ; i--){
            //产生一个【0，i）随机数
            int r = random.nextInt(i);
            swap(poker , i , r);
        }
    }

    private static void swap(List<Card> poker, int i, int j){
        Card tmp = poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }

    public static void main(String[] args) {
        //先买一副牌，打印
        List<Card> poker = buyPoker();
        System.out.println(poker);
        //洗牌
        //标准库中的洗牌方法  Collections.shuffle(poker);
        shuffle(poker);
        System.out.println(poker);
        //发牌，把牌发给三个人，没人发五张
        //通过嵌套List来表示
        //每个玩家的手牌是一个List，多个玩家的手牌再放到一个List中
        List<List<Card>> players = new ArrayList<List<Card>>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());

        for (int cardIndex = 0; cardIndex < 5; cardIndex++){
            for(int playIndex = 0; playIndex < 3; playIndex++){
                //先取到这个玩家
                List<Card> player = players.get(playIndex);
                //再把poker中的最前面的元素发给当前玩家
                Card topCard = poker.remove(0);
                player.add(topCard);
            }
        }

        //展示手牌 ，比大小
        System.out.println("玩家1 的手牌");
        System.out.println(players.get(0));
        System.out.println("玩家2 的手牌");
        System.out.println(players.get(1));
        System.out.println("玩家3 的手牌");
        System.out.println(players.get(2));
    }
}

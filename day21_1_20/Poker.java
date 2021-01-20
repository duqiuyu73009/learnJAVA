package day21_1_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//先建立一副牌
class Card{
    //先定义花色和点数
    private String rank;
    private String suit;

    //建立构造方法
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //建立set和get方法

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    //建立toString方法

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}

public class Poker {
    public static void main(String[] args) {
        //先创建一副牌
        List<Card> poker = new ArrayList<>();
        //洗牌
        Collections.shuffle(poker);
        //创建三个玩家
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        //发牌
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                List<Card> player = players.get(j);
                player.add(poker.remove(0));
            }
        }
        //发牌结束
        for (int i = 0; i < 3; i++){
            System.out.println("玩家"+ i+":"+players.get(i));
        }
    }

    //添加牌
    public static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        String[] suit = {"♠","♥","♣","♦"};
        for (int i = 0; i < 4; i++){
            for (int j = 2; j <= 10; j++){
                poker.add(new Card(""+j,suit[i]));
            }
            poker.add(new Card("A",suit[i]));
            poker.add(new Card("J",suit[i]));
            poker.add(new Card("K",suit[i]));
            poker.add(new Card("Q",suit[i]));
        }
        return poker;
    }
}

package day21_2_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo0207_1 {
    //一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下:我每天给你10万元，你第一天给我1分钱，第二天2分钱，
    //第三天4分钱......
    //这样交换30天后，百万富翁交出了多少钱?陌生人交出了多少钱?(注意一个是万元，一个是分)
    public static void main1(String[] args) {
        int rich = 0;
        int poor = 1;
        for (int i = 0; i < 30; i++){
            rich += 10;
        }
        for (int j = 0; j < 30; j++){
            poor += poor * 2;
        }
        System.out.println(rich+" " + poor);
    }

    //题目描述
    //风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。给你一个回顾历史的机会，
    // 已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素(prices[i])代表该股票第i天的股价。
    // 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，
    // 收益为0。设计算法，计算你能获得的最大收益。输入数值范围: 2<=n<=100,0<=prices[i]<=100
    public int calculateMax(int[] prices) {
        int[] lprofit=new int[prices.length];//存放max{第一次卖出-第一次买入｝
        int[] rprofit=new int[prices.length];//存放max｛第二次持有最高值-第二次买入｝
        //从左到右循环
        int maxProfit=0;//计算已有的最大收益
        int minPrice=prices[0];//已经获得的最小值
        for(int i=0;i<prices.length;i++){
            if(minPrice>prices[i]){
                minPrice=prices[i];
            }
            if(maxProfit< (prices[i]-minPrice)){//最大值产生比较
                maxProfit=(prices[i]-minPrice);
            }
            lprofit[i]=maxProfit;
        }
        //从右到左循环
        maxProfit=0;
        rprofit[prices.length-1]=0;
        int maxPrice = prices[prices.length-1];
        minPrice=prices[prices.length-1];
        int temp;
        for(int j=(prices.length-2);j>=0;j-- ){
            if(maxPrice<prices[j]){
                maxPrice=prices[j];
            }
            if(maxProfit<(temp=maxPrice-prices[j])){
                maxProfit=temp;
            }
            rprofit[j]=maxProfit;
        }

        //计算总和
        maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if((temp=lprofit[i]+rprofit[i]) >maxProfit ){
                maxProfit=temp;
            }

        }
        return maxProfit;

    }

    //输入一行字符串，计算其中A-Z大写字母出现的次数
    //输入描述:
    //案例可能有多组，每个案例输入为一行字符串。
    //输出描述:
    //对每个案例按A-z的顺序输出其中大写字母出现的次数。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char[] ch = s1.toCharArray();
            for (int i = 0; i < ch.length; i++){
                map.put(ch[i],0);
            }
            for (int i = 0; i < chars.length; i++){
                if (chars[i] >= 'A' && chars[i] <= 'Z'){
                    Integer count = map.getOrDefault(chars[i],0);
                    map.put(chars[i],count+1);
                }
            }
            for (Map.Entry<Character,Integer> entry : map.entrySet()){
                System.out.println(entry.getKey()+ ":" + entry.getValue());
            }
        }
    }
}

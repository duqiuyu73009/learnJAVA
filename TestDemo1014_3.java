package day_1014;
//有小鸡，公鸡，母鸡三种鸡，小鸡一块钱三只，公鸡五块一只，母鸡三块钱一只，一共要买100只，只有100元钱，有多少种组合方式
public class TestDemo1014_3 {
    //执行21次
    public static void main(String[] args) {
        int count = 0;
        double j = 0;
        int k = 0;
        for (int i = 0 ; i <= 20; i++){
            j = 25 - (7/4.0)*i;
            k = 100-i-(int)j;
            if ((5 * i + 3 * j + k / 3) == 100 && j >= 0) {
                System.out.println("公🐓" + i +" "+ "母🐓" + (int)j + " " + "小🐓" + k);
            }
            count++;
        }
        System.out.println("共执行了" + count + "次");
    }

    //执行次数：714
    public static void main3(String[] args) {
        int count = 0;
        for (int i = 0; i <= 20 ; i++){
            for (int j = 0; j <= 33; j++){
                int k = 100 - i - j;
                if ((5*i+3*j+k/3.0) == 100){
                    System.out.println("公🐓"+i+"母🐓"+j+"小🐓"+k);
                }
                count++;
            }
        }
        System.out.println("共执行了" + count + "次");
    }

    //执行次数：10201
    public static void main2(String[] args) {
        int count = 0;
        for (int i = 0; i <= 100 ; i++){
            for (int j = 0; j <= 100; j++){
               int k = 100 - i - j;
               if ((5*i+3*j+k/3.0) == 100){
                   System.out.println("公🐓"+i+"母🐓"+j+"小🐓"+k);
               }
               count++;
            }
        }
        System.out.println("共执行了" + count + "次");
    }


    //执行次数：346834
    public static void main1(String[] args) {
        int count = 0;
        for (int i = 0; i <= 100 ; i++){
            for (int j = 0; j <= 100; j++){
                for (int k = 0; k <= 100; k=k+3){
                    if (i+j+k == 100){
                        if ((5*i+3*j+k/3.0) == 100){
                            System.out.println("公🐓"+i+"母🐓"+j+"小🐓"+k);
                        }
                    }
                    count++;
                }
            }
        }
        System.out.println("共执行了" + count + "次");
    }
}

package day_0930;

import java.util.Scanner;

/**
 * 把100分制的分数转化为10分制
 */
public class TestDemo0930_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int score = scanner.nextInt();
            int result = Score(score/10);
            System.out.println(result);
        }
    }

    public static int Score(int score){
        int result = 0;
        switch (score){
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                break;
            case 3:
                result = 3;
                break;
            case 4:
                result = 4;
                break;
            case 5:
                result = 5;
                break;
            case 6:
                result = 6;
                break;
            case 7:
                result = 7;
                break;
            case 8:
                result = 8;
                break;
            case 9:
                result = 9;
                break;
            case 10:
                result = 10;
                break;
        }
        return result;
    }
}

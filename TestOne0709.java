package day_33;

import java.util.Scanner;

/**
 * 石头剪刀布比输赢
 */
public class TestOne0709 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int[] A = {0,0,0};
            int[] B = {0,0,0};
            int win = 0;
            int lose = 0;
            int equal = 0;
            //输入一个数 x ，确定甲乙两人一共需要完成多少局比赛
            String y = scanner.nextLine();
            int x = Integer.parseInt(y);
            //循环输入数组 str ，保存甲乙双方每次的输入状况
            for (int i = 0; i < x; i++){
                String s = scanner.nextLine();
                String[] str = s.split(" ");
                //比较str数组的0位置和1位置的元素
                //相等的情况
                if (str[0].equals(str[1])){
                    equal++;
                }else {
                    if (helpGames(str[0],str[1],A,B)) {
                        //如果不相等，单独建立一个函数来计算输赢
                        win++;
                    }else {
                        lose++;
                    }
                }
            }
            Character a = get(A);
            Character b = get(B);

            System.out.println(win + " " + equal + " " + lose );
            System.out.println(lose + " " + equal + " " + win);
            System.out.println(a + " " + b);
        }
    }

    private static Character get(int[] a) {
        if (a[0] > a[1] && a[0] > a[2]){
            return 'C';
        }else if (a[1] > a[0] && a[1] > a[2]){
            return 'J';
        }else if (a[2] > a[0] && a[2] > a[1]){
            return  'B';
        }else if (a[0] == a[2]){
            if (a[0] > a[1]){
                return 'B';
            }else {
                return 'J';
            }
        }else if (a[1] == a[2]){
            if (a[1] > a[0]){
                return 'B';
            }else {
                return 'C';
            }
        }else if (a[0] == a[1]){
            if (a[0] > a[2]){
                return 'C';
            }else {
                return 'B';
            }
        }else {
            return null;
        }
    }

    private static boolean helpGames(String a, String b, int[] A, int[] B) {
        if (a.equals("C") && b.equals("J")){
            A[0]++;
            return true;
        }else if (a.equals("J") && b.equals("B")){
            A[1]++;
            return true;
        }else if (a.equals("B") && b.equals("C")){
            A[2]++;
            return true;
        }else if (b.equals("C") && a.equals("J")){
            B[0]++;
            return false;
        }else if (b.equals("J") && a.equals("B")){
            B[1]++;
            return false;
        }else if (b.equals("B") && a.equals("C")){
            B[2]++;
            return false;
        }else {
            return false;
        }
    }
}

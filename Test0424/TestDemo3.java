package Test0424;

import java.util.Scanner;

public class TestDemo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] month = new int[2];
        int[] year = new int[4];
        int j = 0;
        int k = 0;
        String s = null;
        if (str.length() >= 4 && str.length() <= 6) {
            for (int i = str.length()-2; i <= str.length()-1 ; i++){
                month[j] = Integer.valueOf(str.charAt(i));
                j++;
            }
            //这个时候month中已经放好了月份

            for (int i = str.length()-2-2; i <str.length()-2 ; i++){
                year[k] = Integer.valueOf(str.charAt(i));
                k++;
            }

            s = "";
            if (year[0] < 2 && year[1] < 2){
                s = "20" + (year[0]-48)+(year[1]-48)+"-"+(month[0]-48)+(month[1]-48);
            }else {
                s = "19" + (year[0]-48)+(year[1]-48)+"-"+(month[0]-48)+(month[1]-48);
            }
        }
        System.out.println(s);
    }
}

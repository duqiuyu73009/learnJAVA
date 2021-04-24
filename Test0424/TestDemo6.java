package Test0424;

import java.util.Scanner;

public class TestDemo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        String[] strings = new String[n];
        for (int i = 0; i < strings.length; i++){
            strings[i] = scanner.nextLine();
        }

        String[] str = new String[k];
        if (k < strings.length){
            for (int i = 0 ; i <= k ; i++){
                if ((!strings[i].contains("easy")) || (!strings[i].contains("qiandao"))){
                    //不包含这些字样的时候
                    str[i] = strings[i];
                }
            }
            System.out.println(str[str.length-1]);
        }else if (k > strings.length){
            System.out.println("Wo AK le");
        }
    }
}

package Test0521;

import javafx.beans.property.IntegerProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestDemo0521_2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T != 0){
            String s1 = bufferedReader.readLine();
            String[] int1 = s1.split(" ");
            int n = Integer.parseInt(int1[0]);
            int q = Integer.parseInt(int1[1]);

            String num =bufferedReader.readLine();

            for (int i = 0; i < q; i++){
                String s2 = bufferedReader.readLine();
                String[] int2 = s2.split(" ");
                int x = Integer.parseInt(int2[0]);
                int k = Integer.parseInt(int2[1]);

                for (int j = 0; j < num.length(); j++){
                    if  (num.charAt(j)== k){
                        int point = i;
                        int del = Math.abs(point - x);
                        System.out.println(del);
                        continue;
                    }
                }
            }
            T--;
        }


    }
}

package Test0321;

import java.io.*;
import java.util.Scanner;

public class Main2 {
    static int[] father;
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while((str = bufferedReader.readLine()) != null) {
                String[] parts = str.split(" ");
                int n = Integer.parseInt(parts[0]);
                if(n == 0) {
                    //直接退出
                    break;
                }
                int m = Integer.parseInt(parts[1]);
                father = new int[n+1];
                for(int i = 1; i <= n; i++){
                    father[i] = i;
                }
                for(int i = 0; i < m; i++) {
                    String[] nums = bufferedReader.readLine().split(" ");
                    combine(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
                }
                int sum = -1;
                for(int i = 1; i <= n; i++) {
                    if(father[i] == i) {
                        sum++;
                    }
                }
                System.out.println(sum);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static int find(int x) {
        while(x != father[x]){
            x = father[x];
        }
        return x;
    }

    public static void combine(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
        }
    }
}

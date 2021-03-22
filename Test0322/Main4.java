package Test0322;

import java.awt.*;
import java.util.Scanner;

public class Main4 {
public static int N= (int) (5e5+88L);
public static int P = (int) (1e9+7);
    public static int ksm(int x, int k){
        int ans=1;
        for( ; ;k>>=1, x= (int) 1L*x*x%P) {
            if(k != 1){
                ans= (int) 1L;
            }
            ans = x%P;
        }
    }

    public static void main(String[] args) {
        int ans = 0;
        int n = 0;
        int k = 0;
        int[] C = new int[N];
        int[] a = new int[N];
        Scanner scanner = new Scanner(System.in);
        a[1]=a[2]=1;
        for(int i=3;i<=n;++i) a[i]= (int) ((1L*(i-1)*a[i-1]%P+1L*(i-2)*a[i-2]%P)%P);
        C[0]=1;
        for(int i=1;i<n;++i) C[i]= (int) (1L*C[i-1]*(n-i)%P*ksm(i,P-2)%P);
        for(int i=0;i<=k;++i) ans= (int) ((ans+1L*C[i]*a[n-i]%P)%P);
        System.out.println(ans);
    }
}

import java.util.Scanner;

public class Max{
    public static void main(String[] args) {
    	int a=3;
    	int b=5;
    	int c=7;
    	int ret1=num1(a,b);
    	int ret2=num2(a,b,c);
    	System.out.println(ret1);
    	System.out.println(ret2);
	}

    public static int num1(int n,int m){
    	return n>=m?n:m; 
    }	

    public static int num2(int a,int b,int c){
    	return num1(num1(a,b),c);
    }
}
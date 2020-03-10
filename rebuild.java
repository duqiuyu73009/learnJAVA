
import java.util.Scanner;
public class rebuild{
    //方法的重建
    public static void main(String[] args) {
    	int a=1;
    	int b=2;
    	int c=3;
    	double d=2.3;
    	double e=3.3;
		int m=num(a,b);//两个整形	
		int n=num(a,b,c);//三个整形
		double r=num(d,e);	//两个double型
		System.out.println(m);
		System.out.println(n);
		System.out.println(r);
	}

    public static int num(int a,int b) {
    	int sum;
    	return sum=a+b;
    }	

    public static int num(int a,int b,int c) {
    	int sum;
    	return sum=a+b+c;
    }	

    public static double num(double a,double b) {
    	double sum;
    	return sum=a+b;
    }	
}

  



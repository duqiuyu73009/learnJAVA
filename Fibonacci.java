
import java.util.Scanner;
public class Fibonacci{
	public static void main(String[] args){
		System.out.println("请输入您需要计算到第n项");
		Scanner scan=new Scanner(System.in);
	    int n = scan.nextInt();
	    int sum=0;
	    int j;
	    for(j=1;j<=n;j++){
	        sum=sum+Num(j);
	    }	   
	    System.out.println("结果为"+sum);		
	}
	//递归
	public static int Num(int n){
		if(n==1){
			return 1;
		}else if(n==2){
			return 1;
		}else{
			return Num(n-1)+Num(n-2);				
		}
	}

	//非递归
	public static int fib(int n){
		int last2=1;
		int last1=1;
		int cur=0;
		for(int i=3;i<=n;i++){
			cur=last1+last2;
			last2=last1;
			last1=cur;
		}
		return cur;
	}
}
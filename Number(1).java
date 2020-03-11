
import java.util.Scanner;
public class Number{
	//主函数
	public static void main(String[] args){
		System.out.println("请输入您需要计算到第n项");
		Scanner scan=new Scanner(System.in);
	    int n = scan.nextInt();
	    int ret=Num2(n);	  
	    System.out.println("结果为"+ret);		
	}
	//递归
	public static int Num2(int j){
		if(j==1){
			return 1;
		}else{
			return j*Num2(j-1);
		}
	}
}
import java.util.Scanner;
public class Num{
	//主函数
	public static void main(String[] args){
		System.out.println("请输入您需要计算到第n项");
		Scanner scan=new Scanner(System.in);
	    int n = scan.nextInt();
	    int sum=0;
	    int j;
	    for(j=1;j<=n;j++){
	      sum=sum+Num2(j);
	    }	  
	    System.out.println("结果为"+sum);		
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




	//非递归
	public static int Num(int n){
		int i;
		int tmp=1;
		for(i=1;i<=n;i++){
		    tmp=tmp*i;
		}
		return tmp;
	}
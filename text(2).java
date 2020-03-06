import java.util.Scanner;

public class text{
	//输出数字带有9的
	public static void main(String[] args) {
		int i=1;
		while(i<=100){
			if(((i%10)/9==1) || (i/10==9)){
				System.out.print(i+" ");
			}
			i++;
		}
	}

   
    //倒序输出一个整数的每一位
	public static void main2(String[] args) {
		Scanner scan=new Scanner(System.in);	    
	    System.out.println("请问输入的为几位数？");
		int i =scan.nextInt();
		System.out.println("请输入数字");
		int a =scan.nextInt();
		int count;
		for(count=0 ; count<i ; count++){
			int n=a%10;
			a=a/10;
			System.out.print(n+" ");
		}
	}
}
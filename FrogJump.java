import java.util.Scanner;
public class FrogJump{
	public static void main(String[] args){
		System.out.println("请输入青蛙跳台阶的阶数");
		Scanner scan=new Scanner(System.in);
	    int n = scan.nextInt();
	    int ret=Jump(n);
	    System.out.println(ret);
	}
	public static int Jump(int num){
		if(num <= 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else if (num == 2) {
			return 2;
		}
		return   Jump(num - 1) + Jump(num - 2);
	}
}
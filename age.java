import java.util.Scanner;
public class age{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入年龄");
   		int a=scan.nextInt();
   		if(a<=18){
   			System.out.println("少年");
   		}
   		if(19<=a && a<=28){
   			System.out.println("青年");
   		}
   		if(29<=a && a<=55){
   			System.out.println("中年");
   		}
   		if(a>=56){
   			System.out.println("老年");
   		}
	}
}

import java.util.Random;
import java.util.Scanner;
public class Number{
		public static void main(String[] args) {	    	
	    Scanner scan=new Scanner(System.in);	    
	    Random random = new Random();//1.生成一个随机数
	    int rand = random.nextInt(100);//只能取到1-99；
	    while(true){
	    	System.out.println("请输入你猜的数字");
	    	int num =scan.nextInt();
	    	if(num>rand){
	    		System.out.println("你猜的数字大了！");
	    	}else if(num == rand){
	    		System.out.println("猜对了");
	    		break;
	    	}else {
	    		System.out.println("你才对数字小了！");
	    	}
	    }
	    System.out.println("游戏结束！");	   
	}
}



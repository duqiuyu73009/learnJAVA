
import java.lang.Math;
import java.util.Scanner;
public class num{
	//输出1-100的素数
	public static void main2(String[] args) {
   		int i=2;
   		int num=1;
   		for(num=1 ; num<100 ; num++){
	   	    for(i=2 ; i<=num-1 ; i++){
	   	    	if(num%i==0){
	   	    		break;
	   	    	}
	   	    	if(i<num){
   	    			System.out.println("不是素数");
   	    	  	}else{
	   	    		System.out.println("是素数");  	    		
	   	    	    }
	   	    	}
	   	    } 
	   	}



	//判断是否为素数
	public static void main1(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入数字");
   		int num=scan.nextInt();
   		int i=2;
   	    for(i=2 ; i<=num-1 ; i++){
   	    	if(num%i==0){   	    		
   	    		break;
   	    	}
   	    	//因为会出现两种情况
   	    	//1.循环正常退出  素数
   	    	//2.因为break    那么i++ 还是有i<num 不是素数
   	    	if(i<num){
   	    		System.out.println("不是素数");
   	    	}else{
   	    		System.out.println("是素数");  	    		
   	    	} 	    		
   	    	}
   	    }


       //判断是否为素数，优化方法1
   	    public static void main3(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入数字");
   		int num=scan.nextInt();
   		int i=2;
   	    for(i=2 ; i<=num/2 ; i++){
   	    	if(num%i==0){   	    		
   	    		break;
   	    	}
   	    	if(i<num/2){
   	    		System.out.println("不是素数");
   	    	}else{
   	    		System.out.println("是素数");  	    		
   	    	}
   	    		
   	    	}
   	    }  

       //判断是否为素数，优化方法2
   	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入数字");
   		int num=scan.nextInt();
   		int i=2;
   	    for(i=2 ; i<=Math.sqre(num) ; i++){//根号
   	    	if(num%i==0){   	    		
   	    		break;
   	    	}
   	    	if(i<Math.sqre(num)){
   	    		System.out.println("不是素数");
   	    	}else{
   	    		System.out.println("是素数");  	    		
   	    	}
   	    		
   	    	}
   	    }  
	}


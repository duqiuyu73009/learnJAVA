

import java.io.IOException;//需要导入IOException包
import java.util.Scanner;
public class TextDemo{
	public static void main(String[] args){

		System.out.println();//输出且换行
		System.out.print();//输出不换行
		System.out.printf("%d\n",n);//输出，\n为换行
}

	public static void main(String[] args){
	    Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
	    int n =scan.nextInt();
	    System.out.println("整型"+n);	
		}
	    System.out.println("结束");	
	}


		public static void main4(String[] args) {	    	
		String name=scan.next();//next遇到空格就结束，空格后的不打印
	   //nextLine可以输出全部的字符，但是一定不能和nextInt使用
	    System.out.println("姓名："+name);

	}

		public static void main1(String[] args) {	    	
	    Scanner scan=new Scanner(System.in);
	    //int型调用nextInt()
	    int n =scan.nextInt();
	    System.out.println("整型"+n);
        //string类型用scan.next()
	    String name=scan.next();
	    System.out.println("姓名："+name);
	    //double类型用nextDouble()
	    double d=scan.nextDouble();
	    System.out.println("小数："+d);
	    //float类型用nextFloat()
	    float c=scan.nextFloat();
	    System.out.println("Float小数："+c);
	    //boolean类型用nextBoolean()
	    boolean c=scan.nextBoolean();
	    System.out.println("boolean类型："+c);
	    //char类型没有直接的调用方法，
	    //用string类型表示，查charAt()获取字符索引型
	    String n=scan.next();
	    char nChar=n.charAt(0);
	    System.out.println("char类型"+name);

	    scan.close();
	}



	public static void main2(String[] args) {	    
	    try{
	    	System.out.println("请输入一个字符");
	    	char ch=(char)System.in.read();
            System.out.println("请输入一个字符"); 
        }catch(IOException e){
        	System.out.println("输出");
        }
	}
} 




        	
       
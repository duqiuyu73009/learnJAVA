
//逻辑控制
//在任何语言，他的构成，一定是通过逻辑构成
//分支结构
//if   switch



import java.util.Scanner;

public class Text{

	//shitch的用法
    public static void main4(String[] args) {
    Scanner scan=new Scanner(System.in);
       int n =scan.nextInt();
       switch(n) {//switch（）里面可以放整形
       	  case 1:
       	     System.out.println("1");
       	     break;//如果不加break，就接着往下运行，直到遇到下一个break
       	   case 2:
       	     System.out.println("2");
       	     break;
       	   case 3:
       	     System.out.println("3");
       	     break;
           default:
              System.out.println("输入有误！");
              break;
       }

    }

	  //闰年：
      //如果可以整除4但是不能被100整除
      //或者可以被400整除
    public static void main3(String[] args) {
       Scanner scan=new Scanner(System.in);
       int year =scan.nextInt();
       if((year%4==0) && (year%100!=0) || (year %400==0)){
       	System.out.println ("当前"+year+"是闰年");
       }
    }

    //读入一个数字，判断是奇数还是偶数
	public static void main2(String[] args) {	   
	    Scanner scan=new Scanner(System.in);
        //循环 停下来的方法
        //ctr+c 中断
        //ctr+z 正常停止
	    while (scan.hasNext()){
		    int n=scan.nextInt();
		    if(n%2==0){
		    	System.out.println("当前数字为偶数");
		    }else{
		    	System.out.println("当前数字为奇数");
		    }
	   }
	 }

    //if的用法
	public static void main1(String[] args) {
		int a = 10;
		//在Java中，真为true，假就是false
		if(a>0){
			//if()里的为布尔类型
			System.out.println("正数");
	    }else if(a<0){
	    	System.out.println("负数");
	    }
    }
		
}
import java.util.Scanner;
public class PassWord{
	public static void main(String[] args) {
	    Scanner scan=new Scanner(System.in);
	    System.out.println("请输入您的6位密码，您有3次机会");
	    int count =3;
	    while(count!=0){
	    System.out.println("请输入您的密码");    	
	    	 String p=scan.next();
	    	 if(p.equals("123456")){//判断字符串是否相同
	    	 	System.out.println("登陆成功");
	    	 	break;
	    	 }else{
	    	 	count--;
	    	 	if(count==0){
	    	 		System.out.print("3次密码均错误，登陆失败！");
	    	 	}else{
	    	 	System.out.println("登陆失败，您还有"+count+"机会！");
	    	    }
	        }
	    }
    }
}
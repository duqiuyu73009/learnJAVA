


import java.util.Scanner;
public class num{
	//求两个数的最大公约数
	public static void main(String[] args) {
	    Scanner scan=new Scanner(System.in);
	    int n =scan.nextInt();
	    int m =scan.nextInt();
	    int t,i;
	    if(m<n){
	    	t=m;
	    	m=n;
	    	n=t;
	    }//让m始终为最大；
	    for(i=n ; i>0 ; i--){
	    	if(m%i==0 && n%i==0){
	    		System.out.println("最大公约数为"+i);
	    		break;
	    	}
	    }
	}

	//两个数的所有公约数
    public static void main1(String[] args) {
	    Scanner scan=new Scanner(System.in);
	    int n =scan.nextInt();
	    int m =scan.nextInt();
	    int t,i;
	    if(m<n){
	    	t=m;
	    	m=n;
	    	n=t;
	    }//让m始终为最大；
	    for(i=1 ; i<=n ; i++){
	    	if(m%i==0 && n%i==0){
	    		System.out.println("公约数为"+i);
	    	}
	    }
	}
}
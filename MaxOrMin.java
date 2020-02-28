


public class MaxOrMin{
	public static void main(String[] args) {
		int a=3;
		int b=2;
		int c=1;				
		if(a>b){
			int t=a;
			a=b;
			b=t;
        }
        if(b>c){
			int p=b;
			b=c;
			c=p;
        }
		System.out.println("max=="+c);
		System.out.println("min=="+a);
	}
}
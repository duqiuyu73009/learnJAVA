
public class form{
	public static void main(String[] args) {
		int i=1,j=1;
		int a=0;
		for(i=1 ; i<=9 ; i++){
			for(j=1 ; j<=i ; j++){
				a=i*j;
				System.out.print(i+"*"+j+"="+a+" ");
				if(j==i){
					System.out.println("\n");
				}
			}
		}
	}
}
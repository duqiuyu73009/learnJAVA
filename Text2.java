
//循环
//while （表达式）  表达式为布尔类型
//for



import java.util.Scanner;
public class Text2{
    //for循环的应用
    public static void main(String[] args) {
    	for(int i=1; i<=100 ; i++){
    		System.out.print(i+" ");
    	}    	
    }

	//阶乘的和；
    public static void main6(String[] args) {
    	Scanner scan=new Scanner(System.in);
        int n =scan.nextInt();
        int sum = 0;       
        int j=1;
        while(j<=n){
        	int i=1;
	        int ret=1;
	        while(i<=j){
	        	ret =ret *i;
	        	i++;
            }
            sum +=ret;
            j++;
        }
        System.out.println("阶乘的和"+sum);
	}

	//n的阶乘
    public static void main5(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n =scan.nextInt();
        int i=1;
        int ret=1;
        while(i<=n){
        	ret =ret *i;
        	i++;
        }
        System.out.println("阶乘"+ret);
	}

    //1-100的奇数的和
    public static void main4(String[] args) {
    	int i = 1;
    	int sum = 0;
    	while(i<=100){
    		sum+=i;
    		i=i+2;
    		}
    		System.out.println(sum);
    	}
    

	//1-100的偶数的和
    public static void main3(String[] args) {
    	int i = 2;
    	int sum = 0;
    	while(i<=100){
    			sum+=i;
    			i=i+2;
    		}
    		System.out.println(sum);
    	}
    

   //1-100的和
    public static void main2(String[] args) {
    	int i = 1;
    	int sum = 0;
    	while(i <= 100){
    		sum+=i;
    		i++;
    	}
    	System.out.println(sum);
    }

	//打印1-10
    public static void main1(String[] args) {
        int num = 10;
        int i=1;
        while(i<=num){
        	System.out.print(i+" ");
        	i++;
        }
    }
}
import java.util.Scanner;
public class year{	
	public static void main(String[] args) {
		for(int year=1000 ; year<=2000 ; year++){
			if((year%4==0) && (year%100!=0) || (year %400==0)){
	       		System.out.println (year);
	        }
		}
	}
}
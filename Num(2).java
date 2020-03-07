

//输出水仙花数/四叶草数。。。。
//
//1.求当前为几位数
//2.求每一位数的次方
//3.加和判断是否与原数字相等
import java.lang.Math;
import java.util.Scanner;
public class num{	
	public static void main(String[] args) {
	    for(int i=0;i<=999999;i++){
	    	int count=0;//代表数字位数
	    	int tmp=i ;//先保存起来
	    	while(tmp!=0){//求数字为几位数，用除法！！！
	    		count ++;
	    		tmp =tmp /10;
	    	}//运算完成后i=0；
	    	tmp=i;
            int sum=0;
	    	//求数字的每一位，求次方
	    	while(tmp!=0){
	    		sum+=Math.pow(tmp%10,count);//tmp每一位的count次方 加和
	    		tmp=tmp/10;
	    	}
	    	if(sum == i){
	    		System.out.println(sum+"是你找的数字");
	    	}
	    }
	}
}
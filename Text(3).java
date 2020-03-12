public class Text {
    public static void main(String[] args) {
        int n=1729;
        int ret=sum(n) ;
        System.out.println(ret);
    }
    //1729每一位相加
    public static int sum(int num) {
        if(num<10){
            return num;
        }
        return num%10+sum(num/10);
    }
}
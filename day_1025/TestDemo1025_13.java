package day_1025;

public class TestDemo1025_13 {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i <= 5 ; i++){
            for (int j = 0; j <= 4; j++){
                for (int k = 0; k <= 8; k++){
                    sum = 1*i + 5*j + 10*k;
                    System.out.print(sum+ " ");
                    count++;
                    }
                }
            }
        System.out.println();
        System.out.println("总共执行了："+count+"次");
        }
}

package Test0508;

public class TestDemo0508_2 {
    public long getCubeNumber (long c) {
        // write code here
        for (long a = 0; a * a * a <= c; a++){
            //long b = (long) Math.sqrt(c - a * a * a);
            long b = (long) Math.pow((c - a * a * a),1.0/3);
            if (b == (int) b){
                return a>b?a:b;
            }
        }
        return -1;
    }

    public long getCubeNumber2 (long c) {
        long left = 0;
        long right = (long) Math.pow(c, 1.0/3);
        while (left <= right){
            long sum = left * left * left + right * right * right;
            if (sum == c){
                return left > right ? left : right;
            }else if (sum > c){
                right--;
            }else {
                left++;
            }
        }
        return -1;
    }
}

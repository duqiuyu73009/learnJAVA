package day1;

public class TestDemo3_0911 {
        public int NumberOf1(int n) {
            int count = 0;
            //直接调用十进制转位二进制的方法
            String binaryNum = Integer.toBinaryString(n);
            for(int i = 0; i < binaryNum.length(); i++){
                if(binaryNum.charAt(i) == '1') {
                    count++;
                }
            }
            return count;
        }
    }

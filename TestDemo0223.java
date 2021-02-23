package day_2;


public class TestDemo0223 {
    //给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
// 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
//对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
//示例1
//输入
//复制
//[1,2,3,4,5]
//返回值
//复制
//[120,60,40,30,24]
    public int[] multiply(int[] A) {

        if(A==null || A.length == 0){
            return null;
        }

        int[] B = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            int res = 1;
            for (int j = 0; j < A.length; j++) {
                if( i == j){
                    temp = A[j];//临时变量存储A[j]的值，避免数组值的改变
                    A[j] = 1;
                    res *= A[j];
                    A[j] = temp;
                }else {
                    res *= A[j];
                }
            }
            B[i] = res;
        }
        return B;
    }


    //请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"
    // 都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
    //示例1
    //输入
    //复制
    //"123.45e+6"
    //返回值
    //复制
    //true
    public boolean isNumeric(char[] str) {
        String ss = String.valueOf(str);
        //先判断每个字符是否合法
        int len = ss.length();
        for(int i=0; i<len; i++){
            char c = ss.charAt(i);
            if(!((c>='0' && c <= '9') || c=='e' || c=='E' || c=='+' || c=='-'|| c=='.')){
                return false;
            }
        }
        //正负号,E不能在末尾
        if(ss.charAt(len-1) == '+' || ss.charAt(len-1) == '-' || ss.charAt(len-1) == 'E' || ss.charAt(len-1) == 'e'){
            return false;
        }
        //判断小数点，只能有一个
        if(ss.indexOf(".") != ss.lastIndexOf(".")){
            return false;
        }
        //正负号在中间的位置时，前面的是e，E,后面是数字
        for(int i=1; i<len-1; i++){
            char c = ss.charAt(i);
            if(c == '+' || c=='-'){
                if(!(ss.charAt(i-1) == 'e' || ss.charAt(i-1) == 'E') ||
                        !(ss.charAt(i+1)>='0' && ss.charAt(i+1)<='9')){
                    return false;
                }
            }
        }
        //e的后面不能有小数点
        for(int i=1; i<len; i++){
            char c = ss.charAt(i);
            if(c == 'e' || c=='E'){
                if(ss.charAt(i+1) == '+' || ss.charAt(i+1) == '-'){
                    if(ss.indexOf(".", i+2) != -1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

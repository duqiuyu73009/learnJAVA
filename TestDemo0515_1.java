package Test0511;

//题目描述
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
// 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
// （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
//对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
//示例1
//输入
//[1,2,3,4,5]
//返回值
//[120,60,40,30,24]

public class TestDemo0515_1 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = A[i];
            A[i] = 1;
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                B[i] *= A[j];
            }
            A[i] = temp;
        }
        return B;
    }

    public int[] multiply1(int[] A) {
        int length=A.length;
        int[] B=new int[length];
        //边界
        if(A==null||A.length<=1){
            return null;
        }
        //计算下三角
        //初始化第一行
        B[0]=1;
        for(int i=1;i<length;i++){
            B[i]=B[i-1]*A[i-1];
        }
        //计算上三角
        //初始化最后一行
        int temp=1;
        for(int i=length-1;i>=0;i--){
            B[i]=temp*B[i];
            temp=A[i]*temp;
        }
        return B;
    }

    public int[] multiply3(int[] A) {
        if(A==null || A.length<2) {
            return null;
        }
        int[] B=new int[A.length];
        B[0]=1;
        //这一轮循环下来，B数组中暂时存放了自己对应左下三角的乘积
        //即自己分成了左右两部分相乘后，左边部分的值此时拿到了
        for(int i=1;i<A.length;i++) {
            B[i]=B[i-1]*A[i-1];
        }
        int temp=1;
        for(int i=A.length-2;i>=0;i--){
            temp*=A[i+1];
            //temp =temp*A[i+1]; temp就是i位置对应的右边部分的值 从A[n-1]一直乘到A[1]
            B[i]*=temp;
            //B[i] =B[i]*temp; 左边部分乘上右边部分
        }
        return B;
    }
}

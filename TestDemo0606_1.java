/**
 * 描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 示例1
 * 输入：
 * [1,2,3,4,5]
 * 复制
 * 返回值：
 * [120,60,40,30,24]
 */

public class TestDemo0606_1 {
    //方法一
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 0) {
            return null;
        }
        int[] C = new int[A.length];
        C[0] = 1;
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }
        int[] D = new int[A.length];
        D[D.length - 1] = 1;
        for (int i = D.length - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = C[i] * D[i];
        }
        return result;
    }

    //方法二
    public int[] multiply2(int[] A) {
        int[] first = new int[A.length];
        int[] back = new int[A.length];
        first[0] = back[0] = 1;
        for (int i = 1; i < A.length; i++) {
            first[i] = first[i - 1] * A[i - 1];
            back[i] = back[i - 1] * A[A.length - i];
        }
        int[] B = new int[A.length];
        for (int j = 0; j < A.length; j++) {
            B[j] = first[j] * back[A.length - j - 1];
        }
        return B;
    }

}

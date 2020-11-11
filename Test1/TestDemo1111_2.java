package Test1;

public class TestDemo1111_2 {

    //---------------------------两个矩阵相加-----------------------------------
    public static int[][] add(int[][] a, int[][] b) {
        int row = a.length;   //行的长度
        int col = a[0].length;   //列的长度
        int[][] ret = new int[row][col];
        //判断b矩阵是否和a矩阵的行列个数一样，如果一样继续执行
        if (row != b.length || col != b[0].length) {
            System.out.println("请输入一样长度的两个矩阵");
        }else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    ret[i][j] = a[i][j] + b[i][j];
                }
            }
        }
        return ret;
    }

    //---------------------------两个矩阵相减-----------------------------------
    public static int[][] sub(int[][] a, int[][] b) {
        int row = a.length;
        int col = a[0].length;
        int[][] ret = new int[row][col];
        if (row != b.length || col != b[0].length) {
            System.out.println("请输入一样长度的两个矩阵");
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    ret[i][j] = a[i][j] - b[i][j];
                }
            }
        }
        return ret;
    }

    //---------------------------矩阵与常数k相乘----------------------------------
    public static int[][] dot(int[][] a, int b) {
        int row = a.length;
        int col = a[0].length;
        int[][] ret = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[i][j] = a[i][j] * b;
            }
        }
        return ret;
    }

    //---------------------------两个矩阵相乘-----------------------------------
    public static int[][] dot(int[][] a, int[][] b) {
        int row = a.length;
        int col = a[0].length;
        int[][] ret = new int[row][col];
        if (col != b.length) {
            System.out.println("错误！");
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    ret[i][j] = 0;
                    for (int k = 0; k < col; k++) {
                        ret[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return ret;
    }

    //---------------------------求矩阵的逆-----------------------------------
    public static int[][] transport(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    //---------------------------打印格式-----------------------------------
    public static void print(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            System.out.print("[");
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
                if (j != col - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");
        }
    }


    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 3, 4 } };
        int[][] b = { { 7, 8 }, { 6, 5 } };
        //a矩阵为
        System.out.println("a = ");
        print(a);
        //b矩阵为
        System.out.println("b = ");
        print(b);

        //两矩阵的加法：
        int[][] ret1 = add(a, b);
        System.out.println("a + b = ");
        print(ret1);

        //两矩阵相减
        int[][] ret2 = sub(a, b);
        System.out.println("a - b = ");
        print(ret2);

        //矩阵与常数相乘
        int[][] ret3 = dot(a, 8);
        System.out.println("a * 8 = ");
        print(ret3);

        //两矩阵相乘
        int[][] ret6 = dot(a, b);
        System.out.println("a * b = ");
        print(ret6);

        //两矩阵相除
        int[][] ret4 = transport(a);
        System.out.println("a的逆 = ");
        print(ret4);
        int[][] ret5 = dot(a, ret4);
        System.out.println("a / b = ");
        print(ret5);
    }
}

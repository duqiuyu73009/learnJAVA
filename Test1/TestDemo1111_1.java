package Test1;

public class TestDemo1111_1 {
    //矩形9*9乘法表————for循环方式
    public static void RecmulFor(){
        for (int i = 1;i <= 9;i++){
            for (int j = 1; j <= 9; j++){
                System.out.print(i +"*" + j + "=" + (i * j)+"\t");
            }
            System.out.println();
        }
    }

    //矩形9*9乘法表————while循环方式
    public static void RecmulWhich(){
        int i = 1;
        int j = 1;
        while (i <= 9){
            while (j <= 9){
                System.out.print(i +"*" + j + "=" + (i * j)+"\t");
                j++;
            }
            System.out.println();
            j = 1;//让j重新计数；
            i++;
        }
    }

    //矩形9*9乘法表————下三角（L型）break
    public static void TriangleBreak(){
        for (int i = 1;i <= 9;i++){
            for (int j = 1; j <= 9; j++){
                if (j <= i){
                    System.out.print(i +"*" + j + "=" + (i * j)+"\t");
                }else {
                    break;
                }
            }
            System.out.println();
        }
    }

    //矩形9*9乘法表————下三角（L型）continue
    public static void TriangleContinue(){
        for (int i = 1;i <= 9;i++){
            for (int j = 1; j <= 9; j++){
                if (j <= i){
                    System.out.print(i +"*" + j + "=" + (i * j)+"\t");
                }else {
                    continue;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------调用：矩形9*9乘法表————for循环方式--------------------");
        RecmulFor(); //调用：矩形9*9乘法表————for循环方式
        System.out.println("-------------------调用：矩形9*9乘法表————which循环方式-------------------");
        RecmulWhich(); //调用：矩形9*9乘法表————which循环方式
        System.out.println("-------------- ---调用：矩形9*9乘法表————下三角（L型）break----------------");
        TriangleBreak();
        System.out.println("-------------- ---调用：矩形9*9乘法表————下三角（L型）continue----------------");
        TriangleContinue();
    }
}

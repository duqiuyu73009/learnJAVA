package Shannon;

import java.util.Arrays;
import java.util.Scanner;


public class TestShannon {
    /**
     * 将概率从大到小排序
     */
    public double[] Sort(double[] p){
        double[] p1 = new double[p.length];
        for(int i = 0; i < p1.length; i++){
            p1[i] = p[i];
        }
        Arrays.sort(p1);
        for(int i = 0, j = p.length-1; i < p.length/2; i++, j--){
            double temp = p1[i];
            p1[i] = p1[j];
            p1[j] = temp;
        }
        return p1;
    }

    /**
     * 验证概率和是否为1，合格为true，否则false
     */
    public boolean varification(double[] p){
        boolean bool = false;
        double d = 0;
        for(int i = 0; i < p.length; i++){
            d+=p[i];
        }
        if(d - 1.0 < 0.000001){
            return true;
        }
        return bool;
    }

    /**
     * 计算每个信源的码长
     */
    public int[] codeLength(double[] p){
        int[] Li = new int[p.length];
        double temp = 0;
        for(int i = 0; i < Li.length; i++){
            temp = - (Math.log(p[i]) / Math.log(2.0));
            Li[i] = (int)Math.ceil(temp);
        }
        return Li;
    }

    /**
     * 计算信源的熵
     */
    public double entropyAll(double[] p){
        double H = 0;
        for(int i = 0; i < p.length; i++){
            H-=(p[i] * (Math.log(p[i]) / Math.log(2.0)));
        }

        return H;
    }

    /**
     * 计算平均码长
     */
    public double averageCodeLength(double[] p, int[] Li){
        double n = 0;
        for(int i = 0; i < p.length; i++){
            n+=p[i] * Li[i];
        }

        return n;
    }

    /**
     * 计算累加概率
     */
    public double[] accumulation(double[] p){
        double[] q = new double[p.length];
        q[0] = 0;

        for(int i = 1; i < p.length; i++){
            q[i] = q[i-1] + p[i-1];
        }
        return q;
    }

    /**
     * 计算二进制编码
     */
    public int[][] binaryMode(double[] acl, int[] cl){
        int[][] c = new int[acl.length][];
        for(int i = 0; i < acl.length; i++){
            c[i] = new int[cl[i]];
        }

        double[] a = new double[acl.length+1];
        for(int i = 0; i < acl.length; i++){
            for(int j = 0; j < cl[i]; j++){
                if(j == 0){
                    a[j] = acl[i] * 2;
                }else{
                    a[j] = a[j-1] * 2;
                }
                if(a[j] > 1){
                    c[i][j] = 1;
                    a[j] = a[j] - 1;
                }else{
                    c[i][j] = 0;
                }
            }
        }

        return c;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TestShannon t = new TestShannon();
        System.out.println("输入信源的个数：");
        int num = sc.nextInt();
        double[] p = new double[num];
        System.out.println("输入概率：");
        for(int i = 0; i < p.length; i++){
            p[i] = sc.nextDouble();
        }
        if(!t.varification(p)){
            System.out.println("输入的概率有误！");
            return;
        }
        double[] q = t.Sort(p);

        int[] cl = t.codeLength(p);

        double[] acl = t.accumulation(p);
        int[][] c = t.binaryMode(acl, cl);
        System.out.println("概率              香农编码");
        for(int i = 0; i < p.length; i++){
            System.out.print(q[i]+"--->");
            for(int j = 0; j < cl[i]; j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
        double avg = t.averageCodeLength(p, cl);
        double ea = t.entropyAll(p);
        System.out.println("平均码长为："+avg);
        System.out.println("信源的信息熵为："+ea);
        System.out.println("编码效率为"+ea/avg);

    }
}


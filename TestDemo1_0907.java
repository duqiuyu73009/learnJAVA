package day1;

public class TestDemo1_0907 {
    public static void main(String[] args) {
        int i1 = 15;
        //i1 = i1++;
        System.out.println(i1++);//预测输出 16   错    实际输出15

        int i2 = 2;
        int j2 = i2++ * 3;
        System.out.println(j2);//预测输出 6    对

        int i = 2;
        int j = ++i * 3;
        System.out.println(j);//预测输出 9     对
    }

    private static int i = 1;
    public int getNext(){
        return i++;
    }
    public static void main2(String [] args){
        TestDemo1_0907 test=new TestDemo1_0907();
        TestDemo1_0907 testObject=new TestDemo1_0907();
        test.getNext();
        testObject.getNext();
        System.out.println(test.getNext());//预测输出 2     错    实际输出 3
    }
}

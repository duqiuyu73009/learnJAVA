package day1011;

/**
 * A B C三个架子，让A是盘子挪到C上，且不改变放置顺序
 */
public class TestDemo1011_1 {
    //1个盘子：A——>B                                     1  2^1-1
    //2个盘子：A-->B A-->C B-->C                         3  2^2-1
    //3个盘子：A-->C A-->B C-->B A-->C B-->A B-->C A-->C 7  2^3-1
    //64.....2^64-1

    //pos1 起始位置
    //pos2 中途位置
    //pos3 目的地位置


    public static void hanoi(int n, char pos1, char pos2, char pos3){
        if (n == 1){
            move(pos1,pos3);
        }else {
            hanoi(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanoi(n-1,pos2,pos1,pos3);
        }
    }

    private static void move(char pos1, char pos3) {
        System.out.print(pos1 + "->" + pos3 + " ");
    }

    public static void main(String[] args) {
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();
        hanoi(4,'A','B','C');
    }
}

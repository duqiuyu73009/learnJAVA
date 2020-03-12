package Text;

public class Hello {
    public static void main(String[] args) {
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();
    }
    public static void move(char pos1,char pos3) {
        System.out.print(pos1+"->"+pos3+" ");
    }
    public static void hanoi(int n,char pos1,char pos2,char pos3) {
       if(n==1){
           move(pos1,pos3);
           return;
       }
        hanoi(n-1,pos1,pos3,pos2);//开始位置，中转位置，目的位置
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);//开始位置，中转位置，目的位置
    }
}

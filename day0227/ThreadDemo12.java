package day0227;

public class ThreadDemo12 {
    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}


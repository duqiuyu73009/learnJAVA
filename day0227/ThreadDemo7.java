package day0227;

public class ThreadDemo7 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (!isQuit){
                    System.out.println("正在转载");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("转载被终止");
            }
        };
        t.start();

        Thread.sleep(5000);
        System.out.println("需要赶快终止交易！！");
        isQuit = true;
    }
}

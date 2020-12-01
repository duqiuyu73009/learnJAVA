package day1201;
import java.io.*;

public class TestDemo1201_3{
    public static void main(String[] args){
        TestDemo1201_3 t = new TestDemo1201_3();
        try{
            t.readFile();
        }catch(IOException e){
            System.out.println(e);
            System.out.println("退出！");
        }
    }

    public void readFile() throws IOException {
        FileInputStream in = new FileInputStream("Test2.java");
        int b = in.read();//如果达到末尾返回null
        while(b!= -1) {
            System.out.print((char)b);
            b = in.read();
        }
        in.close();
    }
}

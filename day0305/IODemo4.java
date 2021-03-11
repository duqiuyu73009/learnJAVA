package day0305;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class IODemo4 {
    public static void main(String[] args) {
        //使用缓冲区和使用缓冲区来感受时间上的差异
        testNoBuffer();
        testBuffer();
    }

    private static void testNoBuffer() {
        long beg = System.currentTimeMillis();
       try ( FileInputStream fileInputStream = new FileInputStream("D:/file_dir/1010.png")){
           int ch = -1;
           while ((ch = fileInputStream.read()) != -1){

           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       long end = System.currentTimeMillis();
        System.out.println("no buffer:"+(end-beg)+"ms");
    }

    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStreamf= new BufferedInputStream(new FileInputStream("D:/file_dir/1010.png"))){
            int ch = -1;
            while ((ch = bufferedInputStreamf.read()) != -1){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("buffer:"+(end-beg)+"ms");
    }
}

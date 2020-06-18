package java_0618;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IODemo4 {
    public static void main(String[] args) {
        //分别用不使用缓冲区和使用缓冲区来读取一个大文件，感受时间的差异
        testNoBuffer();//没有缓冲区
        testBuffer();//有缓冲区
    }

    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""))){
            int ch = -1;
            while ((ch = bufferedInputStream.read()) != -1){
                //啥都不干了
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("has buffer:" + (end - beg) + "ms");
    }

    private static void testNoBuffer() {
        //读的时候就是 一个一个字节读，完全不是用任何缓冲区
        long beg = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("文件名")){
            int ch = -1;
            while ((ch = fileInputStream.read()) != -1){
                //啥都不干了
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("no buffer:" + (end - beg) + "ms");
    }
}

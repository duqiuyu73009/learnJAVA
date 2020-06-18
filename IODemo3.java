package java_0618;

import java.io.*;

/**
 * 内置了缓冲区（本质上事一块内存）
 * BufferedInputStream
 * BufferedOutputStream
 */
public class IODemo3 {
    public static void main(String[] args) {

    }

    private static void copyFile() throws IOException {
        //需要创建的实例事BufferedInputStream  BufferedOutputStream
        //要创建这样的实例，就要先创建FilInputStream和
        FileInputStream fileInputStream = new FileInputStream("d:/Test.java/rose,jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/Test.java/rose2,jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int length = -1;
        //如果督导的len 是-1 说明读取结束，循环就结束了
        while ((length = bufferedInputStream.read(buffer)) != -1) {
            //2.把读取到的内容写到 destPath 对应的文件中
            bufferedOutputStream.write(buffer, 0, length);
        }
        //此处涉及到四个流对象
        //调用这一组close时，就会自动关闭内部包含的FileInputStream  FileOutputStream
        //不用四个都close
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copyFile2(){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/Test.java/rose,jpg"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/Test.java/rose2,jpg"))) {
            byte[] buffer = new byte[1024];
            int length = -1;
            //如果督导的len 是-1 说明读取结束，循环就结束了
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                //2.把读取到的内容写到 destPath 对应的文件中
                bufferedOutputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

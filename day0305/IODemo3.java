package day0305;

import java.io.*;

//字节缓冲流 BufferedInputStream 和 BufferedOutputStream（内置了缓冲区）
public class IODemo3 {
    public static void main(String[] args) throws IOException {
          copyFile();
    }

    private static void copyFile() throws IOException {
        //需要创建的实例 BufferedInputStream 和 BufferedOutputStream，就先要创建FileInputStream和FileOutputStream
        FileInputStream fileInputStream = new FileInputStream("D:/file_dir/1010.png");
        FileOutputStream fileOutputStream = new FileOutputStream("D:/file_dir/10102.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = bufferedInputStream.read(buffer)) != -1){
            bufferedOutputStream.write(buffer,0,length);
        }
        //有四个流对象，只需要关闭这两个,然后就会自动关闭包含的FileInputStream和FileOutputStream
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copyFile2() {
        try( BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:/file_dir/1010.png"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream( new FileOutputStream("D:/file_dir/10102.png"))) {

            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

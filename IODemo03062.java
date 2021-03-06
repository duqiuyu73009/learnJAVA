package dqy0305;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
    //实现文件的复制
    public static void main1(String[] args) throws IOException {
        copyFile("D:/file_dir/1010.png","D:/file_dir/10102.png");
    }

    private static void copyFile1(String srcPath, String destPath) throws IOException {
        //1.先打开文件（先创建InputStream和OutputStreaam对象的过程）
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //2.需要读取srcPath文件对应的内容
        byte[] buffer = new byte[1024];
        int len = -1;
        //如果已经读完了就返回-1.如果返回一个正数，就相当于一共有这个整数的长度
        while((len = fileInputStream.read(buffer)) != -1){
            //读取成功
            //3.把读取到的内容写入desrPath对应的文件中
            fileOutputStream.write(buffer,0,len);
        }
        //4.close关闭文件,如果没有关闭就会造成文件资源泄露
        fileInputStream.close();
        fileOutputStream.close();
    }



    public static void main(String[] args) throws IOException {
        copyFile("D:/file_dir/1010.png","D:/file_dir/10102.png");
    }

    private static void copyFile(String srcPath, String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //1.先打开文件（先创建InputStream和OutputStreaam对象的过程）
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            //2.需要读取srcPath文件对应的内容
            byte[] buffer = new byte[1024];
            int len = -1;
            //如果已经读完了就返回-1.如果返回一个正数，就相当于一共有这个整数的长度
            while((len = fileInputStream.read(buffer)) != -1){
                //读取成功
                //3.把读取到的内容写入desrPath对应的文件中
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.close关闭文件,如果没有关闭就会造成文件资源泄露
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

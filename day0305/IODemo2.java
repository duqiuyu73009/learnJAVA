package day0305;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
    //实现文件的复制
    public static void main1(String[] args) throws IOException {
        copyFile1("D:/file_dir/1010.png","D:/file_dir/10102.png");//初级般
        copyFile2("D:/file_dir/1010.png","D:/file_dir/10102.png");//改进版
        copyFile3();//改进版
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
            //3.把读取到的内容写入destPath对应的文件中
            fileOutputStream.write(buffer,0,len);
        }
        //4.close关闭文件,如果没有关闭就会造成文件资源泄露
        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void copyFile2(String srcPath, String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //1.先打开文件（先创建InputStream和OutputStreaam对象的过程）
            fileInputStream = new FileInputStream(srcPath);
            //但是如果路径对应的文件不存在，此时构造方法也会抛出异常，说明构造尚未成功，还是null，
            // 那么接下来调用close方法就会触发空指针异常
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
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile3(){
        //当代码写成这个样子的时候，就不需要显示调用close
        //try语句会在代码执行完毕后，自动调用close方法（前提是这个类必须实现closeable接口）
        try(FileInputStream fileInputStream = new FileInputStream("D:/file_dir/1010.png");
            FileOutputStream fileOutputStream = new FileOutputStream("D:/file_dir/10102.png")){
            byte[] buffer = new byte[1024];//也相当于是缓冲区
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream .write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }



















}

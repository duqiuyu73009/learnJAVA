package Java_0616;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 流
 *   流是一组类/一组API，描述了如何来进行文件读写操作
 *
 *   1.字节流：读写数据以字节为基本单位 *     处理二进制文件/数据的时候
 *         1) InputStream：输入，从输入设备读取数据到内存中
 *         2) OutputStream：输出，把内存输出至输出设备
 *         如果发现某个类的名字带有以上字样，就说明是字节流
 *   2.字符流：读写数据以字符为基本单位 *     处理文本文件/数据的时候（用记事本打开，如果能看懂就为文本文件，看不懂就是二进制文件）
 *         1) Reader：输入
 *         2) Writer：输出
 *         如果发现某个类的名字带有以上字样，就说明是字符流
 *
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
        copyFile("d:/Test.java/rose,jpg","d:/Test.java/rose2,jpg");
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        //0.先打开文件，才能写入（创建InputStream/OutputStream对象的过程）
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //1.需要读取 srcPath 对应的文件内容
        byte[] buffer = new byte[1024];
        //单词读取的内容是存在上限，要想把文件整个都读完，需要搭配循环来使用
        int len = -1;
        //如果督导的len 是-1 说明读取结束，循环就结束了
        while ((len = fileInputStream.read(buffer)) != -1){
            //2.把读取到的内容写到 destPath 对应的文件中
            fileOutputStream.write(buffer,0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}

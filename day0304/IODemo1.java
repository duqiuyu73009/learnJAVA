package day0304;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main1(String[] args) throws IOException {
        File file = new File("D:\\2.比特文件\\3.JavaWeb\\3.JavaWeb");
        //该文件是否存在是不确定的
        //需要进行判断
        System.out.println("当前文件是否存在："+file.exists());
        System.out.println("文件是否为普通文件："+ file.isFile());
        System.out.println("文件是都为目录：" +file.isDirectory());

       //file.delete();//删除

        file.createNewFile();//在该目录下创建一个新的文件，磁盘满了的时候就会触发异常


    }
    public static void main2(String[] args) throws IOException {
        System.out.println(File.separator);
    }

    public static void main3(String[] args) {
        File file = new File("d:/file_dir/1/2/3/4");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        file.mkdirs();//创建一个空目录
        System.out.println(file.exists());
    }

    public static void main4(String[] args) {
        File file = new File("d:/file_dir/1/2/3/4");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.getParent());
    }

    public static void main(String[] args) {
        File file = new File("d:/file_dir");
        listAllFiles(file);
    }

    private static void listAllFiles(File f){
        if (f.isDirectory()){
            //如果是目录，就把目录中包含的文件罗列出来
            File[] files = f.listFiles();
            for (File file : files){
                listAllFiles(file);
            }
        }else {
            //如果不是目录，就把这个文件路径打印出来
            System.out.println(f);
        }
    }
}

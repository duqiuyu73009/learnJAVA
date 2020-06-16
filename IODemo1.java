package Java_0616;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        //文件操作================================================================
//        File file = new File("d:/Text.java");
//        System.out.println("文件是否存在：" + file.exists());//判断文件是否存在
//        System.out.println("文件是否是普通文件：" + file.isFile());
//        System.out.println("文件是否是一个目录：：" + file.isDirectory());
//        file.createNewFile();//创建文件
//        System.out.println(File.separator);//可以借助这个变量来自动适应不同的系统

//        file.delete();//删除文件
//        System.out.println("文件是否存在：" + file.exists());

        //目录操作==================================================================
        File file = new File("d:/Text.java");
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件是否是一个目录：：" + file.isDirectory());
        file.mkdir();//创建一个目录
        file.mkdirs();//创建多个目录,创建出来的目录是嵌套关系
        System.out.println(file.getParent());//得到当前目录的上一级目录
        System.out.println(file.exists());

        //listFiles
        File file1 = new File("d:/Text.java");
        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f);
        }
    }

    //递归罗列出目录中的所有文件
    public static void listAllFiles(File f) {
        if (f.isDirectory()){
            File[] files = f.listFiles();
            for (File file : files){
                listAllFiles(file);
            }
        }else {
            //把这个文件路径直接打印出来
            System.out.println(f);
        }
    }
}

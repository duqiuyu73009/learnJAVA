package day0304;
import java.io.File;
public class FileDemo {
    public static void main1(String[] args){
        String path = "E:\\java_code\\file\\";
        String name = "demo.txt";
        String pathname = path + name;
        File file = new File(pathname);
        boolean res = file.exists();
        System.out.println("文件" + pathname + "是否存在: " + res);
    }

    public static void main(String[] args){
        String path = "E:\\java_code\\file\\";
        String name = "demo.txt";
        String pathname = path + name;
        File file = new File(pathname);
        boolean res = file.exists();
        System.out.println("文件" + pathname + "是否存在: " + res);
        res = file.isDirectory();
        System.out.println("文件" + pathname + "是否是目录: " + res);
        res = file.isFile();
        System.out.println("文件" + pathname + "是否是文件: " + res);
        file.delete();
        if(!file.exists()){
            System.out.println("删除文件成功！");
        }
        else{
            System.out.println("删除文件失败！");
        }
    }
}
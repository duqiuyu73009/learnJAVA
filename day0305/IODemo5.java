package day0305;

import java.io.*;

//字符流：可以来处理文本文件
public class IODemo5 {
    public static void main(String[] args) {
        copyFile();
    }

    //不带缓冲区
    private static void copyFile(){
        try(FileReader fileReader = new FileReader("d:/test.txt");
            FileWriter fileWriter = new FileWriter("d:/test2.txt")){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1){
                fileWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //带缓冲区
    private static void copyFile2(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test2.txt"))){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = bufferedReader.read(buffer)) != -1){
                bufferedWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile3(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test2.txt"))) {
                String line = "";//读一行，读到换行符为止
                while ((line = bufferedReader.readLine()) != null){
                    bufferedWriter.write(line+ "\n");
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

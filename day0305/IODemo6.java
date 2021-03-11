package day0305;

import java.io.*;
//序列化
class Student implements Serializable {
    public String name;
    public int age;
    public int score;
}
public class IODemo6 {
    public static void main(String[] args) throws IOException {
        Student student = new Student();
        student.name = "ss";
        student.age = 12;
        student.score = 34;
        serialzeStudent(student);
    }

    private static void serialzeStudent(Student student) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
        objectOutputStream.writeObject(student);//序列化和写文件同时搞定
        objectOutputStream.close();
    }






}

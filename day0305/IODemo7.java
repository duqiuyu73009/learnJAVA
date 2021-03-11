package day0305;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IODemo7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student ret = deserializeStudent();
        System.out.println(ret.name);
        System.out.println(ret.age);
        System.out.println(ret.score);
    }

    public static Student deserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/student.txt"));
        Student s = (Student) objectInputStream.readObject();
        return s;
    }
}

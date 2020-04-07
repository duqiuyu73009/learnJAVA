package user;

import book.BookList;
import operation.Ioperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:45
 */
//抽象类
abstract public class User {
    public String name;
    //这个数组当中  保存 每个对象对应的操作
    public Ioperation[] Operations;

    public User(String name){
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(int choice,BookList bookList){
        //Operations[choice]-----拿到的是数组当中元素的对象
        //Operations[choice].work(bookList);-----通过.号 带哦用对应的操作方法m
        Operations[choice].work(bookList);

    }
}

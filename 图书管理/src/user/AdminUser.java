package user;

import operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:44
 */
public class AdminUser extends User {

    public AdminUser(String name){
        super(name);
        //数组当中存放的是对应的操作
        this.Operations = new Ioperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }

    public int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello"+this.name+"欢迎来到图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.打印书籍");
        System.out.println("0.退出系统");
        int choice = scanner.nextInt();
        return choice;
    }
}

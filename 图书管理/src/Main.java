import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:52
 */
public class Main {
    public static User login(){
        //发生了向上转型
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String name = scanner.nextLine();
        System.out.println("请输入你的身份 1->管理员  0->普通用户");
        int num = scanner.nextInt();
        if(num == 1){
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        //1.准备书籍
        BookList bookList = new BookList();

        //2.登录
        User user = login();//向上转型
        while (true) {
            int choice = user.menu();
            //根据你的选择确定需要哪个操作方法
            user.doOperation(choice, bookList);
        }
    }
}

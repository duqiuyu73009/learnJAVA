package operation;

import book.Book;
import book.BookList;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:34
 */
public class AddOperation implements Ioperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("输入图书的作者：");
        String author = scanner.nextLine();
        System.out.println("请输入图书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型：");
        String type = scanner.next();

        Book book = new Book(name,author,price,type);

        int curSize = bookList.getUsedSize();
        bookList.setBooks(curSize,book);
        bookList.setUsedSize(curSize+1);
        System.out.println("新增图书成功！");
    }

}

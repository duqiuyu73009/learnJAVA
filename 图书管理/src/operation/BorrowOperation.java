package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:35
 */
public class BorrowOperation implements Ioperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要借阅的图书");
        String name = scanner.nextLine();

        for(int i = 0 ; i < bookList.getUsedSize() ; i++){
            Book book = bookList.getBooks(i);
            if(book.getName().equals(name)){
               //说明有这本书
                if(book.isBorrowed()){
                    System.out.println("已经被借出去了！");
                    return;
                }
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }
        System.out.println("没有这本书");
    }
}

package Library.operation;

import Library.book.Book;
import Library.book.BookList;

import java.util.Scanner;

/**
 * 归还书籍
 */
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入归还图书的名字");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++){
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功");
                return;
            }
        }
        System.out.println("没有你要归还的书籍");

    }
}

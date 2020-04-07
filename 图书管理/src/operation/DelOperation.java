package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:34
 */
public class DelOperation implements Ioperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入删除图书的名字：");
        String name = scanner.nextLine();


        int pos = 0;
        int i = 0;
        for(i = 0 ; i < bookList.getUsedSize() ; i++){
            Book book = bookList.getBooks(i);
            if(book.getName().equals(name)){
                pos = i;
                break;
            }
        }
        if(i == bookList.getUsedSize()) {
            System.out.println("没有这本书");
        }
        //开始删除书籍
        for(int j = pos; j < bookList.getUsedSize() - 1 ; j++){
            Book book = bookList.getBooks(j+1);
            bookList.setBooks(j,book);
        }
        int curSize = bookList.getUsedSize();
        bookList.setUsedSize(curSize-1);
        System.out.println("删除成功");
    }
}

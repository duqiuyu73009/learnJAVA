package Library.operation;

import Library.book.Book;
import Library.book.BookList;

/**
 * 显示书籍
 */
public class DisplayOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("显示所有书籍");

        for (int i = 0; i < bookList.getUsedSize(); i++){
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}

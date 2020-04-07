package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:36
 */
public class DisplayOperation implements Ioperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印书籍");
        for(int i = 0 ; i < bookList.getUsedSize() ; i++){
            System.out.println(bookList.getBooks(i));
        }
        System.out.println();
    }
}

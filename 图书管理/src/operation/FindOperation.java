package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-04
 * Time: 10:35
 */
public class FindOperation implements Ioperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的图书");
        String name = scanner.nextLine();

        for(int i = 0 ; i < bookList.getUsedSize() ; i++){
            if(bookList.getBooks(i).getName().equals(name)){
                System.out.println(bookList.getBooks(i));
                System.out.println("查找到了这本书！");
                return;
            }
        }
        System.out.println("没有这本书");
    }

}

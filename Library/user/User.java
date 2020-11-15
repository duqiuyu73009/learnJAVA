package Library.user;

import Library.book.BookList;
import Library.operation.IOperation;

abstract public class User {
    protected String name;

    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doOperation( BookList bookList,int choice){
        this.operations[choice].work(bookList);
    }
}

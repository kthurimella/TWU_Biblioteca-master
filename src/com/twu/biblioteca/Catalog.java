package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Collection;

/**
 * Created by ahochoy on 4/29/14.
 */
public class Catalog {

    private final Collection<String> checkedOutBooks;
    private Collection<String> books;
    private final PrintStream printStream;

    public Catalog(Collection<String> bookList, PrintStream printStream, Collection<String> checkedOutBooks) {
        this.books = bookList;
        this.printStream = printStream;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void printListOfBooks(){
        printStream.println("Book List:");
        for(String book : books){
            printStream.println(book);
        }
        printStream.println();
    }

    public Collection<String> getBooks(){
        return books;
    }

    public boolean removeCheckedOutBook(String book) {
        boolean success = books.remove(book);
        if (success) {
            checkedOutBooks.add(book);
        }
        return success;
    }

    public boolean returnBook(String book) {
        boolean success = checkedOutBooks.remove(book);
        if (success){
            books.add(book);
        }
        return success;
    }
}

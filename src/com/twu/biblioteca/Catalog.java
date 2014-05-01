package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Collection;

/**
 * Created by ahochoy on 4/29/14.
 */
public class Catalog {

    private Collection<String> books;
    private final PrintStream printStream;

    public Catalog(Collection<String> bookList, PrintStream printStream) {
        this.books = bookList;
        this.printStream = printStream;
    }

    public void printListOfBooks(){
        printStream.println("Book List:");
        for(String book : books){
            printStream.println(book);
        }
    }

    public Collection<String> getBooks(){
        return books;
    }

    public void removeCheckedOutBook(String s) {
        books.remove(s);
    }
}

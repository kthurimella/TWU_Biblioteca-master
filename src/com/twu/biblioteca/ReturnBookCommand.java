package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by kthurime on 5/4/14.
 */
public class ReturnBookCommand implements Command{

    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Catalog catalog;

    public ReturnBookCommand(PrintStream printStream, BufferedReader bufferedReader, Catalog catalog) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.catalog = catalog;
    }

    @Override
    public void execute() {

        printStream.print("Please type the book you would like to return: ");

        if(catalog.returnBook(readLine())){
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return");
        }


    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

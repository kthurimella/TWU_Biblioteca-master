package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutBooksCommand implements Command{

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Catalog catalog;

    public CheckoutBooksCommand(PrintStream printStream, BufferedReader bufferedReader, Catalog catalog) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        printStream.print("Please select the book you would like to check out: ");
        String input = readline();
        if (catalog.removeCheckedOutBook(input)) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    @Override
    public String commandName() {
        return "Checkout Book";
    }

    private String readline() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("IO Failure");
        }
    }

}

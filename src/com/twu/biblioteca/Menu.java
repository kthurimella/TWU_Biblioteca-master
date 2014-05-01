package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {
    private Catalog catalog;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private boolean doneState;

    public Menu(Catalog catalog, BufferedReader bufferedReader, PrintStream printStream, boolean isDone) {
        this.catalog = catalog;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.doneState = isDone;
    }

    public void chooseOption() {
        String option = readline();
        if (option.equals("1")) {
            catalog.printListOfBooks();
        }
        else if(option.equals("2")){
            printStream.print("Please select the book you would like to check out: ");
            catalog.removeCheckedOutBook(readline());
            printStream.println("Thank you! Enjoy the book");
        }
        else if (option.equalsIgnoreCase("Quit")){
            doneState = true;
            printStream.println("Thanks for using the App!");
        }
        else{
            printStream.println("Select a valid option!");
        }
    }

    private String readline() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isDone() {
        return doneState;
    }

    public void printOptions() {
        printStream.println("Main Menu:");
        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");
    }
}
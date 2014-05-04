package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Catalog catalog;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Map<String, Command> commandMap;
    private boolean doneState;

    public Menu(Catalog catalog, BufferedReader bufferedReader, PrintStream printStream, Map<String, Command> commandMap) {
        this.catalog = catalog;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.commandMap = commandMap;
    }

    public void chooseOption() {
        String option = readline();
        if (option.equals("1")) {
            catalog.printListOfBooks();
        }
        else if(option.equals("2")){
            checkout();
        }
        else if(option.equals("3")){
            returnBook();
        }
        else if (option.equalsIgnoreCase("Quit")){
            quit();
        }
        else{
            printStream.println("Select a valid option!");
        }
    }

    private void quit() {
        doneState = true;
        printStream.println("Thanks for using the App!");
    }

    private void returnBook() {
        printStream.print("Please type the book you would like to return: ");
        if (catalog.returnBook(readline())) {
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return");
        }
    }

    private void checkout() {
        printStream.print("Please select the book you would like to check out: ");
        if (catalog.removeCheckedOutBook(readline())) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
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
        printStream.println("3. Return Book");
    }
}
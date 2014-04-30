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

    public Menu(Catalog catalog, BufferedReader bufferedReader, PrintStream printStream) {
        this.catalog = catalog;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void chooseMenuOption(String s) {
        int optionNumber = Integer.parseInt(s);
        if (optionNumber == 1)
            catalog.printListOfBooks();
        else {
            printStream.println("Select a valid option!");
        }
    }


    public void chooseOption() {
        printStream.println("Main Menu: 1. List Books");
        String option = readline();
        if (option.equals("1")) {
            catalog.printListOfBooks();
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
}
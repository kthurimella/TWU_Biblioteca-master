package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {
    private final BibliotecaApp bibliotecaApp;
    private Catalog catalog;
    private PrintStream printStream;

    public Menu(BibliotecaApp bibliotecaApp, Catalog catalog) {
        this.catalog = catalog;
        this.bibliotecaApp = bibliotecaApp;
    }

    public void chooseMenuOption(String s) {
        int optionNumber = Integer.parseInt(s);
        if (optionNumber == 1)
            catalog.printListOfBooks();
        else {
            printStream.println("Select a valid option!");
        }
    }


}
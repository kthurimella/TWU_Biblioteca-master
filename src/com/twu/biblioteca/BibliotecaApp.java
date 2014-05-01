package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    private PrintStream printStream;
    private Menu menu;

    public BibliotecaApp(PrintStream printStream, Menu menu) {
        this.printStream = printStream;
        this.menu = menu;
    }

    public void displayUserPrompt() {
        printStream.println("Welcome to Biblioteca!");
        printStream.println("Main Menu: 1. List Books");
        printStream.print("Please select an option: ");
    }

    public void start() {
        printStream.println("Welcome to Biblioteca!");
        do {
            menu.printOptions();
            menu.chooseOption();
        }while(!menu.isDone());
    }
}

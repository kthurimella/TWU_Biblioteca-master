package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class BibliotecaApp {

    private PrintStream printStream;
    private BufferedReader inStream;
    private Menu menu;

    public BibliotecaApp(Catalog catalog, PrintStream printStream, BufferedReader inStream) {
        this.printStream = printStream;
        this.inStream = inStream;
        this.menu = new Menu(this, catalog);
    }

    public void displayUserPrompt() {
        printStream.println("Welcome to Biblioteca!");
        printStream.println("Main Menu: 1. List Books");
        printStream.print("Please select an option: ");
    }

    public void readUserInput() {
        try {
            menu.chooseMenuOption(inStream.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

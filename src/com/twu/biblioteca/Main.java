package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        Collection<String> books = new ArrayList<String>();
        books.add("Book 1");
        PrintStream out = System.out;
        Catalog catalog = new Catalog(books, out, new ArrayList<String>());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Command> commandMap = new HashMap<String, Command>();
        AtomicBoolean state = new AtomicBoolean(false);
        commandMap.put("1", new ListBooksCommand(catalog));
        commandMap.put("2", new CheckoutBooksCommand(out, bufferedReader, catalog));
        commandMap.put("3", new ReturnBookCommand(out, bufferedReader, catalog));
        commandMap.put("4", new QuitCommand(out, state));
        Menu menu = new Menu(catalog, bufferedReader, out, commandMap, state);
        BibliotecaApp app = new BibliotecaApp(out, menu);
        app.start();
    }
}

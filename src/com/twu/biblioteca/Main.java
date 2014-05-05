package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        PrintStream out = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        AtomicBoolean state = new AtomicBoolean(false);
        Map<String, Command> commandMap = getStringCommandMap(out, bufferedReader, state);
        Menu menu = new Menu(bufferedReader, out, commandMap, state);
        BibliotecaApp app = new BibliotecaApp(out, menu);
        app.start();
    }

    private static Map<String, Command> getStringCommandMap(PrintStream out, BufferedReader bufferedReader, AtomicBoolean state) {
        Collection<String> books = new ArrayList<String>();
        books.add("Book 1");
        Catalog catalog = new Catalog(books, out, new ArrayList<String>());
        Map<String, Command> commandMap = new TreeMap<String, Command>();
        commandMap.put("1", new ListBooksCommand(catalog));
        commandMap.put("2", new CheckoutBooksCommand(out, bufferedReader, catalog));
        commandMap.put("3", new ReturnBookCommand(out, bufferedReader, catalog));
        commandMap.put("4", new QuitCommand(out, state));
        return commandMap;
    }
}

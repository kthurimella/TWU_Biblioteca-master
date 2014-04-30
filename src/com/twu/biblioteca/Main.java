package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<String> books = new ArrayList<String>();
        books.add("Book 1");
        PrintStream out = System.out;
        Catalog catalog = new Catalog(books, out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BibliotecaApp app = new BibliotecaApp(out, new Menu(catalog, bufferedReader, out));
        app.start();

    }
}

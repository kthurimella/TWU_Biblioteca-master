package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ahochoy on 4/29/14.
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Collection<String> bl = new ArrayList<String>();
        bl.add("Book 1");
        Catalog catalog = new Catalog(bl, System.out);
        BibliotecaApp ba = new BibliotecaApp(catalog,System.out, inStream);
        ba.displayUserPrompt();
        ba.readUserInput();
    }
}

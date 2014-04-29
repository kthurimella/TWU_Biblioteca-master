package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public ArrayList<String> bookList = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public List<String> getListOfBooks() {
        return bookList;
    }
}

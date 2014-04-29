package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> bookList;

    public BibliotecaApp(ArrayList<String> bookList ){
        this.bookList = bookList;
    }

    public ArrayList<String> getListOfBooks() {
        return bookList;
    }

    public String start() {
        return "Welcome to Biblioteca";
    }

    public static void main(String[] args) {
        BibliotecaApp ba = new BibliotecaApp( new ArrayList<String>() );
        System.out.println(ba.start());
    }
}

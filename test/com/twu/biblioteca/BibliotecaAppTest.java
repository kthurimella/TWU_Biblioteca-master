package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldReturnListOfSingleBook() {

        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.bookList.add("Book");

        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Book");

        assertEquals(expectedList, biblioteca.getListOfBooks());
    }

    @Test
    public void shouldReturnListOfMultipleBooks(){

        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.bookList.add("Book 1");
        biblioteca.bookList.add("Book 2");

        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Book 1");
        expectedList.add("Book 2");

        assertEquals(expectedList, biblioteca.getListOfBooks());
    }

}

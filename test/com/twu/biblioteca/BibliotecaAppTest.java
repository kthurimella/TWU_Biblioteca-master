package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;

    @Before
    public void beforeTest() throws Exception {
        ArrayList<String> books = new ArrayList<String>();
        books.add("Book");
        biblioteca = new BibliotecaApp(books);
    }

    @Test
    public void shouldReturnListOfSingleBook() {
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Book");

        assertEquals(expectedList, biblioteca.getListOfBooks());
    }

    @Test
    public void shouldReturnListOfMultipleBooks(){
        ArrayList<String> books = new ArrayList<String>();
        books.add("Book 1");
        books.add("Book 2");

        BibliotecaApp biblioteca = new BibliotecaApp(books);

        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Book 1");
        expectedList.add("Book 2");

        assertEquals(expectedList, biblioteca.getListOfBooks());
    }

    @Test
    public void shouldDisplayWelcomeMessage(){
        String message = biblioteca.start();
        assertThat(message, is("Welcome to Biblioteca"));
    }

    @Test
    public void shouldDisplayMainMenuOptions(){
        String mainMenu = biblioteca.showMainMenu();
        assertThat(mainMenu, is("Main Menu: 1. List Books"));
    }

    @Test
    public void shouldListBooksWhenSelectListBooksFromMenu() {
        ArrayList<String> expectedList = biblioteca.chooseMenuOption("1");
        assertEquals(expectedList, biblioteca.getListOfBooks());
    }
}

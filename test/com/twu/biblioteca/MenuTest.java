package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ahochoy on 4/30/14.
 */
public class MenuTest {

    private PrintStream printStream;
    private BufferedReader inStream;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        inStream = mock(BufferedReader.class);
        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        Catalog catalog = new Catalog(bookList, printStream);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(catalog, printStream, inStream);

        menu = new Menu(bibliotecaApp, catalog);
    }

    @Test
    public void shouldListBooksWhenSelectListBooksFromMenu() {
        menu.chooseMenuOption("1");
        verify(printStream).println("Book List:");
        verify(printStream).println("Book 1");
    }

    @Test
    public void shouldNotifyWithMessageWhenInvalidOptionIsSelected(){
        menu.chooseMenuOption("5");
        verify(printStream).println("Select a valid option!");
    }

    // Quit - As a customer, I would like to continue choosing options until I choose to 'Quit'.
    @Test
    public void shouldQuitWhenSelectQuitFromMenu(){
        menu.chooseMenuOption("2");
        verify(printStream).println("Quit");
    }
}

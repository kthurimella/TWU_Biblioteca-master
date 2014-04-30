package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


// Dismantle!
public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;
    private PrintStream printStream;
    private BufferedReader inStream;
    private Catalog catalog;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        inStream = mock(BufferedReader.class);

        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        catalog = mock(Catalog.class);
        biblioteca = new BibliotecaApp(catalog, printStream, inStream);
    }

    @Test
    public void shouldDisplayWelcomeMessage(){
        biblioteca.displayUserPrompt();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldPrintListOfBooksWhenUserEnter1() throws IOException {
        when(inStream.readLine())
                .thenReturn("1");

        biblioteca.readUserInput();
        verify(catalog).printListOfBooks();

    }

    @Test
    public void shouldWelcomeUserWhenWeStart(){
        biblioteca.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldListBooksWhenWeStart(){
        biblioteca.start();
        verify(catalog).printListOfBooks();
    }


}

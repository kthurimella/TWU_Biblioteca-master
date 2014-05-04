package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;


// Dismantle!
public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;
    private Catalog catalog;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        catalog = mock(Catalog.class);
        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        menu = mock(Menu.class);
        biblioteca = new BibliotecaApp(printStream, menu);
    }

    @Test
    public void shouldWelcomeUserWhenWeStart(){
        when(menu.isDone()).thenReturn(true);
        biblioteca.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldDisplayMenuOptionsWhenWeStart(){
        when(menu.isDone()).thenReturn(true);
        biblioteca.start();
        verify(menu, times(1)).chooseOption();
    }

    @Test
    public void shouldOnlyChooseOptionsTwiceWhenSecondOptionIsQuit(){
        when(menu.isDone()).thenReturn(false).thenReturn(true);
        biblioteca.start();
        verify(menu, times(2)).chooseOption();
    }
}

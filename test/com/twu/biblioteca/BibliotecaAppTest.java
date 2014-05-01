package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;


// Dismantle!
public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;
    private PrintStream printStream;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);

        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        menu = mock(Menu.class);
        biblioteca = new BibliotecaApp(printStream, menu);
    }

    @Test
    public void shouldDisplayWelcomeMessage(){
        biblioteca.displayUserPrompt();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldWelcomeUserWhenWeStart(){
        biblioteca.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldDisplayMenuOptionsWhenWeStart(){
        when(menu.isDone()).thenReturn(false);
        biblioteca.start();
        verify(menu, times(1)).chooseOption();
    }

    @Test
    public void shouldOnlyChooseOptionsTwiceWhenSecondOptionIsQuit(){
        when(menu.isDone()).thenReturn(true).thenReturn(false);
        biblioteca.start();
        verify(menu, times(2)).chooseOption();
    }



}

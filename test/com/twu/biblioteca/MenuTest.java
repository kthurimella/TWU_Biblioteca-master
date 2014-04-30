package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private Catalog catalog;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        catalog = mock(Catalog.class);
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        menu = new Menu(catalog, bufferedReader, printStream);
    }

    @Test
    public void shouldNotifyWithMessageWhenInvalidOptionIsSelected(){
        menu.chooseMenuOption("5");
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldPrintOptions() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");
        menu.chooseOption();
        verify(printStream).println("Main Menu: 1. List Books");
    }

    @Test
    public void shouldListBooksWhenUserEntersOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.chooseOption();
        verify(catalog).printListOfBooks();
    }

    @Test
    public void shouldReturnErrorWhenGivenInvalidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Invalid Option");
        menu.chooseOption();
        verify(printStream).println("Select a valid option!");

    }

    // Quit - As a customer, I would like to continue choosing options until I choose to 'Quit'.
//    @Test
//    public void shouldQuitWhenSelectQuitFromMenu(){
//        menu.chooseMenuOption("2");
//        verify(printStream).println("Quit");
//    }
}

package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnBookCommandTest {

    private BufferedReader bufferedReader;
    private Catalog catalog;
    private PrintStream printStream;
    private ReturnBookCommand returnBookCommand;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        catalog = mock(Catalog.class);
        printStream = mock(PrintStream.class);
        returnBookCommand = new ReturnBookCommand(printStream, bufferedReader, catalog);
    }

    @Test
    public void shouldPromptForBook() {
        returnBookCommand.execute();
        verify(printStream).print("Please type the book you would like to return: ");
    }

    @Test
    public void shouldReadUserInput() throws IOException {
        returnBookCommand.execute();
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldReturnBookWhen3IsInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("A Book");
        returnBookCommand.execute();
        verify(catalog).returnBook("A Book");
    }

    @Test
    public void shouldDisplaySuccessfulReturnMessage() throws IOException {
        when(catalog.returnBook(anyString())).thenReturn(true);
        returnBookCommand.execute();
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldDisplayUnsuccesfulReturnMessage() throws IOException {
        when(catalog.returnBook(anyString())).thenReturn(false);
        returnBookCommand.execute();
        verify(printStream).println("That is not a valid book to return");
    }


}
package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBooksCommandTest {


    private PrintStream printStream;
    private CheckoutBooksCommand checkoutBooksCommand;
    private BufferedReader bufferedReader;
    private Catalog catalog;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        catalog = mock(Catalog.class);
        checkoutBooksCommand = new CheckoutBooksCommand(printStream, bufferedReader, catalog);
    }

    @Test
    public void shouldPromptUsersToCheckoutBook() {
        checkoutBooksCommand.execute();

        verify(printStream).print("Please select the book you would like to check out: ");
    }
    @Test
    public void shouldReadUserInputAfterPrompt() throws IOException {
        checkoutBooksCommand.execute();
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldCheckoutBookAfterReadline() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Book 1");
        checkoutBooksCommand.execute();

        verify(catalog).removeCheckedOutBook("Book 1");
    }

    @Test
    public void shouldNotifyOfSuccessfulCheckout() {
        when(catalog.removeCheckedOutBook(anyString())).thenReturn(true);
        checkoutBooksCommand.execute();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldNotifyOfUnsuccesfulCheckout() {
        when(catalog.removeCheckedOutBook(anyString())).thenReturn(false);
        checkoutBooksCommand.execute();
        verify(printStream).println("That book is not available.");
    }

}
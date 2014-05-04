package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
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
    public void shouldNotifyWithMessageWhenInvalidOptionIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");
        menu.chooseOption();
        verify(printStream).println("Select a valid option!");
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

    @Test
    public void shouldReturnFalseWhenUserInputsQuit() throws IOException {
        boolean result = menu.isDone();
        assertFalse(result);
    }

    @Test
    public void shouldQuitWhenSelectQuitFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Quit");
        menu.chooseOption();
        verify(printStream).println("Thanks for using the App!");
    }

    @Test
    public void shouldBeDoneWhenSelectQuitFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Quit");
        menu.chooseOption();
        assertTrue(menu.isDone());
    }

    @Test
    public void shouldDisplayCheckoutBookOptionInMenu() {
        menu.printOptions();
        verify(printStream).println("2. Checkout Book");
    }

    @Test
    public void shouldCheckOutBookWhenInputIsTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("Book A");
        menu.chooseOption();
        verify(catalog).removeCheckedOutBook("Book A");
    }

    @Test
    public void shouldDisplayThankYouMessageWhenBookIsCheckedOut() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("Book 1");
        when(catalog.removeCheckedOutBook(anyString())).thenReturn(true);
        menu.chooseOption();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldDIsplayUnsuccessfulCheckOutMessageWhenBookIsNotAvailable() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("Unavailable Book");
        menu.chooseOption();
        verify(printStream).println("That book is not available.");

    }

    @Test
    public void shouldDisplayOptionToReturnBookForCustomer(){
        menu.printOptions();
        verify(printStream).println("3. Return Book");
    }

    @Test
    public void shouldReturnBookWhen3IsInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3").thenReturn("A Book");
        menu.chooseOption();
        verify(catalog).returnBook("A Book");
    }

    @Test
    public void shouldDisplaySuccessfulReturnMessage() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3").thenReturn("Book 1");
        menu.chooseOption();
        verify(printStream).println("Thank you for returning the book.");

    }
}

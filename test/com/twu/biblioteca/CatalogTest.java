package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class CatalogTest {
    private Catalog catalog;
    private PrintStream printStream;
    private Collection<String> bookList;
    private Collection<String> checkedOutBooks;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<String>();
        bookList.add("Book 1");
        checkedOutBooks = new ArrayList<String>();
        catalog = new Catalog(bookList, printStream, checkedOutBooks);
    }

    @Test
    public void shouldReturnListOfSingleBook() {
        catalog.printListOfBooks();
        verify(printStream).println("Book List:");
        verify(printStream).println("Book 1");
    }

    // Clean up to only Book 2.
    @Test
    public void shouldReturnListOfMultipleBooks(){
        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        bookList.add("Book 2");
        Catalog catalog = new Catalog(bookList, printStream, null);
        catalog.printListOfBooks();

        verify(printStream).println("Book List:");
        verify(printStream).println("Book 1");
        verify(printStream).println("Book 2");
    }

    @Test
    public void shouldCheckoutSingleBook(){
        catalog.removeCheckedOutBook("Book 1");
        assertFalse(catalog.getBooks().contains("Book 1"));
    }

    @Test
    public void shouldReturnFalseOnUnsuccessfulCheckout(){
        boolean checkoutResult = catalog.removeCheckedOutBook("Book Not In Catalog");
        assertFalse(checkoutResult);
    }

    @Test
    public void shouldMoveCheckedOutBookToCheckedOutList() {
        catalog.removeCheckedOutBook("Book 1");
        assertThat(checkedOutBooks, hasItem("Book 1"));
    }

    @Test
    public void shouldNotMoveNonExistentBookToCheckedOUtList() {
        catalog.removeCheckedOutBook("The next Game of Thrones Book");
        assertThat(checkedOutBooks, not(hasItem("The next Game of Thrones Book")));
    }
    @Test
    public void shouldAddReturnedBookToBookList() {
        catalog.removeCheckedOutBook("Book 1");
        assertThat(bookList, not(hasItem("Book 1")));
        catalog.returnBook("Book 1");
        assertThat(bookList, hasItem("Book 1"));
    }

    @Test
    public void shouldNotAcceptReturnOfNonCheckedOutBook() {
        String book = "A book that didn't come from here";
        catalog.returnBook(book);
        assertThat(bookList, not(hasItem(book)));
    }
}

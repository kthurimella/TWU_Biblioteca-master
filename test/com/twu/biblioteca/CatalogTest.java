package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CatalogTest {
    private Catalog catalog;
    private PrintStream printStream;
    private BufferedReader inStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        inStream = mock(BufferedReader.class);
        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        catalog = new Catalog(bookList, printStream);
    }

    @Test
    public void shouldReturnListOfSingleBook() {
        catalog.printListOfBooks();
        verify(printStream).println("Book List:");
        verify(printStream).println("Book 1");
    }

    @Test
    public void shouldReturnListOfMultipleBooks(){
        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        bookList.add("Book 2");
        Catalog catalog = new Catalog(bookList, printStream);
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
}

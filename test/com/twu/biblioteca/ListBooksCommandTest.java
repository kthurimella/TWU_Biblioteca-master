package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksCommandTest {

    private Catalog catalog;

    @Before
    public void setUp() throws Exception {
        catalog = mock(Catalog.class);
    }

    @Test
    public void shouldListBooksWhenCommandIsExecuted(){
        ListBooksCommand listBooksCommand = new ListBooksCommand(catalog);
        listBooksCommand.execute();

        verify(catalog).printListOfBooks();
    }

}
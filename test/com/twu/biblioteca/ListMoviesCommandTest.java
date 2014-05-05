package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesCommandTest {

    private Catalog catalog;

    @Before
    public void setUp() throws Exception {
        catalog = mock(Catalog.class);
    }

    @Test
    public void shouldListMovies() {
        ListMoviesCommand command = new ListMoviesCommand(catalog);
        command.execute();
        verify(catalog).printListOfMovies();
    }

}
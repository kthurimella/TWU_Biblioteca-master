package com.twu.biblioteca;

/**
 * Created by kthurime on 5/5/14.
 */
public class ListMoviesCommand implements Command{
    private Catalog catalog;

    public ListMoviesCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        catalog.printListOfMovies();
    }

    @Override
    public String commandName() {
        return null;
    }
}

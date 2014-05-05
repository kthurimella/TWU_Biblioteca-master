package com.twu.biblioteca;

public class ListBooksCommand implements Command{

    private Catalog catalog;

    public ListBooksCommand(Catalog catalog) {

        this.catalog = catalog;
    }

    @Override
    public void execute() {
        catalog.printListOfBooks();
    }

    @Override
    public String commandName() {
        return "List Books";
    }
}

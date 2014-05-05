package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Menu {
    private Catalog catalog;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Map<String, Command> commandMap;
    private AtomicBoolean state;

    public Menu(Catalog catalog, BufferedReader bufferedReader, PrintStream printStream, Map<String, Command> commandMap, AtomicBoolean state) {
        this.catalog = catalog;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.commandMap = commandMap;
        this.state = state;
    }

    public void chooseOption() {
        String option = readline();

        if (commandMap.containsKey(option)) {
            commandMap.get(option).execute();
        }
        else{
            printStream.println("Select a valid option!");
        }
    }

    private String readline() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void printOptions() {
        printStream.println("Main Menu:");
        for (String key : commandMap.keySet()) {
            printStream.println(String.format("%s. %s", key, commandMap.get(key).commandName()));
        }
    }

    public boolean isDone() {
        return state.get();
    }
}
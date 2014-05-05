package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Catalog catalog;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Menu menu;
    private HashMap<String, Command> commandMap;
    private AtomicBoolean doneState;

    @Before
    public void setUp() throws Exception {
        catalog = mock(Catalog.class);
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        doneState = new AtomicBoolean(false);
        commandMap = new HashMap<String, Command>();
        menu = new Menu(catalog, bufferedReader, printStream, commandMap, doneState);
    }

    @Test
    public void shouldNotifyWithMessageWhenInvalidOptionIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");
        menu.chooseOption();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldReturnErrorWhenGivenInvalidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Invalid Option");
        menu.chooseOption();
        verify(printStream).println("Select a valid option!");

    }

    @Test
    public void shouldCallCommandBasedOnOption() throws IOException {
        Command command = mock(Command.class);
        commandMap.put("1", command);
        when(bufferedReader.readLine()).thenReturn("1");
        menu.chooseOption();
        verify(command).execute();
    }

    @Test
    public void shouldPrintQuitOptionWhenPrintStatementIsCalled() throws IOException {
        Command command = mock(Command.class);
        when(command.commandName()).thenReturn("Command Name");
        commandMap.put("1", command);
        menu.printOptions();
        verify(printStream).println("1. Command Name");

    }

}

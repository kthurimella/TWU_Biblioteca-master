package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuitCommandTest {

    private PrintStream printStream;
    private QuitCommand quitCommand;
    private AtomicBoolean state;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        state = new AtomicBoolean(false);
        quitCommand = new QuitCommand(printStream, state);
    }

    @Test
    public void shouldQuitWhenSelectQuitFromMenu() throws IOException {
        quitCommand.execute();
        verify(printStream).println("Thanks for using the App!");
    }

    @Test
    public void shouldBeDoneWhenSelectQuitFromMenu() throws IOException {
        quitCommand.execute();
        assertTrue(state.get());
    }

    @Test
    public void shouldModifyMenuStateWhenExecuted() {
        Menu menu = new Menu(null, null, null, null, state);
        quitCommand.execute();
        assertThat(menu.isDone(), is(true));

    }


}
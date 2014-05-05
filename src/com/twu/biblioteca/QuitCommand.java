package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class QuitCommand implements Command{
    private java.io.PrintStream printStream;
    private AtomicBoolean state;

    public QuitCommand(PrintStream printStream, AtomicBoolean state) {
        this.printStream = printStream;
        this.state = state;
    }

    @Override
    public void execute() {
        state.set(true);
        printStream.println("Thanks for using the App!");
    }
}

package net.dtw.command;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The abstraction of the commands used by the <code>CommandManager</code>.
 *
 * @author Daniel Whitney
 */
@FunctionalInterface
public interface Command {

    /**
     * Gives arguments, an input, and an output stream to the class so its
     * command may be executed. Handles the two exceptions elegantly.
     *
     * @param args the array of strings that are the programs arguments.
     * @param in the command input stream.
     * @param out the command output stream.
     * @throws IllegalArgumentException if an argument is of the wrong type.
     * @throws IllegalArgumentCountException if an invalid number of arguments
     * was given.
     */
    void doCommand(String[] args, InputStream in, PrintStream out);

}

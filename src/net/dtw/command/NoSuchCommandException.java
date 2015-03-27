package net.dtw.command;

/**
 * Indicates a command does not exist.
 * 
 * @author Daniel
 */
public class NoSuchCommandException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchCommandException</code> without
     * detail message.
     */
    public NoSuchCommandException() {
    }

    /**
     * Constructs an instance of <code>NoSuchCommandException</code> with the
     * specified missing command.
     *
     * @param commandName the command not found.
     */
    public NoSuchCommandException(String commandName) {
        super("There is no command '" + commandName + "' initialized.");
    }
}

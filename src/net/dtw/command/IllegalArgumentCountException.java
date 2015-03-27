package net.dtw.command;

/**
 * Indicates an invalid number of arguments.
 * 
 * @author Daniel
 */
public class IllegalArgumentCountException extends Exception {

    /**
     * Creates a new instance of <code>IllegalArgumentCountException</code>
     * without detail message.
     */
    public IllegalArgumentCountException() {
    }

    /**
     * Constructs an instance of <code>IllegalArgumentCountException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalArgumentCountException(String msg) {
        super(msg);
    }
}

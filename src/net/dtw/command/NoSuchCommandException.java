/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dtw.command;

/**
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

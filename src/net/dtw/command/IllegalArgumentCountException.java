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

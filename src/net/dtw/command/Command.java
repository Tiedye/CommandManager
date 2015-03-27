/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dtw.command;

import java.io.InputStream;
import java.io.PrintStream;

/**
 *
 * @author Daniel
 */
public abstract class Command {
    
    protected abstract void doCommand(String[] args, InputStream in, PrintStream out) throws IllegalArgumentException, IllegalArgumentCountException;
    
}

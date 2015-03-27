package net.dtw.command;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A self contained command interpreter.
 * 
 * @author Daniel
 */
public class CommandManager {

    private final HashMap<String, Command> commands;
    private final InputStream in;
    private final PrintStream out;
    
    private boolean running;
    
    /**
     * Initialized the <code>Command Manager</code> with an input and output stream.
     * 
     * @param in the stream to read from.
     * @param out the stream to write to.
     */
    public CommandManager(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        running = false;
        commands = new HashMap<>();
    }
    
    /**
     * Associates a command name with a <code>Command</code>.
     * 
     * @param name the name of the command.
     * @param command the <code>Command</code> to link the name to.
     */
    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }
    
    /**
     * Dissociates the <code>Command</code> from the name.
     * 
     * @param name command name which will have its associations cleared.
     * @throws NoSuchCommandException if there is no associations with said command name.
     */
    public void clearCommand(String name) throws NoSuchCommandException {
        if (commands.containsKey(name)) {
            commands.remove(name);
        } else {
            throw new NoSuchCommandException(name);
        }
    }
    
    /**
     * Begins interpreting the text from the input stream as commands.
     */
    public void startInterpreting() {
        Scanner input = new Scanner(in);
        running = true;
        while (running && input.hasNext()) {
            String[] commandTerms = toTerms(input.nextLine());
            String commandName = commandTerms[0];
            String[] commandArguments = Arrays.copyOfRange(commandTerms, 1, commandTerms.length);
            if (!commands.containsKey(commandName)) {
                out.println("The command '" + commandName + "' does not exist.");
            } else {
                try {
                    commands.get(commandName).doCommand(commandArguments, in, out);
                } catch (IllegalArgumentException ex) {
                    out.println("Invalid argument type for command '" + commandName + "'.");
                } catch (IllegalArgumentCountException ex) {
                    out.println("Invalid number of arguments for command '" + commandName + "'.");
                }
            }
        }
    }

    /**
     * Stops interpreting commands from the input stream.
     */
    public void stopInterpreting() {
        running = false;
    }

    private String[] toTerms(String command) {
        ArrayList<String> newTerms = new ArrayList<>();
        boolean inQuote = false;
        for (String term : command.split(" ")) {
            if (inQuote) {
                if (term.endsWith("\"")) {
                    inQuote = false;
                    term = term.substring(0, term.length() - 1);
                }
                newTerms.add(newTerms.size() - 1, newTerms.get(newTerms.size() - 1) + " " + term);
                newTerms.remove(newTerms.size() - 1);
            } else if (term.startsWith("\"")) {
                inQuote = true;
                term = term.substring(1);
                newTerms.add(term);
            } else {
                newTerms.add(term);
            }
        }
        return newTerms.toArray(new String[newTerms.size()]);
    }

}

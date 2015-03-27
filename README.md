## CommandManager
Implements a simple command line interface.
### Usage
To use this library, create Commands by extending the `Command` abstract class.   Then create an instance of the `CommandManager` with `System.in` as the input stream and `System.out` as the output stream.  Register each command in the manager with `CommandManager.registerCommand()`.  Finally use `CommandManager.startInterpreting()` method to begin reading the users commands.

To stop interpreting the method `CommandManager.stopInterpreting()` can be called from inside a command.
Example:

```java
import java.io.*;
import net.dtw.command.*;

public class ExitCommand extends Command {
    
    private CommandManager manager;
    
    public ExitCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    protected void doCommand(String[] args, InputStream in, PrintStream out) throws IllegalArgumentException, IllegalArgumentCountException {
        if (args.length != 0) {
            throw new IllegalArgumentCountException();
        }
        manager.stopInterpreting();
    }
}
```

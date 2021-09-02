package Demos;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogExample {
    private static final Logger LOGGER= Logger.getLogger(LogExample.class.getName());
    static {
        LOGGER.setLevel(Level.FINEST);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINEST);
        LOGGER.addHandler(consoleHandler);
    }

    public static void main(String[] args) {
        LOGGER.log(Level.FINEST,"This is an example message");
    }
}
/*
7 levels of Logger Levels based on severity
 SEVERE,WARNING,INFO,CONFIG,FINE,FINER,FINEST

 Initial Example
public class LogExample {
    private static final Logger LOGGER= Logger.getLogger(LogExample.class.getName());
    public static void main(String[] args) {
       LOGGER.log(Level.INFO,"This is an example message");
    }
}

 ...
 LOGGER.setLevel(Level.FINEST);
 LOGGER.log(Level.FINEST,"This is an example message");
 int this example when run, the message will not appear in our terminal due to handlers
*/

/*
Log Handler Notes
Act as filters
Different types: ConsoleHandler, FileHandler, StreamHandler, SocketHandler, MemoryHandler
 */

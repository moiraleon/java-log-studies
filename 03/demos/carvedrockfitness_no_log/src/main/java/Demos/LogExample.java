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

/*
Best Practices Notes
if something is a warning don't log as severe
if something is an error don't look with level info
don't log too much or too little

3 Log Methods


LOGGER.log(Level.INFO, "This is an example message");

regular log, specify level and give message

LOGGER.logp(Level.INFO, LogExample.class.getName(), "sourceMethodName", ""This is an example message");

log precise, specify level and class from which log message is derived, and method, and message
*best practice

LOGGER.logrb(Level.INFO, ResourceBundle.getBundle("en_US"), "This is an example message");

log resource bundle, great for localization
 */

/*
Log Filters Notes

Need to add a log interface


 */
package Demos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogExample {
    private static final Logger LOGGER= Logger.getLogger(LogExample.class.getName());
    public static void main(String[] args) {
       LOGGER.log(Level.INFO,"This is an example message");
    }
}
/*
7 levels of Logger Levels based on severity
 SEVERE,WARNING,INFO,CONFIG,FINE,FINER,FINEST


 ...
 LOGGER.setLevel(Level.FINEST);
 LOGGER.log(Level.FINEST,"This is an example message");
 int this example when run, the message will not appear in our terminal due to handlers
*/

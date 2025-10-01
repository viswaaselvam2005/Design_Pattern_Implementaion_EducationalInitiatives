package Exercise_2.AstronautDailyScheduler.classes;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("AstronautScheduler");

    static {
        logger.setUseParentHandlers(false); // Disable console logs
        try {
            Handler fileHandler = new FileHandler("scheduler.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            System.err.println("Logger initialization failed: " + e.getMessage());
        }
    }

    public static void info(String message) { logger.log(Level.INFO, message); }
    public static void error(String message) { logger.log(Level.SEVERE, message); }
    public static void error(String message, Throwable t) { logger.log(Level.SEVERE, message, t); }
}

package Library;

import java.io.IOException;
import java.util.logging.*;

public class LoggerConfig {
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());

        try {
            //Create a file handler to store logs
            FileHandler fileHandler = new FileHandler("library.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Failed to initialize log file handler: " + e.getMessage());
        }

        logger.setLevel(Level.ALL); //log All levels
        return logger;
    }
}

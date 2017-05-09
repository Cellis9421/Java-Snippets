import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerExample {

	/* Instantiate Logger object at start of each file */
	private final static Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());

	/* Initialize FileHandler and path if logging to File */
	private static FileHandler fileHandler = null;
	private final static String LOG_FILEPATH = "%h/testlog%u.log";

	/* All Log Levels for test purposes*/
	private static final Level[] LOG_LEVELS = new Level[] { Level.ALL, Level.CONFIG, Level.FINE, Level.FINER,
			Level.FINEST, Level.INFO, Level.OFF, Level.SEVERE, Level.WARNING };

	/* Static init */
	public static void initFileLogging(Level level) {
		try {
			fileHandler = new FileHandler(LOG_FILEPATH);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		fileHandler.setFormatter(new SimpleFormatter());
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(level);
	}

	public static void initFileLogging() {
		initFileLogging(LOGGER.getLevel());
	}
	
	/* Testing */
	public static void main(String[] args) {
		LoggerExample.initFileLogging(Level.ALL);

		for (Level level : LOG_LEVELS)
			LOGGER.log(level, "This is a log visible to: " + level.getName() + ". Default Value: " + level.intValue());

	}

}

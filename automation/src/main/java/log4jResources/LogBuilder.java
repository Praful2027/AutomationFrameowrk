package log4jResources;

import org.apache.logging.log4j.*;

public class LogBuilder {
	
	
	private static Logger log;
	
	public void initializeLogger(Object obj) {
		log = LogManager.getLogger(obj.getClass().getName());
	}

	
	public void trace(String message) {
		log.trace(message);
	}
	
	
	public void debug(String message) {
		log.debug(message);
	}
	
	
	public void info(String message) {
		log.info(message);
	}
	
	
	public void warn(String message) {
		log.warn(message);
	}
	
	
	public void error(String message) {
		log.error(message);
	}
	
	
	public void fatal(String message) {
		log.fatal(message);
	}
	
}

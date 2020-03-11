package testPackage;

import org.testng.annotations.Test;

import log4jResources.LogBuilder;

public class LoggerTest {


	@Test
	public void testLogs() {

		LogBuilder log = new LogBuilder();
		log.initializeLogger(this);
		

		log.debug("This is a debug log");

		log.error("This is a error log");

		log.fatal("This is a fatal log");

		log.info("This is a info log");

	}



}

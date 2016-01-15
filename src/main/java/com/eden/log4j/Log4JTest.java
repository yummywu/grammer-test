package com.eden.log4j;

import org.apache.log4j.Logger;

public class Log4JTest {
	static Logger log = Logger.getLogger(Log4JTest.class);

	public void log() {
		log.debug("Debug info.");
		log.info("Info info");
		log.warn("Warn info");
		log.error("Error info");
		log.fatal("Fatal info");
	}

	public static void main(String[] args) {
		Log4JTest test = new Log4JTest();
		test.log();
	}

}

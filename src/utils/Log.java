package utils;

import org.apache.log4j.Logger;

public class Log {

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite

	public static void startTestCase(Logger logger, String sTestCaseName) {

		logger.info("****************************************************************************************");

		logger.info("****************************************************************************************");

		logger.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		logger.info("****************************************************************************************");

		logger.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(Logger logger, String sTestCaseName) {

		logger.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

		logger.info("X");

		logger.info("X");

		logger.info("X");

		logger.info("X");

	}

}

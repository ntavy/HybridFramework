package appModule;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utils.CommonUtils;
import utils.Operations;

public class SignIn_Action {
	private static Logger logger = Logger.getLogger(SignIn_Action.class);
	private static Properties configObjects = CommonUtils.configObjects;

	public static void signInSystem(WebDriver driver) {
		Operations.setTextByKey(driver, "username", configObjects.getProperty("username"));
		Operations.setTextByKey(driver, "password", configObjects.getProperty("password"));

		Operations.clickByKey(driver, "loginButton");

		Operations.waitUntilVisibility(driver, "loggedLink");
	}

	public static boolean checkIsLogged(WebDriver driver) {
		try {
			if (Operations.getElementByXPath(driver, "loggedLink") != null)
				return true;
		} catch (Exception e) {
			logger.warn("element not exist");
			return false;
		}

		return false;

	}
}

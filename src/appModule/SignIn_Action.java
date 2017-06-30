package appModule;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utils.CommonUtils;
import utils.Operations;

public class SignIn_Action {

	private static Properties configObjects = CommonUtils.configObjects;

	public static void signInSystem(WebDriver driver) {
		Operations.setTextByKey(driver, "username", configObjects.getProperty("username"));
		Operations.setTextByKey(driver, "password", configObjects.getProperty("password"));

		Operations.clickByKey(driver, "searchButton");

		Operations.waitUntilVisibility(driver, "loggedLink");
	}

	public static boolean checkIsLogged(WebDriver driver) {
		if (Operations.getElementByXPath(driver, "loggedLink") != null)
			return true;
		return false;

	}
}

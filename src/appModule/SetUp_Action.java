package appModule;

import org.openqa.selenium.WebDriver;

import operation.MenuObject;
import utils.Operations;

public class SetUp_Action {

	public static void setUp(MenuObject menu, WebDriver driver) {
		// navigate to hrms
		Operations.getToUrl(driver, "urlHrms");

		if (!SignIn_Action.checkIsLogged(driver))
			SignIn_Action.signInSystem(driver);

	}

	public static void release(WebDriver driver) {
		driver.close();
	}
}

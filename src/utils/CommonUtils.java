package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import operation.BrowserService;
import operation.ReadObject;

public class CommonUtils {

	public static WebDriver driver = null;
	public static final ReadObject object = new ReadObject();
	public static final Properties urlObjects = object.getUrlObject();
	public static final Properties xpathObjects = object.getXpathObject();
	public static final Properties configObjects = object.getConfigObject();

	public static void setupBrowser() {
		// setup webdriver
		String browser = configObjects.getProperty("browser");
		if (browser.equals("chrome")) {
			BrowserService browserService = new BrowserService();
			driver = browserService.getChromeWebDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configObjects.getProperty("gecko"));
			driver = new FirefoxDriver();
		}

		// navigate to hrms
		driver.get(urlObjects.getProperty("urlHrms"));

		// maximize browser
		driver.manage().window().maximize();
	}

}

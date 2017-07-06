package utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import operation.ReadObject;

public class CommonUtils {
	private static Logger logger = Logger.getLogger(CommonUtils.class.getName());

	public static WebDriver driver = null;
	public static final ReadObject object = new ReadObject();
	public static final Properties urlObjects = object.getUrlObject();
	public static final Properties xpathObjects = object.getXpathObject();
	public static final Properties configObjects = object.getConfigObject();
	public static WebDriverWait wait = null;

	public static void setupBrowser() {
		// setup webdriver
		String browser = configObjects.getProperty("browser");
		if (browser.equals("chrome")) {
			BrowserUtils browserService = new BrowserUtils();
			driver = browserService.getChromeWebDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configObjects.getProperty("gecko"));
			driver = new FirefoxDriver();
		}

		// navigate to hrms
		driver.get(urlObjects.getProperty("urlHrms"));

		// maximize browser
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
	}

	public static WebDriver getDriver() {

		// setup webdriver
		String browser = configObjects.getProperty("browser");
		if (browser.equals("chrome")) {
			BrowserUtils browserService = new BrowserUtils();
			driver = browserService.getChromeWebDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configObjects.getProperty("gecko"));
			driver = new FirefoxDriver();
		}

		// navigate to hrms
		driver.get(urlObjects.getProperty("urlHrms"));
		driver.manage().window().maximize();
		return driver;
	}

	public static void waitImplicitly(long second) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void waitUntilVisibility(String xPathLocator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
		} catch (Exception ex) {
			logger.warn("Cannot find element");
		}

	}
}

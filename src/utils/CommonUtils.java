package utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import operation.BrowserService;
import operation.ReadObject;

public class CommonUtils {

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
		wait = new WebDriverWait(driver, 60);
	}

	public static void signInSystem() {
		driver.findElement(By.xpath(xpathObjects.getProperty("username")))
				.sendKeys(configObjects.getProperty("username"));
		driver.findElement(By.xpath(xpathObjects.getProperty("password")))
				.sendKeys(configObjects.getProperty("password"));
		driver.findElement(By.xpath(xpathObjects.getProperty("searchButton"))).click();
		waitUntilVisibility(xpathObjects.getProperty("loggedLink"));
		System.out.println("Logged successfully");

	}

	public static void waitImplicitly(long second) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void waitUntilVisibility(String xPathLocator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
	}
}

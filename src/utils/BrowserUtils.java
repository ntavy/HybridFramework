package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
	public static WebDriver getChromeWebDriver() {
		System.setProperty("webdriver.chrome.driver", CommonUtils.configObjects.getProperty("chromeDriver"));
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver getFirefoxWebDriver() {
		System.setProperty("webdriver.gecko.driver", CommonUtils.configObjects.getProperty("geckoDriver"));
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver getBroswer() {
		WebDriver driver;
		String browser = CommonUtils.configObjects.getProperty("browser");
		if (browser.equals("chrome")) {
			driver = getChromeWebDriver();
		} else {
			driver = getFirefoxWebDriver();
		}

		// maximize browser
		driver.manage().window().maximize();
		return driver;
	}
}

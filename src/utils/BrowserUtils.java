package operation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;

public class BrowserService {
	public WebDriver getChromeWebDriver() {
		System.setProperty("webdriver.chrome.driver", CommonUtils.configObjects.getProperty("chromeDriver"));
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getFirefoxWebDriver() {
		System.setProperty("webdriver.gecko.driver", CommonUtils.configObjects.getProperty("geckoDriver"));
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}

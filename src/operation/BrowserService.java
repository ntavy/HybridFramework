package operation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserService {
	public WebDriver getChromeWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:/Working/ExternalLibrary/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getFirefoxWebDriver() {
		System.setProperty("webdriver.gecko.driver", "D:/Working/ExternalLibrary/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}

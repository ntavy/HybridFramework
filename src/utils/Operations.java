package utils;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Operations {

	private static Properties xpathObjects = CommonUtils.xpathObjects;
	private static Properties urlObjects = CommonUtils.urlObjects;

	public static void setTextByKey(WebDriver driver, String xPathKey, String value) {
		setText(driver, xpathObjects.getProperty(xPathKey), value);
	}

	public static void setText(WebDriver driver, String xPath, String value) {
		driver.findElement(By.xpath(xPath)).sendKeys(value);
	}

	public static void clickByKey(WebDriver driver, String xPathProperty) {
		driver.findElement(By.xpath(xpathObjects.getProperty(xPathProperty))).click();
	}

	public static void waitImplicitly(WebDriver driver, long second) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void waitUntilVisibility(WebDriver driver, String xPathKey) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathObjects.getProperty(xPathKey))));
	}

	public static WebElement getElementByXPath(WebDriver driver, String xPathKey) {
		return driver.findElement(By.xpath(CommonUtils.xpathObjects.getProperty(xPathKey)));
	}

	public static List<WebElement> getElementListByXPath(WebDriver driver, String xPathKey) {
		return driver.findElements(By.xpath(CommonUtils.xpathObjects.getProperty(xPathKey)));
	}

	public static void getToUrl(WebDriver driver, String urlKey) {
		driver.get(urlObjects.getProperty(urlKey));
	}

}

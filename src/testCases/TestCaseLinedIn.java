package testCases;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import operation.MenuObject;
import utils.BrowserUtils;
import utils.CommonUtils;
import utils.Operations;

public class TestCaseLinedIn {
	// private Logger logger = Logger.getLogger(TestCase1.class.getName());
	private WebDriver driver = null;
	private MenuObject menu = null;
	private static Properties configObjects = CommonUtils.configObjects;

	@BeforeTest
	public void setup() {
		driver = BrowserUtils.getBroswer();

		Operations.getToUrl(driver, "urlLinked");
		CommonUtils.waitUntilVisibility("usernameLinked");
		Operations.setTextByKey(driver, "usernameLinked", configObjects.getProperty("usernameLinked"));
		Operations.setTextByKey(driver, "passwordLined", configObjects.getProperty("passwordLinked"));

		Operations.clickByKey(driver, "loginButtonLinked");

	}

	@Test
	public void testLinkedIn() {
		Operations.waitUntilVisibility(driver, "searchButtonLinked");

		Operations.clickByKey(driver, "searchButtonLinked");

		Operations.setTextByKey(driver, "searchButtonLinked", "java developer");
		Operations.waitImplicitly(driver, 10);
		Operations.getElementByXPath(driver, "searchButtonLinked").sendKeys(Keys.ENTER);
		List<WebElement> nameList = Operations.getElementListByXPath(driver, "nameSearchedLinked");
		System.out.println(nameList.size());
		for (WebElement element : nameList) {
			System.out.println(element);
			System.out.println(element.getText());
		}
	}

}

package testCases;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import operation.MenuObject;
import operation.ReadObject;

public class TestCase1 {

	WebDriver driver = null;

	@Test
	public void testTestCase1() {
		try {

			System.setProperty("webdriver.gecko.driver", "D:/Working/Java-Project/DemoSel/library/geckodriver.exe");
			driver = new FirefoxDriver();
			ReadObject object = new ReadObject();
			Properties objects = object.getUrlObject();
			Properties xpathObjects = object.getXpathObject();

			MenuObject menu = new MenuObject();
			// navigate
			driver.get(objects.getProperty("urlHrms"));

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathObjects.getProperty("menuList"))));

			WebElement menuAdmin = menu.getMenuAdmin(driver);
			System.out.println(menuAdmin.getText());
			menuAdmin.click();
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathObjects.getProperty("subMenuDiv"))));
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// get all child menu Admin
			List<WebElement> subMenus = driver.findElements(By.xpath(xpathObjects.getProperty("subMenuItem")));
			System.out.println("count itiem:" + subMenus.size());
			for (WebElement sub : subMenus) {
				System.out.println("--------" + sub.getText());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}

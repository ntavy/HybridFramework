package operation;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuObject {
	WebDriver driver;
	ReadObject object = new ReadObject();
	Properties objects;

	public List<WebElement> getMenuList(WebDriver driver) throws IOException {
		objects = object.getXpathObject();
		List<WebElement> listMenu = driver.findElements(By.xpath(objects.getProperty("menuList")));
		return listMenu;
	}

	public WebElement getMenuAdmin(WebDriver driver) throws IOException {
		return getMenuList(driver).get(1);
	}

	public List<WebElement> getSubMenuAdmin(WebDriver driver) throws IOException {
		return getMenuAdmin(driver).findElements(By.xpath("//ul/li"));
	}

}

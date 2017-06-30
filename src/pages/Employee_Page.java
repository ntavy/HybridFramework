package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import operation.ReadObject;

public class Employee_Page {
	private ReadObject object = new ReadObject();
	private Properties xpathObjects = object.getXpathObject();
	private WebDriver driver;

	public Employee_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void selectByText(String contentText) {
		Select select = new Select(driver.findElement(By.xpath(xpathObjects.getProperty("departmentComboBox"))));
		select.selectByVisibleText(contentText);
	}
}

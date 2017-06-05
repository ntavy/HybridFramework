package operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class EmployeeObject {
	ReadObject object = new ReadObject();
	Properties xpathObjects = object.getXpathObject();

	public void selectByText(String contentText) {
		Select select = new Select(
				CommonUtils.driver.findElement(By.xpath(xpathObjects.getProperty("departmentComboBox"))));
		select.selectByVisibleText(contentText);
	}

}

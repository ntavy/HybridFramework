package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtils;

public class Role_Page {
	private WebDriver driver;

	public Role_Page(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getCurrentRoleList(WebDriver driver) {

		return driver.findElements(By.xpath(CommonUtils.xpathObjects.getProperty("currentListRole")));
	}

	public boolean isExistRoleName(String roleName) {
		for (WebElement ele : getCurrentRoleList(driver)) {
			List<WebElement> listTd = ele.findElements(By.tagName("td"));
			if (listTd != null && listTd.size() > 0) {
				if (listTd.get(1).getText().equals(roleName))
					return true;
			}

		}
		return false;
	}
}

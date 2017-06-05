package operation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtils;

public class MenuObject {
	private WebDriver driver = CommonUtils.driver;

	public List<WebElement> getMenuList() {
		List<WebElement> listMenu = driver.findElements(By.xpath(CommonUtils.xpathObjects.getProperty("menuList")));
		return listMenu;
	}

	public WebElement getMenuAdmin() {
		return getMenuList().get(1);
	}

	public WebElement getMenuEmployee() {
		return getMenuList().get(2);
	}

	public WebElement getMenuRecruitment() {
		return getMenuList().get(3);
	}

	public WebElement getMenuCandidate() {
		return getMenuList().get(4);
	}

	public WebElement getMenuTemplate() {
		return getMenuList().get(5);
	}

	public WebElement getMenuPerformance() {
		return getMenuList().get(7);
	}

	public WebElement getMenuLeaveManagement() {
		return getMenuList().get(8);
	}

	public WebElement getMenuCourseManagement() {
		return getMenuList().get(9);
	}

	public int getIndexSubMenuAdminByName(String subMenuName) throws IOException {
		List<WebElement> subMenus = driver.findElements(By.xpath(CommonUtils.xpathObjects.getProperty("subMenuItem")));
		int index = 0;
		for (WebElement sub : subMenus) {
			index++;
			String textName = sub.getText();
			if (sub.getText() != null && textName.trim().equals(subMenuName)) {
				break;
			}
		}
		return index;
	}

	public WebElement getSubMenuByName(String subMenuName) {
		List<WebElement> subMenus = driver.findElements(By.xpath(CommonUtils.xpathObjects.getProperty("subMenuItem")));
		for (WebElement sub : subMenus) {
			String textName = sub.getText();
			if (sub.getText() != null && textName.trim().equals(subMenuName)) {
				return sub;
			}
		}
		return null;
	}

	public WebElement getMenuRole() {
		String indexOfRole = "";
		try {
			indexOfRole = Integer.toString(getIndexSubMenuAdminByName("Role"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver
				.findElement(By.xpath(CommonUtils.xpathObjects.getProperty("subMenuItem") + "[" + indexOfRole + "]"));
	}

}

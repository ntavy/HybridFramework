package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import operation.EmployeeObject;
import operation.MenuObject;
import operation.RoleObject;
import utils.CommonUtils;
import utils.Constants;

public class TestCase1 {
	private WebDriver driver;
	private MenuObject menu;

	private int timeSecondWaitDefault = 10;

	@BeforeTest
	public void setup() {
		if (CommonUtils.driver == null) {
			CommonUtils.setupBrowser();
		}
		driver = CommonUtils.driver;
		menu = new MenuObject();
	}

	@Test
	public void testClickAllMenu() {
		menu.getMenuAdmin().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.ROLE_MENU));
		menu.getMenuEmployee().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.EMPLOYEE_LIST_MENU));
		menu.getMenuRecruitment().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.RECRUITMENT_LIST_MENU));
		menu.getMenuCandidate().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.CANDIATE_LIST_MENU));
		menu.getMenuTemplate().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.LETTER_TEMPLATE));
		menu.getMenuPerformance().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.CATEGORY_MANAGEMENT));
		menu.getMenuLeaveManagement().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.PUBLIC_HOLIDAY));
		menu.getMenuCourseManagement().click();
		Assert.assertNotNull(menu.getSubMenuByName(Constants.TEST_RESULT));

	}

	@Test
	public void testTestCase1() {
		try {
			// wait for menu appear
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(CommonUtils.xpathObjects.getProperty("menuList"))));

			// click Admin Menu
			WebElement menuAdmin = menu.getMenuAdmin();
			menuAdmin.click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			// test click sub menu
			WebElement subAdminMenu = menu.getSubMenuByName(Constants.ROLE_MENU);
			subAdminMenu.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(CommonUtils.xpathObjects.getProperty("searchInputRole"))));
			RoleObject roleObject = new RoleObject();
			Assert.assertFalse(roleObject.isExistRoleName("aaa"));
		} catch (Exception ex) {
			ex.printStackTrace();
			;
		}

	}

	// @Test
	public void testTestCase2() {
		try {

			driver.get("http://localhost:8080/hrms/employee/list");
			EmployeeObject employeeObject = new EmployeeObject();
			employeeObject.selectByText("Bern Dept.");

		} catch (Exception ex) {
			System.out.println(ex);

		}

	}

}

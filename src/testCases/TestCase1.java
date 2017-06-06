package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@BeforeTest
	public void setup() {
		if (CommonUtils.driver == null) {
			CommonUtils.setupBrowser();
		}
		driver = CommonUtils.driver;
		menu = new MenuObject();
		// CommonUtils.signInSystem();
	}

	@Test
	public void test() {
		System.out.println("abc");
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
		System.out.println("hello");

	}

	@Test
	public void testTestCase1() {
		try {
			// wait for menu display
			CommonUtils.waitUntilVisibility(CommonUtils.xpathObjects.getProperty("menuList"));

			// click Admin Menu
			WebElement menuAdmin = menu.getMenuAdmin();
			menuAdmin.click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			// test click sub menu
			WebElement subAdminMenu = menu.getSubMenuByName(Constants.ROLE_MENU);
			subAdminMenu.click();

			// wait for search input role display
			CommonUtils.waitUntilVisibility(CommonUtils.xpathObjects.getProperty("searchInputRole"));

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

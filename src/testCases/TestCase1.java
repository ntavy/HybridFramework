package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModule.SetUp_Action;
import operation.EmployeeObject;
import operation.MenuObject;
import pages.Role_Page;
import utils.BrowserUtils;
import utils.CommonUtils;
import utils.Constants;
import utils.Log;

public class TestCase1 {
	private Logger logger = Logger.getLogger(TestCase1.class.getName());
	private WebDriver driver = null;
	private MenuObject menu = null;

	@BeforeTest
	public void setup() {
		driver = BrowserUtils.getBroswer();
		menu = new MenuObject(driver);
		SetUp_Action.setUp(menu, driver);
	}

	@Test
	public void testClickAllMenu() {
		Log.startTestCase(logger, "testClickAllMenu");
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
		Log.endTestCase(logger, "testClickAllMenu");

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

			Role_Page rolePage = new Role_Page(driver);
			Assert.assertFalse(rolePage.isExistRoleName("aaa"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Test
	public void testTestCase2() {
		try {

			menu.getMenuEmployee().click();
			menu.getSubMenuByName(Constants.EMPLOYEE_LIST_MENU).click();
			CommonUtils.waitUntilVisibility("numberofEmployeeShowing");
			EmployeeObject employeeObject = new EmployeeObject();
			employeeObject.selectByText("Bern Dept.");

		} catch (Exception ex) {
			System.out.println(ex);

		}

	}

	@AfterTest
	public void release() {
		SetUp_Action.release(driver);
	}

}

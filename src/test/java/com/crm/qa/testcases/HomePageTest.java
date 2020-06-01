package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;





public class HomePageTest extends TestBase {
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		testUtil.switchToFrame();
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void homePageUsernameLabelTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.validateUserNameLabel());
	}
	
//	@Test(priority=3)
//	public void contactsLinkTest(){
//		contactsPage = homePage.clickContactsLink();
//		
//	}
//	
//	@Test(priority=4)
//	public void dealsLinkTest(){
//		dealsPage = homePage.clickDealsLink();
//		
//	}
//	
	@AfterMethod
	public void tearDown() throws IOException{
		testUtil.takeScreenshot();
		driver.quit();
		
	}
	
		

	

}

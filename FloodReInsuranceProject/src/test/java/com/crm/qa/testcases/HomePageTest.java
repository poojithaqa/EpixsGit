package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendersPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
//ctrl+shift+o
public class HomePageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contact;
	DealsPage deals;
	CalendersPage calen;
	
public HomePageTest() {
	super(); // to call base class constructor
}
@BeforeMethod
public void setUp() throws InterruptedException {
	initialization();
	testUtil = new TestUtil();
     login = new LoginPage();
     contact = new ContactsPage();
     deals = new DealsPage();
    calen = new  CalendersPage();
	homepage = login.loginFreeCRM(prop.getProperty("username"),prop.getProperty("password"));
	Thread.sleep(5000);
}
@Test (priority=1)
public void verifyHomePageTitleTest() throws IOException  {
	
		
		try{
			String title1 = homepage.verifyHomePageTitle();
	Assert.assertEquals(title1, "CRMPRO","home page title not matched");
	} catch(Exception e) {
		e.printStackTrace();
	
			testUtil.takeScreenshotAtEndOfTest();
		
		}
		
	}
	

@Test (priority=2)
public void verifyUserNameTest() throws InterruptedException {	
	testUtil.switchToFrame();
	Thread.sleep(2000);
	Assert.assertTrue(homepage.verifyUserName());
}
@Test (priority=3)
public void clickOnContacts() throws InterruptedException {
	testUtil.switchToFrame();
	Thread.sleep(2000);
	contact = homepage.clickOnContactsLink();
}
@Test (priority=4)
public void clickOndDeals() throws InterruptedException {
	testUtil.switchToFrame();
	Thread.sleep(2000);
	deals = homepage.clickOnDealsLink();
}
@Test (priority=5)
public void clickOnCalender() throws InterruptedException {
	testUtil.switchToFrame();
	Thread.sleep(2000);
	calen = homepage.clickOncalenderLink();
}
@Test (priority=6)
public void clickOnNewContactTest() throws InterruptedException {
	testUtil.switchToFrame();
	Thread.sleep(2000);
	homepage.ClickonNewContact();
}

	

@AfterMethod
public void tearDown() {
	driver.close();
	
}
}

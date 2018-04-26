package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendersPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalenderspageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	TestUtil testUtil;
	CalendersPage calender;
	
	
	
public  CalenderspageTest() {
	super(); // to call base class constructor
}
@BeforeMethod
public void setUp() throws InterruptedException {
	initialization();
	testUtil = new TestUtil();
     login = new LoginPage();
     calender = new CalendersPage();
     
    
	homepage = login.loginFreeCRM(prop.getProperty("username"),prop.getProperty("password"));
	Thread.sleep(5000);
	testUtil.switchToFrame();
	Thread.sleep(2000);
	
	
}
@Test (priority=1)
public void verifyCalenderLabelTest() {
	 Assert.assertTrue(calender.verifyCalenderLabel(),"Calendar"); 
		
}
@Test 
public void selectMonthYearDate() throws InterruptedException {
	Thread.sleep(5000);
	calender.selectMonthYearDate("September", "2017", "18");
	Thread.sleep(6000);
	
}
@AfterMethod
public void tearDown() {
	driver.close();
	
}


}

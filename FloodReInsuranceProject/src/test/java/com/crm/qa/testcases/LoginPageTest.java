package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage home;
	public LoginPageTest() {
		
		//test base class constructor is to  be called
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		 login = new LoginPage();	
	}
	@Test (priority=1)
	public void loginPageTitleTest() {
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
		
	}
	@Test(priority=2)
	public void crmLogoTest() {
		
		boolean flag = login.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
	home = 	login.loginFreeCRM(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
    @AfterMethod
    public void tearDown() {
    	driver.close();
    	
    }
    
}

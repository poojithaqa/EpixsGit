package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendersPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContavstPageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contact;
	String sheetName = "contacts";
	
	
public  ContavstPageTest() {
	super(); // to call base class constructor
}
@BeforeMethod
public void setUp() throws InterruptedException {
	initialization();
	testUtil = new TestUtil();
     login = new LoginPage();
     contact = new ContactsPage();
     
    
	homepage = login.loginFreeCRM(prop.getProperty("username"),prop.getProperty("password"));
	Thread.sleep(5000);
	testUtil.switchToFrame();
	Thread.sleep(2000);
	homepage.clickOnContactsLink();
	
}
@Test (priority=1)
public void verifyContactsPagelabel() {
	Assert.assertTrue(contact.verifyContactsLabel(),"contact label is missing"); 
		
}
@Test (priority=2)
public void selectContactsText() {
	contact.selectContacts("poojitha chowdary");
}
@Test (priority=3)
public void selectMultipleContactsText() {
	contact.selectContacts("poojitha sandra");
	contact.selectContacts("pooja s");
	
}
@DataProvider
public Object[][] getCRMTestData() {
	
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	
}
@Test (priority=4, dataProvider="getCRMTestData")
public void validateCreateNewContact(String titleinp, String FNinput, String LNinp, String Companyinp) throws InterruptedException  {
	
	homepage.ClickonNewContact();
	Thread.sleep(3000);
	//contact.createNewContact ("Mrs.","tom", "peter", "google");
	contact.createNewContact(titleinp, FNinput, LNinp, Companyinp);
	
}
	

@AfterMethod
public void tearDown() {
	driver.close();
	
}

}

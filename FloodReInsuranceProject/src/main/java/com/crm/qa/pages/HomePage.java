package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: poojitha sandra')]")
	WebElement userpanelname;
    @FindBy(xpath="//a[@title='Contacts']")
    WebElement contacts;
    @FindBy(xpath="//a[@title='Deals']")
    WebElement deals;
    @FindBy(xpath="//a[@title='Calendar']")
    WebElement calender;
    @FindBy(linkText="New Contact")
    WebElement NewContact;
   
    
    
    //Initializing the page objects
    public HomePage() {
    	PageFactory.initElements(driver, this);
    }
   
  
    public String verifyHomePageTitle() {
    	
    	return driver.getTitle();
    }

	public boolean verifyUserName() {
		return userpanelname.isDisplayed();
		
	}

   
    public ContactsPage clickOnContactsLink()
    {
    	contacts.click(); //this should return contacts page object
    	return new ContactsPage();
    	
    }
    public DealsPage clickOnDealsLink()
    {
    	deals.click(); //this should return deals page object
    	return new DealsPage();
    	
    }
    public CalendersPage clickOncalenderLink()
    {
    	calender.click(); //this should return Calenders page object(nextlanding page object)
    	return new CalendersPage();
    	
    }
    //public ContactInfoPage ClickonNewContact() //(Eg :create new class for info page)
   public void ClickonNewContact()
    {
    	
    	 Actions buildr = new Actions(driver);
    	 WebElement menu = contacts;
    	 buildr.moveToElement(menu).build().perform();
    	 NewContact.click();
		//return new ContactInfoPage();
    	 
    }


	
	
}

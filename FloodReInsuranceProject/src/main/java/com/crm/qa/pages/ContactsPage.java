package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	@FindBy(name= "title")
	WebElement title;
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement companyname;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	public  ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}
	//@FindBy(xpath="//td[contains(text(),'Contacts')]")
//	WebElement contactslabel;
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).isSelected());
			
	}
	
	public void createNewContact(String titleinp, String FNinput, String LNinp, String Companyinp) {
		Select titledropdown = new Select(title);
		titledropdown.selectByVisibleText(titleinp);
		firstname.sendKeys(FNinput);
		lastname.sendKeys(LNinp);
		companyname.sendKeys(Companyinp);
		savebtn.click();
		
	}
	
	
}

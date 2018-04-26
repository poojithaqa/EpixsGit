package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//we have define object repository or page factory
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signuplk;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logoimg;
	
	
	//initilize all the webelemets using pagefactory

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logoimg.isDisplayed();
	}
		
     public HomePage loginFreeCRM(String Un, String pwd) throws InterruptedException {
    	 
    	 username.sendKeys(Un);
    	 password.sendKeys(pwd);
    	 Thread.sleep(5000);
    	 loginbtn.click();
 		return new HomePage();
    	 
		}
	
}

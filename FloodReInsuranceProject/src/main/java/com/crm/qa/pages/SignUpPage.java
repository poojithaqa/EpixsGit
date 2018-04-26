package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	//we have define object repository or page factory
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signuplk;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logoimg;

}

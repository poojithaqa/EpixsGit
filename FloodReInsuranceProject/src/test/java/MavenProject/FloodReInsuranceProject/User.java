package MavenProject.FloodReInsuranceProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class User {
	public static WebDriver driver;
	
  @Test (priority = 1)
  public void launchBrowser() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\sandr\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver(); 
  }
  
  @Test (priority = 2)
  public void launchApplication(){
  driver.get("https://www.google.com");
  Assert.assertEquals("Google", driver.getTitle());
	  
  }
  @Test (priority = 3)
  
  public void closeBrowser()
  {
	  driver.close();
  }
}

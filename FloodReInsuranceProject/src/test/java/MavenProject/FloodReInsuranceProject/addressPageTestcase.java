package MavenProject.FloodReInsuranceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class addressPageTestcase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sandr\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sandr\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		
	
		
		driver.manage().window().maximize();
		driver.get("https://home-insurance.lloydsbank.com/lloyds/quote/yourproperty?e=0");
		addressPage locate = new addressPage(driver);
	     locate.selectBACcoverage();
	     Thread.sleep(1000);
	     locate.enterAddress("3");
	     locate.enterpostcode("E17 7DW"); 
	     Thread.sleep(1000);
	     locate.locateAddress();
	     Thread.sleep(2000);
	     locate.selectAddress(0);
	     Thread.sleep(2000);
	     locate.selectdisAddress();
	     Thread.sleep(1000);
	     locate.selectPropertyType(2);
	     Thread.sleep(1000);
	    
	     locate.noofBed(3);
	     Thread.sleep(1000);
	     locate.noofBath(2);
	     Thread.sleep(1000);
	     locate.isListedbuilding(1);
	     Thread.sleep(1000);
	     locate.enterYearofConstruction("1998");
	     Thread.sleep(1000);
	     locate.ownerShip(1);
	     Thread.sleep(1000);
	     locate.isHolidayHome(2); 
	     Thread.sleep(1000);
	     locate.isBusinessUse(1);//....
	     Thread.sleep(5000);
	          String s = driver.findElement(By.name("Policy.RiskBuilding.Lodgers")).getAttribute("data-ufe-br-toggle");
	         System.out.println(s);
	          //Assert.assertEquals(s,"lodgers");
	          if(s=="lodgers")
	          {
	        	  System.out.println(s);
	        	locate.selLodgers(1);
	          }
	     Thread.sleep(5000);
	     locate.selectYessecurityAlarm();
	     Thread.sleep(1000);
	     locate.selectYesFireAlarm();
	     Thread.sleep(1000);
	     locate.proceedNext();
	     
	     
	     
	     
		

	}

}

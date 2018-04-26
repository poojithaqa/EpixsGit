package MavenProject.FloodReInsuranceProject;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class addressPage {
	
	WebDriver driver;
	//System.setProperty("webdriver.chrome.driver", "E:\chromedriver_win32")
	
	
	By BACquote             = By.xpath("//label[@for='Policy.CoverType-BAC']");
	
	
	
	By Address			    = By.id("Policy_RiskAddress_HouseNameOrNumber"); //text
	By Postcode 	   		= By.id("Policy_RiskAddress_PostCode"); //text
	By Locate 			    = By.xpath("//button[@value='findAddress']"); //button
	
	By Selectaddress 		= By.id("AddressLookupResult_SelectedAddressIndex"); // dropdown
	By selectadd 		    = By.xpath("//button[@value='selectAddress']"); //button
	By Propertytype 		= By.id("Policy_RiskBuilding_PropertyType");         //dropdown
	String input;
	By Noofbed     		    = By.xpath("//label[contains(@for,'Policy_RiskBuilding_NumberOfBedrooms-')]"); 
	By Noofbath     		    = By.xpath("//label[contains(@for,'Policy_RiskBuilding_NumberOfBathrooms-')]"); //radio
	//By Noofbath      	    = By.name("Policy.RiskBuilding.NumberOfBathrooms");    //radio
	//By Noofbed  			= By.xpath("//label[@for='Policy_RiskBuilding_NumberOfBedrooms']");
	//By Noofbath 			= By.xpath("//label[@for='Policy_RiskBuilding_NumberOfBathrooms']"); //button
	
	By islisB  				= By.id("Policy_RiskBuilding_IsPropertyListed");     //dropdown
    By YOB      		    = By.id("Policy_RiskBuilding_YearBuilt"); //text
    By Owner 				= By.id("Policy_RiskBuilding_Ownership"); // dropdown
    By HolH					= By.id("Policy_RiskProperty_HolidayHome"); //dropdown
    By BusUseB 				= By.id("Policy_RiskBuilding_BusinessUse"); //dropdown
   
    By Lodgers    		    = By.xpath("//label[contains(@for,'Policy_RiskBuilding_Lodgers-')]"); //radio
   // By SecurityAlarmT 		= By.id("Policy_RiskBuilding_SecurityAlarm-true"); //radio
    By SecurityAlarmT  			= By.xpath("//label[@for='Policy_RiskBuilding_SecurityAlarm-true']");
    By SecurityAlarmF  			= By.xpath("//label[@for='Policy_RiskBuilding_SecurityAlarm-false']");
    
    //By SecurityAlarmF 		= By.id("Policy_RiskBuilding_SecurityAlarm-false"); //radio
   // By FireAlarmT 			= By.id("Policy_RiskBuilding_FireAlarm-true");  //radio
    By  FireAlarmT   			= By.xpath("//label[@for='Policy_RiskBuilding_FireAlarm-true']");
    By  FireAlarmF   			= By.xpath("//label[@for='Policy_RiskBuilding_FireAlarm-false']");
   // By FireAlarmT 	= By.id("Policy_RiskBuilding_FireAlarm-false"); //radio
    By Proceed 				= By.xpath("//button[@value='next']"); //button
    
 public addressPage(WebDriver driver) {
	 
	 this.driver= driver;
 }
 public void selectBACcoverage() {
	 driver.findElement(BACquote).click();
	 
 }
	 
 public void enterAddress(String add) {
	 driver.findElement(Address).sendKeys(add);
	 
 }
 public void enterpostcode(String post) {
	  driver.findElement(Postcode).sendKeys(post);
	 
 }
 public void locateAddress() {
	 driver.findElement(Locate).click();
	 
 }
 public void selectAddress(int index) {
	 WebElement dropdown = driver.findElement(Selectaddress);
	Select selectoneaddress = new Select(dropdown) ;
	selectoneaddress.selectByIndex(index);
	 
 }
 public void selectdisAddress() {
	 driver.findElement(selectadd).click();
	 
 }
 public void selectPropertyType(int index) {
	WebElement dropdown = driver.findElement(Propertytype);
	Select propt = new Select(dropdown) ;
	propt.selectByIndex(index);
 }


 public void noofBed(int input) {
	 
	// driver.findElement(Noofbed).click();
	 List<WebElement> radios = driver.findElements(Noofbed);
	 radios.get(input).click();
	/*// System.out.println(input);
	 List<WebElement> radios = driver.findElements(Noofbed);
	 int r = radios.size();
	 System.out.println(r);
	 for (int i = 0 ; i < radios.size();i++) {
		 if(radios.get(i).getAttribute("value").equals(input))
		 {
	        System.out.println(radios.get(i).getAttribute("value"));
	   WebElement radio =  radios.get(i);
	   radio.click();
	   
	 }}*/
	    }
	//System.out.println(radios.get(input));
	//System.out.println(radios.get(input).getAttribute("value"));
	//for (WebElement radio : radios) {
	//	System.out.println(radios.get(input));
//System.out.println(radio.getAttribute("value"));
	      //if (radio.getAttribute("value").equals(input)) {
	        //radios.get(input).click();
	          
	//}
 
	
	 
 
 public void noofBath(int input) {
	/* List<WebElement> radios = driver.findElements(Noofbath);
	 int r = radios.size();
	 System.out.println(r);
	// for (WebElement radio : radios) {
//System.out.println(radio.getAttribute("value"));
//	       if (radio.getAttribute("value").equals(input1)) {
	//          radio.click();
	          */
	// }}
	
		 
			// driver.findElement(Noofbed).click();
			 List<WebElement> radios = driver.findElements(Noofbath );
			 radios.get(input).click();

 }
 public void isListedbuilding(int index5) {
		WebElement dropdown5 = driver.findElement(islisB);
		Select islisB1 = new Select(dropdown5) ;
		islisB1.selectByIndex(index5);
		 
	 }
	 

 public void enterYearofConstruction(String year) {
	 
	 driver.findElement(YOB).sendKeys(year);
	 
 }
 public void ownerShip(int index5) {
		WebElement dropdown5 = driver.findElement(Owner);
		Select isowner = new Select(dropdown5) ;
		isowner.selectByIndex(index5);
		 
	 }
 public void isHolidayHome(int index6) {
		WebElement dropdown6 = driver.findElement(HolH);
		Select isHolH = new Select(dropdown6) ;
		isHolH.selectByIndex(index6);
		 
	 }
 public void isBusinessUse(int index7) {
		WebElement dropdown7 = driver.findElement(BusUseB);
		Select isBusUse = new Select(dropdown7) ;
		isBusUse.selectByIndex(index7);
		 
	 }
 public void selLodgers(int input) {
		// System.out.println(input);
		 List<WebElement> radios = driver.findElements(Lodgers);
		
		 radios.get(input).click();

 }
 public void selectYessecurityAlarm() {
	 driver.findElement(SecurityAlarmT).click();
	 
 }
 public void selectNosecurityAlarm() {
	 driver.findElement(SecurityAlarmF).click();
	 
 }
 public void selectYesFireAlarm() {
	 driver.findElement(FireAlarmT).click();
	 
 }
 public void selectNoFireAlarm() {
	 driver.findElement(FireAlarmF).click();
	 
 }
 public void proceedNext() {
	 driver.findElement(Proceed).click();
	 
 }
 
	 
 }
    


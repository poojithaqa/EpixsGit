package com.crm.qa.util;




	import java.io.File;
	import java.io.IOException;
	import java.util.Set;

	//import org.junit.Test;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import com.google.common.io.Files;

	public class Specialcases {
		WebDriver oBrowser;
		
		public void launchApplication(String sBrowserType, String sURL)
		{
			//WebDriver oBrowser;
			
			if(sBrowserType.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
				oBrowser = new ChromeDriver();
				
			}else if(sBrowserType.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "/Users/narkandukuri/Downloads/geckodriver 2");
				oBrowser = new FirefoxDriver();
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver 2");
				oBrowser = new ChromeDriver();
			}
				
			//2. Launch URL
			oBrowser.get(sURL);
			
			//Maximize the browser
			oBrowser.manage().window().maximize();
			
		}	
		
		public void captureSceenshot(String sFileName) throws InterruptedException, IOException
		{
			//Create an Empty Physical File
			File oDstFile = new File(sFileName);
			
			//Virtual file which has screenshot information
			TakesScreenshot oScn = (TakesScreenshot) oBrowser;
			File oSrcFile = oScn.getScreenshotAs(OutputType.FILE);
			
			//Copy Virtual file to Physical file
			//FileUtils.copyFile(oSrcFile, oDstFile);	
			Files.copy(oSrcFile, oDstFile);	
		}
		
		public void exForCaptureScreenshot() throws InterruptedException, IOException
		{
			launchApplication("Chrome", "https://www.nasdaq.com/");
			//Create an Empty Physical File
			File oDstFile = new File("/Users/narkandukuri/Documents/Recordings/P2S7/Nasdaq.jpg");
			
			//screenshot will be saved Virtual memory/clipboard file which has screenshot information
			TakesScreenshot oScn = (TakesScreenshot) oBrowser;	//Type Casting
			File oSrcFile = oScn.getScreenshotAs(OutputType.FILE);
			
			//Copy Virtual file to Physical file
			//.copyFile(oSrcFile, oDstFile);
			Files.copy(oSrcFile, oDstFile);		
		}
		
		public void exForCaptureSceenshot() throws InterruptedException, IOException
		{
			launchApplication("Chrome", "https://www.nasdaq.com/");
			
			captureSceenshot("/Users/narkandukuri/Documents/Recordings/P2S7/Nasdaq.jpg") ;
			
		}
		
		public void handleMenus() throws InterruptedException
		{
			launchApplication("Chrome", "https://www.nasdaq.com/");
			
			//oBrowser.findElement(By.linkText("Quotes"));
			
			//Informing that mouse over to be performed in a Browser
			//Actions ==> for performing mouse related operations
			Actions oAct = new Actions(oBrowser);
			
			oAct.moveToElement(oBrowser.findElement(By.id("site-nav-quotes")));
			
			//oAct.moveToElement(oBrowser.findElement(By.linkText("Competitors")));
			
			oAct.build().perform();
			
			Thread.sleep(5000);
			
			oBrowser.findElement(By.linkText("Competitors")).click();
				
		}
		
		public void handleDragAndDrop() throws InterruptedException
		{
			launchApplication("Chrome", "https://www.nasdaq.com/");
			
			//oBrowser.findElement(By.linkText("Quotes"));
			
			//Informing that mouse over to be performed in a Browser
			Actions oAct = new Actions(oBrowser);
			
			WebElement uiSource = oBrowser.findElement(By.id(""));
			WebElement uiDestination = oBrowser.findElement(By.id(""));
			
			oAct.dragAndDrop(uiSource, uiDestination);
				
		}

		public void handleAlert() throws InterruptedException
		{
			launchApplication("Chrome", "https://www.nasdaq.com/symbol/adp");
			
			//Make sure to select the Checkbox
			if(!oBrowser.findElement(By.id("cookiepref")).isSelected())
			{
				oBrowser.findElement(By.id("cookiepref")).click();
			}
			
			//Uncheck the Checkbox
			oBrowser.findElement(By.id("cookiepref")).click();
			
			Thread.sleep(5000);
			
			//Change the focus to an Alert
			Alert oAlt = oBrowser.switchTo().alert();
			
			//retrieve the text
			System.out.println(oAlt.getText());
				
			//Accept - OK
			oAlt.accept();
			
			//dismiss - Cancel/Esc
			//oAlt.dismiss();
			
		}
		
		public void beforeHandleFrame() throws InterruptedException
		{
			launchApplication("Chrome", "http://www.proquest.com/about/careers/current-career-opportunities.html");
			
			Select uiCountry = new Select(oBrowser.findElement(By.id("location")));
			
			uiCountry.selectByVisibleText("Africa");
		}
		
		public void handleFrame() throws InterruptedException
		{
			launchApplication("Chrome", "http://www.proquest.com/about/careers/current-career-opportunities.html");
			
			//Switch focus to Frame
			oBrowser.switchTo().frame(oBrowser.findElement(By.className("careers")));
			
			Select uiCountry = new Select(oBrowser.findElement(By.id("location")));
			Thread.sleep(5000);
			uiCountry.deselectAll();
			Thread.sleep(5000);
			uiCountry.selectByVisibleText("Africa");
			Thread.sleep(5000);
			uiCountry.selectByVisibleText("Ann Arbor, MI");
		}
		
		public void beforeHandleMultipleBrowsers() throws InterruptedException
		{
			launchApplication("Chrome", "https://www.cigna.com/");
			
			oBrowser.findElement(By.linkText("Cigna Medicare")).click();
				
			//Click on Medicare Advantage
			oBrowser.findElement(By.className("promo-icon-cta")).click();
		}

		public void handleSingleChildBrowsers() throws InterruptedException
		{
			launchApplication("Chrome", "https://www.cigna.com/");
			
			System.out.println(oBrowser.getTitle()); //Parent Browser
			
			oBrowser.findElement(By.linkText("Cigna Medicare")).click();
			
			Thread.sleep(5000);
			
			//Switch the focus from Parent Browser to Child Browser
				//Step 1: Find Parent Browser ID
				String sParentID = oBrowser.getWindowHandle();
				
				//Step 2: Find all browser IDs
				Set<String> sAllBrowserIDs = oBrowser.getWindowHandles();
			
				//Step 3: Takeout sParentID from sAllBrowserIDs
				for(String sEachBrowserId: sAllBrowserIDs)
				{
					if(!sEachBrowserId.equals(sParentID))
					{
						//Switch to Browser
						oBrowser.switchTo().window(sEachBrowserId);
						break;
					}
				}
				
			//Child Browser title
			System.out.println(oBrowser.getTitle());
				
			//Click on Medicare Advantage
			oBrowser.findElement(By.className("promo-icon-cta")).click();
		}

		public void handleMoreThanOneChildBrowsers() throws InterruptedException
		{
			String sExpectedChildBrowser = "British Airways";
			
			launchApplication("Chrome", "https://www.cigna.com/");
			
			System.out.println(oBrowser.getTitle()); //Parent Browser
			
			oBrowser.findElement(By.linkText("Cigna Medicare")).click();
			
			Thread.sleep(5000);
			
			//Switch the focus from Parent Browser to Child Browser
				//Step 1: Find Parent Browser ID
				String sParentID = oBrowser.getWindowHandle();
				
				//Step 2: Find all browser IDs
				Set<String> sAllBrowserIDs = oBrowser.getWindowHandles();
			
				//Step 3: Takeout sParentID from sAllBrowserIDs
				for(String sEachBrowserId: sAllBrowserIDs)
				{
					//Switch focus to each Browser
					oBrowser.switchTo().window(sEachBrowserId);
					
					//get the title of it
					if(oBrowser.getTitle().contains(sExpectedChildBrowser))
					{
						break;
					}
				}
				
			//Child Browser title
			System.out.println(oBrowser.getTitle());
				
			oBrowser.findElement(By.className("promo-icon-cta")).click();
		}
	}












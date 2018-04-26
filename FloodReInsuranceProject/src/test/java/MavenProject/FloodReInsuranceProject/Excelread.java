package MavenProject.FloodReInsuranceProject;
	import java.io.IOException;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

import com.crm.qa.util.ExcelReadByJXL;
import com.crm.qa.util.ExcelReadbyPOI;
import com.crm.qa.util.Specialcases;



	public class Excelread  {
		@Test
		public void calculateLoanAmount() throws InterruptedException
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sandr\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    //ExcelReadByJXL readsheet = new ExcelReadByJXL("C:\\Users\\sandr\\Desktop\\testdata.xls","calc");
		ExcelReadbyPOI readsheet = new ExcelReadbyPOI("C:\\Users\\sandr\\Desktop\\test.xlsx","calc");
		
		Specialcases screen = new Specialcases();
		
	
		try
		{
		for (int i = 1; i<=readsheet.rowCount(); i++)
		{
		
		driver.get("http://www.deal4loans.com/Contents_Calculators.php");
		driver.findElement(By.id("Loan_Amount")).clear();
		driver.findElement(By.id("Loan_Amount")).sendKeys(readsheet.getCellData("loanamount",i));
		driver.findElement(By.name("rate")).clear();
		driver.findElement(By.name("rate")).sendKeys(readsheet.getCellData("rate",i));
		driver.findElement(By.name("months")).clear();
		driver.findElement(By.name("months")).sendKeys(readsheet.getCellData("months",i));
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value ='Calculate']")).click();
		}
		}catch(NullPointerException e)
		{
			try
			{
				
			screen.captureSceenshot("C:\\Users\\sandr\\Desktop\\testfail.jpg");
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
			
			
		}
		}
		
		}

	




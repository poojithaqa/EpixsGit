package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CalendersPage extends TestBase {
	@FindBy(id="handle_CALENDAR")
    WebElement calenderlabel;
	@FindBy(name="slctMonth")
	WebElement selectmonth;
	@FindBy(name="slctYear")
	WebElement selectyear;
	
	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[4]
	
	String beforXpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
	String afterXpath = "]/td[";
	String daysel = null;
	boolean flag = false;
	
	
	public  CalendersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCalenderLabel() {
		return calenderlabel.isDisplayed();
		
	}
	
	public void selectMonthYearDate(String month,String year , String day) throws InterruptedException
	{
		Select monthdrop = new Select(selectmonth);
		monthdrop.selectByVisibleText(month);
		Select yeardrop = new Select(selectyear);
		yeardrop.selectByVisibleText(year);
		Thread.sleep(5000);
		for (int rownum=2 ; rownum <=7; rownum++) {
			for(int colNum = 1; colNum <=7;colNum++)
			{
				try {
				daysel = driver.findElement(By.xpath(beforXpath+rownum+afterXpath+colNum+"]")).getText();
				}catch(NoSuchElementException e) {
					System.out.println("enter correct date");
					flag = false;
					break;
				}
				Thread.sleep(5000);
				System.out.println(daysel);
				if(daysel.equals(day))	{
					driver.findElement(By.xpath(beforXpath+rownum+afterXpath+colNum+"]")).click();
					////*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]
					 flag = true;
					break;	
				}
									
						
			}
		}
		
	}

}

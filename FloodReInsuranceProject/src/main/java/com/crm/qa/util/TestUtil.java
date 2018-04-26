package com.crm.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
    
    public static String TESTDATA_SHEET_PATH = "C:\\Users\\sandr\\eclipse-workspace\\FloodReInsuranceProject\\src\\main\\java\\com\\crm\\qa\\testdata\\crmdata.testdata.xlsx";
    static Workbook book ;
    static Sheet sh;
			
    public void switchToFrame() {
    	driver.switchTo().frame("mainpanel");
    	
    }
    
    public static Object[][] getTestData(String sheetName) {
    	
    	FileInputStream file = null;
    			try
    	{
    	 file = new FileInputStream(TESTDATA_SHEET_PATH);
    	}catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	
    			try {
    				book = WorkbookFactory.create(file);
    			}catch(InvalidFormatException e) {
    				e.printStackTrace();
    			}catch(IOException e) {
    				e.printStackTrace();
    			}
    	sh = book.getSheet(sheetName);
    	Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
    	for(int i=0 ;i<sh.getLastRowNum();i++)
    	{
    		for(int k=0 ; k<sh.getRow(0).getLastCellNum();k++)
    		{
    			data[i][k] = sh.getRow(i+1).getCell(k).toString();
    			System.out.println(data[i][k]);
    		}
    	}
    	return data;
    }
    public void takeScreenshotAtEndOfTest() throws IOException {
    	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String currentDir = System.getProperty("user.dir");
    	
    	FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis()+".png"));
    	
    }
}

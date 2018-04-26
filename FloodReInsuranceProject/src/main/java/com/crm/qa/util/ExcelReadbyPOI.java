package com.crm.qa.util;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import jxl.read.biff.BiffException;
	import jxl.write.WriteException;

	public class ExcelReadbyPOI {
		//XLS & XLSX
	    int Column_Count,Row_Count;
	    Workbook oWorkBook = null;
	    Sheet oSheet ;
	    Row oRow;
	    Cell oCell;
	    
	    public ExcelReadbyPOI(String sDatFileWithPath, String sSheetName)
	    {
	    		//File class to deal with xls/xlsx file
		    File oFile =  new File(sDatFileWithPath);
		    
	        try {
		        	//FileInputStream class to read excel file
		    	    FileInputStream oFileStream = new FileInputStream(oFile);
		    	    
		    	    //Retrieve the file extension
		    	    String sDataFileExtension = sDatFileWithPath.substring(sDatFileWithPath.indexOf("."));
		
		    	    //Check if the file is xls or xlsx file
		    	    if(sDataFileExtension.equals(".xlsx"))
		    	    {
		    	    		//XSSFWorkbook class => for XLSX 
		    	    		oWorkBook = new XSSFWorkbook(oFileStream);
		    	    }
		    	    else if(sDataFileExtension.equals(".xls"))
		    	    {	
		    	        //HSSFWorkbook class ==> for XLS
		    	    		oWorkBook = new HSSFWorkbook(oFileStream);
		    	    }
		    	   
		    	    oSheet = oWorkBook.getSheet(sSheetName);
		    	  //Read sheet inside the workbook by its name    
	            Row_Count = oSheet.getLastRowNum() - oSheet.getFirstRowNum();
	            Column_Count = oSheet.getRow(0).getLastCellNum();
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	    }
	    
	    public void writeToExcel(String sDataFileWithPath, String sSheetName, int iRow, int iCol, String sData) throws IOException 
	    {
	    		//Creating a Sheet
	    		oSheet = oWorkBook.createSheet(sSheetName);
	    		oRow = oSheet.createRow(iRow);
	    		oCell = oRow.createCell(iCol);
	    		oCell.setCellValue(sData);
	    		
	    		FileOutputStream oWriteToFile = new FileOutputStream(sDataFileWithPath);

	    		//write this workbook to an Outputstream.
	    		oWorkBook.write(oWriteToFile);
	    		oWriteToFile.flush();
	    		oWriteToFile.close();
		 }

	    public void writeToExistingExcel(String sDataFileWithPath, String sSheetName, int iCol, int iRow, String sData) throws IOException 
	    	{
	    	 	oSheet = oWorkBook.getSheet(sSheetName);
	    	 	oRow = oSheet.createRow(iRow);
	    		oCell = oRow.createCell(iCol);
	    		oCell.setCellValue(sData);
	    		
	    		FileOutputStream oWriteToFile = new FileOutputStream(sDataFileWithPath);

	    		//write this workbook to an Outputstream.
	    		oWorkBook.write(oWriteToFile);
	    		oWriteToFile.flush();
	    		oWriteToFile.close();
	    	}
	    
	    public int getCoulmnNumber(String strCoulmn)
	    {
	    		int colnNum;
	        for(colnNum=0 ; colnNum<Column_Count; colnNum++)
	        {
	        		if(oSheet.getRow(0).getCell(colnNum).toString().equals(strCoulmn))
	            {
	                break;
	            }
	        }
	        return colnNum;
	    }
	      
	    public int getRowNumber(String strRowData){
	        int rowNum;
	        for(rowNum=1;rowNum<Row_Count;rowNum++)
	        	if(oSheet.getRow(rowNum).getCell(0).toString().equals(strRowData))
	        {
	            break;
	        }
	    
	        return rowNum;
	    }

	    public String getCellData(int iRow, int iColumn){
	        return oSheet.getRow(iRow).getCell(iColumn).toString();
	    }

	    public String getCellData(String strColumn, int iRow){
	    	 return oSheet.getRow(iRow).getCell(getCoulmnNumber(strColumn)).toString();
	    }

	    public int rowCount(){
	        return oSheet.getPhysicalNumberOfRows();
	    }

	    public int columnCount(){
	        return oSheet.getRow(0).getLastCellNum();
	    }

	}







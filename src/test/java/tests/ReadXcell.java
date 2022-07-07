package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadXcell 
{
    @Test(enabled=false)
	public void ExcelDataTest() 
	{
		File file = new File("C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\DataFile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet();
		sh.createRow(0).createCell(0).setCellValue("Age");
		sh.getRow(0).createCell(1).setCellValue(78);
		try
		{
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    
    @Test
	public void UpdateExcelDataTest() 
	{
		File file = new File("C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\DataFile.xlsx");
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(0);
			sh.getRow(0).createCell(2).setCellValue(100);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

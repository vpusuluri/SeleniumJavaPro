package SeleniumJava.Project;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadExcel 
{

	public static void main(String[] args) throws Exception 
	{
		String fpath = "C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\DataFile.xls";
		File file = new File(fpath);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet("Employee");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		  HSSFRow row2 = sheet.getRow(1); 
		// CellType cell  = row2.getCell(4).getCellType();
		  //System.out.println("cell DataType  is :" +   cell.toString());
		  if(row2.getCell(4).getCellType() == CellType.NUMERIC)
		  {
			  HSSFCell cell1=row2.getCell(4);
			  double pno = cell1.getNumericCellValue();
			  Double d=new Double(pno);  
			 
			  System.out.println("The Phone Number Extracted = " + d.longValue());
		  }
			   
			
		System.out.println("The Total Number of Rows = " + rowCount);
		for(int i=0;i<= rowCount;i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			HSSFRow row = sheet.getRow(i);
			System.out.println("\n Cell Count for Row " + i + " is = " + cellcount);
			System.out.println("Row " + i + " data is : ");
			for(int j=0;j<cellcount;j++)
			{
				 if(row.getCell(j).getCellType() == CellType.STRING)
				 {
					 String value = sheet.getRow(i).getCell(j).getStringCellValue();
					 System.out.println(" The Row " + i  + " column = " + j + " Value is " + value);
				 }
				 else if(row.getCell(j).getCellType() == CellType.NUMERIC)
				  {
					  HSSFCell cell1=row.getCell(j);
					  double pno = cell1.getNumericCellValue();
					  Double d=new Double(pno);  
					  System.out.println(" The Row " + i  + " column = " + j + " Value is " + d.longValue());
					  //System.out.println("The Phone Number Extracted = " + d.longValue());
				  }
				//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +  ",");
		   }
		}
		System.out.println();
		
		
		 
		

	}

}

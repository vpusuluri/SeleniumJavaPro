package SeleniumJava.Project;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteXLSXFile 
{

	public static void main(String[] args) 
	{
		String fpath = "C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\WriteFile.xlsx";
        try
        {
        	XSSFWorkbook workbook = new XSSFWorkbook();
        	XSSFSheet sheet = workbook.createSheet("EmployeeData");
        	XSSFRow header = sheet.createRow(0);
        	
        	header.createCell(0).setCellValue("Employee Id");
        	header.createCell(1).setCellValue("Employee Name");
        	header.createCell(2).setCellValue("Age");
        	header.createCell(3).setCellValue("Email Id");
        	header.createCell(4).setCellValue("Salary");
        	
        	 XSSFRow row1 = sheet.createRow(1);
        	 
        	 row1.createCell(0).setCellValue("101");
             row1.createCell(1).setCellValue("John william");
             row1.createCell(2).setCellValue("30");
             row1.createCell(3).setCellValue("william.john@gmail.com");
             row1.createCell(4).setCellValue("15000$");
             
             XSSFRow row2 = sheet.createRow(2);
             row2.createCell(0).setCellValue("102");
             row2.createCell(1).setCellValue("Harsh singh");
             row2.createCell(2).setCellValue("35");
             row2.createCell(3).setCellValue("harsh.singh@gmail.com");
             row2.createCell(4).setCellValue("20000$");
             
             FileOutputStream fos = new FileOutputStream(fpath);
             workbook.write(fos);
             fos.close();
             workbook.close();
             System.out.println("Excel file has been created Success");
        }
        catch(IOException e)
        {
        	System.out.println("Exception while writing xlsx file");
        	e.printStackTrace();
        }

	}

}

package SeleniumJava.Project;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class ReadExcelIterator 
{
     
    @SuppressWarnings("incomplete-switch")
	public static void main(String[] args) throws IOException 
    {
        //String excelFilePath = "Books.xlsx";
        String fpath = "C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\DataFile.xlsx";
        FileInputStream fis = new FileInputStream(fpath);
		Workbook workbook = new XSSFWorkbook(fis);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) 
        {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                 //System.out.println("The cell type = " + cell.getCellType());
                switch (cell.getCellType()) 
                {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                    	double pno = cell.getNumericCellValue();
                        Double d=new Double(pno); 
  					    System.out.print(d.longValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
         
        workbook.close();
        fis.close();
    }
 
}
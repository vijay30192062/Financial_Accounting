package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Data 
{
	//Method to Read value from Excel
	
		public static String getValue(String path, String sheet, int row, int cell)
		{
			String v="";
			try
			{
				Workbook wb=WorkbookFactory.create(new FileInputStream(path));
				v=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
			return v;
			
		}
		
		//Method to Count Number of Row values in excel
		public static int getRowCount(String path, String sheet)
		{
			int rowCount=0;
			try
			{
				Workbook wb=WorkbookFactory.create(new FileInputStream(path));
				rowCount=wb.getSheet(sheet).getLastRowNum();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return rowCount;
			
		}
		
		//Method to read count count of column values
		public static int getColumnCount(String path, String sheet, int row)
		{
			int columnCOunt=0;
			try
			{
				Workbook wb=WorkbookFactory.create(new FileInputStream(path));
				columnCOunt=wb.getSheet(sheet).getRow(row).getLastCellNum();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return columnCOunt;
		}

}

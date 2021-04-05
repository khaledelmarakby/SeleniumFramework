package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream file = null;
	
	FileInputStream getfileinputstream()
	{
		String filepath=System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";
		File srcfile=new File(filepath);
		
		try {
			file=new FileInputStream(srcfile);
		
		} catch (FileNotFoundException e) {
			System.out.println("Error file not found"+ e.getMessage());
		}
		
		return file;
	}
	
	
	public Object[][] getExcelData() throws IOException
	{
		file = getfileinputstream();
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int TotalNumberofRows= sheet.getLastRowNum()+1;
		int TotalNumberofColums=4;
		
		String[][] arrayExcelData= new String[TotalNumberofRows][TotalNumberofColums];
		
		for(int i=0;i<TotalNumberofRows;i++)
		{
			for(int j=0;j<TotalNumberofColums;j++)
			{
				XSSFRow row=sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
			}
		}
		workbook.close();
		return arrayExcelData;
	}
}

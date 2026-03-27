package utils;


import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UtilityClass {

	public static WebDriver driver;
	public String sheetname; 
	
	
	public void launchBrowserAndLoadURL(String url,String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		} else {
			driver= new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void browserClose() {
		
		driver.close();
	}
	
	public String[][] readExcel(String sheetname) throws IOException {
		
		// Open the workbook
				XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\leema\\eclipse-workspace\\SauceDemoProject_Test\\src\\test\\resources\\TestData\\TestData.xlsx");
				
				// Open the sheet
				XSSFSheet sheet = book.getSheet(sheetname);
				
				// Get the no.of rows
				int rowCount = sheet.getLastRowNum();
				
				// Get the column count
				int columnCount = sheet.getRow(0).getLastCellNum();
				
				//Create 2D Array
				String[][] data = new String[rowCount][columnCount];
				
				// Get into each row
				
				for(int i=1; i<=rowCount; i++) {
					
					XSSFRow row = sheet.getRow(i);
					
					// get into the column
					
					for(int j=0; j<columnCount; j++) {
						
						XSSFCell cell = row.getCell(j);
						
						// read the value
						
						System.out.print(cell.getStringCellValue()+"|");
						
						// to store in array
						
						data[i-1][j]=cell.getStringCellValue();
					}
					
					System.out.println();
				}
				
				book.close();
				return data;
	}
}

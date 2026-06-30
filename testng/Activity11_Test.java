import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;



public class Activity11_Test {
WebDriver driver;
WebDriverWait wait;
	
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://training-support.net/webelements/simple-form");
		
	}
	
	public static List<List<String>> readExcel(String filePath) throws FileNotFoundException, IOException{
		
		List<List<String>> data=new ArrayList<>();
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(filePath));
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		for(Row rows:sheet) {
			List<String> rowData=new ArrayList<>();
			if(rows.getRowNum()==0)
				continue;
			for(Cell cell:rows) {
				switch (cell.getCellType()) {
				
				case STRING:

					// To get string values

					rowData.add(cell.getStringCellValue().trim());

					break;



				case NUMERIC:

					if (DateUtil.isCellDateFormatted(cell)) {

						// To get dates

						rowData.add(cell.getLocalDateTimeCellValue()

							.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

					} else {

						// To get numbers

						rowData.add(String.valueOf(cell.getNumericCellValue()));

					}

					break;

				default:

					// Add a placeholder string for empty cells

					rowData.add("-");}
			}
			data.add(rowData);
		}
		
		
		return data;
		
	}
	
	@DataProvider(name="Excel_Data")
	public static Object[][] readCsv() throws IOException, CsvException{
		List<List<String>> inputData =readExcel("src/test/resources/input.xlsx");
		
		
		Object data[][]=new Object[inputData.size()][];
		for(int i=0;i<inputData.size();i++) {
			data[i]=inputData.get(i).toArray();
			System.out.println(data[i]);
		}
		
		return data;
		
		
		
		
	}
	
	@Test(dataProvider = "Excel_Data")
	public void testForm(String row[]) {
	
		
		WebElement fullname=driver.findElement(By.id("full-name"));
		fullname.sendKeys(row[0]);
		System.out.println(row[0]);

		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys(row[1]);
		
		WebElement date=driver.findElement(By.name("event-date"));
		date.sendKeys(row[2]);
		
		WebElement details=driver.findElement(By.id("additional-details"));
		details.sendKeys(row[3]);
		
		WebElement submit=driver.findElement(By.xpath("//button[@class='font-bold svelte-7bqce9']"));
		submit.click();
		
		WebElement result=driver.findElement(By.id("action-confirmation"));
		assertEquals(result.getText(),"Your event has been scheduled!");
		
		driver.navigate().refresh();
	}
	
	
	@AfterClass
	public void closeInstance() {
		driver.quit();
	}
}

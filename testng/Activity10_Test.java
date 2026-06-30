import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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



public class Activity10_Test {
WebDriver driver;
WebDriverWait wait;
	
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://training-support.net/webelements/simple-form");
		
	}
	
	@DataProvider(name="CSV_Data")
	public static Object[][] readCsv() throws IOException, CsvException{
		CSVReader csvfile=new CSVReader(new FileReader("src/test/resources/input.csv"));
		csvfile.skip(1);
		List<String[]> csvData=csvfile.readAll();
		Object data[][]=new Object[csvData.size()][];
		for(int i=0;i<csvData.size();i++) {
			data[i]=csvData.get(i);
			System.out.println(data[i]);
		}
		
		return data;
		
		
	}
	
	@Test(dataProvider = "CSV_Data")
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

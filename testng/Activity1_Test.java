import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1_Test {

	WebDriver driver;
	
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	
	@Test
	public void openWebpage() {
		String actualTitle=driver.getTitle();
		assertEquals("Training Support", actualTitle);
		
	}
	
	@Test(dependsOnMethods = "openWebpage")
	public void findLink() {
		driver.findElement(By.linkText("About Us")).click();
		String actualTitle=driver.getTitle();
		assertEquals("About Training Support", actualTitle);
		
	}
	
	@AfterClass
	public void closeInstance() {
		driver.close();
	}
	
	
}

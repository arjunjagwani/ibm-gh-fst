import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3_Test {
	WebDriver driver;
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		
	}
	
	@Test
	public void testCase1() {
		WebElement usernameEle=driver.findElement(By.name("username"));
		usernameEle.sendKeys("admin");
		WebElement passwordEle=driver.findElement(By.name("password"));
		passwordEle.sendKeys("password");
		WebElement submit2=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
		submit2.click();
		String actual=driver.findElement(By.tagName("h2")).getText();
		assertEquals("Welcome Back, Admin!", actual);
	}
	@AfterClass
	public void closeInstance() {
		driver.quit();
	}
}

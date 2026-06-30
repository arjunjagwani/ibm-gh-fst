package suiteExample;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6_Test {
	WebDriver driver;
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void testCase1(String username,String password) throws InterruptedException {
		WebElement usernameEle=driver.findElement(By.name("username"));
		usernameEle.sendKeys(username);
		WebElement passwordEle=driver.findElement(By.name("password"));
		passwordEle.sendKeys(password);
		WebElement submit2=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
		submit2.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
		
		String actual=driver.findElement(By.tagName("h2")).getText();
		System.out.println(actual);
		assertEquals("Welcome Back, Admin!", actual);
	}
	
	@AfterClass
	public void closeInstance() {
		driver.quit();
	}
}

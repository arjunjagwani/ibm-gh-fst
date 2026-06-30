

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9_Test {
	WebDriver driver;
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		
	}
	@BeforeMethod
	public void backContext() {
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void simpleAlertTestCase() {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println(driver.getTitle());
	
		Reporter.log("Entered Title\n");
		WebElement simpleButton=driver.findElement(By.id("simple"));
		simpleButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		
		System.out.println(alert.getText());
		Reporter.log("Alert Generated");
		alert.accept();
		WebElement result=driver.findElement(By.id("result"));
		String actual=result.getText();
		Reporter.log("Alert shown");
		assertEquals("You just accepted a simple alert!", actual);
		
	}
	@Test
	public void confirmAlertTestCase() {
		WebElement confirmButton=driver.findElement(By.id("confirmation"));
	confirmButton.click();
	Reporter.log("Confirm Alert is displayed");
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
	
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert alert= driver.switchTo().alert();
	
	System.out.println(alert.getText());
	
	alert.accept();
	WebElement result=driver.findElement(By.id("result"));
	String actual=result.getText();
	assertEquals("You just accepted a confirmation alert!", actual);
	Reporter.log("| Confirmation Test completed|");
	}
	@Test
	public void promptAlertTestCase() {
	
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println(driver.getTitle());
		WebElement promptButton=driver.findElement(By.id("prompt"));
		promptButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.sendKeys("Awesome!");
		alert.accept();
		WebElement result=driver.findElement(By.id("result"));
		String actual=result.getText();
		assertEquals("You typed \"Awesome!\" into the prompt!", actual);
		
	}
	
	
	
	@AfterClass
	public void closeInstance() {
		driver.quit();
	}
}

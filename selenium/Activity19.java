import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println(driver.getTitle());
		WebElement confirmButton=driver.findElement(By.id("confirmation"));
		confirmButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
		WebElement result=driver.findElement(By.id("result"));
		System.out.println(result.getText());
		
		
		confirmButton.click();
		alert= driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.dismiss();
		 result=driver.findElement(By.id("result"));
		System.out.println(result.getText());
		
		driver.quit();
		
		
	}

}

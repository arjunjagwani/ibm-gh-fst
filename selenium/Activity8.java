import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println(driver.getTitle());
		
		WebElement checkBox=driver.findElement(By.id("checkbox"));
		WebElement toggleCheckBox=driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
		toggleCheckBox.click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		if(checkBox.isDisplayed())
			System.out.println("CheckBox is displayed");
		else
			System.out.println("CheckBox Not displayed");
		
		toggleCheckBox.click();
		
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		
		if(checkBox.isDisplayed())
			System.out.println("CheckBox is displayed");
		else
			System.out.println("CheckBox Not displayed");
		
		checkBox.click();
		
		driver.quit();
	}

}

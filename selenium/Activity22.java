import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/popups");
		System.out.println(driver.getTitle());
		WebElement popupB=driver.findElement(By.id("launcher"));
		
		
		popupB.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInForm")));
		WebElement username=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement submit=driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		submit.click();
		System.out.println(driver.getTitle());
		WebElement result=driver.findElement(By.xpath("//h2[@class='mt-5 text-center text-4xl font-semibold text-gray-800']"));
		
		System.out.println(result.getText());
		driver.quit();
	}

}

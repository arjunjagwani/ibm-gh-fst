

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenge_Activity_2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

WebElement searchBar = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
);

searchBar.sendKeys("iPhone 17 Pro");

		driver.findElement(By.id("nav-search-submit-button")).click();
		
//		Thread.sleep(1000);
		
		String price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[4]")).getText();
		System.out.println("Price of 4th card: "+price);
		///html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]
		
		driver.quit();
	}
}

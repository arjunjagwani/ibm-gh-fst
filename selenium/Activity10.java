import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class Activity10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/mouse-events");
		
		System.out.println(driver.getTitle());
		
		Actions builder=new Actions(driver);
		
		WebElement lock=driver.findElement(By.xpath("(//div[@class='file'])[1]"));
		WebElement result=driver.findElement(By.id("result"));
		WebElement toml=driver.findElement(By.xpath("(//div[@class='file'])[2]"));
		WebElement src=driver.findElement(By.xpath("(//div[@class='file'])[3]"));
		WebElement target=driver.findElement(By.xpath("(//div[@class='file'])[4]"));
		
		builder.click(lock).pause(2000)
		.moveToElement(toml)
		.click(toml).pause(2000)
		.build().perform();
		
		System.out.println(result.getText());
		
		builder.doubleClick(src).pause(2000).moveToElement(target)
		.contextClick().pause(2000).build().perform();
		System.out.println(result.getText());
		
		WebElement openButton=driver.findElement(By.xpath("(//span[@class='ml-3'])[1]"));
		builder.click(openButton).pause(3000).build().perform();
		

	
		System.out.println(result.getText());
		driver.quit();
		
	}

}

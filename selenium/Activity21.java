import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tabs");
		System.out.println(driver.getTitle());
		
		String tab1=driver.getWindowHandle();
		WebElement button=driver.findElement(By.xpath("//button[@class='bg-purple-200 svelte-1bfwg86']"));
		button.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> handles=driver.getWindowHandles();
		System.out.println(handles);
		
		for(String handle:handles)
		{
			if(handle!=tab1)
				driver.switchTo().window(handle);
		}
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
		WebElement code=driver.findElement(By.xpath("//h2[@class='mt-5 text-center font-mono text-4xl text-gray-800']"));
		System.out.println(code.getText());
		
		String tab2=driver.getWindowHandle();
		button=driver.findElement(By.xpath("//button[@class='bg-purple-200 svelte-ov8nwn']"));
		button.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		handles=driver.getWindowHandles();
		System.out.println(handles);
		
		for(String handle:handles)
		{
			if(handle!=tab1 && handle!=tab2)
				driver.switchTo().window(handle);
		}
		//NOT RESOLVED+ CODE:{empty}
		wait.until(ExpectedConditions.titleIs("New Tab!"));
		System.out.println(driver.getTitle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
		WebElement code2=driver.findElement(By.xpath("//h2[@class='mt-5 text-center font-mono text-4xl text-gray-800']"));
		System.out.println(code2.getText());
		
		driver.quit();
		
	}

}

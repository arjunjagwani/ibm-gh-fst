import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println(driver.getTitle());
		
		WebElement input=driver.findElement(By.id("textInput"));
		if(input.isEnabled())
			System.out.println("Input is Enabled");
		else
			System.out.println("Input Not Enabled");
		WebElement enableInput=driver.findElement(By.id("textInputButton"));
		enableInput.click();
		
		if(input.isEnabled())
			System.out.println("Input is Enabled");
		else
			System.out.println("Input Not Enabled");
		driver.quit();
	}

}

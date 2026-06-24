import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/keyboard-events");
		
		System.out.println(driver.getTitle());
		
		Actions builder=new Actions(driver);
		WebElement result=driver.findElement(By.id("result"));
		builder.sendKeys(result, "Arjun").pause(1000).build().perform();
		WebElement ans=driver.findElement(By.xpath("//h1[@class='mt-3 text-4xl font-semibold text-center text-black']"));
		System.out.println(ans.getText().substring(0, ans.getText().length()-1));
		driver.quit();
	}

}

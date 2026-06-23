import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		
		String title=driver.getTitle();
		System.out.println("Title of page: "+title);
		
		WebElement usernameEle=driver.findElement(By.name("username"));
		usernameEle.sendKeys("admin");
//		String username=usernameEle.getAttribute("username");
//		System.out.println("Username: "+username);
//		
		WebElement passwordEle=driver.findElement(By.name("password"));
		passwordEle.sendKeys("password");
//		String password=passwordEle.getAttribute("password");
//		System.out.println("Password: "+password);
		
//		WebElement submit=driver.findElement(By.tagName("Button"));
		WebElement submit2=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
		submit2.click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		driver.quit();
		
	}

}

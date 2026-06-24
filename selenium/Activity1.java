import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity1 {

	public static void main(String[] args) {
//		WebDriver driver=new FirefoxDriver();
//		driver.get("https://training-support.net/");
//		
//		String homepageTitle=driver.getTitle();
//		
//		System.out.println("Homepage Title: "+homepageTitle);
//		driver.navigate().to("https://training-support.net/about/");
//		String aboutTitle=driver.getTitle();
//		
//		System.out.println("About Page Title: "+aboutTitle);
//		driver.quit();
		
		 WebDriver driver = new FirefoxDriver();

	        // Open the page
	        driver.get("https://training-support.net");

	        // Verify the page title
	        System.out.println("Page title is: " + driver.getTitle());
	        // Find the About Us link and click it
	        driver.findElement(By.linkText("About Us")).click();
	        // Print the page title of the About Us page
	        System.out.println("New page title is: " + driver.getTitle());

	        // Close the browser
	        driver.quit();
	}
}

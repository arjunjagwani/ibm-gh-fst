import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println(driver.getTitle());
		
		WebElement checkBox=driver.findElement(By.id("checkbox"));
		if(checkBox.isDisplayed())
			System.out.println("CheckBox is displayed");
		else
			System.out.println("CheckBox Not displayed");
		WebElement toggleCheckBox=driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
		toggleCheckBox.click();
		
		if(checkBox.isDisplayed())
			System.out.println("CheckBox is displayed");
		else
			System.out.println("CheckBox Not displayed");
		driver.quit();
	}

}

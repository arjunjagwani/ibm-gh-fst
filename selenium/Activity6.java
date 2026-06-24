import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println(driver.getTitle());
		
		WebElement checkBox=driver.findElement(By.id("checkbox"));
		if(checkBox.isSelected())
			System.out.println("CheckBox is checked");
		else
			System.out.println("CheckBox not checked");
		checkBox.click();
		
		if(checkBox.isSelected())
			System.out.println("CheckBox is checked");
		else
			System.out.println("CheckBox not checked");
		driver.quit();
	}

}

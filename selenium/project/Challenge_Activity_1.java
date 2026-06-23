//id, name, class
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Challenge_Activity_1 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
		WebElement inputElement=driver.findElement(By.id("APjFqb"));
		String inputId=inputElement.getAttribute("id");
		String nameId=inputElement.getAttribute("name");
		String classId=inputElement.getAttribute("class");
		String name2=inputElement.getDomAttribute("name");
		
		System.out.println(inputId);
		System.out.println(nameId);
		System.out.println(name2);
		System.out.println(classId);
		driver.quit();
		
	}
}

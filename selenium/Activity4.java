import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println(driver.getTitle());
		
		WebElement header3=driver.findElement(By.xpath("//h3[contains(text(),'#3')]"));
		System.out.println(header3.getText());
		
		WebElement header5=driver.findElement(By.xpath("//h3[contains(text(),'#3')]"));
		String h5Color=header5.getCssValue("color");
		System.out.println(h5Color);
		
		String purpleElement=driver.findElement(By.xpath("//button[text()='Purple']")).getAttribute("class");
		System.out.println("Purple class: "+purpleElement);
		
		String slateElement=driver.findElement(By.xpath("//button[text()='Slate']")).getText();
		System.out.println("Slate text: "+slateElement);
		driver.quit();
	}

}

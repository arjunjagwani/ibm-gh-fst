import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/drag-drop");
		
		System.out.println(driver.getTitle());
		
		Actions builder=new Actions(driver);
		WebElement footBall=driver.findElement(By.id("ball"));
		WebElement dropZone1=driver.findElement(By.id("dropzone1"));
		WebElement dropZone2=driver.findElement(By.id("dropzone2"));
		
		WebElement span1=driver.findElement(By.xpath("//div[@id='dropzone1']//span"));
		WebElement span2=driver.findElement(By.xpath("//div[@id='dropzone2']//span"));
		builder.dragAndDrop(footBall, dropZone1).pause(1000).build().perform();
		System.out.println("Dropzone1: "+span1.getText());
		builder.dragAndDrop(dropZone1, dropZone2).pause(1000).build().perform();
		System.out.println("Dropzone2: "+span2.getText());
		driver.quit();
	}

}

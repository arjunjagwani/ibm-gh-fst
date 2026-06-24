import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		
		System.out.println(driver.getTitle());
		
		List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
		List<WebElement> columns=driver.findElements(By.xpath("//table//tbody//tr[1]//td"));
		System.out.println(rows.size());
		System.out.println(columns.size());
		WebElement r3=rows.get(2);
		
		List<WebElement> data = r3.findElements(By.xpath("./td"));
		
		for(WebElement e:data) {
			System.out.println(e.getText());
		}
		
		WebElement r2=rows.get(1);
		
		List<WebElement> data2 = r2.findElements(By.xpath("./td"));
		System.out.println(data2.get(1).getText());
		
		driver.quit();
		
	}

}

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		
		System.out.println(driver.getTitle());
		
		List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
		List<WebElement> columns=driver.findElements(By.xpath("//table//tbody//tr[1]//td"));
		System.out.println(rows.size());
		System.out.println(columns.size());
		WebElement r5=rows.get(4);
		
		List<WebElement> data = r5.findElements(By.xpath("./td"));
		
		
		System.out.println(data.get(1).getText());
		
		List<WebElement> headers=driver.findElements(By.xpath("//table//thead//tr//th"));
		WebElement price=headers.get(4);
		price.click();
		rows=driver.findElements(By.xpath("//table//tbody//tr"));
		r5=rows.get(4);
		data = r5.findElements(By.xpath("./td"));
		System.out.println(data.get(1).getText());
		
		
		driver.quit();
	}

}

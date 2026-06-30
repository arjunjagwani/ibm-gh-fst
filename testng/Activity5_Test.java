import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5_Test {
WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void createInstance() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test
	public void getTitleTest() {
		String title=driver.getTitle();
		assertEquals("Selenium: Target Practice",title);
	}
	
	@Test(dependsOnMethods = "getTitleTest",groups = "HeaderTests")
	public void header3Test() {
		WebElement header3=driver.findElement(By.xpath("//h3[contains(text(),'#3')]"));
		String actual=header3.getText();
		assertEquals("Heading #3", actual);
	}
	@Test(dependsOnMethods = "getTitleTest",  groups = "HeaderTests")
	public void header5Test() {
		WebElement header5=driver.findElement(By.xpath("//h3[contains(text(),'#3')]"));
		String h5Color=header5.getCssValue("color");
		assertEquals("rgb(234, 88, 12)", h5Color);
	}
	
	@Test(dependsOnMethods = "getTitleTest",groups = "ButtonTests")
	public void emeraldTest() {
		
		String emeraldElement=driver.findElement(By.xpath("//button[text()='Emerald']")).getText();
	assertEquals("Emerald", emeraldElement);
	}
	
	@Test(dependsOnMethods = "getTitleTest",groups = "ButtonTests")
	public void thirdRowTest() {
		String thirdRowElement=driver.findElement(By.xpath("//button[text()='Amber']")).getAttribute("class");
		assertEquals("rounded-xl bg-amber-200 p-2 text-3xl font-bold text-amber-900 svelte-2hb4ib", thirdRowElement);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeInstance() {
		driver.close();
	}

}

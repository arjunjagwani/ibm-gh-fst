import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4_Test {

	WebDriver driver;
	@BeforeClass
	public void createInstance() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		
	}
	
	@Test
	public void getTitleTest() {
		String title=driver.getTitle();
		assertEquals("Selenium: Target Practice",title);
	}
	
	@Test
	public void getBlackClassTest() {
		String blackButton=driver.findElement(By.xpath("//button[text()='Black']")).getAttribute("class");
		assertEquals("Button is black",blackButton);
		
	}
    @Test(enabled = false)
    public void testCase3() {
	
        // This test will be skipped and not counted
	
        String subHeading = driver.findElement(By.className("sub")).getText();
	
        Assert.assertTrue(subHeading.contains("Practice"));
	
    }
	
 
	
    @Test
	
    public void testCase4() {
	
        // This test will be skipped and will be be shown as skipped
	
        throw new SkipException("Skipping test case");
	
    }
	
	
	@AfterClass
	public void closeInstance() {
		driver.quit();
	}
}

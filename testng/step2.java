package stepDefinitions;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class step2 extends BaseClass {

	@When("the user clicks on the About Us link")

	public void clickButton() throws Throwable {

		driver.findElement(By.linkText("About Us")).click();

	} 
}

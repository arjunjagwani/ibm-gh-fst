package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;

public class step3 extends BaseClass{
	@Then("they are redirected to another page")

	public void aboutUsPage() throws Throwable {

		wait.until(ExpectedConditions.titleIs("About Training Support"));

		String pageHeading = driver.findElement(By.cssSelector("h1.text-center")).getText();



		System.out.println("New page title is: " + pageHeading);

		assertEquals(pageHeading, "About Us");

	}
}

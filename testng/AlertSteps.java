package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass{
	Alert alert;

	@Given("User is on the page")
	public void user_is_on_page() {
		
		driver.get("https://training-support.net/webelements/alerts");
	}
	
	@When("User clicks the Simple Alert button")
	public void simpleButtonClick() {
		driver.findElement((By.id("simple"))).click();
	}
	@When("User clicks the Confirm Alert button")
	public void confirmButtonClick() {
		driver.findElement((By.id("confirmation"))).click();
	}
	@When("User clicks the Prompt Alert button")
	public void promptButtonClick() {
		driver.findElement((By.id("prompt"))).click();
	}
	
	@Then("Alert opens")
	public void alertOpens() {
		wait.until(ExpectedConditions.alertIsPresent());
		alert=driver.switchTo().alert();
	}
	
	@And("Read the text from it and print it")
	public void readAlert() {
		System.out.println(alert.getText());
//		alert.accept();
		
	}
	
	@And("Write a custom message in it")
	public void promptMessage(){
		alert.sendKeys("Awesome!");
	}
	
	@And("Close the alert")
	public void acceptAlert() {
		alert.accept();
		
	}
	
	@And("Close the alert with Cancel")
	public void dismissAlert() {
		alert.dismiss();
		
	}
	
	@And("Read the result text")
	public void displayMessage() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("result"))));
		
		System.out.println(driver.findElement(By.id("result")).getText());
	}
	
	
}

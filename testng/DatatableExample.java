package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatatableExample extends BaseClass{
	
	static int i=3;
	@Given("user is on the To-Do list page")
	public void openPage() {
		driver.get("https://training-support.net/webelements/todo-list");
		assertEquals(driver.getTitle(), "Selenium: To-Do List");
	}
	
	@When("user adds the following tasks")
	public void addTasks(DataTable inputs) {
		WebElement input=driver.findElement(By.id("todo-input"));
		WebElement button=driver.findElement(By.id("todo-add"));
		input.sendKeys(inputs.toString());
		button.click();
	}

	@Then("they can see the task added to the list")
	public void readTasks() {
		WebElement taskItem=driver.findElement(By.xpath("(//li[@class='w-full']//form//h3)["+i+"]"));
		i++;
		System.out.println(taskItem.getText());
	}
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class YT_Search {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.youtube.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchEle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("search_query"))
        );
        searchEle.sendKeys("spiderman song");

        WebElement searchButton = driver.findElement(
                By.className("ytSearchboxComponentSearchButton")
        );
        searchButton.click();

        // ✅ Wait until video results appear
        WebElement videoTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@id='video-title'])[1]"))
        );

        videoTab.click();

        System.out.println(driver.getTitle());

        // driver.quit();
    }
}
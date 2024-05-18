import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/PC/Documents/my/src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://amazon.com");

            // Perform the correct search
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(920));
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            searchInput.sendKeys("Laptop");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
            searchButton.click();

            // Verify search results
            WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
            if (searchResults.isDisplayed()) {
                System.out.println("Search results displayed.");
            } else {
                System.out.println("Defect: Search results not displayed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

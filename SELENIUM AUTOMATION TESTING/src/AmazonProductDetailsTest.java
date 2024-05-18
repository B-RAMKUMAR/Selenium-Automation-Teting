import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductDetailsTest {
    public static void main(String[] args) {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\my\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to Flipkart's product listing page
            driver.get("https://www.flipkart.com/mobiles/pr?sid=tyy,4io");

            // Step 2: Select a product from the list
            WebElement product = driver.findElement(By.cssSelector("div._1AtVbE:first-child a"));
            product.click();

            // Step 3: Verify product details
            WebElement productName = driver.findElement(By.cssSelector("span.B_NuCI"));
            WebElement productPrice = driver.findElement(By.cssSelector("div._30jeq3"));
            WebElement productDescription = driver.findElement(By.cssSelector("div._3la3Fn"));

            // Step 4: Verify product images and thumbnails
            WebElement productImage = driver.findElement(By.cssSelector("div._396cs4 img"));
            productImage.click(); // Clicking on the image to view full size

            // Step 5: Verify navigation back to product listing
            driver.navigate().back();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

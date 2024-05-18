import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonUserSignUpTest {
    public static void main(String[] args) {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\my\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to Amazon homepage
            driver.get("https://www.amazon.com/");

            // Step 2: Click on "Sign in" or "Hello, Sign in" button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(920));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
            signInButton.click();

            // Step 3: Click on "Create your Amazon account" button
            WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("createAccountSubmit")));
            createAccountButton.click();

            // Step 4: Fill in sign-up details
            WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name")));
            nameInput.sendKeys("Test User");

            WebElement emailInput = driver.findElement(By.id("ap_email"));
            emailInput.sendKeys("testuserUBALA@example.com");

            WebElement passwordInput = driver.findElement(By.id("ap_password"));
            passwordInput.sendKeys("password123");

            WebElement passwordCheckInput = driver.findElement(By.id("ap_password_check"));
            passwordCheckInput.sendKeys("password123");

            // Step 5: Click on "Create your Amazon account" button
            WebElement createAccountSubmitButton = driver.findElement(By.id("continue"));
            createAccountSubmitButton.click();

            // Step 6: Pause to allow user to complete CAPTCHA manually if necessary
            // Wait for the next page or specific element to be visible after CAPTCHA is solved
            // Adjust the selector based on the page element that confirms successful sign-up or next step
            WebElement verificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
            
            if (verificationElement.isDisplayed()) {
                System.out.println("User sign-up successful");
            } else {
                System.out.println("User sign-up failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

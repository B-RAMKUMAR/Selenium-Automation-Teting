import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class AmazonProductBrowsingTest { 
 
 public static void main(String[] args) { 
 // Set up the WebDriver
 System.setProperty("webdriver.chrome.driver", "C:/Users/PC/Documents/my/src/drivers/chromedriver.exe");
 WebDriver driver = new ChromeDriver(); 
 
 // Step 1: Navigate to Amazon product listing page 
 driver.get("https://www.amazon.in/LG-Inverter-Frost-Free-Refrigerator-GL-I292RPZX/dp/B08X72GY5Q/ref=sr_1_1_sspa?_encoding=UTF8&content-id=amzn1.sym.58c90a12-100b-4a2f-8e15-7c06f1abe2be&dib=eyJ2IjoiMSJ9.wdhf-aWgBtjRCDbxdUWNpTAEfPvn3fssZkAdeEa20Ao3ZU5UsL9aFuE9kFcZdZbRjw27GdApVUkPGiPF1ghcXivBaobSXfcGJ8NY3VWtNHFTi9uXMMcSohZ5DVfvTuWCS6NEHpZn-qpLe4ly405uAKFNjYqJjkqAf0htVqRGxSjboow6_GrfVtM7d3W1FvCG5tfGkaiUIpsZJzzcHrXv5Y4RN3I5Tf9xTyWLfGxdyi-lxpfOpyhMFbck99puwMgfgOyVcOP0DdgxHKe6Wj06fk2PMXr1ua-zq2W5WmfnJ2k.WaIID_SGZtgLr5RY8OU5SEAazfv8xWdyafI_YfFWJzE&dib_tag=se&pd_rd_r=f7f36378-c0e1-4035-aa5d-e721facb2311&pd_rd_w=r3fcy&pd_rd_wg=m2PpS&pf_rd_p=58c90a12-100b-4a2f-8e15-7c06f1abe2be&pf_rd_r=V1GHE17ZZ3G9A9CRY754&qid=1716031213&refinements=p_85%3A10440599031&rps=1&s=kitchen&sr=1-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGZfYnJvd3Nl&psc=1"); 
 
 // Step 2: Verify access to the product listing page
 WebElement pageTitle = driver.findElement(By.tagName("h1")); 
 if (pageTitle.getText().contains("Products")) {
 System.out.println("Product listing page accessed successfully");
 } else {
 System.out.println("Product listing page access failed"); 
 } 
 
 // Step 3: Verify accurate display of products' names and prices
 WebElement firstProductName = driver.findElement(By.cssSelector("sg-col-4-of-24 sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 AdHolder sg-col s-widget-spacing-small sg-col-4-of-20"));
 WebElement firstProductPrice = driver.findElement(By.cssSelector(".product-item:first-child .product-price"));
 
 // Step 4: Click on the first product to view details
 WebElement firstProductLink = driver.findElement(By.cssSelector(".product-item:first-child .product-link"));
 firstProductLink.click(); 
 
 // Expected Output for this step: 
 // The browser should navigate to the product details page.
 
 // Close the browser
 driver.quit(); 
 } 
}
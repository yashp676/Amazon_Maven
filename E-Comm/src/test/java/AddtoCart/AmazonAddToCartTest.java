package AddtoCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAddToCartTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("fans");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        WebElement productLink = driver.findElement(By.xpath("//span[contains(text(),'Dreo Nomad One Tower Fans for Home, 24ft/s Velocity Quiet Cooling Fan, 90° Oscillating Fans for Indoors with 4 Speeds, 4 Modes, 8H Timer, Bladeless Fan, Standing Floor Fans, Black, (DR-HTF007)')]"));
        productLink.click();
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        Assert.assertTrue(productTitle.isDisplayed(), "Product details page not displayed");
        WebElement quantityDropdown = driver.findElement(By.id("quantity"));
        quantityDropdown.sendKeys("2");
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        WebElement addedToCartMessage = driver.findElement(By.id("//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4"));
        Assert.assertTrue(addedToCartMessage.getText().contains("Added to Cart"), "Product not added to cart");
    }

    @AfterClass
    public void Close() {
        driver.quit();
    }
}
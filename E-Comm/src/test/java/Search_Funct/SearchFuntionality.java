package Search_Funct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFuntionality {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchProducts() {
       
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("mobile");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        String pageTitle = driver.getTitle();
       
        Assert.assertTrue(pageTitle.contains("Amazon.com : mobile"), "Search results page not displayed");
        WebElement firstProductTitle = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        String firstProductTitleText = firstProductTitle.getText();
        Assert.assertTrue(firstProductTitleText.toLowerCase().contains("mobile"), "Search results do not contain relevant products");
      }
     

    @AfterClass
    public void Close() {
        driver.quit();
    }
}

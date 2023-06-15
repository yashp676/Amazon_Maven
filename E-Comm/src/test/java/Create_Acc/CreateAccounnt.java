package Create_Acc;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounnt {
         WebDriver driver;
         
	@BeforeTest
	public void SetUp() {
		WebDriverManager.chromedriver().setup(); 
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/register?openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void LoginDetails() {
	 driver.findElement(By.id("ap_customer_name")).sendKeys("yash p");
	 driver.findElement(By.id("ap_phone_number")).sendKeys("8551022183");
	 driver.findElement(By.id("ap_email")).sendKeys("xyx6405@gmail.com");
	 driver.findElement(By.id("ap_password")).sendKeys("Testingp");
	 driver.findElement(By.id("continue")).click();
	}
}
	
    

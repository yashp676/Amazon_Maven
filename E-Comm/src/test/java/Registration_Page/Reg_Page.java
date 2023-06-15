package Registration_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reg_Page {
        public static void main(String[] args) {
			
		
	WebDriverManager.chromedriver().setup(); 
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/ap/register?openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    String Title = driver.getTitle();
    if(Title.equals("Amazon Registration")) {
		System.out.println("Test Case 01 is Passed");
	}
	else {
		System.out.println("Test case 01 is Failed");
	}
}
}

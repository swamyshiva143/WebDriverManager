package WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDMTest {

	WebDriver driver;

	
	@BeforeMethod
	public void setUp() {
	
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.edgedriver().setup();
//		WebDriverManager.operadriver().setup();
//		WebDriverManager.phantomjs().setup();
//		WebDriverManager.iedriver().setup();
//		WebDriverManager.chromiumdriver().setup();
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	
	}
	
	@Test
	public void facebookTest() {
		
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

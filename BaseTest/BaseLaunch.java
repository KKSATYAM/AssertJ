package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import assertions.PageAssert;
import assertions.WebElementAssertion;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.SearchPage;

public class BaseLaunch {

	protected WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		System.out.println("Setting::"+driver);
	}

	public static WebElementAssertion assertThat(WebElement ele) {
		return new WebElementAssertion(ele);
	}

	public static PageAssert assertThat(SearchPage bP) {
		return new PageAssert(bP);
	}

	
	@AfterMethod
	public void session()
	{
		System.out.println(driver);
	}
	
	@AfterTest
	public void quit() {
		this.driver.close();
		System.out.println("Closed::"+driver);
		driver.get("google.com");
		
	}
}

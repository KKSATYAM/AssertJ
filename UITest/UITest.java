package UITest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BaseTest.BaseLaunch;
import pages.SearchPage;

public class UITest extends BaseLaunch {
	private SearchPage searchPage;

	@BeforeTest
	public void SearchSetup() {
		this.searchPage = new SearchPage(driver);
	}

	@Test(dataProvider = "getData")
	public void search(String data) {
		this.searchPage.goTo();
		assertThat(searchPage).isAt();
		this.searchPage.search("Hellooo");
		assertThat(this.searchPage.searchBox()).isDisplayed().isEnabled().hasAttributeValue("title", "search");
	}

//	@Test
//	public void searchTest() {
//		this.driver.get("https://www.google.com/");
//		WebElement textBox = driver.findElement(By.xpath("//input[@name='q']"));
//		WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
//
//		WebElementAssertion.assertThat(textBox).isDisplayed().isEnabled()
////						   .isButton()
//				.hasAttributeValue("name", "q");
//
//		WebElementAssertion.assertThat(button).isEnabled().isButton().hasAttributeValue("name", "btnk");
//
//	}

	
	@DataProvider
	public Object[] getData()
	{
		return new String[]
				{
					"1","2","3","1","2","3","1","2","3","1","2","3"
				};
	}
}





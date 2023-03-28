package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	@FindBy(xpath = "//input[@name='q']")
	WebElement textBox;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void goTo() {
		this.driver.get("https://www.google.com");
	}

	public void search(String text) {
		this.textBox.sendKeys(text);
	}

	@Override
	public boolean isAt() {
		return this.driver.getTitle().equalsIgnoreCase("google");
	}

	public WebElement searchBox() {
		return textBox;
	}

}

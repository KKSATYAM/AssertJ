package assertions;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class WebElementAssertion extends AbstractAssert<WebElementAssertion, WebElement>

{

	public WebElementAssertion(WebElement webelement) {
		super(webelement, WebElementAssertion.class);
	}

	public static WebElementAssertion assertThat(WebElement element) {
		return new WebElementAssertion(element);
	}

	public WebElementAssertion isDisplayed() {
		isNotNull();
		if (!actual.isDisplayed()) {
			failWithMessage("Expected the webelement to be Displayed...But it wasn't");
		}
		return this;
	}

	public WebElementAssertion isEnabled() {

		if (!actual.isEnabled()) {
			failWithMessage("Expected the webelement to be Enabled...But it wasn't");
		}
		return this;
	}

	public WebElementAssertion isButton() {
		if (!(actual.getTagName().equalsIgnoreCase("button")
				|| actual.getAttribute("type").contains("submit"))) {
			failWithMessage("Expected the webelement to be Button...But it wasn't");
		}
		return this;
	}

	public WebElementAssertion hasAttributeValue(String attribute, String value) {
		if (!actual.getAttribute(attribute).equalsIgnoreCase(value)) {
			failWithMessage("Expected webelement attribute %s should have value %s...But it wasn't",
					attribute, value);
		}

		return this;
	}

}

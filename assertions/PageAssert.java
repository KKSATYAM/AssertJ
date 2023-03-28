package assertions;

import org.assertj.core.api.AbstractAssert;

import pages.BasePage;
import pages.SearchPage;

public class PageAssert extends AbstractAssert<PageAssert, SearchPage> {

	public PageAssert(SearchPage basePage) {
		super(basePage, PageAssert.class);
	}

	public static PageAssert assertThat(SearchPage basePage) {
		return new PageAssert(basePage);
	}

	public PageAssert isAt() {
		if (!actual.isAt()) {
			failWithMessage("Not on the expected page");
		}
		return this;
	}

}

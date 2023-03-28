package com.api.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class AssertJ {

	@Test(dataProvider = "getData")
	public void test(List<String> result) {
		List<String> expected= Arrays.asList("apple","ball");
		SoftAssertions.assertSoftly(softly->{
		softly.assertThat(result)
			  .hasSize(3)
			  .doesNotContain("cow")
			  .containsAll(expected)
			  .allSatisfy(m->{
				  				Assertions.assertThat(m.length())
				  						  .isGreaterThanOrEqualTo(5);
			  });
		});

		

		Path path_a = Paths.get("src\\test\\resources\\data\\a.txt");
		Path path_b = Paths.get("src\\test\\resources\\data\\b.txt");
		
		
		Assertions.assertThat(path_a)
				  .hasSameContentAs(path_b); 
		
		
		
		result.forEach(m->{
			
			Assertions.assertThat(m.length())
					  .isGreaterThanOrEqualTo(3);
			
			
			
		});
		
	
		
		Assertions.assertThat(result)
				  .hasSize(8)
				  .startsWith("se")
				  .doesNotContain("api")
				  .doesNotContain(" ")
				  .containsOnlyOnce("i");
		
		
		SoftAssertions.assertSoftly(message->{
			
			message.assertThat(result)
				   .hasSize(8)
				   .doesNotContain(" ")
				   .doesNotContain("api")
				   .startsWith("se")
				   .containsOnlyOnce("i");
			
			
		});
		
		
		

		
		
	}

	
	@DataProvider
	public Object[] getData() {
		return new Object[] { 
				
				//"selenium","selenide","apitests"
				
				Arrays.asList("apple","ball","cows")
		};
	}

}

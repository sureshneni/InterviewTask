package test.selenium.GoogleTask;

import org.testng.annotations.Test;

public class GoogleTest {
	
	GoogleAction googleAction;
	
	// UI
	@Test
	public void getGoogleText() {
		
		googleAction = new GoogleAction();
		googleAction.initialiseDriver();
		googleAction.navigateToApplication();
		googleAction.clickOnFeelingLucky();
		googleAction.getDoodleText();
		
	}
	
	// API
	@Test(dependsOnMethods = {"getGoogleText"})
	public void createTestEmployee() {
		googleAction.createEmployee();
		
	}

}

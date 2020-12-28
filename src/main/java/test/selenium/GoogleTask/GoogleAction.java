package test.selenium.GoogleTask;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleAction extends BasePage {
	
	WebElement element;
	Response response = null;
	String doodleText="";
	
	public String iamfeelnglucky_xpath = "//input[@value=\"I'm Feeling Lucky\"]";
//	public String iamfeelinglucky_xpath = "//input[@name='btnI']";
	public String doodle_css = "#highlight > ul > li:nth-child(1) > div";
	
	public void clickOnFeelingLucky() {
		element = getLocator("xpath", iamfeelnglucky_xpath);
		click(element);
	}
	
	public void getDoodleText() {
		element = getLocator("css", doodle_css);
		doodleText = element.getText();
		System.out.println("doodleText: "+doodleText);
	}
	
	public void createEmployee() {
		
		//Create API - http://dummy.restapiexample.com/api/v1/create
			
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
			
		/**
		 * This we can keep in seperate file/externally as payload to maintain effectively.
		 * Just for time being i have hard coded here.
		 */
		
		String createUserPayLoad = "{\n" +
	            "  \"name\": \""+doodleText+"\",\n" +
	            "  \"salary\": \"123\",\n" +
	            "  \"age\": \"23\"\n" +
	            "}";
		
        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createUserPayLoad)
                .when()
                .post("/create");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       System.out.println("API Response: "+response.asString());
       Assert.assertEquals(200, response.getStatusCode());
       Assert.assertEquals("success", response.getStatusLine());
       Assert.assertTrue(response.asString().contains(""));
	 
		
	}

}

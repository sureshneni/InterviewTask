package test.selenium.GoogleTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;


/**
 * 
 * @author suresh
 * 
 * Here, browser name and App url i have hard coded for task but we can get it from any other
 * configuration file.
 *
 */
public class BasePage {
	
	public static WebDriver driver;
	public static WebElement element;
	
	public String browser = "chrome";
	public String rootDriverPath = System.getProperty("user.dir");
	WebDriverWait wait;
	public String appURL = "https://www.google.com/";
	
	protected static final Logger logger = Logger.getLogger(BasePage.class);
	
	/**
	 * Initialise the browser as per configurations we send.
	 * 
	 */
	public void initialiseDriver() {
	
		logger.info("browser name: "+browser);
			
		switch(browser) {
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		
	}
	
	/**
	 * This will navigate to our application
	 */
	public void navigateToApplication() {
		logger.info("App url: "+appURL);
		driver.navigate().to(appURL);	
	}
	
	/**
	 * 
	 * @param locatorType what type of locator we are using
	 * @param locator - actual element
	 * @return the WebElement
	 */
	public WebElement getLocator(String locatorType, String locator) {
		
		switch(locatorType) {
		case "id":
			element = driver.findElement(By.id(locator));
			break;
		case "class":
			element = driver.findElement(By.className(locator));
			break;
		case "name":
			element = driver.findElement(By.name(locator));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locator));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(locator));
			break;
	   default:
		   System.out.println("no locator matched");
		
		}
		return element;
	}
	
	/**
	 * wrapper method to perform click operation.
	 * @param element , element where we are performing click operation.
	 */
	public void click(WebElement element) {
		this.waitForElementToBeVisible(element);
		element.click();
	}
	
	/**
	 * 
	 * @param element, on element where we need to send text.
	 * @param inputText, input text we are sending to element.
	 */
	public void sendText(WebElement element, String inputText) {
		this.waitForElementToBeVisible(element);
		element.sendKeys(inputText);
	}
	
	/**
	 * 
	 * @param element, wait untill element status is clickable
	 * 
	 */
	public void waitForElementToBeClickable(WebElement element){
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	/**
	 * 
	 * @param element, wait untill element is visible to perform any operation.
	 * 
	 */
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}

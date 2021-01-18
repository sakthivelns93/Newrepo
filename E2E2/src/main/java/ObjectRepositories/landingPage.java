package ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	WebDriver driver;
	public landingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By newRequest = By.id("newcase-button");
	
	public By viewRequests = By.id("mycases-button");
	
	public WebElement getNewRequest() {
		return driver.findElement(newRequest);
	}
	
	public WebElement getViewRequests() {
		return driver.findElement(viewRequests);
	}
}

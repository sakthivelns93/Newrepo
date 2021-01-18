package ObjectRepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class viewRequestsPage {
	WebDriver driver;
	
	public viewRequestsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By lblCaseList = By.id("lblCaseListHeader");
	public By names = By.xpath("//a[@class='open-client alert-link']");
	public By statuses = By.xpath("//table[@class='table cases tablesorter tablesorter-default']/tbody/tr/td[3]");
	
	public List<WebElement> getNames() {
		return driver.findElements(names);
	}
	
	public List<WebElement> getStatuses() {
		return driver.findElements(statuses);
	}
}

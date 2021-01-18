package ObjectRepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newRequestPage {
WebDriver driver;
	
	public newRequestPage(WebDriver driver) {
		this.driver=driver;
	}

	public By header = By.id("spanCaseInformation");
	
	public By frame = By.xpath("//iframe[@id='CossScreenFrame']");
	
	public By firstName = By.xpath("//input[@id='txtFirstName']");
	public By lastName = By.id("txtLastName");
	public By dobMonth = By.xpath("//input[@class = 'jq-dte-month hint']");
	public By dobDate = By.xpath("//input[@class='jq-dte-day hint']");
	public By dobYear = By.xpath("//input[@class='jq-dte-year hint']");
	public By age = By.id("txtAge");
	public By btn_Gender = By.xpath("//button[@data-id='ddlGender']");
	public By dd_Genders = By.xpath("(//div[@class='dropdown-menu open'])[1] //span[@class='text']");
	
	public By btn_state = By.xpath("//button[@data-id='ddlState']");
	public By dd_states = By.xpath("(//div[@class='dropdown-menu open'])[2] //span[@class='text']");
	
	public By btn_requestType = By.xpath("//button[@data-id='ddlProductType']");
	public By dd_requestTypes = By.xpath("(//div[@class='dropdown-menu open'])[3] //span[@class='text']");
	
	public By findAvlProducts = By.id("btnFindAvailableProducts");
	
	public By submit = By.xpath("//input[@class='btn btn-default']");
	
	public WebElement getFrame() {
		return driver.findElement(frame);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
		
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getDOBMonth() {
		return driver.findElement(dobMonth);
	}
	
	public WebElement getDOBDate() {
		return driver.findElement(dobDate);
	}
	
	public WebElement getDOBYear() {
		return driver.findElement(dobYear);
	}
	
	public WebElement getAge() {
		return driver.findElement(age);
	}
	
	public WebElement getBtnGender() {
		return driver.findElement(btn_Gender);
	}
	
	public List<WebElement> getDDGenders(){
		return driver.findElements(dd_Genders);
	}
	
	public WebElement getBtnState() {
		return driver.findElement(btn_state);
	}
	
	public List<WebElement> getDDStates() {
		return driver.findElements(dd_states);
	}
	
	public WebElement getBtnRequestType() {
		return driver.findElement(btn_requestType);
	}
	
	public List<WebElement> getDDRequestTypes() {
		return driver.findElements(dd_requestTypes);
	}
	
	public WebElement getFindAvlProducts() {
		return driver.findElement(findAvlProducts);
	}
	
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
}

package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepositories.landingPage;
import ObjectRepositories.loginPage;
import ObjectRepositories.newRequestPage;
import Resources.Base;

@RunWith(Cucumber.class)
public class BC_New_Request extends Base {
	public WebDriver driver;
    @Given("^that the \"([^\"]*)\" browser is initialized$")
    public void that_the_something_browser_is_initialized(String strArg1) throws Throwable {
    	driver = initializeDriver(strArg1);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @And("^the URL \"([^\"]*)\" is launched$")
    public void the_url_something_is_launched(String strArg1) throws Throwable {
        driver.get(strArg1);
    }

    @And("^the username (.+) and the password (.+) is entered$")
    public void the_username_something_and_the_password_something_is_entered(String strArg1, String strArg2) throws Throwable {
    	loginPage login = new loginPage(driver);
		login.getUsername().sendKeys(strArg1);
		login.getPassword().sendKeys(strArg2);
		login.getBtnLogin().click();
		System.out.println("Sakthivel's 1st");
		
		System.out.println("Geetha's 1st");
    }

    @When("^the New Request button is clicked$")
    public void the_new_request_button_is_clicked() throws Throwable {
    	landingPage lp = new landingPage(driver);
		lp.getNewRequest().click();
    }

    @Then("^the page for new request should be opened and the required data should be entered$")
    public void the_page_for_new_request_should_be_opened_and_the_required_data_should_be_entered() throws Throwable {
newRequestPage nr = new newRequestPage(driver);
		
		driver.switchTo().frame(nr.getFrame());
		
		nr.getFirstName().sendKeys("TestFirstName");
		
		nr.getLastName().clear();
		nr.getLastName().sendKeys("TestLastName");
		
		nr.getDOBMonth().sendKeys("06");
		nr.getAge().click();
		nr.getDOBDate().sendKeys("29");
		nr.getAge().click();
		nr.getDOBYear().sendKeys("1990");
		
		nr.getBtnGender().click();
		for(WebElement gender: nr.getDDGenders()) {
			if(gender.getText().equalsIgnoreCase("male")) {
				gender.click();
				break;
			}
		}
		
		nr.getBtnState().click();
		for(WebElement state: nr.getDDStates()) {
			if(state.getText().equalsIgnoreCase("florida")) {
				state.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		nr.getBtnRequestType().click();
		for(WebElement requestType: nr.getDDRequestTypes()) {
			if(requestType.getText().equalsIgnoreCase("phs")) {
				requestType.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		nr.getFindAvlProducts().click();
		
		Thread.sleep(3000);
		nr.getSubmit().click();
		
		driver.close();
    }



}

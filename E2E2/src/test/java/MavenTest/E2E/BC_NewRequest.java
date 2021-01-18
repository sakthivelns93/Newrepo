package MavenTest.E2E;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepositories.landingPage;
import ObjectRepositories.newRequestPage;
import Resources.LaunchURL;

public class BC_NewRequest extends LaunchURL {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BC_NewRequest.class.getName());
	@Test(dataProvider = "credentialManager")
	public void newRequest(String username, String password) throws IOException, InterruptedException {
		driver = launchURL(username, password);
		log.info("URL launched");
		landingPage lp = new landingPage(driver);
		lp.getNewRequest().click();
		log.info("New request option page opened");
		
		newRequestPage nr = new newRequestPage(driver);
		
		driver.switchTo().frame(nr.getFrame());
		
		nr.getFirstName().sendKeys("TestFirstName");
		
		nr.getLastName().clear();
		nr.getLastName().sendKeys("TestLastName");
		log.debug("Names entered");
		nr.getDOBMonth().sendKeys("06");
		nr.getAge().click();
		nr.getDOBDate().sendKeys("29");
		nr.getAge().click();
		nr.getDOBYear().sendKeys("1990");
		log.debug("DOB entered");
		
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
		
		log.debug("Gender & State selected");
		
		Thread.sleep(3000);
		nr.getBtnRequestType().click();
		for(WebElement requestType: nr.getDDRequestTypes()) {
			if(requestType.getText().equalsIgnoreCase("phs")) {
				requestType.click();
				break;
			}
		}
		
		log.debug("PHS selected");
		
		Thread.sleep(3000);
		nr.getFindAvlProducts().click();
		
		Thread.sleep(3000);
		nr.getSubmit().click();
		
		log.info("All personal details entered");
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] credentialManager() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = "GuardianC";
		obj[0][1] = "Password!";
		return obj;
	}
}

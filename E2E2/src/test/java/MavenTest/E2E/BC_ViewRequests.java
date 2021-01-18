package MavenTest.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepositories.landingPage;
import ObjectRepositories.viewRequestsPage;
import Resources.LaunchURL;

public class BC_ViewRequests extends LaunchURL {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BC_ViewRequests.class.getName());
	@Parameters({"username", "password"})
	@Test
	public void viewRequests(String username, String password) throws IOException {
		driver=launchURL(username, password);
		log.info("URL launched");
		landingPage lp = new landingPage(driver);
		lp.getViewRequests().click();
		log.info("View requests option page opened");
		
		viewRequestsPage vr = new viewRequestsPage(driver);
		for(int i=0;i<vr.getNames().size();i++) {
			System.out.println("Count: "+i+"   Name: "+vr.getNames().get(i).getText()+"   Status: "+vr.getStatuses().get(i).getText());
			log.debug("Count: "+i+"   Name: "+vr.getNames().get(i).getText()+"   Status: "+vr.getStatuses().get(i).getText());
		}
		driver.close();
	}
}

package Resources;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ObjectRepositories.loginPage;

public class LaunchURL extends Base {
	public WebDriver launchURL(String username, String password) throws IOException {
		WebDriver driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(getProperties().getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage login = new loginPage(driver);
		login.getUsername().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getBtnLogin().click();
		return driver;
	}
}

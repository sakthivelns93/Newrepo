package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	public static WebDriver driver;
	public static WebDriver initializeDriver() throws IOException {
		String browserName = getProperties().getProperty("browser");
		//String browserName = System.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver_Latest\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver = new ChromeDriver(options);
			return driver;
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			return driver;
		}
		else {
			return null;
		}
	}
	
	public static WebDriver initializeDriver(String browserName) throws IOException {
		//String browserName = getProperties().getProperty("browser");
		//String browserName = System.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver_Latest\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver = new ChromeDriver(options);
			return driver;
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			return driver;
		}
		else {
			return null;
		}
	}
	
	public static Properties getProperties() throws IOException {
		Properties property = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\Data.properties");
		property.load(input);
		return property;
	}
	
	public static String screenshot(WebDriver driver, String methodName) throws IOException {
		File directory = new File(System.getProperty("user.dir")+"\\Screenshots");
		int size = directory.list().length;
		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\Screenshots\\"+methodName+size+".png";
		FileUtils.copyFile(sourcePath, new File(destinationPath));
		return destinationPath;
	}
	
	public static ExtentReports extentReporting() {
		String path = System.getProperty("user.dir")+"\\Reports\\Index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("E2E automation results");
		spark.config().setReportName("Ipipeline test results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
	}
}

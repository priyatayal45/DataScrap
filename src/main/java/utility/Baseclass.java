package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass 

{
	public static WebDriver driver;
	Properties prop;
	
	public Baseclass()
	{
		prop = new Properties();
		FileInputStream file;
		try 
		{
			file = new FileInputStream(System.getProperty("user.dir") + "/utilities/Parameters.properties");
			prop.load(file);
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@BeforeTest
	public void beforeverytest()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}

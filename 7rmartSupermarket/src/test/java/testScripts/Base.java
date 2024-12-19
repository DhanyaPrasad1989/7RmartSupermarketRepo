package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;

//import com.beust.jcommander.Parameters;

import utilities.ScreenShotUtility;


public class Base {
public WebDriver driver;
public  ScreenShotUtility scrshot;
public Properties properties;
@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
	try
	{
		properties= new Properties();
		FileInputStream fileinputstream=new FileInputStream(Constants.CONFIGFILE );
		properties.load(fileinputstream);
	}
	catch (Exception e)
	{
	System.out.println("Exception handled");
	}
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver =new ChromeDriver();	
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		driver =new EdgeDriver();	
		
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver =new FirefoxDriver();
	}
	else
	{
		throw new Exception("browser is not correct");
	}
	driver.get(properties.getProperty("url"));
	//driver = new ChromeDriver();
	//driver.get("https://groceryapp.uniqassosiates.com/admin/login");	
	driver.manage().window().maximize();
	}

@AfterMethod(alwaysRun=true)
	
public void browserQuit(ITestResult iTestResult) throws IOException {
	if (iTestResult.getStatus() == ITestResult.FAILURE) {
		scrshot = new ScreenShotUtility();
		scrshot.captureFailureScreenShot(driver, iTestResult.getName());
	}

	driver.quit();
}

	
}






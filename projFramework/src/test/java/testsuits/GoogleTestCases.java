package testsuits;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.BrowserHelper;
import common.TestConfig;
import guipages.google.GoogleSearchPage;

public class GoogleTestCases
{
	WebDriver driver=null;
	
	GoogleSearchPage objGoogleSearch;//every page we should create object thats y its called POM

	@Test
	public void TC01_GoogleSearch()
	{
	
		TestConfig.SetTestConfig();
		
		driver=BrowserHelper.LaunchBrowser(driver);//to launch browser in chrome 32 as it is in properties file
		
		driver.get("https://www.google.com");
		
		objGoogleSearch=new GoogleSearchPage( driver);//calling constructor
		
		objGoogleSearch.searchTxt();//calling methods 
		
		BrowserHelper.SaveDriverScreenshot(driver, "TC01_GoogleSearch");
		
		driver.quit();
		
		
	}
	
	
	
	
}

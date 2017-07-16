package guipages.google;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.TestConfig;

public class GoogleSearchPage
{
	private WebDriver driver;
	
	By byTxtSearch=By.id("lst-ib");
	
	//By bySearchBtn=By.name("btnG");
	
	public GoogleSearchPage(WebDriver TC01driver)
	{
		this.driver = TC01driver;
	}

	// Type Something in textbox 
	public void searchTxt()
	{
		WebElement btnSearch=driver.findElement(byTxtSearch);
		btnSearch.sendKeys("Selenium");
	}
	
	/*private void clickBtnSearch()
	{
		driver.findElement(bySearchBtn).click();
	}*/
	


}
package testsuits;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.BrowserHelper;
import common.ExcelHelper;
import common.TestConfig;
import guipages.mercury.MercuryFlightFinderPage;
import guipages.mercury.MercuryLoginPage;
import guipages.mercury.MercuryLoginPageFactory;

public class MercuryTestCases
{
	ExcelHelper objExcel;
	WebDriver driver = null;
	MercuryLoginPage objMercuryLogin;
	MercuryLoginPageFactory objMercuryLoginFactory;
	MercuryFlightFinderPage objMercuryFlightFinder;
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("@BeforeTest");
		TestConfig.SetTestConfig();
		objExcel = new ExcelHelper();
		objExcel.SetExcelHeader();
	}

	@AfterTest
	public void afterTest()
	{
		System.out.println("@AfterTest");
		if(!(driver==null))
			driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("@AfterMethod");
		objExcel.ClearExcelData();
	}
	
	@Test
	public void TC01_Mercury_Login_Success()
	{
		try
		{
			String tcName = "TC01_Mercury_Login_Success";
			System.out.println("@Test=" + tcName);
			objExcel.SetExcelData(tcName);
			String xlUserName = objExcel.GetValue(0, "UserName");
			String xlPassword = objExcel.GetValue(0, "Password");
			String xlTitle = objExcel.GetValue(0, "ExpTitle");
			
			driver = BrowserHelper.LaunchBrowser(driver);
			driver.get("http://newtours.demoaut.com/");
			
			objMercuryLogin = new MercuryLoginPage(driver);
			objMercuryLogin.MercuryLogin(xlUserName, xlPassword);
			BrowserHelper.SaveDriverScreenshot(driver,tcName);
			Assert.assertEquals(driver.getTitle(), xlTitle);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC02_Mercury_Login_Failure_Factory()
	{
		try
		{
			String tcName = "TC02_Mercury_Login_Failure";
			System.out.println("@Test=" + tcName);
			objExcel.SetExcelData(tcName);
			String xlUserName = objExcel.GetValue(0, "UserName");
			String xlPassword = objExcel.GetValue(0, "Password");
			String xlTitle = objExcel.GetValue(0, "ExpTitle");
			
			driver = BrowserHelper.LaunchBrowser(driver);
			driver.get("http://newtours.demoaut.com/");
			
			objMercuryLoginFactory = new MercuryLoginPageFactory(driver);
			objMercuryLoginFactory.MercuryLogin(xlUserName, xlPassword);
			BrowserHelper.SaveDriverScreenshot(driver,tcName);
			Assert.assertEquals(driver.getTitle(), xlTitle);
			objExcel.ClearExcelData();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	@Test(dependsOnMethods={"TC01_Mercury_Login_Success"})
	public void TC03_Mercury_FlightFinder_Fillup()
	{
		try
		{
			TestConfig.SetTestConfig();
			
			//TC01_Mercury_Login_Success();
			
			driver=BrowserHelper.LaunchBrowser(driver);//to launch browser in chrome 32 as it is in properties file
			

			
			String tcName = "TC03_Mercury_FlightFinder_Fillup";
			
			System.out.println("@Test=" + tcName);
			
			objExcel.SetExcelData(tcName);
			
			String xlpassNo = objExcel.GetValue(0, "Passengers");
			
			String xldCity = objExcel.GetValue(0, "Depart From");
			
			String xldMonth = objExcel.GetValue(0, "D.Month");
			
			String xldDate = objExcel.GetValue(0, "D.Day");
			
			String xlaCity = objExcel.GetValue(0, "Arriving IN");
			
			String xlrMonth = objExcel.GetValue(0, "A.Month");
			
			String xlrDate = objExcel.GetValue(0, "A.Day");
			
			String xlrairline = objExcel.GetValue(0, "Airline");
			
			//String xlTitle = objExcel.GetValue(0, "ExpTitle");
			
			
			
			objMercuryFlightFinder=new MercuryFlightFinderPage(driver);
			
			
			
			objMercuryFlightFinder.MercuryFlightFinder(xlpassNo, xldCity, xldMonth, xldDate, xlaCity, xlrMonth, xlrDate, xlrairline);
			
			BrowserHelper.SaveDriverScreenshot(driver, tcName);
			
			/*objMercuryFlightFinder.setRadiobtnType();
			
			objMercuryFlightFinder.countDropdownPassenger();
			
			objMercuryFlightFinder.departingFromDropdown();
			
			objMercuryFlightFinder.onMonthDropDown();
			
			objMercuryFlightFinder.onDateDropDown();
			
			objMercuryFlightFinder.ArrivingInDropdown();
			
			objMercuryFlightFinder.ReturningMonthDropDown();
			
			objMercuryFlightFinder.ReturningDateDropDown();
			
			objMercuryFlightFinder.ServiceClassRadioBtn();
			
			objMercuryFlightFinder.AirlineDropdown();
			
			objMercuryFlightFinder.ContinueBtn();
			*/
			
			
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}

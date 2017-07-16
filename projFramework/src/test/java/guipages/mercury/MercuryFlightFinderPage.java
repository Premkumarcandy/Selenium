package guipages.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MercuryFlightFinderPage
{
	private WebDriver driver;
	
	By byTypeRadio=By.name("tripType");
	
	By byDropdownPassengers=By.xpath("//select[@name='passCount']");
	
	By byDropdownDepartingFrom=By.name("fromPort");
	
	By byDropdownDeparingDate=By.name("fromDay");
	
	By byDropdownDeparingMonth=By.name("fromMonth");
	
	By byDropdownReturnDate=By.name("toDay");
	
	By byDropdownReturnMonth=By.name("toMonth");
	
	By byDropdownArrivingTo=By.name("toPort");
	
	By byRadioServiceClass=By.xpath("//input[@value='Business']");
	
	By byDropDownAirline=By.name("airline");
	
	By btnContinue=By.name("findFlights");
	
	
	
	//to initialize the testcase02 driver with class driver
	public MercuryFlightFinderPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void setRadiobtnType()
	{
		driver.findElement(byTypeRadio).click();
	}
	
	public void countDropdownPassenger(String passNo)
	{
		WebElement elePassenger=driver.findElement(byDropdownPassengers) ;
		Select Passenger=new Select(elePassenger);
		Passenger.selectByVisibleText(passNo);
	}
	
	
	public void departingFromDropdown(String dCity)
	{
		WebElement eleDeparting=driver.findElement(byDropdownDepartingFrom);
		Select departFrom=new Select(eleDeparting);
		departFrom.selectByVisibleText(dCity);
	}
	
	public void onMonthDropDown(String dMonth)
	{
		WebElement eleonMonth=driver.findElement(byDropdownDeparingMonth);
		Select onMonth=new Select(eleonMonth);
		onMonth.selectByVisibleText(dMonth);
		
	}
	
	
	public void onDateDropDown(String dDate)
	{
		WebElement eleonDate=driver.findElement(byDropdownDeparingDate);
		Select onDate=new Select(eleonDate);
		onDate.selectByVisibleText(dDate);
		
	}
	
	public void ArrivingInDropdown(String aCity)
	{
		WebElement eleArriving=driver.findElement(byDropdownArrivingTo);
		Select arrivingTo=new Select(eleArriving);
		arrivingTo.selectByVisibleText(aCity);
		
	}
	
	
	
	public void ReturningMonthDropDown(String rMonth)
	{
		
		WebElement eleReturnMonth=driver.findElement(byDropdownReturnMonth);
		Select returnMonth=new Select(eleReturnMonth);
		returnMonth.selectByVisibleText(rMonth);
	}
	
	
	public void ReturningDateDropDown(String rDate)
	{
		WebElement eleReturnDate=driver.findElement(byDropdownReturnDate);
		Select returnDate=new Select(eleReturnDate);
		returnDate.selectByVisibleText(rDate);
	}
	
	public void ServiceClassRadioBtn()
	{

		driver.findElement(byRadioServiceClass).click();
	}
	
	public void AirlineDropdown(String airlineService)
	{
		WebElement eleAirline=driver.findElement(byDropDownAirline);
		Select airline=new Select(eleAirline);
		airline.selectByVisibleText(airlineService);
		
	}
	
	public void ContinueBtn()
	{
		driver.findElement(btnContinue).click();
	}
	
	public void MercuryFlightFinder(String passNo,String dCity,String dMonth,String dDate,String aCity,String rMonth,String rDate,String airlineService)
	{
		this.setRadiobtnType();
		this.countDropdownPassenger(passNo);
		this.departingFromDropdown(dCity);
		this.onMonthDropDown(dMonth);
		this.onDateDropDown(dDate);
		this.ArrivingInDropdown(aCity);
		this.ReturningMonthDropDown(rMonth);
		this.ReturningDateDropDown(rDate);
		this.ServiceClassRadioBtn();
		this.AirlineDropdown(airlineService);
		this.ContinueBtn();
	}
	
	


}

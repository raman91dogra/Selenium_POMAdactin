package com.Capita.Adactin.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Capita.Adactin.testbase.TestBase;

public class SearchHotel extends TestBase{

	WebDriver driver;
	
	public SearchHotel(WebDriver driver)
	{
		this.driver = driver;
	}
	private enum ELEMENT{
		DISPLAYSUSERNAME(By.id("username_show")),
		CHECKINDATE(By.id("datepick_in")),
		CHECKOUTDATE(By.id("datepick_out")),
		LOCATION(By.id("location"));
		
		
		private By findby;
		private ELEMENT(By locator)
		{
			this.findby = locator;
		}
		
	}
	
	public static void selectByValue(WebElement element, String value) {
	    Select selectElement = new Select(element);
	    selectElement.selectByValue(value);
	}
	
	 
}

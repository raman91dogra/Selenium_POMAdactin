package com.Capita.Adactin.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Capita.Adactin.testbase.TestBase;

public class Login extends TestBase{

	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	private enum ELEMENT {
		USERNAME(By.id("username")),
		PASSWORD(By.id("password")),
		LOGIN(By.id("login")),
		LOGOUT(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/a[4]")),
		ERRORMESSAGE(By.xpath("//*[@id='login_form']/table/tbody/tr[5]/td[2]/div/b"));
	
		private By findby;
		private ELEMENT(By locator)
		{
			this.findby = locator;
		}
	}

	public void clickValidLogin()
	{
		driver.findElement(ELEMENT.USERNAME.findby).sendKeys("RobinCAP");
		driver.findElement(ELEMENT.PASSWORD.findby).sendKeys("79D209");
		driver.findElement(ELEMENT.LOGIN.findby).click();
		System.out.println("Login Button is clicked successfully");
	}
	
	public void clickInvalidLogin()
	{
		driver.findElement(ELEMENT.USERNAME.findby).sendKeys("Raman");
		driver.findElement(ELEMENT.PASSWORD.findby).sendKeys("Test");
		driver.findElement(ELEMENT.LOGIN.findby).click();
		System.out.println("Login Button is clicked successfully");
		WebElement result = driver.findElement(ELEMENT.ERRORMESSAGE.findby);
		System.out.println(result.getText());
	}
	
	public void clickLogout()
	{
		driver.findElement(ELEMENT.LOGOUT.findby).click();
		System.out.println("Logout Button is clicked successfully");
	}
}

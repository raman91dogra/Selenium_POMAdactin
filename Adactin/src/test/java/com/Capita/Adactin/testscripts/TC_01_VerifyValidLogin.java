package com.Capita.Adactin.testscripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Capita.Adactin.pageLibrary.Login;
import com.Capita.Adactin.testbase.TestBase;

public class TC_01_VerifyValidLogin extends TestBase{

	Login login;
	
	
	@BeforeClass
	public void startUp() throws IOException
	{
		init();
		System.out.println("Browser is invoked successfully");
	}
	
	
	@Test
	public void testLogin()
	{
		login = new Login(driver);
		login.clickValidLogin();
		login.clickLogout();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		closeBrowser();
	}
	
	
}

package com.Capita.Adactin.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static WebDriver driver;
	public File f;
	public FileInputStream fis;
	public static Properties Repository = new Properties();
	
	public void init() throws IOException
	{
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void loadPropertiesFile() throws IOException
	{
		f = new File(System.getProperty("user.dir")+ "//src//test//java//com//Capita//Adactin//config//config.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);	
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
			System.out.println("Opening Chrome Browser...");
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/drivers/geckodriver.exe");
			System.out.println("Opening Firefox Browser...");
			driver = new FirefoxDriver();
		}
		
		else
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "/drivers/IEDriverServer.exe");
			System.out.println("Opening Internet Explorer Browser...");
			driver = new InternetExplorerDriver();
		}
	}
	
	public void closeBrowser()
	{
		driver.manage().deleteAllCookies();
		driver.close();
		System.out.println("Driver is closed successfully");
	}
}

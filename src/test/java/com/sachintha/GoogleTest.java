package com.sachintha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

	@Parameters("browser")
	@Test
	public void testGoogleTitle(String browser) 
	{
		WebDriver driver = null;
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle().toString(), "Google");
		driver.quit();
	}
}

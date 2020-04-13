package com.Demoblaze.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *This class is particularly used for storing the browser details for the automation process 
 *
 */


public class BrowserFactory {

	public WebDriver driver;
	/**
	 * This method is used to return the path based on the given parameters
	 */
	public WebDriver startBrowser(String browserName, String url) {
		ConfigReader config = new ConfigReader();
		/**
		 * if string name equals to chrome then test automation is done in chrome browser 
		 */
		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", config.getchromepath() );

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		/**
		 * if string name equals to firefox then test automation is done in firefox browser
		 */
		else if(browserName.equalsIgnoreCase("firefox")){

			System.setProperty("webdriver.gecko.driver", config.getfirefoxpath());

			driver = new FirefoxDriver();

		}

		/**
		 * This method returns url
		 */
		driver.get(url);
		return driver;
	}

	/**
	 * To sleep the application for a specific timeOut in seconds
	 * @param timeout
	 * @throws InterruptedException
	 */
	public void sleep(int timeout) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(timeout);
	}
	/**
	 * This method is used to quit the browser
	 */
	public void quit()
	{
		driver.quit();
	}



}

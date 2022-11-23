package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Created by Ali Faizi for demonstration and learning purposes only. 
import com.utilities.ConfigsReader;
import com.utilities.Constants;

public class Base {

	public static WebDriver driver;

	public static WebDriver setup() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supportd");

		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		
		// We initialize all the page elements of the classes in the package com.initialize.pages

		PageInitializer.initialize(); 

		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
//Created by Ali Faizi for demonstration and learning purposes only. 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.PageInitializer;

public class CommonUtils extends PageInitializer {

	/**
	 * This method clears the text box and sends another text
	 */

	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	/**
	 * This method checks if radio/check box is enabled and then clicks on the element that has the value we want
	 */

	public static void ClickRadioOrCheckBox(List<WebElement> listElement, String value) {

		String actualValue;

		for (WebElement element : listElement) {
			actualValue = element.getAttribute("value").trim();
			if (element.isEnabled() && actualValue.equals(value)) {
				element.click();
				break;
			}
		}
	}

	/**
	 * This method checks if the text is found in the drop down element and only then it selects it
	 */

	public static void selectDropdown(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement ele : options) {
				if (ele.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method checks if the text of the index is valid and only then selects it
	 */

	public static void selectDropdown(WebElement element, int index) {

		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method accepts alerts and catches exception if alert is not present
	 * 
	 */

	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method dismisses alert after checking if alert is present
	 * 
	 */

	public static void dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method get alert text after checking if alert is present
	 */

	public static String getAlertText(String alertText) {
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alertText;
	}

	/**
	 * This method send text to alert. NoAlertPresentException is handled
	 */

	public static void sendTextToAlert(String text) {

		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame by using name or id
	 */

	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method switches to a frame by using index
	 */

	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame by using a WebElement
	 */

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches focus to a child window
	 * 
	 */

	public static void switchTOChildWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}
	}

	/**
	 * This method creates a WebDriverWait object and return it
	 */

	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

		return wait;

	}

	/**
	 * This method waits for an element to be click able
	 */

	public static WebElement waitUntiElementClickable(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This method waits for an element to be visible
	 */

	public static WebElement waitUntilElementVisible(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method click on an element and has wait implemented on it
	 */

	public static void clickAndWait(WebElement element) {
		waitUntiElementClickable(element);
	}

	public static void wait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method casts the driver to a JavaScriptExecutor and return it
	 */

	public static JavascriptExecutor getJSObject() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		return jse;

	}

	/**
	 * This method will click on the element passed to it using JavascriptExecutor
	 */

	public static void jseClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click()", element);

	}

	/**
	 * This method will scroll down the page until the element passed to it becomes visible
	 */

	public static void scrollToElement(WebElement element) {

		getJSObject().executeScript("arguments[0],scrollIntoView(true)", element);

	}

	/**
	 * This method will scroll DOWN the page based on the passed pixel parameter
	 */

	public static void scrollDown(int pixel) {

		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");

	}

	/**
	 * This method will scroll UP the page based on the passed pixel parameter
	 */

	public static void scrollUp(int pixel) {

		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will select a date from the calendar
	 */

	public static void selectCalendarDate(List<WebElement> elements, String text) {
		for (WebElement day : elements) {
			if (day.isEnabled()) {
				if (day.getText().equals(text)) {
					day.click();
					break;
				}
			}

		}
	}

	public static byte[] takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] ssBytes = ts.getScreenshotAs(OutputType.BYTES);
		File file = ts.getScreenshotAs(OutputType.FILE);
		// Creating destination s : filepath + filename + fileformat
		String destination = Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ssBytes;
	}

	/**
	 * This method returns the current time stamp in a string
	 */

	public static String getTimeStamp() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_mm_ss");
		return sdf.format(date.getTime());

	}
	
	public static void highlightelementRedBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}

	public static void highlightelementBackground(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.background='yellow'", element);
	}

	public static void highlightelementBorderAndBackground(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}

}

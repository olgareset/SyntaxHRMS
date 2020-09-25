package com.hrms.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer{
	
	/**
	 * Method that sends text to any given element
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);		
	}
	/**
	 * Method returns Object of JavaScript Executor type
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;		
	}
	/**
	 * Method performs CLICK usingJavaScript executor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click;", element);		
	}
	
	/**
	 * Method scrolls up using JavaScript executor
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0, -"+pixel+")");		
	}
	
	/**
	 * Method scrolls down using JavaScript executor
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(windows.scrollBy(0,"+pixel+")");
	}
	
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	}
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	public static void takeScreen(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try{
		FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH+fileName+"png"));
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}

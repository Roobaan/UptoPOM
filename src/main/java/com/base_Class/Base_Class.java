package com.base_Class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Driver//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user,dir") + "//Driver//gecko.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}

	public static void get(String url) {
		driver.get(url);
	}

	public static void inputValues(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void selectIndex(WebElement element, int value) {
		Select s = new Select(element);
		s.selectByIndex(value);
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void backSpace() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	public static void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}

	public static void waitt() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void scrollElementView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}

package com.Runner;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.base_Class.Base_Class;
import com.pom.Page_Object_Manager;

public class Test_Runner extends Base_Class {
	
	public static WebDriver driver = browserLaunch("chrome");;

	public static Page_Object_Manager pom =new Page_Object_Manager(driver);
	
	public static void main(String[] args) throws Throwable {

	
		get("https://adactinhotelapp.com/index.php");
		
		inputValues(pom.getLp().getUsername(), "RoobaanMT");

		inputValues(pom.getLp().getPass(), "Roo@123");

		click(pom.getLp().getLogin());

		selectIndex(pom.getSh().getLocation(), 1);

		selectIndex(pom.getSh().getHotel(), 2);

		selectIndex(pom.getSh().getRoom_type(), 4);

		selectIndex(pom.getSh().getRoom_nos(), 1);

		clear(pom.getSh().getDatepick_in());
		inputValues(pom.getSh().getDatepick_in(), "22/11/2021");

		clear(pom.getSh().getDatepick_out());
		inputValues(pom.getSh().getDatepick_out(), "23/11/2021");

		selectIndex(pom.getSh().getAdult_room(), 2);

		selectIndex(pom.getSh().getChild_room(), 1);

		click(pom.getSh().getSubmit());
		waitt();

		click(pom.getSh1().getRadio());

		click(pom.getSh1().getContinu());

		inputValues(pom.getBp().getFname(), "Roobaan");

		inputValues(pom.getBp().getLname(), "M T");

		inputValues(pom.getBp().getAddress(), "1st Street,India");

		inputValues(pom.getBp().getCcnum(), "1234567891234567");

		selectIndex(pom.getBp().getCctype(), 2);

		selectIndex(pom.getBp().getExpmonth(), 5);

		selectIndex(pom.getBp().getExpyear(), 12);

		inputValues(pom.getBp().getCc_cvv(), "321");

		click(pom.getBp().getBook_now());
		waitt();

		scrollElementView(pom.getBcp().getItin());
		click(pom.getBcp().getItin());
		
		waitt();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File f1 = ts.getScreenshotAs(OutputType.FILE);
		File f2 = new File("C:\\Users\\prasanth murugan\\eclipse-workspace\\Maven_Project\\Screenshot\\adac.png");
		FileHandler.copy(f1, f2);
	}

}

package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Reports_spindle extends BasePage{

	public Reports_spindle(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By spindlerep = By.xpath("//span[text()=' Spindle Run Time ']");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By operation = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[3]");
	private By mechlist = By.xpath("(//span[text()=' TL-01 '])/ancestor::div[1]/mat-option");
	private By monthmm = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[3]");
	private By monthlist = By.xpath("//span[text()=' JANUARY ']/ancestor::div[1]/mat-option");
	private By yearyy = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[3]");
	private By yearlist = By.xpath("(//span[text()=' 2022 '])/ancestor::div[1]/mat-option");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By head = By.xpath("//table/thead/tr/th");
	public void oee() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(Oee, 20);
			click(Oee);
			System.out.println("Oee option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/oee/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for Oee home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void rep() {
		try {
			waittobeclickable(reports, 20);
			click(reports);
			System.out.println("report button is clicked");
			waittobeclickable(spindlerep, 20);
			click(spindlerep);
			System.out.println("spindle runtime report option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/spindle-run-time-reports";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			log.info("Assert verification is done for spindle runtime reports page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void dd() {
		try {
			click(machine);
			List<WebElement> l2 = findWebElements(mechlist);
			l2.get(1).click();
			click(monthmm);
			Thread.sleep(500);
			List<WebElement> l5 = findWebElements(monthlist);
			l5.get(6).click();
			click(yearyy);
			List<WebElement> l6 = findWebElements(yearlist);
			l6.get(1).click();
			click(search);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		waittobeclickable(profile, 10);
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
	public void table() {
		try {
			Thread.sleep(1000);
			List<WebElement> h = findWebElements(head);
			List<String> s = new LinkedList<String>();
			String data = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
			if((h.get(1).getText()).contains("01")){
				
				System.out.println("Table has correct start date");
				}else {
					log.info("Table header start date is wrong");
				}

			if((h.get(h.size()-1).getText()).equals(data)){
				
			System.out.println("Table has correct end date");
			}else {
				log.info("Table header last date is wrong");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
}

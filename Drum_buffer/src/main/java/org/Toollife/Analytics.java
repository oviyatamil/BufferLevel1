package org.Toollife;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Analytics extends BasePage {

	public Analytics(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By tool = By.xpath("//div[text()='Tool Life Management']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By alert = By.xpath("//span[contains(text(),'Alert Report')]");
	private By manage = By.xpath("//span[contains(text(),'Tool Management')]");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']/img");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By machinelist = By.xpath("//span[text()=' TL-01 ']/ancestor::div[1]/mat-option");
	private By datas = By.xpath("//table/tbody/tr/td");
	private By text = By.xpath("//mat-label[text()='Machine']/ancestor::div[1]/descendant::div[2]/span[1]/span");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");

	public void tool() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(tool, 20);
			click(tool);
			System.out.println("Toollife option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/ToolLife/dashboard";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for Toollife home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void alert() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(alert, 20);
			click(alert);
			System.out.println("alert option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/ToolLife/alertreport";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for alert page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void dd() {
		try {
			
			click(machine);
			List<WebElement> l = findWebElements(machinelist);
			for (int i = 1; i < l.size(); i++) {
				Thread.sleep(500);
				if (i == 1) {
					l.get(i).click();
					click(apply);
				} else {
					click(machine);
					l.get(i).click();
					click(apply);
				}
				Thread.sleep(2000);
				List<WebElement> l2 = findWebElements(datas);
				if (l2.get(0).getText().contains("No Records")) {
					System.out.println("No records were displayed for " + gettext(text));
				} else {
					System.out.println("Records displayed for "+gettext(text));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void management() {
		try {
			Thread.sleep(2000);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(alert, 20);
			click(manage);
			System.out.println("Toollife option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/ToolLife/management";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Tool management page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void data() {
		try {
			Thread.sleep(1000);
			click(smartdrum);
			
			Thread.sleep(500);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			calendar(calendar, yeardd, year, startdate);
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
			click(machine);
			List<WebElement> l = findWebElements(machinelist);
			for (int i = 1; i < l.size(); i++) {
				Thread.sleep(500);
				if (i == 1) {
					l.get(i).click();
					click(apply);
					Thread.sleep(1000);
				} else {
					click(machine);
					l.get(i).click();
					click(apply);
					Thread.sleep(1000);
				}
				List<WebElement> l2 = findWebElements(datas);
				Thread.sleep(1000);
				if (l2.get(0).getText().contains("No Records")) {
					log.info("No records were displayed for " + gettext(text));
					Thread.sleep(500);
				} else {
					System.out.println("Records displayed for "+gettext(text));
					Thread.sleep(500);
				}
			}
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

}

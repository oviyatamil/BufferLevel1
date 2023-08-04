package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Alerts extends BasePage{

	public Alerts(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By alerts = By.xpath("//span[contains(text(),'Alert')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By alert = By.xpath("(//span[contains(text(),'Alert')])[2]");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By enddate = By.xpath("//div[text()=' 18 ']/parent::button");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By text = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By datas = By.xpath("//table/tbody/tr/td");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to Excel']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	
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

	public void alerts() {
		try {
			waittobeclickable(alerts, 10);
			click(alerts);
			System.out.println("Alerts button is clicked");
			waittobeclickable(alert, 20);
			click(alert);
			System.out.println("alert option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/alerts";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			log.info("Assert verification is done for alert page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void calendar() {
		try {
			calendar(calendar, yeardd, year, startdate);
			click(search);
			System.out.println("Calendar date is selected");
			waittobeclickable(equipdd, 20);
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for (int i = 1; i < list.size(); i++) {				
				list.get(i).click();
				Thread.sleep(500);
				System.out.println(gettext(text));
				List<WebElement> msg = findWebElements(datas);
				for(WebElement tab:msg) {
					System.out.println(tab.getText());
				}
				System.out.println("*********");
				if(i<list.size()-1) {
				click(equipdd);
			}else {
				break;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void profile() {
		click(pdf);
		System.out.println("pdf is downloaded");
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
}

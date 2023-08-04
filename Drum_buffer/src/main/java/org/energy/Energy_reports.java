package org.energy;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Energy_reports extends BasePage{

	public Energy_reports(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[text()='Energy Monitoring']");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By enreport = By.xpath("//span[contains(text(),'Daily Report')]");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[18]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By table = By.xpath("//table/tbody/tr/td[2]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(energy, 20);
			click(energy);
			System.out.println("Energy monitoring option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.careworx.in/#/energy/Home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Energy monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void report() {
		try {
			waittobeclickable(reports, 20);
			click(reports);
			System.out.println("Reports menu is clicked");
			waittobeclickable(enreport, 20);
			click(enreport);
			System.out.println("Energy reports option is clicked");
			Thread.sleep(1000);
			String ExpectedURL = "https://portal.careworx.in/#/energy/meter-reports";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Reports -> daily reports");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			calendar(calendar, yeardd, year, startdate);
			Thread.sleep(1000);
			click(dd);
			List<WebElement> l = findWebElements(ddlist);
			for(int i=1;i<l.size();i++) {
				if (i>1) {
					click(dd);
				}
					l.get(i).click();				
				click(apply);
				Thread.sleep(3000);
				if(findWebElement(table).isDisplayed()!=true) {
					log.info("Table is not displayed for "+gettext(txt));					
				}else {
					System.out.println("Table is displayed for "+gettext(txt));
				}
				Thread.sleep(1000);
}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
	
	
	
}

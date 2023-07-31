package org.fire;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Monitor extends BasePage {

	public Monitor(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By fire = By.xpath("//div[text()='Fire Safety Monitoring']");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By monitoring = By.xpath("//span[contains(text(),' Monitoring ')]");
	private By firemonitoring = By.xpath("//span[contains(text(),' Fire Monitoring ')]");
	private By report = By.xpath("//span[contains(text(),' Report ')]");
	private By chart = By.xpath("(//*[local-name()='g'])[1]//*[local-name()='image'][1]");

	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By location = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By loclist = By.xpath("//div[@role='listbox']/mat-option");
	private By table = By.xpath("//table/tbody/tr/td");
	private By ddtext = By.xpath("//mat-select[@role='combobox']/div/div/span/span[1]");
	private By loctext = By.xpath("(//mat-select[@role='combobox'])[2]/div/div/span/span[1]");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[18]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");	
	private By enddate = By.xpath("//div[text()=' 21 ']/parent::button");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void fire() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(fire, 20);
			click(fire);
			System.out.println("Oee option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.careworx.in/#/fire/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Fire monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void monitor() {
		try {
			click(monitoring);
			click(firemonitoring);
			Thread.sleep(1000);
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			for(int t=0;t<list.size();t++) {
				if(t>0) {
					click(dd);
					list.get(t).click();
				}else {
				list.get(t).click();
				}
				click(apply);
				click(location);
				Thread.sleep(500);
				List<WebElement> list2 = findWebElements(loclist);
				for(int i=0;i<list2.size();i++) {
					if(i>0) {
						Thread.sleep(500);
						click(location);
						list2.get(i).click();
					}else {
						
						list2.get(i).click();
					}
					click(apply);
					Thread.sleep(1000);
					if(findWebElement(chart).isDisplayed()!=true) {
						log.info("Chart not displayed for "+findWebElement(ddtext).getText()+" ---- "+findWebElement(loctext).getText());
						}
						else {
							System.out.println("Chart displayed for "+findWebElement(ddtext).getText()+" ---- "+findWebElement(loctext).getText());

						}
					
				}
				Thread.sleep(1000);
				
}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

}
	public void report() {
		try {
			Thread.sleep(1000);
			click(monitoring);
			click(report);
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.careworx.in/#/fire/report";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for report page");
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			list.get(1).click();
			calendar(calendar, yeardd, year, startdate);
			System.out.println("Calendar date is selected");
			if(findWebElement(table).getText().contains("No Record Found")){
				System.out.println("No records found");
			}else {
				System.out.println("Record found");
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

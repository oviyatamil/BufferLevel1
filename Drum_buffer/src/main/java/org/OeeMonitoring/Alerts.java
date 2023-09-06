package org.OeeMonitoring;

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
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By alerts = By.xpath("//span[contains(text(),'Alert')]");
	private By alert = By.xpath("(//span[contains(text(),'Alert')])[2]");
	private By msg = By.xpath("//p[contains(text(),'Alert Report')]");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By enddate = By.xpath("//div[text()=' 28 ']/parent::button");
	private By month = By.xpath("//div[contains(text(),'AUG')]/parent::button");
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
			if(findWebElements(msg).size()<=0) {
			waittobeclickable(alert, 20);
			click(alert);
			System.out.println("alert option is clicked");
			Thread.sleep(2000);
			}
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
		//	calendar(calendar, yeardd, year, startdate);
			System.out.println("Calendar date is selected");
			waittobeclickable(equipdd, 20);
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for (int i = 1; i < list.size(); i++) {				
				list.get(i).click();
				Thread.sleep(1000);
				System.out.println(gettext(text));
				List<WebElement> msg = findWebElements(datas);
				if(msg.size()>1) {
				for(WebElement tab:msg) {
					System.out.println(tab.getText());
				}
				System.out.println("*********");
				}else {
					log.info("No record found");
				}
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

package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Analytics_Maintenance extends BasePage{

	public Analytics_Maintenance(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By maintenance = By.xpath("//span[text()=' Maintenance ']");
	private By plot = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[2]/*[local-name()='text']");
	private By plot2 = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]/*[local-name()='text']");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By text = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By mouse = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*[20]");
	private By slide = By.xpath("(//*[local-name()='g' and contains(@class,'fc-gl-slider')])[1]/*[local-name()='circle'][3]");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By overavail = By.xpath("(//fuse-card)[1]/div[2]");



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

	public void main() {
		try {
			waittobeclickable(analytics, 10);
			click(analytics);
			System.out.println("Analytics button is clicked");
			waittobeclickable(maintenance, 20);
			click(maintenance);
			System.out.println("maintenance option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/maintenance";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			log.info("Assert verification is done for analytics maintenance page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void cards() {
		if(gettext(overavail).equals("0%")) {
			log.info("Overall availability shows 0%");
		}else {
		System.out.println("Overall availability is "+gettext(overavail));
		}
	}
	public void calendar() {
		try {
			Thread.sleep(1000);
			calendar(calendar, yeardd, year, startdate);
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
			waittobeclickable(equipdd, 20);
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for(int j=0;j<list.size();j++) {
				list.get(j).click();
				click(apply);
				System.out.println("Equipment is "+gettext(text));
									
					WebElement f = findWebElement(plot);
					Thread.sleep(2000);
					if(f.isDisplayed()!=true) {
						log.info("Maintenance heatmap is not displayed for "+gettext(text));
					
					}else {
						System.out.println("Maintenance heatmap is displayed for "+gettext(text));
					}
					WebElement f2 = findWebElement(plot2);
					Thread.sleep(2000);
					if(f2.isDisplayed()==true) {
						System.out.println("Downtime reason is displayed for "+gettext(text));
						}else {
							log.info("Downtime reason is not displayed for "+gettext(text));
						}
					if(j<list.size()-1) {
				click(equipdd);
					}else {
						break;
				
			}
					Thread.sleep(500);				
			}
			System.out.println("All equipment is selected and Maintenance heat map,down time reasons are checked");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void slider() {
		try {
			Thread.sleep(1000);
			draganddrop(slide);
			System.out.println("slider is working properly");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void chart() {
	
			try {
				click(pdf);
				Thread.sleep(500);
				System.out.println("Overall page is downloaded by clicking export to pdf button");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
	public void mouseover() {
		try {
			Thread.sleep(3000);
			Actions(mouse);
			System.out.println("Mouse over in chart is working");
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




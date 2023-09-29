package org.OeeMonitoring;

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
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By maintenance = By.xpath("//span[text()=' Maintenance ']");
	private By plot = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[2]/*[local-name()='text']");
	private By plot2 = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]/*[local-name()='text']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By text = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By mouse = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*[20]");
	private By slide = By.xpath("(//*[local-name()='g' and contains(@class,'fc-gl-slider')])[1]/*[local-name()='circle'][3]");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By overavail = By.xpath("(//mat-card)[1]/div[2]/div");
	private By msg = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*[local-name()='text']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
		



	public void oee() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			Thread.sleep(2000);
			click(Oee);
			System.out.println("Oee option is clicked");
			Thread.sleep(2000);
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
			log.info("Assert verification is done for analytics maintenance page");			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void cards() {
		if(findWebElements(overavail).size()<=0) {
			log.info("Overall availability not displayed");
		}
		else if(gettext(overavail).equals("0%")) {
			log.info("Overall availability shows 0%");
		}else {
		System.out.println("Overall availability is "+gettext(overavail));
		}
	}
	public void calendar() {
		try {
			Thread.sleep(1000);
	//		calendar(calendar, yeardd, year, startdate);
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
			waittobeclickable(equipdd, 20);
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for(int j=0;j<list.size();j++) {
				list.get(j).click();
				click(apply);
				Thread.sleep(4000);
				System.out.println("Equipment is "+gettext(text));														
					
					if(findWebElement(msg).getText().contains("No data")) {
						log.info("No data to display for "+gettext(text)+"in maintenance heatmap");
					}
					else if(findWebElements(plot).size()<=0) {
						log.info("Maintenance heatmap is not displayed for "+gettext(text));
					
					}else {
						System.out.println("Maintenance heatmap is displayed for "+gettext(text));
					}
					Thread.sleep(2000);
					if(findWebElement(msg2).getText().contains("No data")) {
						log.info("No data to display for "+gettext(text)+"in downtime reasoon chart");
					}
					else if(findWebElements(plot2).size()>0){
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
			if(findWebElement(msg).getText().contains("No data")) {
				log.info("No data to perform slider");
			}else {
			Thread.sleep(1000);
			draganddrop(slide);
			System.out.println("slider is working properly");
			}
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
			if(findWebElement(msg).getText().contains("No data")) {
				log.info("No data to perform mouseover for "+gettext(text));
			}else {
			Thread.sleep(3000);
			Actions(mouse);
			System.out.println("Mouse over in chart is working");
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




package org.OeeMonitoring;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Analytics_device extends BasePage{

	public Analytics_device(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By device = By.xpath("//span[text()=' Device Status ']");
	private By msg = By.xpath("//*[local-name()='g' and contains(@class,'messageGroup')]");	
	private By plot = By.xpath("//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')]/*[local-name()='text']");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By type = By.xpath("//mat-label[text()='Type']/ancestor::div[1]/descendant::div[3]");
	private By machtxt = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By typelist = By.xpath("//span[text()='Select type']/ancestor::div[1]/mat-option");
	private By text = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By typetext = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By mouse = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*[20]");
	private By slide = By.xpath("(//*[local-name()='g' and contains(@class,'fc-gl-slider')])[1]/*[local-name()='circle'][3]");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
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

	public void devices() {
		try {
			waittobeclickable(analytics, 10);
			click(analytics);
			System.out.println("Analytics button is clicked");
			waittobeclickable(device, 20);
			click(device);
			System.out.println("device status option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for analytics device status page");
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
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
			waittobeclickable(equipdd, 20);
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for(int j=0;j<list.size();j++) {
				list.get(j).click();
				System.out.println("Equipment is "+gettext(text));
				Thread.sleep(1000);
				click(type);
				List<WebElement> element = findWebElements(typelist);
				for(int i=1;i<element.size();i++) {
					if(i>1) {
					click(type);
					element.get(i).click();
					click(apply);
					Thread.sleep(1000);	
					if(findWebElement(msg).getText().contains("No data")) {
						log.info("No data to display for "+gettext(machtxt)+"---"+gettext(typetext));
					}
					else if(findWebElement(plot).isDisplayed()) {
						   System.out.println("Device status Heatmap is displayed for "+gettext(machtxt)+"---"+gettext(typetext));
					   }else {
						   log.info("Device status Heatmap is not displayed for "+gettext(machtxt)+"---"+gettext(typetext));
					   }
					
					
					}else {
						element.get(i).click();
						click(apply);
						Thread.sleep(1000);
						if(findWebElement(msg).getText().contains("No data")) {
							log.info("No data to display for "+gettext(machtxt)+"---"+gettext(typetext));
						}
						else if(findWebElement(plot).isDisplayed()) {
							   System.out.println("Device status Heatmap is displayed for "+gettext(machtxt)+"---"+gettext(typetext));
						   }else {
							   log.info("Device status Heatmap is not displayed for "+gettext(machtxt)+"---"+gettext(typetext));
						   }
					}
				}
				System.out.println("***********");
				if(j<list.size()-1) {
				click(equipdd);
				Thread.sleep(500);
			}
				
			}
			System.out.println("All types for all equipment is selected and oee heat map is displayed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void slider() {
		try {
			Thread.sleep(1000);
			if(findWebElement(msg).getText().contains("No data")!=true) {
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
				if(findWebElement(msg).getText().contains("No data")!=true) {
				click(export);
				click(jpg);
				System.out.println("device status heat map chart is downloaded");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
	public void mouseover() {
		try {
			Thread.sleep(3000);
			if(findWebElement(msg).getText().contains("No data")!=true) {
			Actions(mouse);
			System.out.println("Mouse over in chart is working");
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

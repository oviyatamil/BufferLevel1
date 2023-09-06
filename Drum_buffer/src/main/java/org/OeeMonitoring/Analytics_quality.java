package org.OeeMonitoring;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import com.BasePage.BasePage;

public class Analytics_quality extends BasePage {

	public Analytics_quality(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By quality = By.xpath("//span[text()=' Quality ']");
	private By bar = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[3]/*[local-name()='rect']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[4]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By text = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By msg = By.xpath("//*[local-name()='g' and contains(@class,'messageGroup')]/*[local-name()='text']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	private By msg3 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[3]/*[local-name()='text']");
	private By msg4 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[4]/*[local-name()='text']");
	private By mouse = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*[20]");
	private By slide = By
			.xpath("(//*[local-name()='g' and contains(@class,'fc-gl-slider')])[1]/*[local-name()='circle'][3]");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By plot = By
			.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[2]/*[local-name()='text']");
	private By pareto = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[5]/*[local-name()='rect']");
	private By pareto2 = By
			.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[11]/*[local-name()='path']");
	private By overquality = By.xpath("(//mat-card)[1]/descendant::div[4]");
	private By totrej = By.xpath("(//mat-card)[3]/descendant::div[4]");

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

	public void quality() {
		try {
			waittobeclickable(analytics, 10);
			click(analytics);
			System.out.println("Monitoring button is clicked");
			waittobeclickable(quality, 20);
			click(quality);
			System.out.println("quality option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for analytics quality page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void calendar() {
		try {
			Thread.sleep(1000);
		//	calendar(calendar, yeardd, year, startdate);
		//	Thread.sleep(1000);
			System.out.println("Calendar date is selected");			
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for (int j = 1; j < list.size(); j++) {
				list.get(j).click();
				Thread.sleep(2000);
				System.out.println(gettext(text));
				if(findWebElement(msg).getText().contains("No data")) {
					log.info("Quality  heatmap is not displayed for " + gettext(text));		
				}
				else if (findWebElement(plot).isDisplayed()!=true) {
					log.info("Quality  heatmap is not displayed for " + gettext(text));					
				} else {
					System.out.println("Quality heatmap is displayed for " + gettext(text));					
				}
				if(findWebElement(msg2).getText().contains("No data")) {
					log.info("Bar chart for machine wise rejection units is not displayed for " + gettext(text));
				}
				else if (findWebElements(bar).size()<=1) {
					log.info("Bar chart for machine wise rejection units is not displayed for " + gettext(text));					
				}
				 else {
					System.out.println("Bar chart for machine wise rejection units is displayed for " + gettext(text));
				}
				if(findWebElement(msg3).getText().contains("No data")) {
					log.info("Pareto chart for rejection-machine wise is not displayed for " + gettext(text));
				}
				else if (findWebElement(pareto).isDisplayed()!=true) {
					log.info("Pareto chart for rejection-machine wise is not displayed for " + gettext(text));
					
				} else {
					System.out.println("Pareto chart for rejection-machine wise is displayed for " + gettext(text));
				}
				if(findWebElement(msg4).getText().contains("No data")) {
					log.info("Pareto chart for reason wise rejection is not displayed for " + gettext(text));					
				}
				else if (findWebElement(pareto2).isDisplayed()!=true) {
					log.info("Pareto chart for reason wise rejection is not displayed for " + gettext(text));					
				} else {
					System.out.println("Pareto chart for reason wise rejection is displayed for " + gettext(text));
				}
				if (j < list.size() - 1) {
					click(equipdd);
					Thread.sleep(500);
				} else {
					break;
				}
			}
			log.info("All types for all equipment is selected and quality heat map is displayed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void slider() {
		try {
			if(findWebElement(msg).getText().contains("No data")!=true) {
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
//				click(pdf);
			Thread.sleep(500);
			if(findWebElement(msg).getText().contains("No data")!=true) {
//				log.info("Overall page is downloaded by clicking export to pdf button");
			click(export);
			click(jpg);
			System.out.println("quality heat map chart is downloaded");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void displaycards() {
		
		System.out.println("Overall quality percentage is " + gettext(overquality));

		System.out.println("Overall rejected quantity is " + gettext(totrej));

		System.out.println("Overall quality percentage and rejected quantities for all equipments are displayed");
	}
	

	public void mouseover() {
		try {
			if(findWebElement(msg).getText().contains("No data")!=true) {
			Thread.sleep(3000);
			Actions(mouse);
			System.out.println("Mouse over in chart is working");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void pareto() {
		try {
			Thread.sleep(1000);
			if(findWebElement(msg3).getText().contains("No data")!=true) {							
				List<WebElement> l = findWebElements(pareto);
				Actions a = new Actions(driver);
				for (WebElement x : l) {
					a.moveToElement(x).perform();
					Thread.sleep(500);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void paret() {
		try {
			List<WebElement> l = findWebElements(pareto2);
			if(findWebElement(msg4).getText().contains("No data")!=true) {
				Actions a = new Actions(driver);
				for (WebElement x : l) {
					a.moveToElement(x).perform();
					Thread.sleep(50);
				}
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

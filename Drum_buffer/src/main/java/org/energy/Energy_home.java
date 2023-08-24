package org.energy;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import com.BasePage.BasePage;

public class Energy_home extends BasePage {

	public Energy_home(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[text()='Energy Monitoring']");
	private By msg = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*[local-name()='text']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	private By msg3 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[3]/*[local-name()='text']");
	private By msg4 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[4]/*[local-name()='text']");
	private By pie1 = By.xpath(
			"(//*[local-name()='g' and contains(@class,'pie-label')])[1]/*[local-name()='g']/*[local-name()='text']");
	private By pie2 = By.xpath(
			"(//*[local-name()='g' and contains(@class,'pie-label')])[2]/*[local-name()='g']/*[local-name()='text']");
	private By category = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
	private By charts = By.xpath("(//*[local-name()='g' and contains(@class,'crosslineBottom')])[5]");
	private By chartss = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[4]/*[local-name()='text']");
	private By kpi = By.xpath("//span[text()=' KPI ']");
	private By home = By.xpath("//span[contains(text(),'Home')]");
	private By epi = By.xpath("//span[text()=' EPI ']");
	private By area = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]");
	private By beds = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[3]/*[local-name()='path']");
	private By equiplist = By.xpath("//span[text()='Select Site']/ancestor::div[1]/mat-option");
	private By equipdd = By.xpath("//mat-select[@role='combobox']/ancestor::div[1]/descendant::div[4]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By text = By.xpath("//mat-select[@role='combobox']/descendant::div[2]/span/span");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']/parent::div");
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
//			String ExpectedURL = "https://portal.careworx.in/#/energy/Home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Energy monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void charts() {
		try {
			Actions a = new Actions(driver);
			click(home);
			Thread.sleep(2000);	
			click(equipdd);
			List<WebElement> l = findWebElements(equiplist);
			for(int i=1;i<l.size();i++) {
				if(i>1) {
					click(equipdd);
				}
					l.get(i).click();
					click(apply);
			Thread.sleep(4000);	
			if(findWebElement(msg).getText().contains("No data to display")) {
				log.info("Pie chart based on month wise energy consymption not displyed for "+gettext(text));
			}
			else {
				System.out.println("Chart is displayed for "+gettext(text)+"  month wise energy consymption");
				List<WebElement> chart = findWebElements(pie1);			
				for (WebElement x : chart) {
					a.moveToElement(x).perform();
					Thread.sleep(200);
				}
			}
			if(findWebElement(msg2).getText().contains("No data to display")) {
				log.info("Pie chart based on category wise energy consymption not displyed for "+gettext(text));
			}
			else {
				System.out.println("Chart is displayed for "+gettext(text)+"  category wise energy consymption");
				List<WebElement> cat = findWebElements(category);
				for (WebElement x : cat) {
					a.moveToElement(x).perform();
					Thread.sleep(200);
				}
			}
			if(findWebElement(msg4).getText().contains("No data to display")) {
				log.info("Chart based on Energy consumption analyser not displyed for "+gettext(text));
			}
			else {
				System.out.println("Chart is displayed for "+gettext(text)+"  Energy consumption analyser");
			}
			if(findWebElement(msg3).getText().contains("No data to display")) {
				log.info("Pie chart based on floor wise energy consymption not displyed for "+gettext(text));
			}
			else {
				System.out.println("Chart is displayed for "+gettext(text)+"  floor wise energy consymption");
				List<WebElement> pie = findWebElements(pie2);
				for (WebElement x : pie) {
					a.moveToElement(x).perform();
					Thread.sleep(200);
				}
			}
			
//			if(findWebElement(pie1).isDisplayed()) {
//				System.out.println("Chart is displayed for "+gettext(text)+"  month wise energy consymption");
//			}else {
//				log.info("Pie chart based on month wise energy consymption not displyed for "+gettext(text));
//			}
//			if(findWebElement(category).isDisplayed()) {
//				System.out.println("Chart is displayed for "+gettext(text)+" cataegory wise energy consumption");
//			}else {
//				log.info("Chart based on cataegory wise energy consumption not displyed for "+gettext(text));
//			}
//			if(findWebElement(pie2).isDisplayed()) {
//				System.out.println("Chart is displayed for "+gettext(text)+" floor wise energy consumption");
//			}else {
//				log.info("Chart based on floor wise energy consumption not displyed for "+gettext(text));
//			}
			}
//			List<WebElement> chart = findWebElements(pie1);
//			Actions a = new Actions(driver);
//			for (WebElement x : chart) {
//				a.moveToElement(x).perform();
//				Thread.sleep(200);
//			}
//			List<WebElement> cat = findWebElements(category);
//			for (WebElement x : cat) {
//				a.moveToElement(x).perform();
//				Thread.sleep(200);
//			}
			System.out.println("Mouseover works in category wise  chart and data is displayed");
//			List<WebElement> pie = findWebElements(pie2);
//			for (WebElement x : pie) {
//				a.moveToElement(x).perform();
//				Thread.sleep(200);
//			}
//			System.out.println("Mouseover works in floor wise pie chart and data is displayed");
//			if(findWebElement(chartss).getText().contains("No data to display")) {
//				log.info("Chart not displayed ");
//			}else {
//				System.out.println("Chart displayed");
//				draganddrop(charts);
//			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void epi() {
		try {
			waittobeclickable(kpi, 20);
			click(kpi);
			System.out.println("Kpi menu is clicked");
			waittobeclickable(epi, 20);
			click(epi);
			System.out.println("Epi option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/EPI";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for energy Kpi page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void chart2() {
		try {
			Thread.sleep(500);
			click(equipdd);
			List<WebElement> l = findWebElements(equiplist);
			for(int i=1;i<l.size();i++) {
				if(i>1) {
					Thread.sleep(500);
					click(equipdd);
				}
					l.get(i).click();
					click(apply);
				Thread.sleep(3000);
				if(findWebElement(msg).getText().contains("No data to display")) {
					log.info("EPI chart based on area not displyed for "+gettext(text));
				}
				else {
					System.out.println("Chart is displayed for "+gettext(text)+" EPI based on area");
				}
				if(findWebElement(msg2).getText().contains("No data to display")) {
					log.info("EPI chart based on no of beds not displyed for "+gettext(text));
				}
				else {
					System.out.println("Chart is displayed for "+gettext(text)+" EPI based on number of beds");
				}
				
//				if(findWebElement(area).isDisplayed()!=true) {
//					log.info("EPI chart based on area not displyed for "+gettext(text));					
//				}else {
//					System.out.println("Chart is displayed for "+gettext(text)+" EPI based on area");
//				}
//				if(findWebElement(beds).isDisplayed()!=true) {
//					log.info("EPI chart based on No of beds not displyed for "+gettext(text));
//				}else {					
//					System.out.println("Chart is displayed for "+gettext(text)+" EPI based on No of beds");
//				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		click(pdf);
		log.info("pdf is downloaded");
		click(profile);
		log.info("profile button is clicked");
		click(signout);
		log.info("signout button is clicked");
	}
}

package org.Oxygen;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Oxygen_reports extends BasePage{

	public Oxygen_reports(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By oxy = By.xpath("//div[contains(text(),'Oxygen Monitoring')]");
	private By custom = By.xpath("//span[contains(text(),'Custom Report')]");
	private By monthly = By.xpath("//span[contains(text(),'Oxygen Monthly Report')]");
	private By hourly = By.xpath("//span[contains(text(),'Oxygen Hourly Report')]");
	private By daily = By.xpath("//span[contains(text(),'Oxygen Daily Report')]");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By loc = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("//span[text()='Select Location']/ancestor::div[1]/mat-option");
	private By cat= By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By list = By.xpath("//span[text()='Select Site']/parent::mat-option/parent::div/mat-option");
	private By list2 = By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'All')]");
	private By list3 = By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'All')]");
	private By table = By.xpath("//table/tbody/tr/td");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By row = By.xpath("//table/tbody/tr");	
	private By search = By.xpath("//span[text()='Search']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(oxy, 20);
			click(oxy);
			System.out.println("Oxygen monitoring option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/oxygen/home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Oxygen monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void report() {
		try {
			waittobeclickable(custom, 20);
			click(custom);
			System.out.println("Custom menu is clicked");
			waittobeclickable(monthly, 20);
			click(monthly);
			System.out.println("Oxygen monthly option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Oxygen%20Monthly%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Custom -> Oxygen monthly report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void report2() {
		try {
			waittobeclickable(custom, 20);
			click(custom);
			System.out.println("Custom menu is clicked");
			waittobeclickable(hourly, 20);
			click(hourly);
			System.out.println("Oxygen hourly option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Oxygen%20Hourly%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Custom -> Oxygen hourly report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	public void report3() {
		try {
			waittobeclickable(custom, 20);
			click(custom);
			System.out.println("Custom menu is clicked");
			waittobeclickable(daily, 20);
			click(daily);
			System.out.println("Oxygen daily option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Oxygen-Daily%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Custom -> Oxygen daily report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	public void dd() {
		try {					
			click(loc);
			List<WebElement> l2 = findWebElements(loclist);
			l2.get(1).click();		
			click(cat);	
			Thread.sleep(500);
			click(list2);
			Thread.sleep(100);
			click(machine);
			Thread.sleep(500);
			click(list3);
		//	String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			calendar(calendar, yeardd, year, startdate);
			click(site);
			List<WebElement> l = findWebElements(list);
			for(int i=1;i<l.size();i++) {
				if(i>1) {
					click(site);	
				}
			l.get(i).click();	
			click(search);
			Thread.sleep(500);
			if(findWebElements(table).size()>1) {
				System.out.println("Table is displayed");
				String data2 = new SimpleDateFormat("dd-MMM").format(new Date());	
				List<WebElement> rows = findWebElements(row);
					WebElement text = driver.findElement(By.xpath("//table/tbody/tr["+(rows.size())+"]/td[5]"));		
				String text2 = text.getText();
				String[] split4 = text2.split(",");
				System.out.println(split4[1]);
				if(split4[1].contains(data2)) {
					System.out.println("Report end date is correct");
				}else {
					log.info("Report end date is wrong");
				}
			}else{
				log.info("Table is not displayed for "+gettext(txt));		
			}			
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd2() {
		try {			
			click(loc);
			List<WebElement> l2 = findWebElements(loclist);
			l2.get(1).click();
			click(cat);	
			Thread.sleep(500);
			click(list2);
			Thread.sleep(100);
			click(machine);
			Thread.sleep(500);
			click(list3);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			calendar(calendar, yeardd, year, startdate);
			click(site);
			List<WebElement> l = findWebElements(list);
			for(int i=1;i<l.size();i++) {
				if(i>1) {
					click(site);	
				}
			l.get(i).click();	
			click(search);
			Thread.sleep(500);
			if(findWebElements(table).size()>1) {
				System.out.println("Table is displayed");
				String data2 = new SimpleDateFormat("dd-MMM").format(new Date());	
				String[] split5 = data2.split("-");
				int sum = (Integer.parseInt(split5[0]))-1;
				String v = String.valueOf(sum);
				String h = v+"-"+split5[1];
				System.out.println("**************************");
				System.out.println(h);
				Thread.sleep(1000);
				List<WebElement> rows = findWebElements(row);
					WebElement text = driver.findElement(By.xpath("//table/tbody/tr["+(rows.size())+"]/td[5]"));		
				String text2 = text.getText();
				String[] split4 = text2.split(",");
				if(split4[1].contains(h)) {
					System.out.println("Report end date is correct");
				}else {
					log.info("Report end date is wrong");
				}
			}else{
				log.info("Table is not displayed for "+gettext(txt));		
			}		
			}
		} catch (NumberFormatException | InterruptedException e) {
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

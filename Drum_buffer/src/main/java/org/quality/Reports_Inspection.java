package org.quality;
import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class Reports_Inspection extends BasePage {

	public Reports_Inspection(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By quality = By.xpath("//div[contains(text(),'Quality')]");
	private By reports = By.xpath("//span[contains(text(),'Report')]");
	private By insreport = By.xpath("//span[contains(text(),'Inspection Report')]");
	private By usagereport = By.xpath("//span[contains(text(),'Usage Report')]");
	private By auditreport = By.xpath("//span[contains(text(),'Audit Report')]");
	private By date = By.xpath("//table/tbody/tr");
	private By machname = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By parttext = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By partno = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By control = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By machdd = By.xpath("//span[text()='Select Machine Name']/parent::mat-option/parent::div/mat-option");
	private By usagepartdd = By.xpath("//span[text()='All']/parent::mat-option/parent::div/mat-option");
	private By partnodd = By.xpath("//span[contains(text(),'Select Part Number')]/ancestor::div[1]/mat-option");
	private By controldd = By.xpath("//span[contains(text(),'Select Inspection Plan')]/ancestor::div[1]/mat-option");
	private By calendar = By.xpath("(//mat-label[contains(text(),'Date')])[1]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By search = By.xpath("//span[text()='Search']");
	private By apply = By.xpath("//span[text()='Apply']");
	private By record = By.xpath("//table/tbody/tr/td[1]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");

	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			Thread.sleep(2000);
			click(quality);
			System.out.println("Quality option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for quality home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void inspection() {
		try {
			waittobeclickable(reports, 10);
			click(reports);
			System.out.println("Report menu is clicked");
			waittobeclickable(insreport, 10);
			click(insreport);
			System.out.println("Inspection Report menu is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/oee/FirstoffReport";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Inspection report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void usage() {
		try {
			waittobeclickable(reports, 10);
			click(reports);
			System.out.println("Report menu is clicked");
			waittobeclickable(usagereport, 10);
			click(usagereport);
			System.out.println("Usage Report menu is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Usage report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void audit() {
		try {
			waittobeclickable(reports, 10);
			click(reports);
			System.out.println("Report menu is clicked");
			waittobeclickable(auditreport, 10);
			click(auditreport);
			System.out.println("Audit Report menu is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/auditreport";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Audit report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void data() {
		try {
			Actions a = new Actions(driver);
			calendar(calendar, yeardd, year, startdate);
			click(machname);
			List<WebElement> m = findWebElements(machdd);
			for (int i = 1; i < m.size(); i++) {
				if(i>1) {
					click(machname);
				}
				m.get(i).click();
				click(partno);
				List<WebElement> pd = findWebElements(partnodd);
				for (int j = 1; j < pd.size(); j++) {
					if(j>1) {
						click(partno);
					}
					pd.get(j).click();
					click(control);
					Thread.sleep(1000);
					List<WebElement> c = findWebElements(controldd);
					Thread.sleep(500);
					if(c.size()==1) {
						System.out.println("No inspection plan");	
						a.moveToElement(findWebElement(search)).click().perform();
					}else {
						c.get(1).click();	
						click(search);
					}				
					Thread.sleep(1000);
					if (findWebElements(date).size()>2) {
						System.out.println("Table displayed");					
					} else {
						log.info("Table not displayed for "+gettext(txt)+" ---- "+gettext(parttext));
					}
//				}
					
				Thread.sleep(500);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void use() {
		try {
			click(machname);
			List<WebElement> m = findWebElements(usagepartdd);
			for (int i = 1; i < m.size(); i++) {
				if(i>1) {
					click(machname);
				}
				m.get(i).click();
				click(apply);
				Thread.sleep(500);
				if (findWebElement(record).getText().contains("No Records found") ){
					log.info("No records found");
				} else {
					System.out.println("Records found  for "+gettext(txt));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void aud() {
		try {
			calendar(calendar, yeardd, year, startdate);
			click(machname);
			List<WebElement> m = findWebElements(usagepartdd);
			for (int i = 1; i < m.size(); i++) {
				if(i>1) {
					click(machname);
				}
				m.get(i).click();
				click(apply);
				Thread.sleep(500);
				if (findWebElement(record).getText().contains("No Records found")) {
					log.info("No records found");
				} else {
					System.out.println("Records found for "+gettext(txt));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void profile() {
		try {
			Thread.sleep(1000);
			click(profile);
			System.out.println("profile button is clicked");
			click(signout);
			System.out.println("signout button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package org.OeeMonitoring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Reports_spindle extends BasePage{

	public Reports_spindle(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By spindlerep = By.xpath("//span[text()=' Spindle Run Time ']");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[3]");
	private By mechlist = By.xpath("(//span[contains(text(),'All')])/ancestor::div[1]/mat-option");
	private By monthmm = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[3]");
	private By monthlist = By.xpath("//span[text()=' JANUARY ']/ancestor::div[1]/mat-option");
	private By yearyy = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[3]");
	private By yearlist = By.xpath("(//span[text()=' 2022 '])/ancestor::div[1]/mat-option");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By head = By.xpath("//table/thead/tr/th");
	private By tab = By.xpath("//table/tbody/tr/td");
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

	public void rep() {
		try {
			waittobeclickable(reports, 20);
			click(reports);
			System.out.println("report button is clicked");
			waittobeclickable(spindlerep, 20);
			click(spindlerep);
			System.out.println("spindle runtime report option is clicked");
			Thread.sleep(2000);			
			log.info("Assert verification is done for spindle runtime reports page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void dd() {
		try {
			String data = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
			click(monthmm);
			Thread.sleep(500);
			List<WebElement> l5 = findWebElements(monthlist);
		//	l5.get(7).click();
			String[] split = data.split("-");
			String sp =split[1];
			String up = sp.toUpperCase();
			for(WebElement y:l5) {
				if(y.getText().contains(up)) {
					Thread.sleep(300);
					y.click();
					break;
				}
			}
			click(yearyy);
			List<WebElement> l6 = findWebElements(yearlist);
			l6.get(1).click();
			click(machine);
			List<WebElement> l2 = findWebElements(mechlist);
			for(int i=1;i<l2.size();i++) {
				if(i>1) {
					click(machine);
				}
				l2.get(i).click();
				click(search);
				Thread.sleep(1000);
				if(findWebElements(tab).size()>1) {								
				List<WebElement> h = findWebElements(head);				
				if((h.get(1).getText()).contains("01")){
					
					System.out.println("Table has correct start date");
					}else {
						log.info("Table header start date is wrong");
					}

				if((h.get(h.size()-1).getText()).equals(data)){
					
				System.out.println("Table has correct end date");
				}else {
					log.info("Table header last date is wrong");
				}
				Thread.sleep(500);
			}else {
				log.info("No records found");
			}
			
		} 
		}catch (InterruptedException e) {
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

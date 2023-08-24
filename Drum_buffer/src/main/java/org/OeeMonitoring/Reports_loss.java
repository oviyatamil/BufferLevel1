package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Reports_loss extends BasePage {

	public Reports_loss(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By lossrep = By.xpath("//span[text()=' Loss Report ']");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By text = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");

	private By shift = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By shiftlist = By.xpath("(//span[text()='Shift 1'])/ancestor::div[1]/mat-option");
	private By operation = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[3]");
	private By mechlist = By.xpath("(//span[text()=' TL-01 '])/ancestor::div[1]/mat-option");
	private By filter = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[3]");
	private By filterlist = By.xpath("(//span[text()='Monthly'])/ancestor::div[1]/mat-option");
	private By operalist = By.xpath("(//span[text()=' Idle Time '])/ancestor::div[1]/mat-option");
	
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
//	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
//	private By enddate = By.xpath("//div[text()=' 18 ']/parent::button");
private By chart = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')][1]/*[local-name()='rect']");
private By chart2 = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')][5]");
	private By no = By.xpath("//table/tbody/tr/td");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By head = By.xpath("//table/thead/tr/th");
	private By data = By.xpath("//table/tbody/tr/td");
	
	
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

	public void rep() {
		try {
			waittobeclickable(reports, 10);
			click(reports);
			System.out.println("report button is clicked");
			waittobeclickable(lossrep, 20);
			click(lossrep);
			System.out.println("loss report option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/lossTime";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			log.info("Assert verification is done for loss time reports page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void dd() {
		try {
			calendar(calendar, yeardd, year, startdate);
			click(operation);
			List<WebElement> l3 = findWebElements(operalist);
			l3.get(0).click();
			click(filter);
			List<WebElement> l4 = findWebElements(filterlist);
			l4.get(0).click();
			click(shift);
			List<WebElement> l1 = findWebElements(shiftlist);
			l1.get(0).click();
			click(machine);
			List<WebElement> l2 = findWebElements(mechlist);
			for(int i=1;i<l2.size();i++) {
				if(i>1) {
					click(machine);
				}
			l2.get(i).click();			
			String datas = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + datas);
			Thread.sleep(1000);					
			System.out.println("Calendar date is selected");
			click(search);
			Thread.sleep(2000);
			List<WebElement> h = findWebElements(head);
			List<String> s1 = new LinkedList<String>();
			for(int k=1;k<h.size();k++) {
				String text = h.get(k).getText();
				s1.add(text);
			}
			List<WebElement> d = findWebElements(data);
			List<String> s2 = new LinkedList<String>();
			for(int k=1;k<d.size();k++) {
				String text = d.get(k).getText();
				s2.add(text);
			}
			if(findWebElements(no).size()<=1) {
				log.info("No records found for "+gettext(text));
			}else {
			for(int j=0;j<s1.size();j++) {
			System.out.println("Losstime report is "+s1.get(j)+" ------ "+s2.get(j));
			if(findWebElement(chart).isDisplayed()) {
				System.out.println("Loss time Chart is displayed");
			}else {
				log.info("Loss time chart is not displyed for "+gettext(text));
			}
			}			
			}
			Thread.sleep(1000);
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

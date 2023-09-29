package org.OeeMonitoring;

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
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By lossrep = By.xpath("//span[text()=' Loss Report ']");
	private By loc = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("(//span[text()='Select Location'])/ancestor::div[1]/mat-option");
	private By text = By.xpath("(//mat-select[@role='combobox'])[4]/descendant::span[2]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]");
	private By year = By.xpath("//div[text()=' 2023 ']");
	private By startdate = By.xpath("//div[contains(text(),'1')]/parent::button");
//	private By shift = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
//	private By shiftlist = By.xpath("(//span[text()='Shift 1'])/ancestor::div[1]/mat-option");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[3]");
	private By mechlist = By.xpath("(//span[contains(text(),'All')])/ancestor::div[1]/mat-option");
	private By opera = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[3]");
	private By filter = By.xpath("(//mat-select[@role='combobox'])[6]/ancestor::div[1]/descendant::div[3]");
	private By filterlist = By.xpath("(//span[text()='Monthly'])/ancestor::div[1]/mat-option");
	private By operalist = By.xpath("(//span[text()=' Idle Time '])/ancestor::div[1]/mat-option");
	
private By chart = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')][1]/*[local-name()='rect']");
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
			log.info("Assert verification is done for loss time reports page");			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void dd() {
		try {
			calendar(calendar, yeardd, year, startdate);
			click(loc);
			List<WebElement> l3 = findWebElements(loclist);
			l3.get(1).click();
			Thread.sleep(500);
			click(opera);
			List<WebElement> l4 = findWebElements(operalist);
			l4.get(0).click();
			Thread.sleep(300);
			click(filter);		
			List<WebElement> l1 = findWebElements(filterlist);
			l1.get(0).click();
			Thread.sleep(300);
			click(machine);		
			List<WebElement> l2 = findWebElements(mechlist);
			for(int i=1;i<l2.size();i++) {
				if(i>1) {
					click(machine);
				}
			l2.get(i).click();				
			Thread.sleep(200);
			click(search);
			String datas = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + datas);
			Thread.sleep(1000);					
			System.out.println("Calendar date is selected");			
			Thread.sleep(4000);
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

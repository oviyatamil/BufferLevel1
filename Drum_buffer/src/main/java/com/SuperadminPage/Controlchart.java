package com.SuperadminPage;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Controlchart extends BasePage{

	public Controlchart(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By superadmin = By.xpath("//div[contains(text(),'Super Admin')]/parent::div/button");
	private By control = By.xpath("//span[contains(text(),'Control Center')]");
	private By api = By.xpath("(//div[contains(text(),'API')])[2]/ancestor::div[2]/div[1]/div");
	private By job = By.xpath("(//div[contains(text(),'Job')])[2]/ancestor::div[2]/div[1]/div[1]");
	private By note = By.xpath("(//div[contains(text(),'Notifications')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By ts = By.xpath("(//div[contains(text(),'Sessions')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By gate = By.xpath("(//div[contains(text(),'Gateway')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By table = By.xpath("//table/tbody/tr/td");
	
	private By apimon = By.xpath("//div[contains(text(),'API Monitoring')]");
	private By devapi = By.xpath("(//div[contains(text(),'Device API')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By appapi = By.xpath("(//div[contains(text(),'Application API')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By intapi = By.xpath("(//div[contains(text(),'Integration API')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By error = By.xpath("(//div[contains(text(),'Error Exception')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By chart = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	
//	private By health = By.xpath("//div[contains(text(),'API Health Check')]");
//	private By cusdd = By.xpath("(//div[contains(text(),'Device API')])[1]/ancestor::div[2]/div[1]/div[1]");
//	private By cuslist = By.xpath("(//div[contains(text(),'Application API')])[1]/ancestor::div[2]/div[1]/div[1]");
//	private By sitedd = By.xpath("(//div[contains(text(),'Integration API')])[1]/ancestor::div[2]/div[1]/div[1]");
//	private By site = By.xpath("(//div[contains(text(),'Error Exception')])[1]/ancestor::div[2]/div[1]/div[1]");
//	private By productdd = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
//	private By prod = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
//	private By gatedd = By.xpath("(//span[text()='Export As JPG'])[1]");
//	private By gate = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
//	private By prod = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
//	private By gatedd = By.xpath("(//span[text()='Export As JPG'])[1]");	
//	private By productdd = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
//	private By prod = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
//	private By gatedd = By.xpath("(//span[text()='Export As JPG'])[1]");
	
	private By jobmon = By.xpath("//div[contains(text(),'Jobs Monitoring')]");
	private By hourjob = By.xpath("(//div[contains(text(),'Hourly Job')])[1]/ancestor::div[2]/div[1]/div[2]/div[2]");
	private By dailyjob = By.xpath("(//div[contains(text(),'Daily Job')])[1]/ancestor::div[2]/div[1]/div[2]/div[2]");
	private By monjob = By.xpath("(//div[contains(text(),'Monthly Job')])[1]/ancestor::div[2]/div[1]/div[2]/div[2]");
	private By yrjob = By.xpath("(//div[contains(text(),'Yearly Job')])[1]/ancestor::div[2]/div[1]/div[2]/div[2]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By cusdd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By cuslist = By.xpath("//span[text()='Select Customer']/parent::mat-option/parent::div/mat-option");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By site = By.xpath("//span[text()='Select site']/parent::mat-option/parent::div/mat-option");
	private By productdd = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By prod = By.xpath("//span[text()='Select Product']/parent::mat-option/parent::div/mat-option");
	private By gatedd = By.xpath("(//mat-select[@role='combobox'])[4]/descendant::div[4]");
	private By gatelist = By.xpath("//span[text()='Select Gateway']/parent::mat-option/parent::div/mat-option");
	private By freqdd = By.xpath("(//mat-select[@role='combobox'])[5]/descendant::div[4]");
	private By freqlist = By.xpath("//span[text()='Select Frequency']/parent::mat-option/parent::div/mat-option");
	private By calendar = By.xpath("//mat-label[contains(text(),'Time')]/following::span[1]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]");
	private By year = By.xpath("//div[text()=' 2023 ']");
	private By startdate = By.xpath("//div[contains(text(),'28')]/parent::button");
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])");
	private By gatename = By.xpath("//table/tbody/tr/td[2]/span");	
	private By time = By.xpath("//table/tbody/tr/td[5]/span");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 25 ']");
	private By arr = By.xpath("//table/thead/tr/th[5]/div/child::div[2]");
	private By search = By.xpath("//input[contains(@placeholder,'search')]");
	
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	

	public void home() {
			try {
				waittobeclickable(ninedots, 20);
				click(ninedots);
				System.out.println("Ninedots button is clicked");
				waittobeclickable(superadmin, 20);
				click(superadmin);
				System.out.println("Super admin menu option is clicked");
				Thread.sleep(2000);
				String ExpectedURL = "http://20.204.188.25/#/superadmin/home";
				String ActualURL = getCurrentURL();
				assertEquals(ExpectedURL, ActualURL);
				System.out.println("Assert verification is done for super admin home page");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	public void control() {
		try {
			waittobeclickable(control, 20);
			click(control);
			System.out.println("Super admin menu option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "http://20.204.188.25/#/superadmin/control-center;id=Control%20Center";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for control chart page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void submenu() {
		try {
			Thread.sleep(2000);
			if(findWebElement(api).getText().equals(" 0 ")) {
				log.info("Api count is zero");
			}else {
				System.out.println("Api count is "+gettext(api));
			}
			if(findWebElement(job).getText().equals(" 0 ")) {
				log.info("Job count is zero");
			}else {
				System.out.println("Job count is "+gettext(job));
			}
			if(findWebElement(note).getText().equals(" 0 ")) {
				log.info("Notification count is zero");
			}else {
				System.out.println("Notification count is "+gettext(note));
			}
			if(findWebElement(ts).getText().equals(" 0 ")) {
				log.info("Today session count is zero");
			}else {
				System.out.println("Today session count is "+gettext(ts));
			}
			if(findWebElement(gate).getText().equals(" 0 ")) {
				log.info("Gateway count is zero");
			}else {
				System.out.println("Gateway count is "+gettext(gate));
			}
			if(findWebElements(table).size()>1) {
				System.out.println("User details Table is displayed");
			}else {
				log.info("User details Table is not displayed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void api() {
		
		try {
			click(apimon);
			Thread.sleep(2000);
			if(findWebElement(devapi).getText().equals(" 0 ")) {
				log.info("Device api count is zero");
			}else {
				System.out.println("Device Api count is "+gettext(devapi));
			}
			if(findWebElement(appapi).getText().equals(" 0 ")) {
				log.info("Application api count is zero");
			}else {
				System.out.println("Application api count is "+gettext(appapi));
			}
			if(findWebElement(intapi).getText().equals(" 0 ")) {
				log.info("Integration api is zero");
			}else {
				System.out.println("Integration api count is "+gettext(intapi));
			}
			if(findWebElement(error).getText().equals(" 0 ")) {
				log.info("Error exception count is zero");
			}else {
				System.out.println("Error exception count is "+gettext(error));
			}
			if(findWebElement(chart).isDisplayed()!=true) {
				log.info("Chart not displayed");
			}else {
				System.out.println("Chart displayed");
				List<WebElement> ch = findWebElements(chart);
				for(WebElement x:ch) {
					move(x);
				}
				System.out.println("Data displays when mouseover is performed");
				click(export);
				click(jpg);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void jobmon() {
		try {
			click(jobmon);
			Thread.sleep(2000);
			log.info("Hourly job failed count is "+gettext(hourjob));		
			log.info("Daily job failed count is "+gettext(dailyjob));		
			log.info("Monthly job failed count is "+gettext(monjob));		
			log.info("Yearly job failed count is "+gettext(yrjob));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
	}
	public void add() {
		try {
			click(add);
			click(cusdd);
			List<WebElement> cu = findWebElements(cuslist);
			for(WebElement x:cu) {
				if(x.getText().contains("Work Customer 1")) {
					x.click();
					break;
				}
			}
			Thread.sleep(200);
			click(sitedd);		
			List<WebElement> s = findWebElements(site);			
			s.get(1).click();
			Thread.sleep(500);
			click(productdd);
			List<WebElement> p = findWebElements(prod);		
			p.get(1).click();
			Thread.sleep(500);
			click(gatedd);
			List<WebElement> g = findWebElements(gatelist);
			Thread.sleep(500);
			g.get(1).click();
			click(freqdd);
			List<WebElement> f = findWebElements(freqlist);
			Thread.sleep(500);
			f.get(1).click();
			Thread.sleep(1000);
			click(calendar);
			click(yeardd);
			click(year);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			String[] split = data.split(" ");
			String sp = split[0].toUpperCase();
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + sp + "')]/parent::button"));
			mon.click();
			click(startdate);
			click(save);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void chart() {
		if(findWebElement(chart).isDisplayed()!=true) {
			log.info("Product wise job monitoring chart is not displayed");
		}else {
			System.out.println("Product wise job monitoring chart is displayed");
		}
	}
	public void radio() {
		click(pagedd);
		click(pagesize);
		click(radio);
		click(view);
		click(cancelbtn);
		System.out.println("View option is checked");
		click(arr);
		String data = new SimpleDateFormat("MMM dd,yyyy").format(new Date());
		List<WebElement> ti = findWebElements(time);
		for(int i=0;i<ti.size();i++) {
				if(findWebElements(time).get(i).getText().contains(data)){
					if(findWebElements(gatename).get(i).getText().contains("Work")){
					List<WebElement> rad = findWebElements(radio);	
				rad.get(i).click();
				break;
					}else {
						continue;
					}
				}	
			click(edit);
			click(freqdd);
			List<WebElement> f = findWebElements(freqlist);
			f.get(2).click();
			click(update);
			System.out.println("Edit and Update option is checked");
			EnterText(search, "wor");
			List<WebElement> rad2 = findWebElements(radio);
			rad2.get(0).click();
			click(delete);
			click(delete2);
			System.out.println("Delete option is checked");
			break;	
				}
	}
		
	public void profile() {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
	
}

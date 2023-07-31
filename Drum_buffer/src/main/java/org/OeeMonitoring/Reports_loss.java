package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	private By machine = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[3]");
	private By shift = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By shiftlist = By.xpath("(//span[text()='Shift 1'])/ancestor::div[1]/mat-option");
	private By operation = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[3]");
	private By mechlist = By.xpath("(//span[text()=' TL-01 '])/ancestor::div[1]/mat-option");
	private By filter = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[3]");
	private By filterlist = By.xpath("(//span[text()='Monthly'])/ancestor::div[1]/mat-option");
	private By monthmm = By.xpath("(//mat-select[@role='combobox'])[6]/ancestor::div[1]/descendant::div[3]");
	private By monthlist = By.xpath("(//span[text()='JANUARY'])/ancestor::div[1]/mat-option");
	private By yearyy = By.xpath("(//mat-select[@role='combobox'])[7]/ancestor::div[1]/descendant::div[3]");
	private By yearlist = By.xpath("(//span[text()=' 2022 '])/ancestor::div[1]/mat-option");
	private By operalist = By.xpath("(//span[text()=' Idle Time '])/ancestor::div[1]/mat-option");
	private By text = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By loss = By.xpath("(//*[local-name()='g' and contains(@class,'dataset-axis')])[2]/*");
	private By losspercent = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[2]/*");
	private By chart1 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*");
	private By chart2 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[5]/*");
	
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
//	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
//	private By enddate = By.xpath("//div[text()=' 18 ']/parent::button");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By no = By.xpath("//table/tbody/tr/td");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By head = By.xpath("//table/thead/tr/th");
	private By data = By.xpath("//table/tbody/tr/td");
	private By row = By.xpath("//table/tbody/tr");
	
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
			click(shift);
			List<WebElement> l1 = findWebElements(shiftlist);
			l1.get(0).click();
			click(machine);
			List<WebElement> l2 = findWebElements(mechlist);
			l2.get(2).click();
			click(operation);
			List<WebElement> l3 = findWebElements(operalist);
			l3.get(0).click();
			click(filter);
			List<WebElement> l4 = findWebElements(filterlist);
			l4.get(0).click();
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			Thread.sleep(1000);
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + s + "')]/parent::button"));
			mon.click();
			click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m = split3[1];
			WebElement end = driver
					.findElement(By.xpath("//div[contains(text(),'" + m + "')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		click(search);
	}
	
	public void table() {
		try {
			Thread.sleep(2000);
			List<WebElement> h = findWebElements(head);
			List<String> s = new LinkedList<String>();
			for(WebElement x:h) {
				String txt = x.getText();
				s.add(txt);
			}
			List<WebElement> d = findWebElements(data);
			List<String> s2 = new LinkedList<String>();
			for(WebElement x2:d) {
				String txt2 = x2.getText();
				s2.add(txt2);
			}
			if(findWebElement(no).getText().contains("No Records Found")) {
				log.info("No records found");
			}else {
			for(int i=0;i<s.size();i++) {
			System.out.println("Losstime report is "+s.get(i)+" ------ "+s2.get(i));
			}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void losschart() {
		try {
			Thread.sleep(1000);
			if(findWebElement(chart1).isDisplayed()) {
				System.out.println("Pareto chart for loss reson is displayed");
			}else {
				log.info("Pareto chart for loss reson is not displayed");
			}
			if(findWebElement(chart2).isDisplayed()) {
				System.out.println("Loss time analysis chart is displayed");
			}else {
				log.info("Loss time analysis chart is not displayed");
			}
			Thread.sleep(1000);
			List<WebElement> l = findWebElements(loss);
			List<String> s = new LinkedList<String>();
			for(WebElement x:l) {
				String txt = x.getText();
				s.add(txt);
			}
			List<WebElement> lp = findWebElements(losspercent);
			List<String> s2 = new LinkedList<String>();
			for(WebElement x:lp) {
				String txt = x.getText();
				s2.add(txt);
			}
			for(int i=0;i<l.size();i++) {
				System.out.println("Losstime report is "+s.get(i)+" ------ "+s2.get(i));
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

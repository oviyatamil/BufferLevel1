package org.energy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Energy_custom extends BasePage{

	public Energy_custom(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[contains(text(),'Energy Monitoring')]");
	private By cusreports = By.xpath("//span[contains(text(),'Custom Report')]");
	private By consreport = By.xpath("//span[contains(text(),'Consumption Report')]");
	private By monthly = By.xpath("//span[contains(text(),'Energy Monthly Report')]");
	private By hourly = By.xpath("//span[contains(text(),'Energy Hourly Report')]");
	private By daily = By.xpath("//span[contains(text(),'Energy Daily Report')]");
	private By yearly = By.xpath("//span[contains(text(),'Energy Yearly Report')]");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/ancestor::div[1]/mat-option");
	private By loc = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("//span[text()='Select Location']/ancestor::div[1]/mat-option");
	private By cat= By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By catlist = By.xpath("//span[text()='All']/ancestor::div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Search')]");
	private By table = By.xpath("//table/tbody/tr/td[2]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By row = By.xpath("//table/tbody/tr");
	
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

	public void report() {
		try {
			waittobeclickable(cusreports, 20);
			click(cusreports);
			System.out.println("Custom reports menu is clicked");
			waittobeclickable(consreport, 20);
			click(consreport);
			System.out.println("consumption report option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Consumption%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for energy Custom -> consumption report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void report2() {
		try {
			waittobeclickable(cusreports, 20);
			click(cusreports);
			System.out.println("Custom reports menu is clicked");
			waittobeclickable(hourly, 20);
			click(hourly);
			System.out.println("Energy hourly report option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Energy%20Hourly%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for energy Custom -> Energy hourly report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	public void report3() {
		try {
			waittobeclickable(cusreports, 20);
			click(cusreports);
			System.out.println("Custom menu is clicked");
			waittobeclickable(daily, 20);
			click(daily);
			System.out.println("Energy daily option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Energy%20Daily%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Custom -> Energy daily report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	public void report4() {
		try {
			waittobeclickable(cusreports, 20);
			click(cusreports);
			System.out.println("Custom reports menu is clicked");
			waittobeclickable(yearly, 20);
			click(yearly);
			System.out.println("Energy yearly report option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Energy%20Yearly%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for energy Custom -> Energy yearly report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	public void report5() {
		try {
			waittobeclickable(cusreports, 20);
			click(cusreports);
			System.out.println("Custom reports menu is clicked");
			waittobeclickable(monthly, 20);
			click(monthly);
			System.out.println("Energy monthly report option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/custom/reports;id=Energy%20Monthly%20Report";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for energy Custom -> Energy monthly report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	
	public void dd2() {
		try {
			calendar(calendar, yeardd, year, startdate);		
				click(loc);
				List<WebElement> l2 = findWebElements(loclist);
				l2.get(1).click();	
				click(cat);
				Thread.sleep(500);
				List<WebElement> l3 = findWebElements(catlist);
				l3.get(0).click();
				Thread.sleep(500);
				click(machine);
				List<WebElement> l4 = findWebElements(catlist);
				l4.get(0).click();
				click(site);
				List<WebElement> l = findWebElements(sitelist);
				for(int i=1;i<l.size();i++) {
					if(i>1) {
						click(site);
					}
					l.get(i).click();
					
				click(apply);
				Thread.sleep(4000);
				if(findWebElement(table).isDisplayed()) {
					System.out.println("Table is displayed");
				}else {
					log.info("No records found");
				}
				}
			Thread.sleep(500);
	
			String data2 = new SimpleDateFormat("dd-MMM").format(new Date());	
			String[] split5 = data2.split("-");
			int sum = (Integer.parseInt(split5[0])) - 1;
			String v = String.valueOf(sum);
	 		String h = v+"-"+split5[1];
			System.out.println("**************************");
			System.out.println(h);
			List<WebElement> rows = findWebElements(row);
				WebElement text = driver.findElement(By.xpath("//table/tbody/tr["+rows.size()+"]/td[5]"));		
			String text2 = text.getText();
			String[] split4 = text2.split(",");
			System.out.println(split4[1]);
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(true);", text);
			if(split4[1].contains(h)) {
				System.out.println("Report end date is correct");
			}else {
				log.info("Report end date is wrong");
			}
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd3() {
		try {
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			calendar(calendar, yeardd, year, startdate);		
				click(loc);
				List<WebElement> l2 = findWebElements(loclist);
				l2.get(1).click();	
				click(cat);
				Thread.sleep(500);
				List<WebElement> l3 = findWebElements(catlist);
				l3.get(0).click();
				Thread.sleep(500);
				click(machine);
				List<WebElement> l4 = findWebElements(catlist);
				l4.get(0).click();
				click(site);
				List<WebElement> l = findWebElements(sitelist);
				for(int i=1;i<l.size();i++) {
					if(i==1) {
					l.get(i).click();
					}else {
						click(site);
						l.get(i).click();
					}
				click(apply);
				Thread.sleep(2000);
				if(findWebElement(table).isDisplayed()) {
					System.out.println("Table is displayed");
				}else {
					log.info("No records found");
				}
				}
			Thread.sleep(500);
			String data2 = new SimpleDateFormat("yyyy").format(new Date());
			List<WebElement> rows = findWebElements(row);
			WebElement text = driver.findElement(By.xpath("//table/tbody/tr["+(rows.size()-1)+"]/td[5]"));		
		if((text.getText()).equals(data2)) {
			System.out.println("Report end date is correct");
		}else {
			log.info("Report end date is wrong");
		}
	} catch (NumberFormatException | InterruptedException e) {
		e.printStackTrace();
	}
	}
	public void dd4() {
		
			try {
				String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
				System.out.println("Current timing is "+data);
				String[] split = data.split(" ");
				String s = split[0].toUpperCase();
				click(calendar);
				click(yeardd);
				click(year);
				WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'"+s+"')]/parent::button"));
				mon.click();	
				click(startdate);
				click(startdate);
//				String[] split2 = data.split(",");
//				String[] split3 = split2[0].split(" ");
//				String m =split3[1];	
//				int mn = Integer.parseInt(m);
//				WebElement end = driver.findElement(By.xpath("//div[contains(text(),'"+mn+"')]/parent::button"));
//				end.click();			
					click(loc);
					List<WebElement> l2 = findWebElements(loclist);
					l2.get(1).click();	
					click(cat);
					Thread.sleep(500);
					List<WebElement> l3 = findWebElements(catlist);
					l3.get(0).click();
					Thread.sleep(500);
					click(machine);
					List<WebElement> l4 = findWebElements(catlist);
					l4.get(0).click();
					click(site);
					List<WebElement> l = findWebElements(sitelist);
					for(int i=1;i<l.size();i++) {
						if(i>1) {
							click(site);
						}
						l.get(i).click();
						
					click(apply);
					Thread.sleep(10000);
					if(findWebElement(table).isDisplayed()) {
						System.out.println("Table is displayed");
					}else {
						log.info("No records found");
					}
					}
				Thread.sleep(500);
		
				String data2 = new SimpleDateFormat("dd-MMM").format(new Date());	
				List<WebElement> rows = findWebElements(row);
					WebElement text = driver.findElement(By.xpath("//table/tbody/tr["+(rows.size()-1)+"]/td[5]"));		
				String text2 = text.getText();
				String[] split4 = text2.split(",");
				if(split4[1].contains(data2)) {
					System.out.println("Report end date is correct");
				}else {
					log.info("Report end date is wrong");
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



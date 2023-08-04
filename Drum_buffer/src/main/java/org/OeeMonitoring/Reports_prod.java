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

public class Reports_prod extends BasePage {

	public Reports_prod(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By production = By.xpath("//span[text()=' Production Report ']");
	private By equiptext = By.xpath("//mat-label[text()='Functional Location']/ancestor::div[1]/descendant::div[2]/span[1]/span");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("(//span[text()=' Chennai '])/ancestor::div[1]/mat-option");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By location = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By locationlist = By.xpath("//span[text()=' TL-01 ']/ancestor::div[1]/mat-option");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By head = By.xpath("//table/thead/tr/th");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By enddate = By.xpath("//div[text()=' 20 ']/parent::button");
	private By daterep = By.xpath("//table/tr/th[3]");
	private By caltext = By.xpath("//input[@formcontrolname='date']");
	private By prodhour = By.xpath("//table/tr[12]/td");
	private By overalloee = By.xpath("(//table)[1]/tr[2]/td[2]");
	private By availability = By.xpath("(//table)[1]/tr[2]/td[3]");
	private By performance = By.xpath("(//table)[1]/tr[2]/td[4]");
	private By quality = By.xpath("(//table)[1]/tr[2]/td[5]");

	private By acttime = By.xpath("(//table)[1]/tr[2]/td[6]");
	private By idletime = By.xpath("(//table)[1]/tr[2]/td[7]");
	private By alerttime = By.xpath("(//table)[1]/tr[2]/td[8]");
	private By down = By.xpath("(//table)[1]/tr[2]/td[9]");
	private By part = By.xpath("(//table)[1]/tr[2]/td[10]");
	private By rej = By.xpath("(//table)[1]/tr[2]/td[11]");
	private By hold = By.xpath("(//table)[1]/tr[2]/td[12]");

	private By oee2 = By.xpath("(//table)[2]/tbody/tr/td[2]");
	private By availability2 = By.xpath("(//table)[2]/tbody/tr/td[3]");
	private By performance2 = By.xpath("(//table)[2]/tbody/tr/td[4]");
	private By quality2 = By.xpath("(//table)[2]/tbody/tr/td[5]");

	private By acttime2 = By.xpath("(//table)[2]/tbody/tr/td[6]");
	private By idletime2 = By.xpath("(//table)[2]/tbody/tr/td[7]");
	private By alerttime2 = By.xpath("(//table)[2]/tbody/tr/td[8]");
	private By down2 = By.xpath("(//table)[2]/tbody/tr/td[9]");
	private By part2 = By.xpath("(//table)[2]/tbody/tr/td[10]");
	private By rej2 = By.xpath("(//table)[2]/tbody/tr/td[12]");
	private By hold2 = By.xpath("(//table)[2]/tbody/tr/td[11]");
	private By lossdate = By.xpath("(//table)[3]/tbody/tr/td[1]");
	private By losshour = By.xpath("(//table)[3]/tbody/tr/td[2]");

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
			waittobeclickable(reports, 20);
			click(reports);
			System.out.println("report button is clicked");
			waittobeclickable(production, 20);
			click(production);
			System.out.println("analysis production report option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/production-reports";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			System.out.println("Assert verification is done for analysis production reports page");
//			click(smartdrum);
//			System.out.println("Smart drum is clicked");
//			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void table() {
		try {
			Thread.sleep(2000);
			System.out.println("Oee for given date is " + findWebElement(overalloee).getText());
			System.out.println("Availability for given date is " + findWebElement(availability).getText());
			System.out.println("Performance for given date is " + findWebElement(performance).getText());
			System.out.println("Quality for given date is " + findWebElement(quality).getText());
			System.out.println("Active time for given date is " + findWebElement(acttime).getText());
			System.out.println("Idle time for given date is " + findWebElement(idletime).getText());
			System.out.println("Alert time for given date is " + findWebElement(alerttime).getText());
			System.out.println("Down time for given date is " + findWebElement(down).getText());
			System.out.println("Part count for given date is " + findWebElement(part).getText());
			System.out.println("Rejected quantity for given date is " + findWebElement(rej).getText());
			System.out.println("Hold count for given date is " + findWebElement(hold).getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void table2() {
		try {
			Thread.sleep(1000);
			click(site);
			List<WebElement> list = findWebElements(sitelist);
			list.get(0).click();
			
			calendar(calendar, yeardd, year, startdate);
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
			waittobeclickable(location, 20);
			click(location);
			List<WebElement> list2 = findWebElements(locationlist);
			for(int fs=0;fs<list2.size();fs++) {
			list2.get(fs).click();
			click(apply);
			Thread.sleep(2000);
			List<WebElement> oee = findWebElements(oee2);
			List<Float> f = new LinkedList<>();
			float fl = 0f;
			for (int i = 0; i < oee.size(); i++) {
				String text = oee.get(i).getText();
				String replace = text.replace("%", "");
				Float valueOf = Float.valueOf(replace);
				f.add(valueOf);
				fl = fl + f.get(i);
			}
//		  float m = fl/f.size();
//			String val = String.valueOf(Math.round(m));
			if (findWebElement(overalloee).getText().equals("0")) {
				log.info("Overall oee shows 0 in table for "+gettext(equiptext));
				
			} else {
				System.out.println("Average oee is " + fl / f.size());
			}
			Thread.sleep(1000);
			List<WebElement> ava = findWebElements(availability2);
			List<Float> f2 = new LinkedList<>();
			float fl2 = 0f;
			for (int i = 0; i < ava.size(); i++) {
				String text = ava.get(i).getText();
				String replace = text.replace("%", "");
				Float valueOf = Float.valueOf(replace);
				f2.add(valueOf);
				fl2 = fl2 + f2.get(i);
			}
			float n = fl2/f2.size();
			String val2 = String.valueOf(Math.round(n));
			if (findWebElement(availability2).getText().equals("0")) {
				log.info("Overall availability shows 0 in table for "+gettext(equiptext));
				
			} else {
				System.out.println("Average availability is " + fl2 / f2.size());
			}
			Thread.sleep(1000);
			List<WebElement> per = findWebElements(performance2);
			List<Float> f3 = new LinkedList<>();
			float fl3 = 0f;
			for (int i = 0; i < per.size(); i++) {
				String text = per.get(i).getText();
				String replace = text.replace("%", "");
				Float valueOf = Float.valueOf(replace);
				f3.add(valueOf);
				fl3 = fl3 + f3.get(i);
			}
			float n2 = fl3/f3.size();
			String val3 = String.valueOf(n2);
			if (findWebElement(performance).getText().equals("0")) {
				log.info("Overall performance shows 0 in table for "+gettext(equiptext));				
			} else {
				System.out.println("Average performance is " + fl3 / f3.size());
			}
			Thread.sleep(1000);
			List<WebElement> qual = findWebElements(quality2);
			List<Float> f4 = new LinkedList<>();
			float fl4 = 0f;
			for (int i = 0; i < qual.size(); i++) {
				String text = qual.get(i).getText();
				String replace = text.replace("%", "");
				Float valueOf = Float.valueOf(replace);
				f4.add(valueOf);
				fl4 = fl4 + f4.get(i);
			}
			float n3 = fl4/f4.size();
			String val4 = String.valueOf(Math.round(n3));
			System.out.println(val4);
			if (findWebElement(quality).getText().equals("0")) {
				log.info("Overall quality mshows 0 in table for "+gettext(equiptext));
				
			} else {
				System.out.println("Average Quality is " + n3);
			}
			Thread.sleep(1000);
			List<WebElement> p = findWebElements(part2);
			List<Float> f9 = new LinkedList<>();
			float fl9 = 0f;
			for (int i = 0; i < p.size(); i++) {
				String text = p.get(i).getText();
			//	String replace = text.replace("%", "");
				Float valueOf = Float.valueOf(text);
				f9.add(valueOf);
				fl9 = fl9 + f9.get(i);
			}
			System.out.println("***"+fl9);
			String v = String.valueOf(fl9);
			if (v.contains(findWebElement(part).getText())) {
				System.out.println("Total part count is " + fl9);				
			} else {
				log.info("Overall part count mismatches with part count in table for "+gettext(equiptext));				
			}
			Thread.sleep(1000);
			List<WebElement> r = findWebElements(rej2);
			List<Integer> f10 = new LinkedList<>();
			Integer fl10 = 0;
			for (int i = 0; i < r.size(); i++) {
				String text = r.get(i).getText();
			//	String replace = text.replace("%", "");
				Integer valueOf = Integer.valueOf(text);
				f10.add(valueOf);
				fl10 = fl10 + f10.get(i);
			}
			String val10 = String.valueOf(fl10);
			if (findWebElement(rej).getText().equals(val10)) {
				System.out.println("Total rejected count is " + val10);
			}else {
				log.info("Overall rejected count mismatches with rejected count in table for "+gettext(equiptext));
			}	
				
			Thread.sleep(1000);
			List<WebElement> h = findWebElements(hold2);
			List<Integer> f11 = new LinkedList<>();
			int fl11 = 0;
			for (int i = 0; i < h.size(); i++) {
				String text = h.get(i).getText();
			//	String replace = text.replace("%", "");
				Integer valueOf = Integer.valueOf(text);
				f11.add(valueOf);
				fl11 = fl11 + f11.get(i);
			}
			String val11 = String.valueOf(fl11);
			if (findWebElement(hold).getText().contains(val11)) {
				System.out.println("Total hold count is " + val11);
			} else {
				log.info("Overall hold count mismatches with hold count in table for "+gettext(equiptext));
			}
			if(fs<list2.size()-1) {
				click(location);
			}else {
				break;
			}
		}
		}catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void loss() {
		List<WebElement> l1 = findWebElements(losshour);
		List<WebElement> l2 = findWebElements(lossdate);
		Map<String,String> m = new LinkedHashMap<>();
		for(int i=0;i<l1.size();i++) {
			m.put(l1.get(i).getText(), l2.get(i).getText());
		}
		System.out.println(m);
		
	}
	public void profile() {
		waittobeclickable(profile, 10);
		click(profile);
		log.info("profile button is clicked");
		click(signout);
		log.info("signout button is clicked");
	}
}

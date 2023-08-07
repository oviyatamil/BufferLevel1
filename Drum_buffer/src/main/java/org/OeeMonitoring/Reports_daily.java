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

public class Reports_daily extends BasePage {

	public Reports_daily(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By reports = By.xpath("//span[contains(text(),'Reports')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By dailyrep = By.xpath("//span[text()=' Daily Production Report ']");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("(//span[text()=' Chennai '])/ancestor::div[1]/mat-option");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By location = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By locationlist = By.xpath("(//span[text()=' Sriperumbudur '])/ancestor::div[1]/mat-option");
	private By shift = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By shiftlist = By.xpath("(//span[text()=' Shift 1 '])/ancestor::div[1]/mat-option");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By mechlist = By.xpath("(//span[text()=' TL-01 '])/ancestor::div[1]/mat-option");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By text = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By text2 = By.xpath("(//mat-select[@role='combobox'])[4]/descendant::span[2]");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By daterep = By.xpath("//table/tr/th[3]");
	private By prodhour = By.xpath("//table/tr[12]/td");

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
			waittobeclickable(dailyrep, 20);
			click(dailyrep);
			System.out.println("daily production report option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/daily-production-report";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			System.out.println("Assert verification is done for daily production reports page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void dd() {
		try {
			Thread.sleep(1000);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + s + "')]/parent::button"));
			mon.click();
			click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m = split3[1];

			int n = (Integer.parseInt(m)) - 1;

			WebElement end = driver	.findElement(By.xpath("//div[contains(text(),'" + n + "')]/parent::button"));
			end.click();
			
			click(site);
			List<WebElement> list = findWebElements(sitelist);
			list.get(0).click();
			waittobeclickable(location, 20);
			click(location);
			List<WebElement> list2 = findWebElements(locationlist);
			list2.get(0).click();
			waittobeclickable(machine, 20);
			click(machine);
			List<WebElement> list3 = findWebElements(mechlist);
			for(int i=0;i<list3.size();i++) {
				if(i>0) {
					click(machine);
				}
					list3.get(i).click();
				
				click(shift);
				List<WebElement> l2 = findWebElements(shiftlist);
				for(int j=0;j<l2.size();j++) {
					if(j>0) {
						click(shift);
					}					
						l2.get(j).click();											
					click(apply);
					Thread.sleep(2000);
					System.out.println(gettext(daterep));
					Thread.sleep(500);
					List<WebElement> lis = findWebElements(prodhour);
					List<Integer> l = new LinkedList<Integer>();
					int w = 0;
					for (int k = 1; k < 9; k++) {
						String text = lis.get(k).getText();
						Integer in = Integer.valueOf(text);
						l.add(in);
					}
					for (Integer x : l) {
						w = w + x;
					}
					String text3 = lis.get(9).getText();
					int pa = (Integer.parseInt(text3));
					String text4 = lis.get(10).getText();
					int par = (Integer.parseInt(text4));
					if ((lis.get(11).getText()).equals(String.valueOf(w))) {
						System.out.println("Total Production count for "+gettext(text2)+"---"+gettext(text)+" is " + w);
					} else if((pa+par)==w){
						System.out.println("Total Production count for "+gettext(text2)+"---"+gettext(text)+" is " + w);
					}else {
						log.info("Total production count displayed is not equal to the hourly production for "+gettext(text2)+"---"+gettext(text));

					}
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void table() {
		try {
			System.out.println(gettext(daterep));
			Thread.sleep(500);
			List<WebElement> list = findWebElements(prodhour);
			List<Integer> l = new LinkedList<Integer>();
			int w = 0;
			for (int i = 1; i < 9; i++) {
				String text = list.get(i).getText();
				Integer in = Integer.valueOf(text);
				l.add(in);
			}
			for (Integer x : l) {
				w = w + x;
			}
			if ((list.get(11).getText()).equals(String.valueOf(w))) {
				System.out.println("Total Production count is " + w);
			} else {
				log.info("Total production count displayed is not equal to the hourly production");
			}
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void profile() {
		waittobeclickable(profile, 10);
		click(profile);
		log.info("profile button is clicked");
		click(signout);
		log.info("signout button is clicked");
	}
}

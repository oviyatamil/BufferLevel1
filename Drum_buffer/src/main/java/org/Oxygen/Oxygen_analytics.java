package org.Oxygen;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Oxygen_analytics extends BasePage {

	public Oxygen_analytics(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By oxy = By.xpath("//div[text()='Oxygen Monitoring']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By consumption = By.xpath("//span[contains(text(),'Consumption')]");
	private By heat = By.xpath("//span[contains(text(),'Heat Map')]");
	private By equip = By.xpath("//span[contains(text(),'Equipment Wise Consumption')]");
	private By charts = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[3]/*[local-name()='text']");
	private By msg = By.xpath("//span[contains(@class,'fusioncharts-container')]/*[local-name()='svg']");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By slider = By.xpath("(//*[local-name()='g' and contains(@class,'slider')])[1]/*[3]");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()=' KHCH1 ']/parent::mat-option/parent::div/mat-option");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By ddlist2 = By.xpath("//div[@role='listbox']/mat-option");
	private By ddlist = By.xpath("//span[contains(text(),'All')]/parent::mat-option/parent::div/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By legend = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[2]/*[local-name()='g']/*[local-name()='rect']");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[18]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");	
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");	
	private By mouseover = By.xpath("//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')]/*[local-name()='text']");	
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");	
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");

	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(oxy, 20);
			click(oxy);
			System.out.println("Oxygen monitoring option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.careworx.in/#/oxygen/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for Oxygen monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void analytic() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(consumption, 20);
			click(consumption);
			System.out.println("Consumption option is clicked");
			Thread.sleep(1000);
			String ExpectedURL = "https://portal.careworx.in/#/oxygen/consumption";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analytics -> consumption page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dd() {
		try {
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

			WebElement end = driver	.findElement(By.xpath("//div[contains(text(),'" + String.valueOf(n) + "')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			click(site);
			List<WebElement> sites = findWebElements(sitelist);
			for (int i = 0; i < sites.size(); i++) {
				if (i>0) {
					click(site);
				} 	
				Thread.sleep(1000);
					sites.get(i).click();				
				click(dd);
				List<WebElement> list = findWebElements(ddlist);
				list.get(0).click();
				click(apply);
				Thread.sleep(2000);
				if (findWebElement(msg).isDisplayed()) {

					System.out.println("Chart is displayed for "+ gettext(txt));
					List<WebElement> leg = findWebElements(legend);
					for (WebElement x : leg) {
						x.click();
						Thread.sleep(100);
					}
				} else {
					log.info("No chart is displayed for"+ gettext(txt));
				}
				
				

			}
			click(export);
			click(jpg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void chart() {
		try {
			Actions a = new Actions(driver);
		
			if(findWebElement(mouseover).isDisplayed()!=true) {
				log.info("Chart is not displayed for "+gettext(txt));
			}else {
			List<WebElement> m = findWebElements(mouseover);
			for(WebElement x: m) {
				a.moveToElement(x);
			}
			System.out.println("Chart and datas are present");
			}
			click(export);
			click(jpg);
			List<WebElement> leg = findWebElements(legend);
			for (WebElement x : leg) {
				x.click();
				Thread.sleep(100);
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void heatmaphome() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(heat, 20);
			click(heat);
			System.out.println("Heatmap option is clicked");
			Thread.sleep(1000);
			String ExpectedURL = "https://portal.careworx.in/#/oxygen/heatmap";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for anlytics heatmap  page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void heatmap() {
		try {
			Thread.sleep(2000);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);			
			calendar(calendar, yeardd, year, startdate);
			click(apply);
			Thread.sleep(1000);
			click(site);
			List<WebElement> sites = findWebElements(sitelist);
			for (int i = 0; i < sites.size(); i++) {
				if (i>0) {
					click(site);
				} 
				Thread.sleep(500);
					sites.get(i).click();
				
				click(dd);
				List<WebElement> list = findWebElements(ddlist2);
				
					list.get(0).click();
					click(apply);
					Thread.sleep(2000);
					if (findWebElement(msg).isDisplayed()) {
						System.out.println("heatmap is displayed");
					} else {						
						log.info("No heatmap is displayed");
					}
				
			}
			Thread.sleep(500);
			
			click(pdf);
			click(export);
			click(jpg);
			draganddrop(slider);
			Thread.sleep(2000);

		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void equipment() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(equip, 20);
			click(equip);
			System.out.println("Equipment wise consumption option is clicked");
			Thread.sleep(1000);
			String ExpectedURL = "https://portal.careworx.in/#/oxygen/equipmentconsumption";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for equipment wise consumption page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void equipchart() {
		try {
			Actions a = new Actions(driver);
			Thread.sleep(2000);
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
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'" + n + "')]/parent::button"));
			end.click();			
			click(apply);
			Thread.sleep(1000);
			click(site);
			List<WebElement> sites = findWebElements(sitelist);
			for (int i = 0; i < sites.size(); i++) {
				if (i>0) {
					click(site);
				} 	
				Thread.sleep(500);
					sites.get(i).click();
				
				click(dd);
				List<WebElement> list = findWebElements(ddlist);
				list.get(0).click();
				click(apply);
				Thread.sleep(2000);
				if (findWebElement(charts).isDisplayed()!=true) {
					log.info("Chart is not displayed");	
				} else {
					System.out.println("Chart is displayed");
					List<WebElement> leg = findWebElements(legend);
					for (WebElement x : leg) {
						x.click();
						Thread.sleep(100);
					}
				List<WebElement> ch = findWebElements(charts);
				for(WebElement x:ch) {
					a.moveToElement(x);
				}
				}
				List<WebElement> leg = findWebElements(legend);
				for (WebElement x : leg) {
					x.click();
					Thread.sleep(100);
				}

			}
			Thread.sleep(500);

//			click(pdf);
//			click(export);
//			click(jpg);
//			
			

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

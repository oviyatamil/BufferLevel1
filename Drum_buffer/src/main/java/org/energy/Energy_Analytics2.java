package org.energy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class Energy_Analytics2 extends BasePage {

	public Energy_Analytics2(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[contains(text(),'Energy Monitoring')]");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By eflow = By.xpath("//span[contains(text(),'Energy Flow Analysis')]");
	private By variance = By.xpath("//span[contains(text(),'Variance Analysis')]");
	private By peak = By.xpath("//span[contains(text(),'Peak Demand Analysis')]");
	private By chart = By.xpath("(//*[local-name()='g' and contains(@class,'line-plot-meso')])[1]/*[local-name()='path'][2]");
	private By equip = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[3]");
	private By loclist = By.xpath("//span[text()='Select Location']/ancestor::div[1]/mat-option");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By equipment = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By equiplist = By.xpath("//span[text()='Select Equipment']/ancestor::div[1]/mat-option");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");	
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By flow = By.xpath("(//*[local-name()='g' and contains(@class,'sankey-link-group')])[1]/*[local-name()='path']");
	private By flow2 = By.xpath("(//*[local-name()='g' and contains(@class,'sankey-link-group')])[2]/*[local-name()='path']");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By txt2 = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By txt3 = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By bar = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*[local-name()='rect']");
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
			System.out.println("Assert verification is done for Energy monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void analytic() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(eflow, 20);
			click(eflow);
			System.out.println("Energy flow analysis option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/flow-analysis";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analytics -> energy flow analysis page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void analytic2() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(variance, 20);
			click(variance);
			System.out.println("Variance analysis option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/variance-analysis";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analytics -> Variance analysis page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void analytic3() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(peak, 20);
			click(peak);
			System.out.println("Peak demand analysis option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/demand-analysis";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analytics -> Peak demand analysis page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void eflows() {
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

			WebElement end = driver	.findElement(By.xpath("//div[contains(text(),'" + n + "')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			click(equip);
			
			List<WebElement> sites = findWebElements(ddlist);
			for (int i = 1; i < sites.size(); i++) {
				if (i>1) {
					click(equip);
				}
					sites.get(i).click();
				
					click(apply);
					Thread.sleep(2000);
					
					if (findWebElement(flow).isDisplayed()!=true) {
						log.info("Flow diagram for floor wise is not displayed for "+gettext(txt));
						
					} else {						
						System.out.println("Flow diagram for floor wise is displayed");									
			}
					if (findWebElement(flow2).isDisplayed()!=true) {
						log.info("Flow diagram for category wise is not displayed for "+gettext(txt));
						
					} else {						
						System.out.println("Flow diagram for category wise is displayed");									
			}
			Thread.sleep(500);

			}
			
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void var() {
		try {
			calendar(calendar, yeardd, year, startdate);
			click(equip);		
			List<WebElement> sites = findWebElements(ddlist);
			for (int i = 1; i < sites.size(); i++) {
				if (i>1) {
					click(equip);
				}
					sites.get(i).click();
				
					click(apply);
					Thread.sleep(2000);
					if (findWebElement(bar).isDisplayed()!=true) {
						log.info("Line chart is  not displayed for "+gettext(txt));
						
					} else {						
						System.out.println("Line chart is displayed");
						List<WebElement> fl = findWebElements(bar);
						for(WebElement x:fl) {
							move(x);
							Thread.sleep(100);
					}
}


}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void peakdemand() {
		try {
			Thread.sleep(1000);
			click(equip);
			
			List<WebElement> sites = findWebElements(ddlist);
			for (int i = 1; i < sites.size(); i++) {
				if (i>1) {
					click(equip);
				}
					sites.get(i).click();
				
					click(apply);
					Thread.sleep(2000);
					click(dd);
					List<WebElement> sites2 = findWebElements(loclist);					
					for (int j = 1; j < sites2.size(); j++) {
						if (j>1) {
							click(dd);
						}
						Thread.sleep(500);
							sites2.get(j).click();
						
							click(apply);
							Thread.sleep(500);
							click(equipment);
							List<WebElement> sites3 = findWebElements(equiplist);
							if(sites3.size()>0) {
							for (int k = 1; k < sites3.size(); k++) {
								if (k>1) {
									click(equipment);
								}
								Thread.sleep(500);
									sites3.get(k).click();
								
									click(apply);
									Thread.sleep(500);
							
									if (findWebElement(chart).isDisplayed()!=true) {
										log.info("Bar diagram is  not displayed for "+gettext(txt)+"-----"+gettext(txt2)+"---"+gettext(txt3));
										
									} else {						
										System.out.println("Bar diagram is displayed");
}
							}
		}else {
			break;
		}
			}
		}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		try {
			Thread.sleep(500);
			click(profile);
			System.out.println("profile button is clicked");
			click(signout);
			System.out.println("signout button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

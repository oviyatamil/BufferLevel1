package org.energy;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Energy_Analytics2 extends BasePage{

	public Energy_Analytics2(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[text()='Energy Monitoring']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By eflow = By.xpath("//span[contains(text(),'Energy Flow Analysis')]");
	private By equip = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[3]");
	private By catlist = By.xpath("//span[text()='Select Category']/ancestor::div[1]/mat-option");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By site = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By flow = By.xpath("//*[local-name()='g' and contains(@class,'sankey-node-group')]/*[local-name()='rect']");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(energy, 20);
			click(energy);
			System.out.println("Energy monitoring option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.careworx.in/#/energy/Home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Energy monitoring home page");
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
			String ExpectedURL = "https://portal.careworx.in/#/energy/flow-analysis";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analytics -> energy flow analysis page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void eflows() {
		try {
		//	Actions a = new Actions(driver);
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
						log.info("Flow diagram is  not displayed for "+gettext(txt));
						
					} else {						
						System.out.println("Flow diagram is displayed");
						List<WebElement> fl = findWebElements(flow);
						for(WebElement x:fl) {
							move(x);
							Thread.sleep(100);
					}
				
			}
			Thread.sleep(500);

			}
			
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}


}

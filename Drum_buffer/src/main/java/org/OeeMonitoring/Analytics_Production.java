package org.OeeMonitoring;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class Analytics_Production extends BasePage {

	public Analytics_Production(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By production = By.xpath("(//span[text()=' Production '])[2]");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[4]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By text = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By productionunit = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]/*");
	private By export1 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg1 = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By chart = By.xpath("(//*[local-name()='g' and contains(@class,'canvasdatalabel')])[1]/*[local-name()='g']/*[local-name()='g']/*[local-name()='g']/*[local-name()='text']");
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

	public void analytics() {
		try {
			waittobeclickable(analytics, 10);
			click(analytics);
			System.out.println("Monitoring button is clicked");
			waittobeclickable(production, 20);
			click(production);
			System.out.println("oee monitor option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for analytics production page");
			click(smartdrum);
			System.out.println("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void calendar() {
		try {
//			calendar(calendar, yeardd, year, startdate);			
			Thread.sleep(1000);
			System.out.println("Calendar date is selected");
			click(equipdd);
			System.out.println("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for (int i = 1; i < list.size(); i++) {				
				list.get(i).click();			
				click(apply);
				Thread.sleep(5000);
				System.out.println(gettext(text));
				if(findWebElements(chart).size()>1) {
					System.out.println("Machine wise production unit chart is dispalyed");
				}else {
					log.info("Machine wise production unit chart is not dispalyed");
				}
				if(findWebElements(productionunit).size()<=0) {
					log.info("Part wise production unit is empty for "+gettext(text));
				}else {
					if(findWebElement(msg2).getText().contains("No data")) {
						log.info("No data to display for "+gettext(text));
					}else {
			System.out.println("Part wise production unit is "+gettext(productionunit));
					}
				}
				Thread.sleep(1000);
				if(i<list.size()-1) {
					click(equipdd);
			}else {
				break;
			}				
			}
			System.out.println("All products production and rejection units are checked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		public void chart() {
			try {
				click(pdf);
				Thread.sleep(500);
				System.out.println("Overall page is downloaded by clicking export to pdf button");
				click(export1);
				click(jpg1);
				System.out.println("Machine wise production unit chart is downloaded");
				Thread.sleep(500);
			} catch (InterruptedException e) {
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

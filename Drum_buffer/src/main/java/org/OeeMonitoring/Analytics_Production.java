package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By production = By.xpath("(//span[text()=' Production '])[2]");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By text = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By prodcard = By.xpath("//fuse-card[1]/div[2]/div");
	private By defcard = By.xpath("//fuse-card[2]/div[2]/div");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[14]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By enddate = By.xpath("//div[text()=' 17 ']/parent::button");
	private By productionunit = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]/*");
	private By rejectunit = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[8]/*");
	private By export1 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg1 = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By export2 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[2]/*[local-name()='rect'][2]");
	private By jpg2 = By.xpath("(//span[text()='Export As JPG'])[2]");
	private By export3 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[3]/*[local-name()='rect'][2]");
	private By jpg3 = By.xpath("(//span[text()='Export As JPG'])[3]");
	private By export4 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[4]/*[local-name()='rect'][2]");
	private By jpg4 = By.xpath("(//span[text()='Export As JPG'])[4]");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
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

	public void analytics() {
		try {
			waittobeclickable(analytics, 10);
			click(analytics);
			System.out.println("Monitoring button is clicked");
			waittobeclickable(production, 20);
			click(production);
			System.out.println("oee monitor option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/production";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
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
			WebElement end = driver
					.findElement(By.xpath("//div[contains(text(),'" + m + "')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			log.info("Calendar date is selected");
			click(equipdd);
			log.info("Equipment dropdown is selected");
			List<WebElement> list = findWebElements(equiplist);
			for (int i = 1; i < list.size(); i++) {				
				list.get(i).click();
				Thread.sleep(500);
				click(apply);
				System.out.println(gettext(text));
				if(findWebElement(productionunit).getText().isEmpty()) {
					log.info("Part wise production unit is empty for "+gettext(text));
				}else {
			System.out.println("Part wise production unit is "+gettext(productionunit));	
			System.out.println("Part wise rejection unit is "+gettext(rejectunit));
				}
				Thread.sleep(3000);
				if(i<list.size()-1) {
					click(equipdd);
			}else {
				break;
			}
				System.out.println("All products production and rejection units are displayed");
			}
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
//				click(export2);
//				click(jpg2);
//				log.info("Part wise production unit chart is downloaded");
//				Thread.sleep(500);
				click(export3);
				click(jpg3);
				System.out.println("Machine wise rejection unit chart is downloaded");
				Thread.sleep(500);
//				click(export4);
//				click(jpg4);
//				log.info("Part wise rejection unit chart is downloaded");
//				Thread.sleep(500);
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

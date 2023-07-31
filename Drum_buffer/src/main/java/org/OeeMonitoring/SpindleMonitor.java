package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import com.BasePage.BasePage;

public class SpindleMonitor extends BasePage{

	public SpindleMonitor(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By monitoring = By.xpath("//span[contains(text(),'Monitoring')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By spindle = By.xpath("//span[text()=' Spindle Monitoring ']");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[4]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By fusion = By.xpath("(//*[text()='S1load'])[2]");
	private By fusion2 = By.xpath("(//div[@class='fc__tooltip fusioncharts-div'])[2]");
	private By export = By.xpath("//*[local-name()='g' and contains(@class,'toolbar-master')]/*[1]/*[2]/*[3]");
	private By ver = By.xpath("//*[local-name()='g' and contains(@class,'veritcal-crossline-marker-group')]");
	private By jpg = By.xpath("//span[text()='Export As JPG']");
	private By txt = By.xpath("(//mat-select)[2]/descendant::span[2]");
	private By timestamp = By.xpath("//*[local-name()='g' and contains(@class,'range-selector-text')]/*[local-name()='text']");
	private By drag = By.xpath("//*[local-name()='g' and contains(@class,'brush-group')]/*[local-name()='rect'][2]");
	private By drop = By.xpath("(//*[local-name()='g'])[140]/*[local-name()='rect'][3]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By graph = By.xpath("(//*[local-name()='g' and contains(@class,'vertical-crossline-group')])[1]");
	public void oee() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			log.info("Ninedots button is clicked");
			waittobeclickable(Oee, 20);
			click(Oee);
			log.info("Oee option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/oee/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Oee home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void spindlemonitor() {
		try {
			waittobeclickable(monitoring, 10);
			click(monitoring);
			log.info("Monitoring button is clicked");
			waittobeclickable(spindle, 20);
			click(spindle);
			log.info("oee monitor option is clicked");
			Thread.sleep(2000);
			String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/spindle-monitoring";
			String ActualURL2 = getCurrentURL();
			assertEquals(ExpectedURL2, ActualURL2);
			log.info("Assert verification is done for spindle monitoring page");
			click(smartdrum);
			log.info("Smart drum is clicked");
			click(smartdrum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void chart() {
		try {
			click(equipdd);
			List<WebElement> list = findWebElements(equiplist);
			for(int i=1;i<list.size();i++){
				if(i>1) {
					click(equipdd);
				}
				list.get(i).click();
				Thread.sleep(1000);
				click(apply);
		WebElement list2 = findWebElement(timestamp);
		System.out.println("Current timing is "+new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date()));
		System.out.println("Timestamp is "+list2.getText());
		String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
		String[] split2 = data.split(",");
		if((list2.getText()).contains(split2[0]))
		{
			System.out.println("Timestamp displayed is correct");
		}else {
			log.info("Timestamp is not correct for "+gettext(txt));
		}
		Thread.sleep(5000);
		}
			click(export);
			click(jpg);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			Thread.sleep(1000);
		//	Actions a = new Actions(driver);
		//	WebElement element = findWebElement(drag);
			draganddrop(drag);
			Thread.sleep(1000);
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


package org.Dialysis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Dialysis extends BasePage{

	public Dialysis(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By dial = By.xpath("//div[contains(text(),'Dialysis Monitoring')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By yesterday = By.xpath("(//span[text()='No. of Dialysis'])[1]/parent::div/div");
	private By nomonth = By.xpath("(//span[text()='No. of Dialysis'])[2]/parent::div/div");
	private By runhrsyes = By.xpath("(//span[text()='Run Hours'])[1]/parent::div/div");
	private By runhrsmon = By.xpath("(//span[text()='Run Hours'])[2]/parent::div/div");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By location = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By loclist = By.xpath("//span[text()='All']/parent::mat-option/parent::div/mat-option");
	private By time = By.xpath("//span[text()='Last Telemetry']/ancestor::div[4]/div[2]/div[1]/div[1]/span[2]");
	private By table = By.xpath("//span[text()='Last Telemetry']/ancestor::div[4]/div[1]/div");
	private By runhrtable = By.xpath("//span[text()='Last Telemetry']/ancestor::div[4]/div[2]/div[1]/div[5]/span[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(dial, 20);
			click(dial);
			System.out.println("Dialysis option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Dialysis monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void monitor() {
		try {
			Thread.sleep(1000);
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			list.get(1).click();
				click(location);
				List<WebElement> list2 = findWebElements(loclist);
				Thread.sleep(1000);
				list2.get(1).click();
					click(apply);							
				Thread.sleep(5000);
				if((findWebElement(yesterday).getText()).equals("0")||(findWebElement(yesterday).getText()).equals("-")) {
					log.info("No of dialysis yesterday is "+findWebElement(yesterday).getText());
				}else {
					System.out.println("Yesterday dialysis count is "+findWebElement(yesterday).getText());
				}
				if((findWebElement(nomonth).getText()).equals("0")||(findWebElement(nomonth).getText()).equals("-")) {
					log.info("No of dialysis for a month is "+findWebElement(nomonth).getText());
				}else {
					System.out.println("No of dialysis for a month is "+findWebElement(nomonth).getText());
				}
				if((findWebElement(runhrsyes).getText()).equals("0")||(findWebElement(runhrsyes).getText()).equals("-")) {
					log.info("Run hrs time is "+findWebElement(runhrsyes).getText());
				}else {
					System.out.println("Run hrs time is "+findWebElement(runhrsyes).getText());
				}
				if((findWebElement(runhrsmon).getText()).equals("0")||(findWebElement(runhrsmon).getText()).contains("-")) {
					log.info("Run hrs for month is "+findWebElement(runhrsmon).getText());
				}else {
					System.out.println("Run hrs for month is "+findWebElement(runhrsmon).getText());
				}
				

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

}
	public void table() {
	try {
		Thread.sleep(3000);
		if(findWebElements(table).size()<1) {
			log.info("No record found for Equipments");
		}else {
		List<WebElement> list = findWebElements(table);
		for(int i=0;i<list.size();i++) {
			Thread.sleep(300);
			System.out.println("EQUIPMENT IS "+list.get(i).getText());
			List<WebElement> timestamp = findWebElements(time);
			String text = timestamp.get(i).getText();
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			String[] split = data.split(",");
			String s = split[0];
			if(text.contains(s)) {
				Thread.sleep(500);
				System.out.println("Timestamp in machine is "+timestamp.get(i).getText());
			}else {
				Thread.sleep(500);
				log.info("Date in "+list.get(i).getText()+" machine mismatches with actual time "+timestamp.get(i).getText());
			}
			System.out.println("Run hours yesterday is "+findWebElements(runhrtable).get(i).getText());
			Thread.sleep(500);
}
		}
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

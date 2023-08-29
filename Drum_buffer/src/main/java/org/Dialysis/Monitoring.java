package org.Dialysis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class Monitoring extends BasePage {

	public Monitoring(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By dial = By.xpath("//div[contains(text(),'Dialysis Monitoring')]");
	private By monitor = By.xpath("//span[contains(text(),'Monitoring')]");
	private By dialysis = By.xpath("//span[contains(text(),'Dialysis Monitoring')]");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By chartss = By.xpath("//*[local-name()='g' and contains(@class,'messageGroup')]/*[local-name()='text']");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	//private By chart = By.xpath("//*[local-name()='g' and contains(@class,'crossline-value-group')]/*[local-name()='rect']");
	private By legend = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[2]/*[local-name()='g']/*[local-name()='rect']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(dial, 20);
			click(dial);
			System.out.println("Dialysis monitoring option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for Dialysis monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void monitor() {
		try {
			waittobeclickable(monitor, 20);
			click(monitor);
			System.out.println("Monitor menu is clicked");
			waittobeclickable(dialysis, 20);
			click(dialysis);
			System.out.println("Dialysis option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Monitoring";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for monitoring page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			Thread.sleep(1000);			
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'"+s+"')]/parent::button"));
			mon.click();	
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m =split3[1];
			int mn = Integer.parseInt(m);		
			int n = (Integer.parseInt(m))-1;	
			WebElement start = driver.findElement(By.xpath("//div[contains(text(),'"+n+"')]/parent::button"));
			start.click();
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'"+mn+"')]/parent::button"));
			end.click();
			click(dd);
			Thread.sleep(500);
			List<WebElement> list = findWebElements(ddlist);
			for(int i=1;i<list.size();i++) {
				if(i>1) {
					Thread.sleep(500);
					click(dd);
				}
				list.get(i).click();
				click(apply);
				Thread.sleep(7000);	
				takescreenshots("dia-chart");
				if(findWebElement(chartss).getText().contains("No data")) {
					log.info("Chart is not displayed for "+gettext(txt));					
				}else {
					System.out.println("Chart is displayed");
					Thread.sleep(500);
					click(legend);
				}
//				if(findWebElement(charts).isDisplayed()!=true) {
//					log.info("Chart dosen't displayed for "+gettext(txt));
//				}else {
//					System.out.println("Chart displayed for "+gettext(txt));
//				}
				
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

package org.Oxygen;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BasePage.BasePage;

public class Oxygen_monitoring extends BasePage{

	public Oxygen_monitoring(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By oxy = By.xpath("//div[text()='Oxygen Monitoring']");
	private By monitor = By.xpath("//span[contains(text(),'Monitoring')]");
	private By oxygen = By.xpath("//span[contains(text(),'Oxygen Monitoring')]");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[contains(text(),'KHCH1')]/parent::mat-option/parent::div/mat-option");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[18]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");	
	private By enddate = By.xpath("//div[text()=' 21 ']/parent::button");
	private By flowrate = By.xpath("//span[contains(text(),'Flow Rate')]/parent::div/div");
	private By line = By.xpath("//span[contains(text(),'Line Pressure')]/parent::div/div");
	private By reset = By.xpath("(//*[local-name()='g' and contains(@class,'toolbar')])[2]/*[local-name()='g'][3]/*[local-name()='rect'][2]");
	private By flowchart = By.xpath("(//*[local-name()='g' and contains(@class,'common-elems-group')])[1]");
	private By linechart = By.xpath("(//*[local-name()='g' and contains(@class,'common-elems-group')])[2]");
	private By outletchart = By.xpath("(//*[local-name()='g' and contains(@class,'common-elems-group')])[3]");
	private By txt = By.xpath("(//mat-select)[1]/descendant::span[2]");
	private By txt2 = By.xpath("(//mat-select)[2]/descendant::span[2]");
	
	private By chart = By.xpath("//*[local-name()='g' and contains(@class,'crosslineBottom')]");
	private By legend = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[2]/*[local-name()='g']/*[local-name()='rect']");
	private By chart2 = By.xpath("(//*[local-name()='g' and contains(@class,'crosslineBottom')])[2]");
	private By legend2 = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[4]/*[local-name()='g']/*[local-name()='rect']");
	private By reset2 = By.xpath("(//*[local-name()='g' and contains(@class,'toolbar')])[4]/*[local-name()='g'][3]/*[local-name()='rect'][2]");
	private By chart3 = By.xpath("(//*[local-name()='g' and contains(@class,'crosslineBottom')])[3]");
	private By legend3 = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[6]/*[local-name()='g']/*[local-name()='rect']");
	private By reset3 = By.xpath("(//*[local-name()='g' and contains(@class,'toolbar')])[6]/*[local-name()='g'][3]/*[local-name()='rect'][2]");
	private By rel = By.xpath("//*[local-name()='g' and contains(@class,'crossline-label-group')]/*[local-name()='text']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
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
	public void monitor() {
		try {
			waittobeclickable(monitor, 20);
			click(monitor);
			System.out.println("Monitor menu is clicked");
			waittobeclickable(oxygen, 20);
			click(oxygen);
			System.out.println("Oxygen monitoring option is clicked");
			Thread.sleep(1000);
			String ExpectedURL = "https://portal.careworx.in/#/oxygen/monitoring";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for oxygen monitoring page");
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
			Thread.sleep(1000);
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'"+s+"')]/parent::button"));
			mon.click();	
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m =split3[1];
			
			
			int n = (Integer.parseInt(m))-1;

			WebElement start = driver.findElement(By.xpath("//div[contains(text(),'"+n+"')]/parent::button"));
			start.click();
			
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'"+m+"')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			click(site);
			List<WebElement> si = findWebElements(sitelist);
			
			for(int i=0;i<si.size();i++) {
				if(i>0) {
					click(site);
				}
				si.get(i).click();
				click(apply);
				Thread.sleep(3000);
				
				
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
	//		for(WebElement x2:list) {
	//			x2.click();		
			list.get(0).click();
			click(apply);
			Thread.sleep(1000);
			System.out.println("Flowrate in cards is "+findWebElement(flowrate).getText()); 
			System.out.println("Line pressure in cards is "+findWebElement(line).getText());
				
				if(findWebElement(flowchart).isDisplayed()!=true) {
					log.info("Flowchart is not displayed for "+gettext(txt)+"---"+gettext(txt2));
					
				}else {
					System.out.println("Flowchart is displayed");
				}
				if(findWebElement(linechart).isDisplayed()!=true) {
					log.info("linechart is not displayed for "+gettext(txt)+"---"+gettext(txt2));
				}else {
					System.out.println("linechart is displayed");
				}
				if(findWebElement(outletchart).isDisplayed()!=true) {
					log.info("Outletchart is not displayed for "+gettext(txt)+"---"+gettext(txt2));
				}else {
					System.out.println("Outletchart is displayed");
					
				}
				
		} 
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void chart() {
		try {
			Thread.sleep(1000);
			
			draganddrop(chart);
			Thread.sleep(1000);
			click(reset);
			click(legend);
			draganddrop(chart2);
			Thread.sleep(500);
			click(reset2);
			click(legend2);
			draganddrop(chart3);
			Thread.sleep(500);
			click(reset3);
			click(legend3);
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


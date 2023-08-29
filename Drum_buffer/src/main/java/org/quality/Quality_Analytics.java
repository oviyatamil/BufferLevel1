package org.quality;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Quality_Analytics extends BasePage{

	public Quality_Analytics(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By quality = By.xpath("//div[contains(text(),'Quality')]");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By machinedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By machlist = By.xpath("//span[text()='Select Machine Name']/parent::mat-option/parent::div/mat-option");
	private By partdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By partlist = By.xpath("//span[text()='Select Part Number']/parent::mat-option/parent::div/mat-option");
	private By chardd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By charlist = By.xpath("//span[text()='Select Part Characteristic']/parent::mat-option/parent::div/mat-option/span");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");	
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By txt2 = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By txt3 = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By usl = By.xpath("//span[contains(text(),'USL')]/ancestor::div[3]/descendant::span[1]");
	private By nominal = By.xpath("//span[contains(text(),'USL')]/ancestor::div[3]/descendant::span[3]");
	private By lsl = By.xpath("//span[contains(text(),'USL')]/ancestor::div[3]/descendant::span[5]");
	private By ucl = By.xpath("//span[contains(text(),'UCL')]/ancestor::div[3]/descendant::span[1]");
	private By cl = By.xpath("//span[contains(text(),'UCL')]/ancestor::div[3]/descendant::span[3]");
	private By lcl = By.xpath("//span[contains(text(),'UCL')]/ancestor::div[3]/descendant::span[5]");
	private By sigma = By.xpath("//span[contains(text(),'Sigma')]/ancestor::div[3]/descendant::span[1]");
	private By cp = By.xpath("//span[contains(text(),'Sigma')]/ancestor::div[3]/descendant::span[3]");
	private By cpk = By.xpath("//span[contains(text(),'Sigma')]/ancestor::div[3]/descendant::span[5]");
	private By ichart = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[2]/*[local-name()='text']");
	private By sigma2 = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[1]");
	private By pp = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[3]");
	private By ppk = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[5]");
	private By mrchart = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]/*[local-name()='text']");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By msg1 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*[local-name()='text']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(quality, 20);
			click(quality);
			System.out.println("Quality option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for quality home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void controlchart() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("Analytics center menu is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/imr-chart";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analaytics page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {			
			calendar(calendar, yeardd, year, startdate);
			click(machinedd);
			List<WebElement> m = findWebElements(machlist);
			for(int i=1;i<m.size();i++) {
				if(i>1) {
					click(machinedd);
				}
				m.get(i).click();
				Thread.sleep(500);
				click(partdd);
				List<WebElement> p = findWebElements(partlist);
				for(int k=1;k<p.size();k++) {
					if(k>1) {
						click(partdd);
					}
					p.get(k).click();
				Thread.sleep(500);
				click(chardd);
				List<WebElement> c = findWebElements(charlist);
				System.out.println(c.get(1).getText());
				for(int j=1;j<c.size();j++) {
					if(j>1) {
						click(chardd);
					}
					Thread.sleep(500);
					c.get(j).click();
					click(search);
					Thread.sleep(500);
					if(gettext(usl).equals("0")) {
						log.info("USL card count is 0");
					}else {
						System.out.println("USL card count is "+gettext(usl)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(nominal).equals("0")) {
						log.info("Nominal card count is 0");
					}else {
						System.out.println("Nominal card count is "+gettext(nominal)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(lsl).equals("0")) {
						log.info("LSL card count is 0");
					}else {
						System.out.println("LSL card count is "+gettext(lsl)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(ucl).equals("0")) {
						log.info("UCL card count is 0");
					}else {
						System.out.println("UCL card count is "+gettext(ucl)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(cl).equals("0")) {
						log.info("CL card count is 0");
					}else {
						System.out.println("CL card count is "+gettext(cl)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(lcl).equals("0")) {
						log.info("LCL card count is 0");
					}else {
						System.out.println("LCL card count is "+gettext(lsl)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(sigma).equals("0")) {
						log.info("Sigma card count is 0");
					}else {
						System.out.println("Sigma card count is "+gettext(sigma)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(cp).equals("0")) {
						log.info("CP card count is 0");
					}else {
						System.out.println("CP card count is "+gettext(cp)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(cpk).equals("0")) {
						log.info("CPK card count is 0");
					}else {
						System.out.println("CPK card count is "+gettext(cpk)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(sigma2).equals("0")) {
						log.info("USL card count is 0");
					}else {
						System.out.println("USL card count is "+gettext(sigma2)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(pp).equals("0")) {
						log.info("Process capability long term card count is 0");
					}else {
						System.out.println("Process capability long term sigma card count is "+gettext(pp)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(ppk).equals("0")) {
						log.info("PPK card count is 0");
					}else {
						System.out.println("PPK card count is "+gettext(ppk)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					Thread.sleep(1000);
					if(findWebElement(msg1).getText().contains("No data")) {
						log.info("No data found to display");
					}
					else if(findWebElement(ichart).isDisplayed()!=true) {
						log.info("Ichart not displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}			
					else {
						System.out.println("Ichart displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(findWebElement(msg2).getText().contains("No data")) {
						log.info("No data found to display");
					}
					else if(findWebElement(mrchart).isDisplayed()!=true) {
						log.info("MRchart not displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					else {
						System.out.println("MRchart displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
			}				
	}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void exports() {
	//	click(pdf);
		//waittobeclickable(export, 10);
		if(findWebElement(export).isDisplayed()==true) {
			click(export);
			click(jpg);	
		}
//		waittobeclickable(export2, 10);
//		click(export2);
//		click(jpg2);
	}
	public void profile() {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}





	
	
}

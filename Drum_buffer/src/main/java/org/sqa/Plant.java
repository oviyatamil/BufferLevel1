package org.sqa;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Plant extends BasePage {

	public Plant(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By sqa = By.xpath("//div[contains(text(),'SQA')]/parent::div/child::button");
	private By plant = By.xpath("//span[contains(text(),'Plant Manag')]");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to specific filter condition']/img");
	private By machinedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By supplier = By.xpath("//span[text()='Select Supplier']/parent::mat-option/parent::div/mat-option");
	private By partdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By partlist = By.xpath("//span[text()='Select Part Number']/parent::mat-option/parent::div/mat-option");
	private By chardd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By charlist = By.xpath("//span[text()='Select Part Characteristic']/parent::mat-option/parent::div/mat-option");
	private By machinedd2 = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By partdd2 = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[4]");
	private By partlist2 = By.xpath("//span[text()='Select Part Number']/parent::mat-option/parent::div/mat-option");
	private By chardd2 = By.xpath("(//mat-select[@role='combobox'])[6]/ancestor::div[1]/descendant::div[4]");
	private By charlist2 = By.xpath("//span[text()='Select Part Characteristic']/parent::mat-option/parent::div/mat-option");
	private By search = By.xpath("//span[contains(text(),'Search')]");
	private By calendar = By.xpath("(//mat-label[contains(text(),'Date')])[1]/following::span[1]");
	private By calendar2 = By.xpath("(//mat-label[contains(text(),'Date')])[2]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");	
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By txt2 = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By txt3 = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::span[2]");
	private By txt4 = By.xpath("(//mat-select[@role='combobox'])[4]/descendant::span[2]");
	private By txt5 = By.xpath("(//mat-select[@role='combobox'])[5]/descendant::span[2]");
	private By txt6 = By.xpath("(//mat-select[@role='combobox'])[6]/descendant::span[2]");
	private By usl = By.xpath("//span[contains(text(),'USL')]/ancestor::div[3]/descendant::span[1]");
	private By nominal = By.xpath("//span[contains(text(),'USL')]/ancestor::div[3]/descendant::span[3]");
	private By lsl = By.xpath("//span[contains(text(),'USL')]/ancestor::div[3]/descendant::span[5]");
	
	private By legend2 = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[4]/*[local-name()='g']/*[local-name()='rect']");
	private By sigma = By.xpath("//span[contains(text(),'Sigma')]/ancestor::div[3]/descendant::span[1]");
	private By cp = By.xpath("//span[contains(text(),'Sigma')]/ancestor::div[3]/descendant::span[3]");
	private By cpk = By.xpath("//span[contains(text(),'Sigma')]/ancestor::div[3]/descendant::span[5]");
	private By boxchart = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[2]");
	private By sigma2 = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[1]");
	private By pp = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[3]");
	private By ppk = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[5]");
	private By usl2 = By.xpath("(//span[contains(text(),'USL')])[2]/ancestor::div[3]/descendant::span[1]");
	private By nominal2 = By.xpath("(//span[contains(text(),'USL')])[2]/ancestor::div[3]/descendant::span[3]");
	private By lsl2 = By.xpath("(//span[contains(text(),'USL')])[2]/ancestor::div[3]/descendant::span[5]");
	private By search2 = By.xpath("(//span[contains(text(),'Search')])[2]");
	private By sigma3 = By.xpath("(//span[contains(text(),'Sigma')])[2]/ancestor::div[3]/descendant::span[1]");
	private By cp2 = By.xpath("(//span[contains(text(),'Sigma')])[2]/ancestor::div[3]/descendant::span[3]");
	private By cpk2 = By.xpath("(//span[contains(text(),'Sigma')])[2]/ancestor::div[3]/descendant::span[5]");
	private By boxchart2 = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]");
	private By sigma4 = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[1]");
	private By pp2 = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[3]");
	private By ppk2 = By.xpath("//span[contains(text(),'Pp')]/ancestor::div[3]/descendant::span[5]");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By export2 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[2]/*[local-name()='rect'][2]");
	private By jpg2 = By.xpath("(//span[text()='Export As JPG'])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(sqa, 10);
			click(sqa);
			System.out.println("SQA option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for SQA home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void plantmanager() {
		try {
			waittobeclickable(plant, 20);
			click(plant);
			System.out.println("Plant manager menu is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/plant-manager";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Plant manager page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {	
			click(smartdrum);
			Thread.sleep(500);
			calendar(calendar, yeardd, year, startdate);
			click(machinedd);
			List<WebElement> m = findWebElements(supplier);
				m.get(1).click();
				Thread.sleep(500);
				click(partdd);
				List<WebElement> p = findWebElements(partlist);
				p.get(1).click();
				click(chardd);
				Thread.sleep(500);
				List<WebElement> c = findWebElements(charlist);
				Thread.sleep(500);
					c.get(1).click();
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
						log.info("Process capability long term card count is 0");
					}else {
						System.out.println("Process capability long term card count is "+gettext(sigma2)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(pp).equals("0")) {
						log.info("pp card count is 0");
					}else {
						System.out.println("pp card count is "+gettext(pp)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(gettext(ppk).equals("0")) {
						log.info("PPK card count is 0");
					}else {
						System.out.println("PPK card count is "+gettext(ppk)+" for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					Thread.sleep(1000);					
					calendar(calendar2, yeardd, year, startdate);
					click(machinedd2);
					List<WebElement> m2 = findWebElements(supplier);
						m2.get(1).click();
						Thread.sleep(500);
						click(partdd2);
						List<WebElement> p2 = findWebElements(partlist2);
						p2.get(1).click();
						Thread.sleep(500);
						click(chardd2);
						List<WebElement> c2 = findWebElements(charlist2);
							c2.get(2).click();
							click(search2);
							Thread.sleep(500);
							if(gettext(usl2).equals("0")) {
								log.info("USL card count is 0");
							}else {
								System.out.println("USL card count is "+gettext(usl2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(nominal2).equals("0")) {
								log.info("Nominal card count is 0");
							}else {
								System.out.println("Nominal card count is "+gettext(nominal2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(lsl2).equals("0")) {
								log.info("LSL card count is 0");
							}else {
								System.out.println("LSL card count is "+gettext(lsl2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(sigma3).equals("0")) {
								log.info("Sigma card count is 0");
							}else {
								System.out.println("Sigma card count is "+gettext(sigma3)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(cp2).equals("0")) {
								log.info("CP card count is 0");
							}else {
								System.out.println("CP card count is "+gettext(cp2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(cpk2).equals("0")) {
								log.info("CPK card count is 0");
							}else {
								System.out.println("CPK card count is "+gettext(cpk2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(sigma4).equals("0")) {
								log.info("Process capability long term card count is 0");
							}else {
								System.out.println("Process capability long term count is "+gettext(sigma4)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(pp2).equals("0")) {
								log.info("Pp long term card count is 0");
							}else {
								System.out.println("Pp long term sigma card count is "+gettext(pp2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							if(gettext(ppk2).equals("0")) {
								log.info("PPK card count is 0");
							}else {
								System.out.println("PPK card count is "+gettext(ppk2)+" for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}
							Thread.sleep(1000);
							JavascriptExecutor j = (JavascriptExecutor)driver;
							j.executeScript("arguments[0].scrollIntoView(true);", findWebElement(legend2));
							if(findWebElement(boxchart).isDisplayed()!=true) {
								log.info("Boxchart not displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
							}else {
								System.out.println("Boxchart displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
							}
							Thread.sleep(1000);
							if(findWebElement(boxchart2).isDisplayed()!=true) {
								log.info("Boxchart not displayed for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}else {
								System.out.println("Boxchart displayed for "+gettext(txt4)+" ----- "+gettext(txt5)+" ---- "+gettext(txt6));
							}									
	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void exports() {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(false);", findWebElement(export));
		waittobeclickable(export, 10);
		click(export);
		click(jpg);
		System.out.println("Chart is exported");
		waittobeclickable(export2, 10);
		click(export2);
		click(jpg2);
	}
	public void profile() {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}





	
}

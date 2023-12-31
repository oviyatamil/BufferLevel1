package org.sqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;
import org.openqa.selenium.interactions.*;
public class Control extends BasePage{

	public Control(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By sqa = By.xpath("//div[contains(text(),'SQA')]/parent::div/child::button");
	private By control = By.xpath("//span[contains(text(),'Control Chart')]");
	private By machinedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By supplier = By.xpath("//span[text()='Select Supplier']/parent::mat-option/parent::div/mat-option");
	private By partdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By partlist = By.xpath("//span[text()='Select Part Number']/parent::mat-option/parent::div/mat-option");
	private By chardd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By charlist = By.xpath("//span[text()='Select Part Characteristic']/parent::mat-option/parent::div/mat-option");
	private By search = By.xpath("//span[contains(text(),'Search')]");
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
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By export2 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[2]/*[local-name()='rect'][2]");
	private By jpg2 = By.xpath("(//span[text()='Export As JPG'])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By msg1 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*[local-name()='text']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	private By signout = By.xpath("//span[text()='Sign out']");


	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(sqa, 20);
			click(sqa);
			System.out.println("SQA option is clicked");
			Thread.sleep(2000);
			System.out.println("Assert verification is done for SQA home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void controlchart() {
		try {
			waittobeclickable(control, 20);
			click(control);
			System.out.println("Control center menu is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Control chart page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			Actions a = new Actions(driver);
			click(machinedd);
			List<WebElement> m = findWebElements(supplier);
			for(int i=1;i<m.size();i++) {
				if(i>1) {
					click(machinedd);
				}
				m.get(i).click();
				Thread.sleep(300);
				click(partdd);
				List<WebElement> p = findWebElements(partlist);
				for(int l=1;l<p.size();l++) {
					if(l>1) {
						click(partdd);
					}				
					p.get(l).click();
				Thread.sleep(300);
				click(chardd);
				List<WebElement> c = findWebElements(charlist);
				for(int j=1;j<c.size();j++) {
					if(j>1) {
						click(chardd);
					}				
					c.get(j).click();
					Thread.sleep(500);
					a.moveToElement(findWebElement(search)).click().perform();
					waittobeclickable(search, 10);
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
						log.info("No data found to display for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					else if(findWebElement(ichart).isDisplayed()!=true) {
						log.info("Ichart not displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					else {
						System.out.println("Ichart displayed for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
					}
					if(findWebElement(msg2).getText().contains("No data")) {
						log.info("No data found to display for "+gettext(txt)+" ----- "+gettext(txt2)+" ---- "+gettext(txt3));
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
		click(pdf);
		waittobeclickable(export, 10);
		click(export);
		click(jpg);
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

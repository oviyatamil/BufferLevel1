package org.quality;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Quality_ProductionEntry extends BasePage{

	public Quality_ProductionEntry(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By quality = By.xpath("//div[text()='Quality']");
	private By production = By.xpath("//span[contains(text(),'Production')]");
	private By prodentry = By.xpath("//span[contains(text(),'Production Entry')]");
	private By inspectentry = By.xpath("//span[contains(text(),'Inspection Data Entry')]");
	private By prodquant= By.xpath("//input[@formcontrolname='productionQuantity']");
//	private By product= By.xpath("//input[@formcontrolname='productionQuantity']");
	private By reject= By.xpath("//input[@formcontrolname='rejectionQuantity']");
	private By mvalue= By.xpath("//input[@formcontrolname='measuredValue']");
	private By lists = By.xpath("//div[@role='listbox']/mat-option/span");
	private By chip = By.xpath("//div[contains(@class,'mat-chip-list-wrapper')]/descendant::mat-chip");
	private By radio = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By actions = By.xpath("(//span[@class='mat-button-wrapper'])[13]");
	private By reason= By.xpath("//input[@formcontrolname='reason']");
	private By quantity= By.xpath("(//input[@formcontrolname='rejectionQuantity'])[2]");
	private By valuebox = By.xpath("(//mat-select[@role='combobox'])");
	private By partno= By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By partno2= By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By control= By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By machdd= By.xpath("//span[text()='Select Machine Name']/parent::mat-option/parent::div/mat-option");
	private By partnodd= By.xpath("//span[text()='Select Part Number']/parent::mat-option/parent::div/mat-option");
	private By controldd= By.xpath("//span[contains(text(),'Inspection Characteristics')]/following::div[@role='listbox']/mat-option");
	private By save = By.xpath("//span[text()=' Save ']");
	private By submit = By.xpath("//button[@type='submit']");
	private By profile = By.xpath("//span[contains(text(),'Master')]/following::button[5]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");

	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			Thread.sleep(2000);
			click(quality);
			System.out.println("Quality option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for quality home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void production() {
		try {
			waittobeclickable(production, 20);
			click(production);
			System.out.println("Production menu is clicked");
			waittobeclickable(prodentry, 20);
			click(prodentry);
			System.out.println("Production entry menu is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/production-dataEntry";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Production entry page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void inspection() {
		try {
			waittobeclickable(production, 20);
			click(production);
			System.out.println("Production menu is clicked");
			waittobeclickable(inspectentry, 20);
			click(inspectentry);
			System.out.println("Inspection entry menu is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/oee/InspectionDataEntry";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Inspection data entry page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void add() {
		try {
			click(partno);
			List<WebElement> p = findWebElements(partnodd);
			p.get(1).click();
			click(radio);
			EnterText(prodquant, "100");
			EnterText(reject, "2");
			click(actions);
			EnterText(reason, "low quality");
			EnterText(quantity, "2");
			click(save);
			System.out.println("Successfully entered production entry");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			click(partno);
			List<WebElement> m = findWebElements(machdd);
			m.get(1).click();
			click(partno2);
			List<WebElement> pd = findWebElements(partnodd);
			pd.get(1).click();
			click(control);
			Thread.sleep(500);
			List<WebElement> c = findWebElements(controldd);		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", c.get(c.size()-1));
		//	c.get(1).click();
			
			List<WebElement> chips = findWebElements(chip);
			for(int k=0;k<chips.size();k++) {
			if((findWebElement(valuebox).isDisplayed()==true) & (findWebElements(valuebox).size()>3)) {
				List<WebElement> l = findWebElements(valuebox);
				for(int i=3;i<l.size();i++) {
					l.get(i).click();
					List<WebElement> l2 = findWebElements(lists);
					l2.get(0).click();
					Thread.sleep(500);
				}
			}			
			else if(findWebElement(mvalue).isDisplayed()==true) {
				List<WebElement> mv = findWebElements(mvalue);
				for(int j=0;j<mv.size();j++) {
					mv.get(j).sendKeys("2");
				}
			}
			else {
			System.out.println("No value box");
			}
			click(submit);
//			if(findWebElement(next).isDisplayed()!=true) {
//				click(finish);			
//				}else {
//					click(next);
//				}
			Thread.sleep(500);
			}	
			
			System.out.println("Successfully entered inspection report");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		try {
			Thread.sleep(1000);
			click(profile);
			System.out.println("profile button is clicked");
			click(signout);
			System.out.println("signout button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

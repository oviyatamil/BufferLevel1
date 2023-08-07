package org.quality;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Masters_QualityDefects extends BasePage{

	public Masters_QualityDefects(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By quality = By.xpath("//div[text()='Quality']");
	private By qual = By.xpath("//span[contains(text(),'Quality Defects')]");
	private By master = By.xpath("//span[contains(text(),'Masters')]");
	private By add=By.xpath("//span[text()='Add']");
	private By defect= By.xpath("//input[@formcontrolname='defectName']");
	private By desc= By.xpath("//input[@formcontrolname='description']");
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By save = By.xpath("//span[text()=' Save ']");
	private By deflist = By.xpath("//table/tbody/tr/td[2]/span");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	
	
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

	public void Qualdef() {
		try {
			waittobeclickable(master, 10);
			click(master);
			System.out.println("Master menu is clicked");
			waittobeclickable(qual, 10);
			click(qual);
			System.out.println("Quality defects option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/qualityDefects";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Quality defects page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		try {
			click(add);
			EnterText(defect,"OK");
			EnterText(desc, "OK");
			click(save);
			click(cancelbtn);
			System.out.println("Duplicate defect is checked");
			click(add);
			EnterText(defect,"Defects");
			EnterText(desc, "Defect");
			click(save);
			System.out.println("Defect is added");
			Thread.sleep(1000);
			click(radio);
			click(view);
			click(cancelbtn);
			System.out.println("View option is checked");
			List<WebElement> rad = findWebElements(radio);
			List<WebElement> def = findWebElements(deflist);
			for(int i=0;i<def.size();i++) {
				if(def.get(i).getText().contains("Defects")) {
					rad.get(i).click();
				click(edit);
				clear(desc);
				EnterText(desc, "Defects");
				click(update);
				System.out.println("Edit and Update option is checked");
				List<WebElement> rad2 = findWebElements(radio);
				rad2.get(i).click();
				click(delete);
				click(delete2);
				System.out.println("Delete option is checked");
				
				
			}
			}
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

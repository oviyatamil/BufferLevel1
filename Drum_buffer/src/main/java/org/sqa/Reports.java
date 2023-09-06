package org.sqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Reports extends BasePage{

	public Reports(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By sqa = By.xpath("//div[contains(text(),'SQA')]/parent::div/child::button");
	private By reports = By.xpath("//span[contains(text(),'Report')]");	
	private By usagereport = By.xpath("//span[contains(text(),'Usage Report')]");
	private By suppdd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By supplier = By.xpath("//span[text()='All']/parent::mat-option/parent::div/mat-option");
	private By apply = By.xpath("//span[text()='Apply']");
	private By record = By.xpath("//table/tbody/tr/td[1]");
	private By partdd= By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
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
	
	public void usage() {
		try {
			waittobeclickable(reports, 10);
			click(reports);
			System.out.println("Report menu is clicked");
			waittobeclickable(usagereport, 10);
			click(usagereport);
			System.out.println("Usage Report menu is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Usage report page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void use() {
		try {
			click(suppdd);
			List<WebElement> m = findWebElements(supplier);
			for (int i = 1; i < m.size(); i++) {
				if(i>1) {
					click(suppdd);
				}
				m.get(i).click();
				Thread.sleep(500);
				click(partdd);
				List<WebElement> s = findWebElements(supplier);				
					s.get(0).click();
				click(apply);
				Thread.sleep(500);
				if (findWebElement(record).getText().contains("No Records") ){
					log.info("No records found");
				} else {
					System.out.println("Records found  for "+gettext(txt));
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

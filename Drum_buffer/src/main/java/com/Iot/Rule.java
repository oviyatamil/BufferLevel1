package com.Iot;

import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Rule extends BasePage{

	public Rule(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By rule = By.xpath("//div[contains(text(),'Rule Engine')]");
	private By ru = By.xpath("//span[text()='Rules']");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/parent::mat-option/parent::div/mat-option");
	private By paradd = By.xpath("(//mat-select[@role='combobox'])[6]/ancestor::div[1]/descendant::div[4]");
	private By paralist = By.xpath("//span[text()='Select Parameter']/parent::mat-option/parent::div/mat-option");
	private By condd = By.xpath("(//mat-select[@role='combobox'])[7]/ancestor::div[1]/descendant::div[4]");
	private By conlist = By.xpath("//span[text()='Select Condition']/parent::mat-option/parent::div/mat-option");
	private By reldd = By.xpath("(//mat-select[@role='combobox'])[8]/ancestor::div[1]/descendant::div[4]");
	private By maildd = By.xpath("(//mat-select[@role='combobox'])[9]/ancestor::div[1]/descendant::div[4]");
	private By smsdd = By.xpath("(//mat-select[@role='combobox'])[10]/ancestor::div[1]/descendant::div[4]");
	private By calldd = By.xpath("(//mat-select[@role='combobox'])[11]/ancestor::div[1]/descendant::div[4]");
	private By whatdd = By.xpath("(//mat-select[@role='combobox'])[12]/ancestor::div[1]/descendant::div[4]");
	private By maillist = By.xpath("//div[@role='listbox']/mat-option/mat-pseudo-checkbox");
	private By vallist = By.xpath("//span[text()='Select Relation']/parent::mat-option/parent::div/mat-option");
	private By value = By.xpath("//input[@formcontrolname='value']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By table = By.xpath("//table/tbody/tr/td");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By add = By.xpath("//span[text()='Add']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By radiobtn2 = By.xpath("(//span[@class='mat-radio-inner-circle'])[2]");
	private By radiobtn3 = By.xpath("(//span[@class='mat-radio-inner-circle'])[3]");
	private By view = By.xpath("//span[text()='View']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
	private By name = By.xpath("//input[@formcontrolname='Rule Name']");
	private By recu = By.xpath("//input[@formcontrolname='recurrency']");
	private By locdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("//span[text()='Select Location']/parent::mat-option/parent::div/mat-option");
	private By proddd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By prodlist = By.xpath("//span[text()='Select Product']/parent::mat-option/parent::div/mat-option");
	private By devdd = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By devlist = By.xpath("//span[text()='Select Product']/parent::mat-option/parent::div/mat-option");
	private By machdd = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[4]");
	private By machlist = By.xpath("//div[@role='listbox']/mat-option/mat-pseudo-checkbox");
	private By next = By.xpath("//span[contains(text(),'Next')]");
	private By next2 = By.xpath("(//span[contains(text(),'Next')])[2]");
	private By sms = By.xpath("//textarea[@formcontrolname='notification_SMS_Template']");
	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);			
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(rule, 20);
			click(rule);
			System.out.println("Rule engine menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void rule() {
		try {
			click(sitedd);
			List<WebElement> s = findWebElements(sitelist);
			for(int i=1;i<s.size();i++) {
				if(i>1) {
					click(sitedd);
					Thread.sleep(1000);
				}
				s.get(i).click();
				if(findWebElements(table).size()>1) {			
					if(findWebElement(table).getText().contains("No Record Found")!=true) {
						System.out.println("Table displayed");
					}else {
						log.info("No record found");
					}				
				}else {
					log.info("No record found");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void rulelist() {
		Actions a = new Actions(driver);
		click(ru);
		click(add);
		EnterText(rule, "Rule");
		click(sitedd);
		List<WebElement> s = findWebElements(sitelist);
		s.get(1).click();
		click(locdd);
		List<WebElement> s1 = findWebElements(loclist);
		s1.get(1).click();
		click(proddd);
		List<WebElement> s2 = findWebElements(prodlist);
		s2.get(1).click();
		click(devdd);
		List<WebElement> s3 = findWebElements(devlist);
		s3.get(1).click();
		click(machdd);
		List<WebElement> s4 = findWebElements(machlist);
		s4.get(1).click();
		a.moveToElement(findWebElement(radiobtn2)).click().perform();
		click(radiobtn2);
		click(next);
		
		click(paradd);
		List<WebElement> k = findWebElements(paralist);
		k.get(1).click();
		click(condd);
		List<WebElement> k1 = findWebElements(conlist);
		k1.get(1).click();
		EnterText(value, "456");
		click(reldd);
		List<WebElement> k2 = findWebElements(vallist);
		k2.get(1).click();
		click(save);
		click(next2);
		click(radiobtn3);
		click(maildd);
		List<WebElement> m = findWebElements(maillist);
		m.get(1).click();
		a.moveToElement(findWebElement(smsdd)).click().perform();
		click(smsdd);
		List<WebElement> m1 = findWebElements(maillist);
		m1.get(1).click();
		
		a.moveToElement(findWebElement(calldd)).click().perform();
		click(calldd);
		List<WebElement> m2 = findWebElements(maillist);
		m2.get(1).click();
		
		a.moveToElement(findWebElement(whatdd)).click().perform();
		click(whatdd);
		List<WebElement> m3= findWebElements(maillist);
		m3.get(1).click();
		a.moveToElement(findWebElement(sms)).click().perform();
		EnterText(sms, "status:pass");
		EnterText(recu, "35");
		click(next);
		
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

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
	private By ru = By.xpath("//span[contains(text(),'Rules')]");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/parent::mat-option/parent::div/mat-option");
	private By paradd = By.xpath("(//mat-label[contains(text(),'Parameter')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By paralist = By.xpath("//span[text()='Select Parameter']/parent::mat-option/parent::div/mat-option");
	private By condd = By.xpath("(//mat-label[contains(text(),'Condition')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By conlist = By.xpath("//span[text()='Select Condition']/parent::mat-option/parent::div/mat-option");
	private By reldd = By.xpath("(//mat-label[contains(text(),'Relation')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By maildd = By.xpath("(//mat-label[contains(text(),'Email')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By smsdd = By.xpath("(//mat-label[contains(text(),'SMS')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By calldd = By.xpath("(//mat-label[contains(text(),'Call')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By whatdd = By.xpath("(//mat-label[contains(text(),'WhatsApp')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By maillist = By.xpath("//div[@role='listbox']/mat-option/mat-pseudo-checkbox");
	private By vallist = By.xpath("//span[text()='Select Relation']/parent::mat-option/parent::div/mat-option");
	private By value = By.xpath("//input[@formcontrolname='value']");
	private By emailid =By.xpath("(//mat-label[contains(text(),'Email')])[3]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By smsnum =By.xpath("(//mat-label[contains(text(),'SMS')])[3]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By interval =By.xpath("(//mat-label[contains(text(),'Interval')])[1]/ancestor::div[1]/mat-select/descendant::div[4]");
	private By escalate = By.xpath("//input[@formcontrolname='after']");
	private By rulename = By.xpath("//input[@formcontrolname='rule_Name']");
	private By interlist = By.xpath("//span[text()='Select Interval']/parent::mat-option/parent::div/mat-option");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By table = By.xpath("//table/tbody/tr/td");
	private By table2 = By.xpath("//table/tbody/tr/td[2]/span");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By submit = By.xpath("//span[contains(text(),'submit')]");
	private By add = By.xpath("//span[text()='Add']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By radiobtn2 = By.xpath("(//span[@class='mat-radio-inner-circle'])[2]");
	private By radiobtn3 = By.xpath("(//span[@class='mat-radio-inner-circle'])[3]");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
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
	private By next3 = By.xpath("(//span[contains(text(),'Next')])[3]");
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
						Thread.sleep(500);
					}else {
						log.info("No record found");
					}				
				}else {
					log.info("Table not displayed");
					Thread.sleep(500);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void rulelist() {
		try {
			Actions a = new Actions(driver);
			click(ru);
			Thread.sleep(500);
			click(add);
			EnterText(rulename, "Abc");
			Thread.sleep(200);
			click(sitedd);
			List<WebElement> s = findWebElements(sitelist);		
			Thread.sleep(200);
			s.get(1).click();
			Thread.sleep(200);
			click(locdd);
			List<WebElement> s1 = findWebElements(loclist);	
			Thread.sleep(200);
			s1.get(1).click();
			Thread.sleep(200);
			click(proddd);
			List<WebElement> s2 = findWebElements(prodlist);	
			Thread.sleep(200);
			s2.get(1).click();
			Thread.sleep(200);			
			click(devdd);
			List<WebElement> s3 = findWebElements(devlist);		
			Thread.sleep(200);
			s3.get(1).click();
			Thread.sleep(500);
			click(machdd);
			List<WebElement> s4 = findWebElements(machlist);	
			Thread.sleep(200);
			s4.get(1).click();
			Thread.sleep(200);
			a.moveToElement(findWebElement(radiobtn2)).click().perform();
			click(radiobtn2);
			click(next);
			Thread.sleep(500);
			click(paradd);
			List<WebElement> k = findWebElements(paralist);
			Thread.sleep(200);
			k.get(1).click();
			Thread.sleep(200);
			click(condd);
			List<WebElement> k1 = findWebElements(conlist);
			Thread.sleep(200);
			k1.get(1).click();
			Thread.sleep(200);
			EnterText(value, "456");
			click(reldd);
			List<WebElement> k2 = findWebElements(vallist);
			Thread.sleep(200);
			k2.get(1).click();	
			Thread.sleep(200);
			click(next2);
			Thread.sleep(500);
			click(radiobtn3);
			Thread.sleep(200);
			click(maildd);
			List<WebElement> m = findWebElements(maillist);
			Thread.sleep(200);
			m.get(1).click();
			a.moveToElement(findWebElement(smsdd)).click().perform();
			Thread.sleep(200);
			click(smsdd);
			List<WebElement> m1 = findWebElements(maillist);
			Thread.sleep(200);
			m1.get(1).click();
			
			a.moveToElement(findWebElement(calldd)).click().perform();
			Thread.sleep(200);
			click(calldd);
			List<WebElement> m2 = findWebElements(maillist);
			Thread.sleep(200);
			m2.get(1).click();
			
			a.moveToElement(findWebElement(whatdd)).click().perform();
			Thread.sleep(200);
			click(whatdd);
			List<WebElement> m3= findWebElements(maillist);
			Thread.sleep(200);
			m3.get(1).click();
			a.moveToElement(findWebElement(sms)).click().perform();
			Thread.sleep(200);
			EnterText(sms, "status:pass");
			EnterText(recu, "35");
			Thread.sleep(200);
			click(next3);
			Thread.sleep(500);
			click(emailid);
			List<WebElement> m4= findWebElements(maillist);
			Thread.sleep(200);
			m4.get(1).click();
			a.moveToElement(findWebElement(smsnum)).click().perform();
			Thread.sleep(200);
			click(smsnum);
			List<WebElement> m5= findWebElements(maillist);
			Thread.sleep(200);
			m5.get(1).click();
			a.moveToElement(findWebElement(escalate)).click().perform();
			Thread.sleep(200);
			EnterText(escalate, "10");
			click(interval);
			List<WebElement> m6= findWebElements(interlist);
			Thread.sleep(200);
			m6.get(1).click();
			a.moveToElement(findWebElement(submit)).click().perform();
			Thread.sleep(200);
			click(submit);
			Thread.sleep(1000);
			List<WebElement> f = findWebElements(table2);
			for(int i=0;i<f.size();i++) {
				if(f.get(i).getText().equals("Abc")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					Thread.sleep(200);
					click(delete);
					click(delete2);
					System.out.println("Rule list is deleted");
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

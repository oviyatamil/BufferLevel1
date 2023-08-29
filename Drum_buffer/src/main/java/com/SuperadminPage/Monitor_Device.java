package com.SuperadminPage;

import org.openqa.selenium.interactions.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Monitor_Device extends BasePage{

	public Monitor_Device(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By superadmin = By.xpath("//div[text()='Super Admin']");
	private By master = By.xpath("//span[contains(text(),'Master Data')]");
	private By dev = By.xpath("(//div[contains(text(),'Monitoring Device')])");
	private By device = By.xpath("//input[@formcontrolname='device_Type']");
	private By edge = By.xpath("//input[@formcontrolname='device_Make']");
	private By desc = By.xpath("//input[@formcontrolname='device_Name']");
	private By reg = By.xpath("//input[@formcontrolname='register']");
	private By proddd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By prodlist = By.xpath("//span[contains(text(),'Select Product Name')]/ancestor::div[1]/mat-option/span");
	private By paradd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By paralist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By datadd = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By add = By.xpath("//span[text()='Add']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By plus = By.xpath("//mat-icon[@mattooltip='Click to Add']");
	private By tick = By.xpath("//button[@mattooltip='Click to Save']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	private By roles = By.xpath("//table/tbody/tr/td[2]/span");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(superadmin, 20);
			click(superadmin);
			System.out.println("Super admin menu option is clicked");
			Thread.sleep(2000);
			System.out.println("Assert verification is done for super admin home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void mondev() {
		try {
			click(master);
			Thread.sleep(1000);
			click(dev);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void add() {
		try {
			Actions a = new Actions(driver);
			click(add);
			EnterText(device, "Analytic device");
			EnterText(edge, "edge");
			EnterText(desc, "Monitor");
			click(proddd);
			List<WebElement> uom = findWebElements(prodlist);
			uom.get(1).click();
			click(plus);
			Thread.sleep(500);
			a.moveToElement(findWebElement(paradd)).click().perform();
			click(paradd);
			List<WebElement> uom2 = findWebElements(paralist);
			uom2.get(1).click();
			EnterText(reg, "12345");
			click(datadd);
			Thread.sleep(500);
			List<WebElement> uom3 = findWebElements(paralist);
			uom3.get(1).click();
			click(tick);
			click(save);
			Thread.sleep(1000);
			click(add);
			EnterText(device, "Analytic device");
			EnterText(edge, "edge");
			EnterText(desc, "Monitor");
			click(proddd);
			List<WebElement> uom1 = findWebElements(prodlist);
			uom1.get(1).click();
			click(plus);
			Thread.sleep(500);
			a.moveToElement(findWebElement(paradd)).click().perform();
			click(paradd);
			List<WebElement> uom21 = findWebElements(paralist);
			uom21.get(1).click();
			EnterText(reg, "12345");
			click(datadd);
			Thread.sleep(500);
			List<WebElement> uom31 = findWebElements(paralist);
			uom31.get(1).click();
			click(tick);
			click(save);
			Thread.sleep(200);
			click(cancel);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void radio() {
		try {
			Thread.sleep(1000);
			click(radiobtn);
			System.out.println("radio button is clicked");
			click(view);
			System.out.println("view button is clicked");
			click(cancel);
			System.out.println("cancel button is clicked after clicking view option");
			click(radiobtn);
			click(cancel);
			System.out.println("cancel button is clicked after clicking radio button");
			Thread.sleep(1000);
			List<WebElement> r = findWebElements(roles);
			for(int i=0;i<r.size();i++) {
				if(r.get(i).getText().equals("Analytic device")) {
			//		List<WebElement> m = findWebElements(mail);
			//		if(m.get(i).getText().equals("aadav@gmail.com")) {
						List<WebElement> rad = findWebElements(radiobtn);
						rad.get(i).click();
						click(edit);
						System.out.println("edit button is clicked");
						clear(edge);
						System.out.println("edge is cleared");
						EnterText(edge, "Sensor");
						click(update);
						System.out.println("update button is clicked");
						Thread.sleep(1000);
						break;
					}else {
						 continue;
					}
				}							
			List<WebElement> r2 = findWebElements(roles);
			for(int i=0;i<r2.size();i++) {
				if(r2.get(i).getText().equals("Analytic device")) {					
						List<WebElement> rad = findWebElements(radiobtn);
						rad.get(i).click();
						click(delete);
						System.out.println("delete button is clicked");
						click(delete2);
						System.out.println("confirm delete button is clicked");
						Thread.sleep(1000);
						break;
					}
				else {
					continue;
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
	
	

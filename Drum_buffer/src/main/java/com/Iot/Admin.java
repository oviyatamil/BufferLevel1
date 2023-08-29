package com.Iot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Admin extends BasePage {

	public Admin(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By admin = By.xpath("//div[contains(text(),'Admin') or contains(text(),'Organisation')]");
	private By threedots = By.xpath("//table/tbody/tr/td[8]/button");
	private By location = By.xpath("//span[contains(text(),'Location')]");
	private By site = By.xpath("//span[contains(text(),'Site')]");
	private By loclist = By.xpath("//table/tbody/tr/td[3]/span");
	private By shiftlist = By.xpath("//table/tbody/tr/td[2]/span");
	private By dep = By.xpath("//span[contains(text(),'Department')]");
	private By zone = By.xpath("//span[contains(text(),'Zone')]");
	private By locname = By.xpath("//input[@formcontrolname='name']");
	private By floor = By.xpath("//input[@formcontrolname='zone_Name']");
	private By desc = By.xpath("//input[@formcontrolname='zone_Description']");
	private By sensordd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By ceilingdd = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By sensorlist = By.xpath("//span[text()='Select Sensor']/parent::mat-option/parent::div/mat-option");
	private By ceilinglist = By.xpath("//span[text()='Select Ceiling Type']/parent::mat-option/parent::div/mat-option");
	private By device = By.xpath("//input[@formcontrolname='device_Address']");
	private By xaxis = By.xpath("//input[@formcontrolname='xAxis']");
	private By yaxis = By.xpath("//input[@formcontrolname='yAxis']");
	private By loop = By.xpath("//input[@formcontrolname='loop']");
	private By register = By.xpath("//input[@formcontrolname='register']");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[contains(text(),'25')]");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By ddlist = By.xpath("//span[text()='Select Department']/parent::mat-option/parent::div/mat-option");

	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By loc = By.xpath("//div[contains(text(),'Location Listing')]");	
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");		
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");	
	private By shift = By.xpath("//span[contains(text(),'Shift')]");
	private By sname = By.xpath("//input[@formcontrolname='shift_Name']");
	private By start = By.xpath("//input[@formcontrolname='start_Time']");
	private By start2 = By.xpath("(//input[@formcontrolname='start_Time'])[2]");
	private By breakname = By.xpath("//input[@formcontrolname='break_Name']");
	private By breakmin = By.xpath("//input[@formcontrolname='break_Minutes']");
	private By end = By.xpath("//input[@formcontrolname='end_Time']");
	private By end2 = By.xpath("(//input[@formcontrolname='end_Time'])[2]");
	private By action = By.xpath("//mat-icon[@mattooltip='Click to Add']");
	private By tick = By.xpath("//table/tbody/tr/td[6]/button");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);			
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(admin, 20);
			click(admin);
			System.out.println("Admin/Organisation menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	
	public void loc() {
		try {
			click(threedots);
			click(location);
			Thread.sleep(500);
			click(add);
			EnterText(locname, "4Terrace");
			click(save);
			click(pagedd);
			click(pagesize);
			Thread.sleep(500);
			List<WebElement> l = findWebElements(loclist);
			for(int i=0;i<l.size();i++) {
				if(l.get(i).getText().equals("4Terrace")) {
					WebElement rad = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[9]/button"));
					rad.click();
					click(dep);
					break;
				}
			}
			Thread.sleep(500);
			click(add);
			click(dd);
			List<WebElement> d = findWebElements(ddlist);
			d.get(1).click();
			click(save);
			System.out.println("Location is added");
			Thread.sleep(500);
			click(radiobtn);
			click(view);
			click(cancelbtn);
			click(loc);
			Thread.sleep(200);
			click(pagedd);
			click(pagesize);
			Thread.sleep(500);
			List<WebElement> l2 = findWebElements(loclist);
			for(int i=0;i<l2.size();i++) {
				if(l2.get(i).getText().equals("4Terrace")) {
					WebElement rad = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[9]/button"));
					rad.click();
					click(zone);
					break;
				}
			}
			Thread.sleep(200);
			click(add);
			click(dd);
			List<WebElement> d2 = findWebElements(ddlist);
			d2.get(1).click();
			EnterText(floor, "2");
			EnterText(desc, "asdf");
			EnterText(device, "1234");
			EnterText(xaxis, "45");
			EnterText(yaxis, "50");
			click(sensordd);
			List<WebElement> sl = findWebElements(sensorlist);
			sl.get(1).click();
			EnterText(loop, "23");
			EnterText(register, "34567");
			click(ceilingdd);
			List<WebElement> ce = findWebElements(ceilinglist);
			ce.get(1).click();
			click(save);
			Thread.sleep(500);
			System.out.println("Zone is added");
			click(loc);
			Thread.sleep(500);
			List<WebElement> l3 = findWebElements(loclist);
			for(int i=0;i<l3.size();i++) {
				if(l3.get(i).getText().equals("4Terrace")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					Thread.sleep(500);
					click(delete);
					click(delete2);	
					System.out.println("Location is deleted");
					break;
				}
			}
			Thread.sleep(500);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public void shift() {
		try {
			click(site);
			click(threedots);
			click(shift);
			Thread.sleep(300);
			click(add);
			EnterText(sname, "Dayshift");
			EnterText(start, "0830am");
			EnterText(end, "0530pm");
			click(action);
			EnterText(breakname, "break");
			EnterText(start2, "1000am");
			EnterText(end2, "1015am");
			EnterText(breakmin, "15");
			click(tick);
			click(save);
			System.out.println("Shift is added");
			Thread.sleep(500);
			List<WebElement> s = findWebElements(shiftlist);
			for(int i=0;i<s.size();i++) {
				if(s.get(i).getText().equals("Dayshift")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					click(delete);
					click(delete2);		
					System.out.println("Shift is deleted");
					break;
				}
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	public void profile() {
		try {
			Thread.sleep(500);
			click(profile);
			System.out.println("profile button is clicked");
			click(signout);
			System.out.println("signout button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

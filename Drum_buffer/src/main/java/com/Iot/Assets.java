package com.Iot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Assets extends BasePage{

	public Assets(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By assets = By.xpath("//div[contains(text(),'Assets')]");	
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/parent::mat-option/parent::div/mat-option");
	private By edgedd = By.xpath("(//mat-select[@role='combobox'])[6]/ancestor::div[1]/descendant::div[4]");
	private By gatedd = By.xpath("(//mat-select[@role='combobox'])[7]/ancestor::div[1]/descendant::div[4]");
	private By siddd = By.xpath("(//mat-select[@role='combobox'])[8]/ancestor::div[1]/descendant::div[4]");
	
	private By sys = By.xpath("//input[@formcontrolname='subsystem_Name']");
	private By catdd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By catlist = By.xpath("(//span[text()='Select Category'])/ancestor::div[1]/mat-option/span");
	private By sitelist2 = By.xpath("//div[@role='listbox']/mat-option/span");
	private By locdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("//span[text()='Select Location']/parent::mat-option/parent::div/mat-option");
	private By plus = By.xpath("//mat-icon[@mattooltip='Click to Add']/parent::span");
	private By tick = By.xpath("//button[@mattooltip='Click to Save']/child::span[1]");
	private By typedd = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By typelist = By.xpath("(//span[text()='Select EquipmentType'])/ancestor::div[1]/mat-option/span");
	private By sublist = By.xpath("//table/tbody/tr/td[2]/span");
	private By isdd = By.xpath("(//mat-select[@role='combobox'])[5]/ancestor::div[1]/descendant::div[4]");
	private By islist = By.xpath("(//span[text()=' Select IS '])/ancestor::div[1]/mat-option/span");
	private By eqname = By.xpath("//input[@formcontrolname='equipment_Name']");
	private By manu = By.xpath("//input[@formcontrolname='manufacturer']");
	private By model = By.xpath("//input[@formcontrolname='model']");
	private By calendar = By.xpath("//mat-label[text()='Installation Date']/following::button[1]/span[1]");
	private By radio = By.xpath("//table/tbody/tr/td[1]/descendant::span[1]/span[2]");
	private By img = By.xpath("//input[@type='file']");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By save1 = By.xpath("(//button[@type='submit'])");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By edit2 = By.xpath("(//span[contains(text(),'Edit')])[2]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
//	private By update2 = By.xpath("(//span[contains(text(),'Update')])[2]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn2 = By.xpath("(//span[contains(text(),'Cancel')])[2]");
	private By cancelbtn = By.xpath("(//span[contains(text(),'Cancel')])");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("(//button[@type='submit'])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);			
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(assets, 20);
			click(assets);
			System.out.println("Assets menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void assets() {
		try {
		//	Actions a = new Actions(driver);
			click(add);
			click(sitedd);
			Thread.sleep(100);
			List<WebElement> s = findWebElements(sitelist);
			s.get(1).click();
			click(locdd);
			Thread.sleep(100);
			List<WebElement> s2 = findWebElements(loclist);
			s2.get(1).click();
			click(catdd);
			Thread.sleep(100);
			List<WebElement> s3 = findWebElements(catlist);
			for(WebElement x:s3) {
				if(x.getText().equals("Equipment cat")) {
					x.click();
					break;
				}
			}
			click(typedd);
			Thread.sleep(100);
			List<WebElement> t = findWebElements(typelist);
			t.get(1).click();
			EnterText(eqname, "Machinery");
			click(isdd);
			Thread.sleep(100);
			List<WebElement> i = findWebElements(islist);
			i.get(1).click();
			EnterText(manu, "Tata");
			EnterText(model, "note5");
			click(calendar);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			String[] split = data.split(" ");
			String ss = split[0].toUpperCase();
			Thread.sleep(1000);
			click(yeardd);
			click(year);		
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + ss + "')]/parent::button"));
			mon.click();		
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m = split3[1];
			int p = Integer.parseInt(m);
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'" + p + "')]/parent::button"));
			end.click();
			EnterText(img, "C:\\Users\\oviya\\Pictures\\spindle.png");
			click(save1);
			Thread.sleep(1000);
			click(add);
			EnterText(sys, "systemuser");
			click(plus);
			click(edgedd);
			List<WebElement> st = findWebElements(sitelist2);
			st.get(0).click();
			Thread.sleep(500);
			click(gatedd);
			List<WebElement> st2 = findWebElements(sitelist2);
			st2.get(0).click();
			Thread.sleep(500);
			click(siddd);
			List<WebElement> st3 = findWebElements(sitelist2);
			st3.get(0).click();
			Thread.sleep(100);
			click(tick);						
			click(save);
			Thread.sleep(500);
			click(radio);
			click(view);
			click(cancelbtn2);
			List<WebElement> f = findWebElements(sublist);
			for(int j=0;j<f.size();j++) {
				if(f.get(j).getText().equals("systemuser")) {
					List<WebElement> r = findWebElements(radio);
					r.get(j).click();
			break;
				}
			}
			click(edit2);
			clear(sys);
			EnterText(sys, "SystemInfo");
			click(update);
			Thread.sleep(500);
			click(cancelbtn2);
			Thread.sleep(2000);
			List<WebElement> su = findWebElements(sublist);
			for(int j=0;j<su.size();j++) {
				if(su.get(j).getText().equals("Machinery")) {
					List<WebElement> r = findWebElements(radio);
					r.get(j).click();
					click(edit);
					clear(model);
					EnterText(model, "Oneplus");
					click(update);					
					waittobeclickable(cancelbtn2, 10);
					click(cancelbtn2);
					Thread.sleep(500);	
					break;				
					}
			}
			for(int j=0;j<su.size();j++) {
				List<WebElement> su2 = findWebElements(sublist);
				if(su2.get(j).getText().equals("Machinery")) {
					List<WebElement> r = findWebElements(radio);
					r.get(j).click();
					click(delete);
					click(delete2);
					Thread.sleep(500);	
					break;				
					}
			}
			
		} catch (NumberFormatException | InterruptedException e) {
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

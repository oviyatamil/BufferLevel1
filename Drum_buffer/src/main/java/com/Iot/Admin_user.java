package com.Iot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import com.BasePage.BasePage;

public class Admin_user extends BasePage{

	public Admin_user(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By admin = By.xpath("//div[contains(text(),'Admin') or contains(text(),'Organisation')]");
	private By threedots = By.xpath("//table/tbody/tr/td[8]/button");
	private By location = By.xpath("//span[contains(text(),'Location')]");
	private By userm = By.xpath("//span[contains(text(),'User Management')]");
	private By user = By.xpath("//div[contains(text(),'User')]");
	private By masterdata = By.xpath("//span[contains(text(),'Master Data')]");
	private By cat = By.xpath("//input[@formcontrolname='name']");
	private By desc = By.xpath("//input[@formcontrolname='description']");
	private By dep = By.xpath("//input[@formcontrolname='department_Name']");
	
	private By catlist = By.xpath("//table/tbody/tr/td[2]/span");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By equipcat = By.xpath("//div[contains(text(),'Equipment Category')]");
	private By equip = By.xpath("//div[contains(text(),'Equipment Type')]");
	private By depart = By.xpath("//div[contains(text(),'Department')]");
	private By categorylist = By.xpath("(//span[text()='Select Category'])/ancestor::div[1]/mat-option/span");
//	private By type = By.xpath("//input[@formcontrolname='description']");
	
	private By loclist = By.xpath("//table/tbody/tr/td[3]/span");
	private By shiftlist = By.xpath("//table/tbody/tr/td[2]/span");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By rolename = By.xpath("//input[@formcontrolname='role_Name']");
	private By diaanalytics = By.xpath("(//div[contains(text(),'Analytics')]/ancestor::span/descendant::span[1])[1]");
	private By energykpi = By.xpath("(//div[contains(text(),'KPI')]/ancestor::span/descendant::span[1])[2]");
	private By firerep = By.xpath("(//div[text()=' Monitoring '])[3]/following::tr[3]/td[1]/mat-checkbox");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By roledd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By rolelist = By.xpath("(//span[text()='Select Role'])/ancestor::div[1]/mat-option/span");
	private By sitelist = By.xpath("//div[@role='listbox']/mat-option/mat-pseudo-checkbox");
	private By name = By.xpath("//input[@formcontrolname='userName']");
	private By ph = By.xpath("//input[@formcontrolname='user_Mobile']");
	private By address = By.xpath("//input[@formcontrolname='address1']");	
	private By mail = By.xpath("//input[@formcontrolname='user_Email']");
	private By pwd = By.xpath("//input[@formcontrolname='user_Password']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	
	
	
	
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
	public void user() {
		try {
			Actions a = new Actions(driver);
			click(userm);
			click(add);
			EnterText(rolename, "asdfg");
			click(diaanalytics);
			waittobeclickable(energykpi, 10);
			click(energykpi);
			waittobeclickable(firerep, 10);
			click(firerep);
			waittobeclickable(save, 10);
			click(save);
			Thread.sleep(1000);
			click(user);
			click(add);
			Thread.sleep(500);
			click(sitedd);
			List<WebElement> r2 = findWebElements(sitelist);
			r2.get(0).click();
			a.moveToElement(findWebElement(roledd)).click().perform();
			click(roledd);
			List<WebElement> r = findWebElements(rolelist);
			for (int i = 1; i < r.size(); i++) {
				String text = r.get(i).getText();
				if(text.equals("asdfg")) {
					r.get(i).click();
					break;
				}
				Thread.sleep(100);
				
			}
			EnterText(name, "maya");
			EnterText(ph, "7657657655");		
			EnterText(mail, "maya@yahoo.com");
			EnterText(pwd, "Admin@123");
			EnterText(address, "Madurai");
			click(save);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void equipcat() {
		try {
			click(masterdata);
			Thread.sleep(500);
//			click(add);
//			EnterText(cat, "Chocolate");
//			EnterText(desc, "candy");
//			click(save);
//			Thread.sleep(1000);
//			click(radiobtn);
//			click(view);
//			click(cancelbtn);
			List<WebElement> c = findWebElements(catlist);
			for(int i=0;i<c.size();i++) {
				if(c.get(i).getText().equals("Chocolate")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					click(edit);
					clear(desc);
					EnterText(desc, "candies");
					click(update);
					Thread.sleep(500);									
				}
			}
			click(equip);
			click(add);
			click(sitedd);
			List<WebElement> ca = findWebElements(categorylist);
			for(WebElement x:ca) {
				if(x.getText().equals("Chocolate")) {
					x.click();
					break;
				}
			}
			EnterText(cat, "Art");
			click(save);
			Thread.sleep(200);	
			List<WebElement> c2 = findWebElements(catlist);
			for(int i=0;i<c2.size();i++) {
				if(c2.get(i).getText().equals("Art")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					click(edit);
					clear(cat);
					EnterText(cat, "Arts");
					click(update);
					Thread.sleep(500);
					r.get(i).click();
					click(delete);
					click(delete2);
					break;
				}
			}
			click(depart);
			click(add);
			EnterText(dep, "ECE");
			EnterText(desc, "Electronics");
			click(save);
			List<WebElement> c3 = findWebElements(catlist);
			for(int i=0;i<c3.size();i++) {
				if(c3.get(i).getText().equals("ECE")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					click(edit);
					clear(desc);
					EnterText(desc, "Communication");
					click(update);
					Thread.sleep(500);
					r.get(i).click();
					click(delete);
					click(delete2);
					break;
				}
			}
			click(equipcat);
			Thread.sleep(1000);
			List<WebElement> c4 = findWebElements(catlist);
			for(int i=0;i<c4.size();i++) {
				if(c4.get(i).getText().equals("Chocolates")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					click(delete);
					click(delete2);
					break;									
				}
			}
			
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

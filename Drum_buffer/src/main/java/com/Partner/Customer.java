package com.Partner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Customer extends BasePage{

	public Customer(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By partner = By.xpath("//div[contains(text(),'Partner portal')]");	
	private By topcus = By.xpath("//div[contains(text(),'Customer Listing')]");	
	private By customer = By.xpath("//span[contains(text(),'Customer')]");
	private By add = By.xpath("//span[contains(text(),'Add')]");	
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("(//span[contains(text(),'Update')])");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");		
	private By site = By.xpath("(//span[contains(text(),'Site')])");
	private By sub = By.xpath("(//span[contains(text(),'Subscription')])");	
	private By sitetext = By.xpath("//input[@formcontrolname='name']");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By cuslist = By.xpath("//table/tbody/tr/td[2]/span");
	private By numlist = By.xpath("//table/tbody/tr/td[5]/span");
	private By cus = By.xpath("//input[@formcontrolname='customer_Name']");
	private By contact = By.xpath("//input[@formcontrolname='contact_Person']");
	private By num = By.xpath("//input[@formcontrolname='mobile']");
	private By mail = By.xpath("//input[@formcontrolname='email']");
	private By pwd = By.xpath("//input[@formcontrolname='password']");
	private By add1 = By.xpath("//input[@formcontrolname='address1']");
	private By add2 = By.xpath("//input[@formcontrolname='address2']");
	private By zip = By.xpath("//input[@formcontrolname='postal_Code']");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date Range')]/following::span[1]");
	private By coudd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By stadd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By citydd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By coulist = By.xpath("(//span[text()='Select Country'])/ancestor::div[1]/mat-option/span");
	private By stalist = By.xpath("(//span[text()='Select State'])/ancestor::div[1]/mat-option/span");
	private By citylist = By.xpath("(//span[text()='Select City'])/ancestor::div[1]/mat-option/span");
	private By sitelist = By.xpath("(//span[text()='Select Site'])/ancestor::div[1]/mat-option/span");
	private By prolist = By.xpath("(//span[text()='Select Product'])/ancestor::div[1]/mat-option/span");
	private By qua = By.xpath("//input[@formcontrolname='quantity_Subscribed']");
	private By subscribe = By.xpath("//input[@formcontrolname='subscription_Amount']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]/parent::button");
	

	public void home() {
		try {
			waittobeclickable(ninedots, 20);			
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(partner, 20);
			click(partner);
			System.out.println("Partner menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void add() {
		try {
			waittobeclickable(customer, 20);			
			click(customer);
			System.out.println("Customer button is clicked");
			click(add);
			EnterText(cus, "Aradhya");
			EnterText(contact, "maya");
			EnterText(num, "7654334567");
			EnterText(mail, "Aradhya@gmail.com");
			EnterText(pwd, "Admin@123");
			EnterText(add1, "Coorg");
			EnterText(add2, "Ooty");
			click(coudd);
			List<WebElement> c = findWebElements(coulist);
			c.get(1).click();
			Thread.sleep(300);
			click(stadd);
			List<WebElement> c2 = findWebElements(stalist);			
			c2.get(1).click();
			Thread.sleep(300);
			click(citydd);
			List<WebElement> c3 = findWebElements(citylist);
			c3.get(1).click();
			Thread.sleep(300);
			EnterText(zip, "607890");
			click(save);
			click(cancelbtn);
			System.out.println("Customer is already added");
			Thread.sleep(1000);
			List<WebElement> cu = findWebElements(cuslist);
			for(int i=0;i<cu.size();i++) {
				if(cu.get(i).getText().equals("Aradhya")) {
					WebElement d = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[7]/child::button/span[1]"));
				d.click();
				click(site);
				break;
				}
			}
			Thread.sleep(500);
			click(add);
			EnterText(sitetext, "Coorg");
			EnterText(contact, "maya");
			EnterText(num, "7654394567");
			EnterText(add1, "Coorg");
			EnterText(add2, "Ooty");
			click(coudd);
			List<WebElement> cc = findWebElements(coulist);
			Thread.sleep(200);
			cc.get(1).click();	
			Thread.sleep(100);
			click(stadd);
			List<WebElement> cc2 = findWebElements(stalist);
			Thread.sleep(200);
			cc2.get(1).click();	
			Thread.sleep(100);
			click(citydd);
			List<WebElement> cc3 = findWebElements(citylist);
			Thread.sleep(200);
			cc3.get(1).click();
			Thread.sleep(100);
			EnterText(zip, "607890");
			click(save);
			System.out.println("Site is added");
			Thread.sleep(1000);
			List<WebElement> nu = findWebElements(numlist);
			for(int j=0;j<nu.size();j++) {
				WebElement r = driver.findElement(By.xpath("//table/tbody/tr["+(j+1)+"]/td[5]/span"));
				if(r.getText().equals("7654394567")) {
					List<WebElement> rad = findWebElements(radiobtn);
					rad.get(j).click();
					click(edit);
					clear(add1);
					EnterText(add1, "Kkdi");
					click(update);
					break;
				}
			}
			Thread.sleep(500);
			System.out.println("Site is updated");
//	List<WebElement> nu = findWebElements(numlist);
//			for(int j=0;j<nu.size();j++) {
//				WebElement r = driver.findElement(By.xpath("//table/tbody/tr["+(j+1)+"]/td[5]/span"));
//				if(r.getText().equals("7654394567")) {
//					List<WebElement> rad = findWebElements(radiobtn);
//					rad.get(j).click();
//					click(delete);
//					click(delete2);
//					break;
//				}
//			}
//			System.out.println("Site is deleted");
			Thread.sleep(500);
			click(topcus);
			Thread.sleep(500);
			List<WebElement> cu2 = findWebElements(cuslist);
			for(int i=0;i<cu2.size();i++) {
				if(cu2.get(i).getText().equals("Aradhya")) {
					WebElement d = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[7]/child::button/span[1]"));
				d.click();
				Thread.sleep(200);
				click(sub);
				break;
				}
			}
			Thread.sleep(300);
			click(add);
			Thread.sleep(200);
			click(coudd);
			List<WebElement> st = findWebElements(sitelist);
			Thread.sleep(200);
			st.get(1).click();
			Thread.sleep(100);
			click(stadd);
			List<WebElement> p = findWebElements(prolist);
			Thread.sleep(100);
			p.get(3).click();
			Thread.sleep(100);
			EnterText(qua, "45");
			EnterText(subscribe, "650");
			click(calendar);
			String data = new SimpleDateFormat("MMM dd yyyy").format(new Date());
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			Thread.sleep(1000);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + s + "')]/parent::button"));
			mon.click();
			String s2 = split[1];
			int p2 = Integer.parseInt(s2);			
			WebElement sta = driver.findElement(By.xpath("//div[contains(text(),'" + p2 + "')]/parent::button"));
			sta.click();		
			sta.click();
			click(save);
			System.out.println("Subscription is added");
			Thread.sleep(1000);
//			List<WebElement> cuu = findWebElements(cuslist);
//			for(int j=0;j<cuu.size();j++) {			
//				if(cuu.get(j).getText().equals("Coorg")) {
//					List<WebElement> rad = findWebElements(radiobtn);
//					rad.get(j).click();
//					click(delete);
//					click(delete2);
//					break;
//				}
//			}
			click(topcus);
			Thread.sleep(500);
			List<WebElement> cu1 = findWebElements(cuslist);
			for(int i=0;i<cu1.size();i++) {
				if(cu1.get(i).getText().equals("Aradhya")) {
					WebElement d = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[7]/child::button/span[1]"));
				d.click();
				click(site);
				break;
				}
			}
			
			List<WebElement> cu3 = findWebElements(cuslist);
			for(int i=0;i<cu3.size();i++) {
				if(cu3.get(i).getText().equals("Coorg")) {
					List<WebElement> rad = findWebElements(radiobtn);
					rad.get(i).click();
					click(delete);
					click(delete2);
					System.out.println("Customer is deleted");
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void profile() {
		waittobeclickable(profile, 10);
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}


}

package com.Partner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Supplier extends BasePage {

	public Supplier(WebDriver driver) {
		super(driver);
	}


	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By partner = By.xpath("//div[contains(text(),'Partner portal')]");	
	private By supplier = By.xpath("//span[contains(text(),'Supplier Mapping')]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By buyerdd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By supdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By buylist = By.xpath("(//span[text()='Select Buyer'])/ancestor::div[1]/mat-option/span");
	private By suplist = By.xpath("(//span[text()='Select Supplier'])/ancestor::div[1]/mat-option/span");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By buyer = By.xpath("//table/tbody/tr/td[2]/span");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
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
			waittobeclickable(ninedots, 20);			
			click(supplier);
			System.out.println("Supplier mapping menu is clicked");
			click(add);
			Thread.sleep(500);
			click(buyerdd);
			List<WebElement> b = findWebElements(buylist);
			Thread.sleep(200);
			for(WebElement x:b) {
				if(x.getText().equals("Aradhya")) {
					x.click();
					break;
				}
			}
			Thread.sleep(200);
			click(supdd);
			List<WebElement> s = findWebElements(suplist);
			Thread.sleep(100);
			s.get(1).click();
			Thread.sleep(100);
			click(save);
			Thread.sleep(1000);
			List<WebElement> buy = findWebElements(buyer);
			for(int i=0;i<buy.size();i++) {
				if(buy.get(i).getText().equals("Aradhya")) {
					List<WebElement> r = findWebElements(radiobtn);
					r.get(i).click();
					break;
				}
			}
			click(delete);
			click(delete2);
			Thread.sleep(1000);
			
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

package com.Partner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BasePage.BasePage;

public class Home extends BasePage{

	public Home(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By partner = By.xpath("//div[contains(text(),'Partner portal')]");	
	private By home = By.xpath("//span[contains(text(),'Home')]");
	private By rev = By.xpath("//div[@mattooltip='Revenue(INR)']/following::div[1]/div[1]/p");
	private By ytd = By.xpath("//div[@mattooltip='Revenue(INR)']/following::div[1]/div[2]/p");
	private By est = By.xpath("//div[@mattooltip='Revenue(INR)']/following::div[1]/div[3]/p");
	private By table = By.xpath("(//table)[1]/tbody/td");
	private By table2 = By.xpath("(//table)[2]/tbody/td");
	private By cus = By.xpath("//div[@mattooltip='Customers']/following::div[1]/div[1]/p");
	private By mrr = By.xpath("//div[@mattooltip='Customers']/following::div[1]/div[2]/p");
	private By avg = By.xpath("//div[@mattooltip='Customers']/following::div[1]/div[3]/p");
	
	private By pro = By.xpath("//div[@mattooltip='Products']/following::div[1]/div[1]/p");
	private By prorev = By.xpath("//div[@mattooltip='Products']/following::div[1]/div[2]/p");
	private By cusrev = By.xpath("//div[@mattooltip='Products']/following::div[1]/div[3]/p");
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
	public void cards() {
		try {
			waittobeclickable(ninedots, 20);			
			click(home);
			System.out.println("home option is clicked");			
			Thread.sleep(2000);
			if(findWebElement(rev).getText().equals("₹ 0")||(findWebElement(rev).getText().equals(" ₹ 0"))) {
				log.info("Revenue FTM is 0");
			}else {
				System.out.println("Revenue FTM is "+findWebElement(rev).getText());
			}
			if((findWebElement(ytd).getText().equals("₹ 0"))||(findWebElement(ytd).getText().equals("₹0"))) {
				log.info("Revenue YTD is 0");
			}else {
				System.out.println("Revenue YTD is "+findWebElement(ytd).getText());
			}
			if(findWebElement(est).getText().equals("₹ 0")) {
				log.info("Estimate FTY is 0");
			}else {
				System.out.println("Estimate FTY is "+findWebElement(est).getText());
			}
			
			if(findWebElement(cus).getText().equals(" 0")||(findWebElement(cus).getText().equals("0"))) {
				log.info("No of customer is 0");
			}else {
				System.out.println("No of customer is "+findWebElement(cus).getText());
			}
			if((findWebElement(mrr).getText().equals("₹ 0"))||(findWebElement(mrr).getText().equals("₹0"))) {
				log.info("MRR is 0");
			}else {
				System.out.println("MRR is "+findWebElement(mrr).getText());
			}
			if(findWebElement(avg).getText().equals("₹ 0")) {
				log.info("Avg revenue FTY is 0");
			}else {
				System.out.println("Avg revenue FTY is "+findWebElement(avg).getText());
			}
			
			if(findWebElement(pro).getText().equals(" 0")||(findWebElement(pro).getText().equals("0"))) {
				log.info("No of product is 0");
			}else {
				System.out.println("No of product is "+findWebElement(pro).getText());
			}
			if((findWebElement(prorev).getText().equals("₹ 0"))||(findWebElement(prorev).getText().equals("₹0"))) {
				log.info("Product revenue is 0");
			}else {
				System.out.println("Product revenue is "+findWebElement(prorev).getText());
			}
			if(findWebElement(cusrev).getText().equals("₹ 0")) {
				log.info("Customer revenue FTY is 0");
			}else {
				System.out.println("Customer revenue FTY is "+findWebElement(cusrev).getText());
			}
			if(findWebElements(table).size()>1) {
				System.out.println("Product Table is displayed");
			}else {
				log.info("Product Table is not displayed");
			}
			if(findWebElements(table2).size()>1) {
				System.out.println("Customer Table is displayed");
			}else {
				log.info("Customer Table is not displayed");
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

package com.SuperadminPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Product_list extends BasePage {

	public Product_list(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By superadmin = By.xpath("//div[text()='Super Admin']");
	private By product = By.xpath("//span[contains(text(),'Product')]");
	private By head = By.xpath("//h2[text()='Products List']/following::div[1]/div/descendant::p");	
	private By pro = By.xpath("//span[contains(text(),' Product Listing ')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By sub = By.xpath("(//span[contains(text(),'Subscription')])[1]");
	private By uom = By.xpath("//span[contains(text(),'Subscription UOM')]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By roles = By.xpath("//table/tbody/tr/td[2]/span");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By cancel = By.xpath("(//span[contains(text(),'Cancel')])[2]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By cost = By.xpath("//input[@formcontrolname='subscription_Cost']");
	private By uomname = By.xpath("//input[@formcontrolname='uom']");
	private By desc = By.xpath("//input[@formcontrolname='description']");
	private By radio = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By prodd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By uomdd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By prolist = By.xpath("//span[text()='Select Product']/parent::mat-option/parent::div/mat-option");
	private By uomlist = By.xpath("//span[text()='Select UOM']/parent::mat-option/parent::div/mat-option");

	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			Thread.sleep(4000);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(superadmin, 20);
			click(superadmin);
			System.out.println("Super admin menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void prod() {
		waittobeclickable(product, 20);
		click(product);
		System.out.println("Product menu is clicked");
		click(pro);		
		log.info("Navigated to Product listing screen");

	}
	public void prodlist() {
		try {
			Thread.sleep(3000);
			List<WebElement> h = findWebElements(head);
			for (int i = 1; i <h.size(); i++) {
				String text = h.get(i-1).getText();
				System.out.println("**** "+text+" ****");
				List<WebElement> p = driver.findElements(By.xpath("(//table)["+i+"]/tr/td"));
				for(WebElement x:p) {
					System.out.println(x.getText());
				}
			}
			System.out.println("Get Product listing");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void subscription() {
		try {
			waittobeclickable(product, 20);
			click(product);
			System.out.println("Product menu is clicked");
			click(sub);	
			click(add);
			Thread.sleep(500);
			click(prodd);
			List<WebElement> pr = findWebElements(prolist);			
			pr.get(1).click();
			Thread.sleep(500);
			click(uomdd);
			List<WebElement> u = findWebElements(uomlist);			
			u.get(1).click();
			EnterText(cost, "1234");
			click(cancelbtn);
			System.out.println("Subscription uom is added");
			click(radio);
			click(view);
			click(cancelbtn);
			Thread.sleep(300);
			System.out.println("view button is checked");
			click(radio);		
			click(cancelbtn);			
			System.out.println("cancel button is checked");
			Thread.sleep(200);
			click(radio);		
			click(delete);
			click(delete2);
			Thread.sleep(500);
			System.out.println("delete button is checked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
	}
	public void uom() {
		try {
			waittobeclickable(product, 20);
			click(product);
			System.out.println("Product menu is clicked");
			Thread.sleep(1000);
			waittobeclickable(uom, 20);
			click(uom);	
			click(add);		
			EnterText(uomname,"AAA");	
			EnterText(desc,"aaa");			
			click(save);
			Thread.sleep(1000);
			click(radio);
			click(view);
			click(cancelbtn);
			Thread.sleep(500);
			System.out.println("view button is checked");
			List<WebElement> r = findWebElements(roles);
			for(int i=0;i<r.size();i++) {
				if(r.get(i).getText().equals("AAA")) {
					List<WebElement> rad = findWebElements(radio);
					rad.get(i).click();
					click(edit);
					clear(uomname);
					EnterText(uomname, "Abcd");
					click(update);
					System.out.println("update button is checked");
					break;
				}
			}
			Thread.sleep(1000);
			List<WebElement> r2 = findWebElements(roles);
			for(int j=0;j<r2.size();j++) {
					if(r2.get(j).getText().equals("Abcd")) {
						List<WebElement> rad = findWebElements(radio);
						rad.get(j).click();
						click(delete);
						click(cancel);
						System.out.println("delete button is checked");						
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

package com.Pages;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Duplicate extends BasePage{
	public Duplicate(WebDriver driver) {
		super(driver);
	}
	private By master = By.xpath("//span[text()=' Master ']");
	private By product = By.xpath("//span[text()=' Product ']");
	private By product2 = By.xpath("(//span[text()=' Product '])[2]");
	private By productcategory=By.xpath("//span[text()=' Product Category ']");
	private By active = By.xpath("//table[@role='table']/tbody/tr/td[10]/span/span");
	private By activecoll = By.xpath("//table[@role='table']/tbody/tr/td[2]/span");
	private By pnamelist = By.xpath("//span[text()='Select Product']/ancestor::div[1]/mat-option[@role='option']/span");
	private By pnamedrop = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[3]");
	private By add2 =By.xpath("(//span[text()='Add'])[2]");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By profile = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void active() {
	   try {
		click(master);
		   click(product2);
		   Thread.sleep(2000);
		   List<WebElement> list = findWebElements(active);
		   List<String> l = new LinkedList<>();
		   List<String> s = new LinkedList<>();
		   for(int i= 0;i<list.size();i++) {
			   if((list.get(i).getText()).equalsIgnoreCase("Active")) {
				   List<WebElement> list2 = findWebElements(activecoll);
				   String text = list2.get(i).getText();
				   l.add(text);
			   }else {
				   List<WebElement> in = findWebElements(activecoll);
				   String text = in.get(i).getText();
				   s.add(text);
			   }
		   }
		   for(int k=0;k<100;k++) {
		 		WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");
				
				if(!att.contains("disabled")) {
			click(nextpage);
			Thread.sleep(2000);
			List<String> l3 = new LinkedList<>();
			List<WebElement> list2 = findWebElements(active);
			for (int i = 0; i < list2.size(); i++) {
				if((list2.get(i).getText()).equalsIgnoreCase("Active")) {
					   List<WebElement> list3 = findWebElements(activecoll);
					   String text = list3.get(i).getText();
					   l3.add(text);
				   }
				else {
					List<WebElement> in2 = findWebElements(activecoll);
					   String text = in2.get(i).getText();
					   s.add(text);
				}
			}
			System.out.println("Inactive elements are " +s +" and size is " + s.size());
			l.addAll(l3);
			System.out.println("Active elements size is "+l.size());
				}
				else {
					break;
				}
		 	}
		   System.out.println(l);
		Thread.sleep(2000);
		   click(product);
		   click(productcategory);
		   click(add2);
			click(pnamedrop);
			log.info("product name dropdown is clicked");
			List<WebElement> pname = findWebElements(pnamelist);
			List<String> l2 = new LinkedList<>();
			for(int i=1;i<pname.size();i++) {
				String text2 = pname.get(i).getText();
				l2.add(text2);
			}
		System.out.println(l2);
		pname.get(2).click();
		Map<String,Integer> m = new LinkedHashMap<>();
		for(int i=0;i<l.size();i++) {
			for(int j=0;j<l2.size();j++) {
				if((l.get(i)).equals(l2.get(j))){
					m.put(l.get(i), 1);
				//	System.out.println("Same product");	
					break;
				}
				else {
					continue;
				}
			}
		}
		System.out.println("Size of map is "+ l2.size());
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	public void signout() {
		try {
			Thread.sleep(1000);
			click(profile);
			log.info("profile button is clicked");
			click(signout);
			log.info("signout button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
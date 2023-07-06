package com.Pages;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Deploy extends BasePage{

	public Deploy(WebDriver driver) {
		super(driver);
	}
	private By platform = By.xpath("//span[contains(text(),'Platform')]");
	private By deploy = By.xpath("//span[contains(text(),'Deploy')]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By bvdrop = By.xpath("//mat-label[text()='Business Vertical']/ancestor::div[1]/descendant::div[3]");
	private By dropselect = By.xpath("//mat-option[@role='option']/span");
	private By platformname = By.xpath("//input[@formcontrolname='platform_Name']");
	private By domain = By.xpath("//input[@formcontrolname='domain_Name']");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By deployment = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By tenant = By.xpath("//input[@formcontrolname='tenant_Id']");
	private By secret = By.xpath("//input[@formcontrolname='client_Secret']");
	private By subscription = By.xpath("//input[@formcontrolname='subscription_Id']");
	private By region = By.xpath("(//mat-select[@role='combobox'])[2]/child::div/div[2]");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	private By radio= By.xpath("//span[@class='mat-radio-inner-circle']");
	private By platradio = By.xpath("//table/tbody/tr/td[2]/span");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By threedots = By.xpath("//table/tbody/tr/td[7]/button/span[1]/mat-icon");
	private By listing = By.xpath("//span[contains(text(),'Listing')]");
	private By categoryarr = By.xpath("//div[contains(text(),'Category')]/following::div[1]");
	private By domainarr = By.xpath("//div[contains(text(),'Domain')]/following::div[1]");
	private By statusarr = By.xpath("//div[contains(text(),'Status')]/following::div[1]");
	private By actionarr = By.xpath("//div[contains(text(),'Action')]/following::div[1]");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By platformlist = By.xpath("//div[contains(text(),'Platform Listing')]");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By platformnamearr = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By deploystatusarr = By.xpath("//table/thead/tr[1]/th[7]/div/child::div[2]");
	private By domainarr1 = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By credatearr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	private By deploymentarr = By.xpath("//table/thead/tr[1]/th[4]/div/child::div[2]");
	private By creabyarr = By.xpath("//table/thead/tr[1]/th[5]/div/child::div[2]");
	private By profile = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By product =By.xpath("//span[text()=' Product ']");
	private By businessvertical =By.xpath("//span[text()=' Business Vertical ']");
	private By bnamelist = By.xpath("//table/tbody/tr/td[2]");
	private By threedotsradio = By.xpath("//table/tbody/tr/td[1]/span");
	
	
	public void deploy() {
		try {
			click(platform);
			log.info("Platform button is cliked");
			click(deploy);
			log.info("deploy button is cliked");
			Thread.sleep(2000);
			String expectedurl = "http://20.204.188.25/#/platform/listing";
			String actualurl = getCurrentURL();
			assertEquals(expectedurl, actualurl);
			log.info("Assert verification for deploy module is done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void add() {
		try {
			click(add);
			log.info("add button is cliked");
			click(bvdrop);
			log.info("business vertical dropdown is cliked");
			List<WebElement> drop = findWebElements(dropselect);
			drop.get(1).click();
			log.info("dropdown option is selected");
			EnterText(platformname, "pyroferus");
			log.info("Platform name is entered");
			EnterText(domain, "pyroferus.co");
			log.info("domain is entered");
			List<WebElement> dp = findWebElements(deployment);
			dp.get(1).click();
			log.info("Radio button is selected");
			Thread.sleep(500);
			EnterText(tenant, "pyrodrum");
			log.info("tenant id is entered");
			EnterText(secret, "123Asw");
			log.info("secret id is entered");
			EnterText(subscription, "testing");
			log.info("subscription is entered");
			click(region);
			log.info("region dropdown is cliked");
			List<WebElement> drop2 = findWebElements(dropselect);
			drop2.get(1).click();
			log.info("dropdown option is selected");
			click(cancel);
			click(save);
			log.info("save button is clicked");
			Thread.sleep(1000);
			click(product);
			click(businessvertical);
			log.info("navigate to product-business vertical screen");
			Thread.sleep(1000);
			List<String> l2 = new LinkedList<>();
			List<WebElement> list = findWebElements(bnamelist);
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				List<String> l1 = new LinkedList<>();
				l1.add(text);
				l2.addAll(l1);

			}
			for(int i=0;i<100;i++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");
			
			if(att.contains("disabled")) {
				break;
			}
			else {
				click(nextpage);
				Thread.sleep(2000);
				List<WebElement> list2 = findWebElements(bnamelist);
				for (int k = 0; k < list2.size(); k++) {
					String text2 = list2.get(k).getText();
					l2.add(text2);
				}
			}
			}
			Thread.sleep(1000);
			click(platform);
			click(deploy);
			click(add);
			click(bvdrop);
			Thread.sleep(500);
			List<WebElement> dropp = findWebElements(dropselect);
			for(int i=0;i<l2.size();i++) {
				for(int j=i+1;j<=i+1;j++) {
			if((l2.get(i)).equals(dropp.get(j).getText())) {
				System.out.println("Same business vertical name "+l2.get(i));
			}else {
				System.out.println("different business vertical name "+l2.get(i));
			}
		}
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void other() {
		try {
		//	click(cancel);
			Thread.sleep(1000);
			List<WebElement> rad = findWebElements(radio);
			
			//System.out.println(rad.size());
		//	for(int i=0;i<rad.size();i++) {
				Thread.sleep(1000);
				rad.get(6).click();
				Thread.sleep(1000);
				click(view);
				String getattribute = getattribute(subscription);
				System.out.println(getattribute);
				click(cancel);	
			List<WebElement> plat = findWebElements(platradio);
			log.info("All platform names");
			for(WebElement x:plat) {
				System.out.println(x.getText());
			}
			for(int k=0;k<1000;k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");
				
				if(att.contains("disabled")) {
					break;
				}
				else {
					click(nextpage);
					Thread.sleep(1000);
					List<WebElement> rad2 = findWebElements(platradio);
					for(WebElement x:rad2) {
						System.out.println(x.getText());
					}
				}
			}
			
			log.info("radio button for all platform is clicked");
			log.info("view option is clicked for all platforms");			
			log.info("cancel button is clicked");
			Thread.sleep(1000);
			
	//		System.out.println(three.size());
			for(int i=0;i<rad.size();i++) {
				List<WebElement> three = findWebElements(threedots);
				three.get(i).click();
				click(listing);
//				for(WebElement x:cat) {
//					System.out.println(x.getText());
//				}
				Thread.sleep(500);
				click(platformlist);
				
				
			}
			for(int k=0;k<1000;k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");
				
				if(att.contains("disabled")) {
					break;
				}
				else {
					click(nextpage);
					Thread.sleep(1000);
					List<WebElement> rad3 = findWebElements(threedots);
					for(int i=0;i<rad3.size();i++) {
						rad3.get(i).click();
						click(listing);
						Thread.sleep(500);
						click(platformlist);
						
					}
				}
			}
			log.info("three dots button is clicked for all platforms");	
			log.info("listing button is clicked and listing is verified for all platforms");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void listarrow() {
		try {
			List<WebElement> three = findWebElements(threedots);
			three.get(1).click();
			click(listing);
			Thread.sleep(2000);
			String expectedurl = "http://20.204.188.25/#/platform/deploylisting";
			String actualurl = getCurrentURL();
			assertEquals(expectedurl, actualurl);
			log.info("Assert verification for listing page is done");
			click(categoryarr);
			log.info("category arrow is cliked");
			click(domainarr);
			log.info("domain arrow is cliked");
			click(statusarr);
			log.info("status arrow is cliked");
			click(actionarr);
			log.info("action arrow is cliked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pagination() {
		try {
			Thread.sleep(2000);
			
			click(pagedd);
			log.info("page dropdown is selected");
			click(pagesize);
			log.info("page size is selected");
			click(nextpage);
			log.info("nextpage is clicked");
			click(previous);
			log.info("previouspage is clicked");
			click(lastpage);
			log.info("lastpage is clicked");
			click(firstpage);
			log.info("firstpage is clicked");
			takescreenshots("pagination");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void arrow() {
		click(platformlist);
		log.info("platform listing link is clicked");
		click(platformnamearr);
		log.info("platformname arrow is clicked");
		click(domainarr1);
		log.info("domain arrow is clicked");
		click(deploymentarr);
		log.info("deployment arrow is clicked");
		click(creabyarr);
		log.info("createdby arrow is clicked");
		click(credatearr);
		log.info("createddate arrow is clicked");
		click(deploystatusarr);
		log.info("deploystatus arrow is clicked");
	}
	
	public void search() {
		EnterText(search, "dev");
	}
	
	public void signout() {
		click(profile);
		log.info("profile button is clicked");
		click(signout);
		log.info("signout button is clicked");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
package com.SuperadminPage;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;
public class Permission extends BasePage{

	public Permission(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By superadmin = By.xpath("//div[contains(text(),'Super Admin')]/parent::div/button");
	private By permission = By.xpath("//span[contains(text(),'Permission')]");
	private By role = By.xpath("//input[@formcontrolname='role_Name']");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By user = By.xpath("//div[contains(text(),'User')]");
	private By btn = By.xpath("//div[contains(text(),'Role')]");
	private By address = By.xpath("//input[@formcontrolname='address1']");	
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By radio = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By roles = By.xpath("//table/tbody/tr/td[2]/span");
	private By mail2 = By.xpath("//table/tbody/tr/td[4]/span");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 25 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By Username =By.xpath("//*[@id='email']");
	private By Password =By.xpath("//*[@type='password']");
	private By Login =By.xpath("//span[contains(text(),'Sign in')]");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	
	
	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			Thread.sleep(2000);
			click(superadmin);
			System.out.println("Super admin menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
public void permission() {
	try {
		//Thread.sleep(2000);
		click(permission);
		Thread.sleep(1000);			
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}
public void perm() {
	try {
		click(btn);
		Thread.sleep(1000);
		click(radio);
		click(view);
		click(cancelbtn);
		System.out.println("View option is checked");
		click(pagedd);
		click(pagesize);
		Thread.sleep(1000);
		List<WebElement> rad = findWebElements(radio);
		List<WebElement> def = findWebElements(roles);
		for(int i=0;i<def.size();i++) {
			if(def.get(i).getText().equals("ABC")) {				
				rad.get(i).click();
			click(edit);
			clear(role);
			EnterText(role, "QA Engineer");
			click(update);
			System.out.println("Edit and Update option is checked");
			click(lastpage);
			break;
			}
			}		
		for (int s = 0; s < 1000; s++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");

			if (!att.contains("disabled")) {
				click(nextpage);
				List<WebElement> rad2 = findWebElements(radio);
				List<WebElement> def2 = findWebElements(roles);
				for(int k=0;k<def2.size();k++) {
				if(def2.get(k).getText().equals("ABC")) {				
					rad2.get(k).click();
				click(edit);
				clear(role);
				EnterText(role, "QA Engineer");
				click(update);
				System.out.println("Edit and Update option is checked");
				click(lastpage);
				Thread.sleep(100);
				break;
				}
				}
	}else {
		break;
	}
		}
		Thread.sleep(1000);
		click(firstpage);
		Thread.sleep(1000);
		List<WebElement> rad3 = findWebElements(radio);
		List<WebElement> def3 = findWebElements(roles);
		for(int i=0;i<def3.size();i++) {
			if(def3.get(i).getText().equals("QA Engineer")) {				
				rad3.get(i).click();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(false);", findWebElement(delete));
				click(delete);
				click(delete2);
				System.out.println("Delete option is checked");
			break;
			}
			}		
		for (int ss = 0; ss < 1000; ss++) {
			WebElement element2 = findWebElement(nextdisable);
			String att2 = element2.getAttribute("class");

			if (!att2.contains("disabled")) {
				Thread.sleep(500);
				click(nextpage);
				Thread.sleep(1000);
				List<WebElement> rad2 = findWebElements(radio);
				List<WebElement> def2 = findWebElements(roles);
				for(int k=0;k<def2.size();k++) {
				if(def2.get(k).getText().equals("QA Engineer")) {				
					rad2.get(k).click();
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(false);", findWebElement(delete));
					click(delete);
					click(delete2);
					System.out.println("Delete option is checked");
				break;
				}
				}
		}else {
			break;
		}
		}
		
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	public void useradd() {
		try {
			click(user);	
			Thread.sleep(1000);			
			click(radio);
			click(view);
			click(cancelbtn);
			System.out.println("View option is checked");
			List<WebElement> rad = findWebElements(radio);
			List<WebElement> def = findWebElements(mail2);
			for(int i=0;i<def.size();i++) {
				if(def.get(i).getText().equals("oviya@yahoo.com")) {				
					rad.get(i).click();
				click(edit);
				clear(address);
				EnterText(address, "Chennai");
				click(update);
				System.out.println("Edit and Update option is checked");
				click(lastpage);
				break;
				}
			}
			for (int s = 0; s < 1000; s++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");

				if (!att.contains("disabled")) {
					click(nextpage);
					Thread.sleep(1000);
					List<WebElement> rad2 = findWebElements(radio);
					List<WebElement> def2 = findWebElements(mail2);
					for(int k=0;k<def2.size();k++) {
					if(def2.get(k).getText().equals("oviya@yahoo.com")) {				
						rad2.get(k).click();
						click(edit);
						clear(address);
						EnterText(address, "Chennai");
						click(update);
						System.out.println("Edit and Update option is checked");
						click(lastpage);
						break;
					}
					}	
					
}else {
			break;
}
			}
			
			Thread.sleep(500);
			click(firstpage);
			Thread.sleep(1000);
			List<WebElement> rad3 = findWebElements(radio);
			List<WebElement> def3 = findWebElements(mail2);		
			for(int i=0;i<def3.size();i++) {
				if(def3.get(i).getText().equals("oviya@yahoo.com")) {				
					rad3.get(i).click();
					click(delete);
					click(delete2);
					System.out.println("Delete option is checked");
				break;
				}
				}		
			for (int ss = 0; ss < 1000; ss++) {
				WebElement element2 = findWebElement(nextdisable);
				String att2 = element2.getAttribute("class");

				if (!att2.contains("disabled")) {
					click(nextpage);
					Thread.sleep(1000);
					List<WebElement> rad2 = findWebElements(radio);
					List<WebElement> def2 = findWebElements(mail2);
					for(int k=0;k<def2.size();k++) {
					if(def2.get(k).getText().equals("oviya@yahoo.com")) {				
						rad2.get(k).click();
						click(delete);
						click(delete2);
						System.out.println("Delete option is checked");
						click(lastpage);
					break;
					}
					}
			}else {
				break;
			}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 	

public void profile() {
	try {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
		Thread.sleep(7000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
public void login() {
	try {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		EnterText(Username,"oviya@yahoo.com");		
		System.out.println("Entered the username");
		Thread.sleep(1000);
		EnterText(Password,"Admin@123");
		System.out.println("Entered the Password");
		Thread.sleep(10000);
		click(Login);
		System.out.println("Clicked on the Login");
		Thread.sleep(2000);
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}




}

package com.SuperadminPage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;
import com.BasePage.ReportSetup;
import com.aventstack.extentreports.Status;

public class Permission2 extends BasePage{

	public Permission2(WebDriver driver) {
		super(driver);
	}
	private By master = By.xpath("//span[contains(text(),'Master Data')]");
	private By customer = By.xpath("//span[contains(text(),'Customer')]");
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By superadmin = By.xpath("//div[text()='Super Admin']");
	private By control = By.xpath("//span[contains(text(),'Control Center')]");
	private By permission = By.xpath("//span[contains(text(),'Permission')]");
	private By role = By.xpath("//input[@formcontrolname='role_Name']");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By add2 = By.xpath("//span[contains(text(),'Add')]/parent::span");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By user = By.xpath("//div[contains(text(),'User')]");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By perm = By.xpath("//div[contains(text(),'Permission')]/ancestor::span/descendant::span[1]");
	private By cusadd = By.xpath("//div[contains(text(),'Customer')]/following::tr[2]/td[2]/descendant::span[1]");
	private By masedit = By.xpath("//div[contains(text(),'Master Data')]/following::tr[2]/td[3]/descendant::span[1]");
	private By masdel = By.xpath("//div[contains(text(),'Master Data')]/following::tr[2]/td[4]/descendant::span[1]");
	private By roledd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By rolelist = By.xpath("(//span[text()='Select Role'])/ancestor::div[1]/mat-option/span");
	private By name = By.xpath("//input[@formcontrolname='userName']");
	private By ph = By.xpath("//input[@formcontrolname='user_Mobile']");
	private By address = By.xpath("//input[@formcontrolname='address1']");	
	private By mail = By.xpath("//input[@formcontrolname='user_Email']");
	private By pwd = By.xpath("//input[@formcontrolname='user_Password']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By header = By.xpath("//div[contains(@class,'horizontal-navigation-wrapper')]/descendant::span");
	private By buttons = By.xpath("(//div[contains(text(),'Monitoring Parameter Listing')])[2]/following::div[1]/button/descendant::span[2]");
	private By Username =By.xpath("//*[@id='email']");
	private By Password =By.xpath("//*[@type='password']");
	private By Login =By.xpath("//span[contains(text(),'Sign in')]");
	
	
	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);		
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
public void permission() {
	try {
		//Thread.sleep(2000);
		click(permission);
		Thread.sleep(1000);
		click(add);
		EnterText(role, "ABC");
		click(perm);
		waittobeclickable(cusadd, 10);
		click(cusadd);
		waittobeclickable(masedit, 10);
		click(masedit);
		waittobeclickable(masdel, 10);
		click(masdel);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", findWebElement(save));
		click(save);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}
public void users() {
	try {
		Thread.sleep(1000);
		click(user);
		click(add);
		click(roledd);
		List<WebElement> r = findWebElements(rolelist);
		for (int i = 1; i < r.size(); i++) {
			String text = r.get(i).getText();
			if(text.equals("ABC")) {
				r.get(i).click();
				break;
			}
			Thread.sleep(100);
			
		}
		EnterText(name, "Oviya");
		EnterText(ph, "8876543210");
		EnterText(address, "Madurai");
		EnterText(mail, "oviya@yahoo.com");
		EnterText(pwd, "Admin@123");
		click(save);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}
public void profile() {
	try {
		waittobeclickable(profile, 10);
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
public void check() {
	try {
		Thread.sleep(2000);
		List<WebElement> he = findWebElements(header);
		for(WebElement x:he) {
			if(x.getText().equals("Permission")) {
				log.info("Permission Menu still exists after it disabled");
			}else {
				continue;
			}
		}
		Thread.sleep(1000);
		click(master);
		click(radiobtn);
		List<WebElement> b = findWebElements(buttons);
		for(WebElement x:b) {
			if(x.getText().equals("Edit")) {
				log.info("Edit option is enabled for user even it is disabled");
			}else if(x.getText().equals("Delete")) {
				log.info("Delete option is enabled for user even it is disabled");
			}else {
				continue;
			}
		}
		Thread.sleep(1000);
		click(customer);
		if(findWebElement(add2).isDisplayed()!=true) {
			System.out.println("Add button in customer is not shown after disabled it");
		}else {
			log.info("Add button in customer is shown even after disabled it");
		}
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}

}

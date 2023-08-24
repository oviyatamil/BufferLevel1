package com.SuperadminPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;


public class Support extends BasePage{

	public Support(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By superadmin = By.xpath("//div[text()='Super Admin']");
	private By support = By.xpath("//span[contains(text(),'Support')]");
	private By dash = By.xpath("//span[contains(text(),'Error Dashboard')]");
	private By log = By.xpath("//span[contains(text(),'Error Log')]");
	private By ticket = By.xpath("//span[contains(text(),'Ticket Listing')]");
	private By scroll = By.xpath("//span[contains(text(),'Error Log')]");
	private By help = By.xpath("//span[text()=' Support ']/following::button[2]/span[1]/mat-icon");
	private By contact = By.xpath("//span[text()='Contact us']/parent::a");
	private By name = By.xpath("//input[@formcontrolname='name']");
	private By subject = By.xpath("//input[@formcontrolname='subject']");
	private By msg = By.xpath("//textarea[@formcontrolname='message']");
	private By datearr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	private By attach = By.xpath("//input[@type='file']");
	private By back = By.xpath("//span[text()='Back to Help Center']/parent::span/mat-icon");
	private By act = By.xpath("//table/tbody/tr/td[9]");
	private By status = By.xpath("//table/tbody/tr/td[8]");
	private By sub = By.xpath("//table/tbody/tr/td[4]");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By edit = By.xpath("//table/tbody/tr/td[9]/mat-icon");
	private By assign = By.xpath("(//span[text()='Select User'])/ancestor::div[1]/mat-option/span");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By open = By.xpath("//div[contains(text(),'Open')]/ancestor::div[2]/div[1]/div");
	private By prog = By.xpath("//div[contains(text(),'Inprogress')]/ancestor::div[2]/div[1]/div");
	private By rej = By.xpath("//div[contains(text(),'Rejected')]/ancestor::div[2]/div[1]/div");
	private By close = By.xpath("//div[contains(text(),'Closed')]/ancestor::div[2]/div[1]/div");
	private By slide = By.xpath("//div[@class='overflow-x-auto']");
	private By tot = By.xpath("(//div[contains(text(),'Total Issues')])[1]/following::div[4] ");
	private By curr = By.xpath("(//div[contains(text(),'Current Done')])[1]/following::div[7]");
	private By chart1 = By.xpath("(//*[local-name()='g' and contains(@class,'plots')])[2]/*[local-name()='path']");
	private By chart2 = By.xpath("(//*[local-name()='g' and contains(@class,'plots')])[4]/*[local-name()='path']");
	private By table = By.xpath("//table/tbody/tr/td");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By file = By.xpath("//span[contains(text(),'Open to file')]/following::button[1]/span[1]");
	private By msg1 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*[local-name()='text']");
	private By msg2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	
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
	public void errordash() {
		try {
			click(support);
			System.out.println("support menu is clicked");
			Thread.sleep(1000);
			click(dash);
			System.out.println("Navigated to error dashboard screen");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void data() {	
		try {
			Thread.sleep(5000);
			System.out.println("Total number of issues are "+ gettext(tot));			
			System.out.println("Completed issues are "+gettext(curr));		
				if(findWebElement(msg1).getText().contains("No data to display")) {
					System.out.println("****************No data to display******** shows instead of product chart");
				}else if(findWebElement(chart1).isDisplayed()!=true) {
					System.out.println("**********Product chart not displayed**********");
				}else {
					System.out.println("Product chart displayed");
				}
				if(findWebElement(msg2).getText().contains("No data to display")) {
					System.out.println("****************No data to display******** shows instead of status chart");
				}else if(findWebElement(chart2).isDisplayed()!=true) {
					System.out.println("**********Status chart not displayed**********");
				}else {
					System.out.println("Status chart displayed");
				}
				if(findWebElements(table).size()<=1) {				
					System.out.println("No records found");
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void errorlog() {
		try {
			click(support);
			click(log);
			Thread.sleep(2000);
			System.out.println("Open count is "+gettext(open));
			System.out.println("Inprogress count is "+gettext(prog));
			System.out.println("Reject count is "+gettext(rej));
			System.out.println("Close count is "+gettext(close));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",findWebElement(lastpage));
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView();",findWebElement(act));
			click(edit);
			Thread.sleep(2000);
			click(dd);
			List<WebElement> as = findWebElements(assign);
			as.get(1).click();
			click(cancelbtn);
			
	//		js.executeScript("window.scrollBy(3000,40)");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void ticket() {
		try {
			Thread.sleep(1000);
			click(support);
			click(ticket);
			Thread.sleep(3000);
			System.out.println("Open ticket listing count is "+gettext(open));
			System.out.println("Inprogress ticket listing count is "+gettext(prog));
			System.out.println("Rejected ticket listing count is "+gettext(rej));
			System.out.println("Closed ticket listing count is "+gettext(close));
			click(datearr);
			click(datearr);
			Thread.sleep(2000);
//			List<WebElement> f2 = findWebElements(sub);
//			for(int i=0;i<f2.size();i++) {
//				if(f2.get(i).getText().equals("bugsss")) {
//					WebElement fe = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[8]"));
//					fe.click();
//					click(file);
//					System.out.println("File is downloaded");
//					Thread.sleep(500);
//					click(cancelbtn);	
//					break;
//				}
//			}	
			List<WebElement> f = findWebElements(sub);
			for(int i=0;i<f.size();i++) {
				if(f.get(i).getText().equals("bugsss")) {
					WebElement fe = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[9]/mat-icon"));
					fe.click();
					click(dd);
					List<WebElement> as = findWebElements(assign);
					as.get(1).click();
					System.out.println("User is assigned");
					click(save);
					break;
				}
			}					
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void help() {
		try {
			click(help);
			Thread.sleep(500);
			click(contact);
			System.out.println("contact us is clicked");
			Thread.sleep(1000);
			System.out.println("Assert verification for contact us is done");
			EnterText(name, "admin");
			System.out.println("name is entered");
			EnterText(subject, "bugsss");
			System.out.println("Subject is entered");
			EnterText(msg, "Kindly solve the issue");
			System.out.println("Message is entered");
			EnterText(attach, "C:\\Users\\oviya\\Downloads\\OxygenMonitoring (3).pdf");
			System.out.println("File is attached");
			Thread.sleep(100);
			click(save);
			System.out.println("save option is clicked");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
	
}

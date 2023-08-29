package com.SuperadminPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Home extends BasePage{

	public Home(WebDriver driver) {
		super(driver);
	}
	private By mrr = By.xpath("(//div[contains(text(),' MRR')])[1]/ancestor::div[2]/div[1]/div");
	private By asset = By.xpath("(//div[contains(text(),'Assests Monitoring')])[1]/ancestor::div[2]/div[1]/div");
	private By arr = By.xpath("(//div[contains(text(),'ARR')])[1]/ancestor::div[2]/div[1]/div");
	private By revenue = By.xpath("(//div[contains(text(),'Revenue/Customer')])[1]/ancestor::div[2]/div[1]/div");
	private By renewal = By.xpath("(//div[contains(text(),'RENEWAL RATE')])[1]/ancestor::div[2]/div[1]/div");
	private By chart = By.xpath("//*[local-name()='g' and contains(@class,'manager-anchor-group')]/*[local-name()='g'][2]/*[local-name()='rect']");
	private By legend = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[2]/*[local-name()='g']/*[local-name()='rect']");
	private By table = By.xpath("//table/tbody/tr/td");
	private By view = By.xpath("(//span[contains(text(),'View')])");
	private By table2 = By.xpath("(//table)[2]/tbody/tr/td");
	private By cancel = By.xpath("//mat-icon[contains(text(),'cancel')]");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[4]");
	private By pagesize = By.xpath("(//span[contains(text(),'5')])[2]");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By customer = By.xpath("//table/tbody/tr/td[1]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");

public void home() {
	try {
		Thread.sleep(5000);
			if(findWebElement(mrr).getText().equals(" 0 ")||findWebElement(mrr).getText().equals(" ₹0 ")) {
				log.info("MRR value is zero");
			}else {
				System.out.println("MRR value is "+gettext(mrr));
			}
			if(findWebElement(asset).getText().equals(" 0 ")) {
				log.info("Asset monitoing value is zero");
			}else {
				System.out.println("Asset monitoring value is "+gettext(asset));
			}
			if(findWebElement(arr).getText().equals(" 0")||findWebElement(arr).getText().equals(" 0 ")) {
				log.info("ARR value is zero");
			}else {
				System.out.println("ARR value is "+gettext(arr));
			}
			if(findWebElement(revenue).getText().equals(" 0")||findWebElement(revenue).getText().equals(" 0 ")) {
				log.info("Revenue/customer value is zero");
			}else {
				System.out.println("Revenue/customer value is "+gettext(revenue));
			}
			if(findWebElement(renewal).getText().equals(" 0")||findWebElement(renewal).getText().equals(" 0 ")) {
				log.info("Renewal rate is zero");
			}else {
				System.out.println("Renewal rate is "+gettext(renewal));
			}
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	

}
public void chart() {
	
	try {
		if(findWebElement(chart).isDisplayed()!=true) {
			log.info("Chart is not displayed");
		}else {
			System.out.println("Chart is displayed");
			List<WebElement> web = findWebElements(chart);
			for(WebElement x:web) {
				move(x);
			}
			System.out.println("Mouseover is working in chart and data is displayed");
			List<WebElement> l = findWebElements(legend);
			for(WebElement x:l) {
				x.click();
			}
			System.out.println("Legend is working properly in chart");
		}
//		click(ly);
//		Thread.sleep(5000);
//		if(findWebElement(chart).isDisplayed()!=true) {
//			log.info("Chart is not displayed for last year");
//		}else {
//			System.out.println("Chart is displayed for last year");
//		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",findWebElement(nextpage));
	if(findWebElement(table).isDisplayed()!=true) {
		log.info("Customer details Table not displayed");
	}else {
		System.out.println("Customer details Table displayed");
		List<WebElement> vi = findWebElements(view);		
		for(int i=0;i<vi.size();i++) {
			List<WebElement> li = findWebElements(customer);
			String text = li.get(i).getText();
			vi.get(i).click();
			Thread.sleep(1000);
			if(findWebElement(table2).getText().contains("No Record")) {
				log.info("No records found for "+text);
			}else {
				System.out.println("Records displayed");
			}
			click(cancel);
			Thread.sleep(500);
		}				
	}
} catch (InterruptedException e) {
	e.printStackTrace();
}
}

	public void pagination() {
		try {
			Thread.sleep(1000);
			click(pagedd);
			System.out.println("Page dropdown is clicked");
			waittobeclickable(pagesize, 5);
			click(pagesize);
			System.out.println("Pagesize is clicked");
			click(nextpage);
			System.out.println("nextpage is clicked");
			click(previous);
			System.out.println("previouspage is clicked");
			click(lastpage);
			System.out.println("lastpage is clicked");
			click(firstpage);
			System.out.println("firstpage is clicked");
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
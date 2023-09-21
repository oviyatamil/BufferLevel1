package org.sqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BasePage.BasePage;

public class Home extends BasePage{

	public Home(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By sqa = By.xpath("//div[contains(text(),'SQA')]/parent::div/child::button");
	private By supplier = By.xpath("(//div[contains(text(),'Home')])[1]/following::div[2]/span[1]");
	private By parts = By.xpath("(//div[contains(text(),'Home')])[1]/following::div[3]/span[1]");
	private By prod = By.xpath("(//div[contains(text(),'Home')])[1]/following::div[4]/span[1]");
	private By rej = By.xpath("(//div[contains(text(),'Home')])[1]/following::div[5]/span[1]");
	private By ppm = By.xpath("(//div[contains(text(),'Home')])[1]/following::div[6]/span[1]");
	private By table = By.xpath("(//table)[1]/tbody/tr/td");
	private By table2 = By.xpath("(//table)[2]/tbody/tr/td");
	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(sqa, 20);
			click(sqa);
			System.out.println("SQA option is clicked");
			Thread.sleep(2000);
			System.out.println("Assert verification is done for SQA home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void card() {
		if(findWebElement(supplier).getText().equals("0")) {
			log.info("Supplier count is 0");
		}else {
			System.out.println("Supplier count is "+gettext(supplier));
		}
		if(findWebElement(parts).getText().equals("0")) {
			log.info("Parts count is 0");
		}else {
			System.out.println("Parts count is "+gettext(parts));
		}
		if(findWebElement(prod).getText().equals("0")) {
			log.info("Production count is 0");
		}else {
			System.out.println("Production count is "+gettext(prod));
		}
		if(findWebElement(rej).getText().equals("0")) {
			log.info("Rejected count is 0");
		}else {
			System.out.println("Rejected count is "+gettext(rej));
		}
		if(findWebElement(ppm).getText().equals("0")) {
			log.info("PPM count is 0");
		}else {
			System.out.println("PPM count is "+gettext(ppm));
		}
		
		if(findWebElements(table).size()>1) {
			System.out.println("Table1 displayed");
		}else {
			log.info("Table1 not displayed");
		}
		if(findWebElements(table2).size()>1) {
			System.out.println("Table2 displayed");
		}else {
			log.info("Table2 not displayed");
		}
	}
}

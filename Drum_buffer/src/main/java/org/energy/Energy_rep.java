package org.energy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Energy_rep extends BasePage{

	public Energy_rep(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[text()='Energy Monitoring']");
	private By cusreports = By.xpath("//span[contains(text(),'Custom Report')]");
	private By site = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/ancestor::div[1]/mat-option");
	private By loc = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("//span[text()='Select Location']/ancestor::div[1]/mat-option");
	private By cat= By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By machine = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By catlist = By.xpath("//span[text()='All']/ancestor::div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Search')]");
	private By table = By.xpath("//table/tbody/tr/td");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By row = By.xpath("//table/tbody/tr");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to Excel']");
	private By daily = By.xpath("//span[contains(text(),'Daily Report')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(energy, 20);
			click(energy);
			System.out.println("Energy monitoring option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Energy monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void report() {
		try {
			waittobeclickable(cusreports, 20);
			click(cusreports);
			System.out.println("Custom reports menu is clicked");
			Thread.sleep(1000);
			log.info("Assert verification is done for energy Custom ->report page");
			click(daily);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd2() {
		try {
			calendar(calendar, yeardd, year, startdate);		
				click(loc);
				List<WebElement> l2 = findWebElements(loclist);
				l2.get(1).click();	
				click(cat);
				Thread.sleep(500);
				List<WebElement> l3 = findWebElements(catlist);
				l3.get(0).click();
				Thread.sleep(500);
				click(machine);
				List<WebElement> l4 = findWebElements(catlist);
				l4.get(0).click();
				click(site);
				List<WebElement> l = findWebElements(sitelist);
				for(int i=1;i<l.size();i++) {
					if(i>1) {
						waittobeclickable(site, 10);
						click(site);
					}
					l.get(i).click();
					
				click(apply);
				Thread.sleep(4000);				
				if(findWebElements(table).size()>1) {
					System.out.println("Table is displayed");
					String data2 = new SimpleDateFormat("dd-MMM").format(new Date());	
					String[] split5 = data2.split("-");
					int sum = (Integer.parseInt(split5[0])) - 1;
					String v = String.valueOf(sum);
			 		String h = v+"-"+split5[1];
					System.out.println("**************************");
					System.out.println(h);
					List<WebElement> rows = findWebElements(row);
						WebElement text = driver.findElement(By.xpath("//table/tbody/tr["+rows.size()+"]/td[5]"));		
					String text2 = text.getText();
					String[] split4 = text2.split(",");
					System.out.println(split4[1]);
					JavascriptExecutor j = (JavascriptExecutor)driver;
					j.executeScript("arguments[0].scrollIntoView(true);", text);
					Thread.sleep(2000);
					if(split4[1].contains(h)) {
						System.out.println("Report end date is correct");											
						Thread.sleep(2000);
					}else {
						log.info("Report end date is wrong");	
						j.executeScript("arguments[0].scrollIntoView(false);", findWebElement(pdf));
						Thread.sleep(1000);
					}
				}else {
					log.info("No records found");
					Thread.sleep(1000);
				}
				}
			Thread.sleep(500);
	
			
		} catch (NumberFormatException | InterruptedException e) {
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

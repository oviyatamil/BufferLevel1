package com.Iot;

import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class Report extends BasePage{

	public Report(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By report = By.xpath("//div[contains(text(),'Report')]");	
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/parent::mat-option/parent::div/mat-option");
	private By locdd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By loclist = By.xpath("//span[text()='Select Location']/parent::mat-option/parent::div/mat-option");
	private By proddd = By.xpath("(//mat-select[@role='combobox'])[3]/ancestor::div[1]/descendant::div[4]");
	private By prolist = By.xpath("//span[text()='Select Product']/parent::mat-option/parent::div/mat-option/span");
	private By datedd = By.xpath("(//mat-select[@role='combobox'])[4]/ancestor::div[1]/descendant::div[4]");
	private By datelist = By.xpath("//span[text()='Select Type']/parent::mat-option/parent::div/mat-option");
	private By menu = By.xpath("//input[@formcontrolname='screenName']");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])[1]");
	private By radio2 = By.xpath("(//span[@class='mat-radio-inner-circle'])");
	private By replist = By.xpath("//table/tbody/tr/td[2]/span");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By name = By.xpath("//input[@formcontrolname='reportName']");
	private By next = By.xpath("(//span[contains(text(),'Next')])[1]");
	private By next2 = By.xpath("(//span[contains(text(),'Next')])[2]");
	private By display = By.xpath("//mat-label[contains(text(),'Display Option')]/following::span[1]/span[2]");
	private By rep = By.xpath("//mat-label[contains(text(),'Report based')]/following::span[1]/span[2]");
	private By group = By.xpath("//mat-label[contains(text(),'Group By')]/following::span[contains(text(),'Daily')]/parent::label/span[1]/span[2]");
	private By submit = By.xpath("//span[contains(text(),'Submit')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By drag = By.xpath("(//div[@class='cdk-drop-list item-list'])[1]/div[1]");
	private By drop = By.xpath("//div[@class='carditems']/div");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);			
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(report, 20);
			click(report);
			System.out.println("Report menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void report() {					
				Actions a = new Actions(driver);
				try {
					click(add);
					EnterText(name, "AnalyticReport");
					click(radio);
					click(next);
					Thread.sleep(500);
					click(sitedd);
					Thread.sleep(100);
					List<WebElement> s = findWebElements(sitelist);
					s.get(1).click();
					click(locdd);
					Thread.sleep(100);
					List<WebElement> s2 = findWebElements(loclist);
					s2.get(1).click();
					click(proddd);
					Thread.sleep(100);
					List<WebElement> s3 = findWebElements(prolist);
					for(WebElement x:s3) {
						if(x.getText().equals("OEE Monitoring")) {
							x.click();
							break;
						}
					}
					EnterText(menu, "Daily-report");
					click(datedd);
					List<WebElement> d = findWebElements(datelist);
					d.get(2).click();
					click(next2);
					Thread.sleep(500);
					click(display);
					click(rep);
					click(group);
					Thread.sleep(1000);
					a.moveToElement(findWebElement(drag)).perform();
				//	a.dragAndDrop(findWebElement(drag), findWebElement(drop)).perform();
					a.clickAndHold(findWebElement(drag)).moveToElement(findWebElement(drop)).release(findWebElement(drop)).build().perform();
					Thread.sleep(500);
					click(submit);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}						
			}
	public void radio() {
		try {		
			List<WebElement> r = findWebElements(replist);
			for(int i=0;i<r.size();i++) {
				if(r.get(i).getText().equals("AnalyticReport")) {
					List<WebElement> ra = findWebElements(radio2);
					ra.get(i).click();
					break;
				}
			}	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false);", findWebElement(edit));
			click(edit);
			click(next);
			Thread.sleep(500);	
			click(datedd);
			List<WebElement> d = findWebElements(datelist);
			d.get(3).click();
			click(next2);
			Thread.sleep(500);	
			click(update);
			System.out.println("Report is updated");
			Thread.sleep(1000);	
			List<WebElement> r2 = findWebElements(replist);
			for(int i=0;i<r2.size();i++) {
				if(r2.get(i).getText().equals("AnalyticReport")) {
					List<WebElement> ra = findWebElements(radio2);
					ra.get(i).click();
					break;
				}
			}
			js.executeScript("arguments[0].scrollIntoView(false);", findWebElement(delete));
			click(delete);
			click(delete2);
			System.out.println("Report is updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		try {			
			Thread.sleep(1000);
			click(profile);
			System.out.println("profile button is clicked");
			click(signout);
			System.out.println("signout button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

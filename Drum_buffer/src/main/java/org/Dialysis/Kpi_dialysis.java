package org.Dialysis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Kpi_dialysis extends BasePage{

	public Kpi_dialysis(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By dial = By.xpath("//div[contains(text(),'Dialysis Monitoring')]");
	private By kpi = By.xpath("//span[contains(text(),'KPI')]");
	private By machine = By.xpath("//span[contains(text(),'Machine Utilization')]");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");	
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[2]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By mach = By.xpath("//*[@id='element-to-export']/div[4]/div/child::div/child::div/child::div[1]");
	private By act = By.xpath("//*[@id='element-to-export']/div[4]/div/child::div/child::div[1]/descendant::span[3]");
	private By inact = By.xpath("//*[@id='element-to-export']/div[4]/div/child::div/child::div[1]/descendant::span[4]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(dial, 20);
			click(dial);
			System.out.println("Dialysis monitoring option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for Dialysis monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void kpi() {
		try {
			waittobeclickable(kpi, 20);
			click(kpi);
			System.out.println("Kpi menu is clicked");
			waittobeclickable(machine, 20);
			click(machine);
			System.out.println("Machine utilization option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Machine-Utilization";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for machine utilization page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void table() {
		try {
			Thread.sleep(1000);
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			list.get(1).click();
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'"+s+"')]/parent::button"));
			mon.click();
		//	click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m =split3[1];
			int n = (Integer.parseInt(m))-1;
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'"+n+"')]/parent::button"));
			end.click();
			click(apply);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void percent() {
		try {
			Thread.sleep(2000);
			List<WebElement> machine = findWebElements(mach);
			for(int i=0;i<machine.size();i++) {
				Thread.sleep(500);
				System.out.println("Machine is "+machine.get(i).getText());
				List<WebElement> active = findWebElements(act);
				if((active.get(i).getText()).contains("0.00%")) {
					log.info("Active percentage is 0% for "+machine.get(i).getText());
				}else {
				System.out.println("Active percentage is "+active.get(i).getText()+" for "+machine.get(i).getText());
				List<WebElement> inactive = findWebElements(inact);
				System.out.println("Inactive percentage is "+inactive.get(i).getText()+" for "+machine.get(i).getText());
			}
			}
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

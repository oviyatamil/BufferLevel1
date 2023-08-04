package org.Toollife;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Home_page extends BasePage{
	public Home_page(WebDriver driver) {
		super(driver);
	}

	
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By tool= By.xpath("//div[text()='Tool Life Management']");
	private By table = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[1]/div");
	private By time = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[1]/span[2]");
	private By oee = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[2]/span[2]");
	private By availability = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[3]/span[2]");
	private By quality = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[5]/span[2]");
	private By performance = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[4]/span[2]");
	private By partcount = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[6]/span[2]");
	private By pgm = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/div/div[2]/div[7]/span[2]");
	private By toolid = By.xpath("//*[@id='element-to-export']/div");
	private By home = By.xpath("//a[contains(text(),'Home')]");
	private By search = By.xpath("//div[text()='TL-01']/parent::div/parent::div/parent::div/descendant::button/span[1]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	
	public void tool() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(tool, 20);
			click(tool);
			System.out.println("Toollife option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/ToolLife/dashboard";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Toollife home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
	public void table() {
		try {
			List<WebElement> list = findWebElements(table);
			for(int i=0;i<list.size();i++) {
				Thread.sleep(500);
				System.out.println("EQUIPMENT IS "+list.get(i).getText());
				List<WebElement> timestamp = findWebElements(time);
				String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());		
				System.out.println("Current timing is "+data);
				System.out.println("Timestamp in machine is "+timestamp.get(i).getText());
				List<WebElement> oeepercentage = findWebElements(oee);
				System.out.println("Oee percentage is "+oeepercentage.get(i).getText());
				List<WebElement> avail = findWebElements(availability);
				System.out.println("Availability is "+avail.get(i).getText());
				List<WebElement> perf = findWebElements(performance);
				System.out.println("Performance is "+perf.get(i).getText());
				List<WebElement> quali = findWebElements(quality);
				System.out.println("Quality is "+quali.get(i).getText());
				List<WebElement> part = findWebElements(partcount);
				System.out.println("Part number is "+part.get(i).getText());
				List<WebElement> prog = findWebElements(pgm);
				System.out.println("Program is "+prog.get(i).getText());
				System.out.println("*******************");
				Thread.sleep(500);
				if(oeepercentage.get(i).getText().equals("0%")) {
					if(avail.get(i).getText().equals("0%")) {
						if(perf.get(i).getText().equals("0%")) {
							if(part.get(i).getText().equals("0")) {
								if(prog.get(i).getText().equals("0")) {
									log.info("All datas are zero expect quality for "+list.get(i).getText());
								}
							}
						}
					}
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	
}
	public void sear() {
		try {			
			List<WebElement> list = findWebElements(table);
			for(int i=0;i<list.size();i++) {
				List<WebElement> list2 = findWebElements(table);	
				String txt = list2.get(i).getText();
				Thread.sleep(500);
			List<WebElement> se = findWebElements(search);
			se.get(i).click();
			Thread.sleep(500);
			
			if(findWebElements(toolid).size()>2) {		
				click(home);				
				log.info("No record found for "+txt);	
				
			}else {
				Thread.sleep(1000);
				System.out.println("Record is displayed");	
				JavascriptExecutor j = (JavascriptExecutor)driver;
				j.executeScript("arguments[0].scrollIntoView(false);", findWebElement(home));
				click(home);
			}
			
}
			System.out.println("All records are checked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		waittobeclickable(profile, 10);
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}

}

package org.Oxygen;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Oxygen extends BasePage{

	public Oxygen(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By oxygen = By.xpath("//div[text()='Oxygen Monitoring']");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By report = By.xpath("//span[contains(text(),' Report ')]");
	private By msg = By.xpath("//*[local-name()='g' and contains(@class,'messageGroup')]/*");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("//span[text()=' KHCH1 ']/parent::mat-option/parent::div/mat-option");
	private By location = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By loclist = By.xpath("//span[contains(text(),'All')]/parent::mat-option/parent::div/mat-option");
	private By table = By.xpath("//*[@id='element-to-export']/div[4]/div/descendant::div[3]");
	private By btn = By.xpath("//*[@id='element-to-export']/div[4]/div/div[1]/div[2]/mat-icon");
	private By ddtext = By.xpath("//mat-select[@role='combobox']/div/div/span/span[1]");
	private By loctext = By.xpath("(//mat-select[@role='combobox'])[2]/div/div/span/span[1]");
	private By calendar = By.xpath("(//span[@class='mat-button-wrapper'])[18]");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])[2]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By month = By.xpath("//div[text()=' JUL ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");	
	private By enddate = By.xpath("//div[text()=' 21 ']/parent::button");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void oxygen() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(oxygen, 20);
			click(oxygen);
			System.out.println("Oxygen monitoring option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.careworx.in/#/oxygen/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Oxygen monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void home() {
		try {
			Thread.sleep(1000);
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			for(int t=0;t<list.size();t++) {
				if(t>0) {
					click(dd);
				}
				Thread.sleep(500);
				list.get(t).click();				
				click(location);
				List<WebElement> list2 = findWebElements(loclist);				
						Thread.sleep(1000);
						list2.get(0).click();
						click(apply);
						List<WebElement> tab = findWebElements(table);
						if(findWebElement(table).isDisplayed()!=true) {
							log.info("Table not displayed for "+list.get(t).getText());
						}else {
		//				for(WebElement x: tab) {
						System.out.println("Tables displayed ");
						}
		//				}
						//are "+x.getText()+" for"+list.get(t).getText()
//						click(btn);
//						Thread.sleep(1000);
//						driver.switchTo().defaultContent();
				Thread.sleep(1000);
				
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

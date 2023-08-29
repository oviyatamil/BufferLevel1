package com.Iot;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Device extends BasePage {

	public Device(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By device = By.xpath("//div[contains(text(),'Device')]");	
	private By table = By.xpath("//form/following::div[@class='ng-star-inserted']/descendant::div");
	private By search = By.xpath("//form/following::div[@class='ng-star-inserted']/descendant::div[2]/descendant::button");
	private By tabtxt = By.xpath("//form/following::div[@class='ng-star-inserted']/descendant::div[2]/descendant::div/descendant::div[2]");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By sitelist = By.xpath("//span[text()='Select Site']/parent::mat-option/parent::div/mat-option");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By info = By.xpath("//table/tbody/tr/td");
	private By head = By.xpath("//h2");
	private By topdevice = By.xpath("//a[contains(text(),'Device Connectivity')]");
	private By topdev = By.xpath("//a[contains(text(),'Devices')]");
	private By sym = By.xpath("//form/following::div[@class='ng-star-inserted']/descendant::div[2]/div/descendant::div[8]/descendant::mat-icon");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);			
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(device, 20);
			click(device);
			System.out.println("Device menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void device() {
	try {
	
		click(sitedd);
		List<WebElement> s = findWebElements(sitelist);
		for(int k=1;k<s.size();k++) {
			if(k>1) {
				click(sitedd);				
			}
			List<WebElement> s2 = findWebElements(sitelist);
			s2.get(k).click();
			String t = gettext(txt);
			Thread.sleep(1000);
			if(findWebElements(table).size()>2) {			
				System.out.println("Table displayed");
				List<WebElement> se = findWebElements(search);
//				a.moveToElement(se.get(0)).click().perform();
				for(int i=0;i<se.size();i++) {
//					a.moveToElement(se.get(i)).click().perform();	
					List<WebElement> f = findWebElements(tabtxt);
					String t2 = f.get(i).getText();		
					List<WebElement> se2 = findWebElements(search);
					se2.get(i).click();
					Thread.sleep(1000);	
					if(findWebElements(table).size()<=6){	
						log.info("No records Found for "+t+" -- "+t2);
						click(topdevice);
					}	
					else {
						System.out.println("Asset status table Records found");
						List<WebElement> sy = findWebElements(sym);
						for(int j=0;j<sy.size();j++) {							
							List<WebElement> sy2 = findWebElements(sym);
							sy2.get(j).click();
							Thread.sleep(1000);
							if(findWebElements(info).size()>1) {
								System.out.println("Info listing is displayed");
								click(topdev);
							}else {									
								log.info("No records found displayed in info listing for "+t+" -- "+t2+"---"+gettext(head));
								click(topdev);
								Thread.sleep(500);
							}
					}
						click(topdevice);
						continue;
					}						
			}
				continue;
			}else {
				log.info("Table not displayed for "+t);
				click(topdevice);
			}
			
		}
	} catch (InterruptedException e) {
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



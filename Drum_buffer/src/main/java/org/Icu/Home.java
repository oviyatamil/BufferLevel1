package org.Icu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Home extends BasePage{

	public Home(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By icu = By.xpath("//div[contains(text(),'Digital ICU')]");
	private By smart = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/child::div[1]/div[2]");
	private By sitelist = By.xpath("//span[contains(text(),'Select Site')]/ancestor::div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By admit = By.xpath("//table/tbody/tr/td[7]/span[1]/span");
	private By register = By.xpath("//span[contains(text(),'Patient Registration')]");
	private By home = By.xpath("//span[contains(text(),'Home')]");
	private By card = By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div/div");

	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			Thread.sleep(1000);
			click(icu);			
			System.out.println("Digital ICU menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}

	public void digital() {
		try {			
			click(register);
			log.info("Patient registration option is clicked");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void admit() {
		try {
			int ct=0;
			int b=0;
			int sm = 0,sn=0;
			List<WebElement> ad = findWebElements(admit);
			for(WebElement x:ad) {				
				if(x.getText().equalsIgnoreCase("Admitted")) {
					b=ct++;
				}else {
					break;
				}
			}
			System.out.println(b+1);
			click(home);
			Thread.sleep(1000);
			click(smart);
			Thread.sleep(500);
			click(sitedd);
			List<WebElement> st = findWebElements(sitelist);
			for(int i=1;i<st.size();i++) {
				if(i>1) {
					click(sitedd);
				}
				st.get(i).click();
				click(apply);
				Thread.sleep(4000);
				if(findWebElements(card).size()==ct) {
					System.out.println("Card is displayed correct");
				}else {
					log.info("Card is missing/excess");
					break;
				}
				List<WebElement> ad2 = findWebElements(card);
				for(int j=0;j<ad2.size();j++) {			
				for(int k=1;k<4;k++) {
				List<WebElement> l = driver.findElements(By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div/div["+(j+1)+"]/div[3]/div/div[2]/div["+k+"]/span"));
				if(l.size()<=1) {													
					sn=sm++;
					continue;
					}
				}
				for(int l=1;l<4;l++) {
				List<WebElement> l2 = driver.findElements(By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div/div["+(j+1)+"]/div[3]/div/div[2]/div["+l+"]/span"));
				if(l2.size()<=1) {													
					sn=sm++;
					continue;
					}
				}
				System.out.println("-------------");
				WebElement txt = driver.findElement(By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div/div["+(j+1)+"]/div[1]/div/div[1]/span"));
				if(sm==6) {
					log.info("Data not displayed for "+txt.getText());
				}else {
					System.out.println("Datas displayed for "+txt.getText());
				}
				sm=0;sn=0;
				Thread.sleep(500);
				
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
	



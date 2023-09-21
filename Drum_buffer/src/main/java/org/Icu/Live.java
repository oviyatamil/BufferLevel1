package org.Icu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import com.BasePage.BasePage;

public class Live extends BasePage{

	public Live(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By icu = By.xpath("//div[contains(text(),'Digital ICU')]");
	private By smart = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/child::div[1]/div[2]");
	private By sitelist = By.xpath("//span[contains(text(),'Select Site')]/ancestor::div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By live = By.xpath("//span[contains(text(),'Live Patients')]");
	private By dev = By.xpath("//span[contains(text(),'Device Monitoring')]");
	private By video = By.xpath("(//mat-icon[contains(@data-mat-icon-name,'video-camera')])[1]");
	private By chat = By.xpath("(//mat-icon[contains(@data-mat-icon-name,'chat')])[1]");
	private By notes = By.xpath("(//mat-icon[contains(@data-mat-icon-name,'chat')])[2]");
	private By alarm = By.xpath("(//mat-icon[contains(@data-mat-icon-name,'cog')])[1]");
	private By table = By.xpath("//table/tbody");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	private By vital = By.xpath("//mat-card[contains(text(),'Vital')]");
	private By report = By.xpath("//mat-card[contains(text(),'Report')]");
	private By trend = By.xpath("//mat-card[contains(text(),'Trend')]");
	private By pres = By.xpath("//mat-card[contains(text(),'Prescription')]");
	private By doctor = By.xpath("//table/tbody/tr[1]/td[7]");
	private By card = By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div/div");
	private By bed = By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div[2]/div/div[1]/div");
	private By colour = By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div[2]/div/div[1]");
	private By back = By.xpath("//span[contains(text(),'Back')]");
	private By arrow = By.xpath("//mat-icon[contains(@data-mat-icon-name,'arrow-narrow-left')]");
	private By text = By.xpath("//mat-select[@role='combobox']/descendant::span[2]");
	private By ordername = By.xpath("//input[contains(@formcontrolname,'drugName')]");
	private By dose = By.xpath("//input[contains(@formcontrolname,'dose')]");
	private By unit= By.xpath("//input[contains(@formcontrolname,'totalQuantity')]");
	private By freq = By.xpath("//input[contains(@formcontrolname,'frequency')]");
	private By route = By.xpath("//input[contains(@formcontrolname,'route')]");
	private By duration = By.xpath("//input[contains(@formcontrolname,'duration')]");
	private By notess = By.xpath("//textarea[contains(@formcontrolname,'notes')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");	
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");						
			click(icu);
			Thread.sleep(1000);
			System.out.println("Digital ICU menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}

	public void digital() {
		try {			
			click(live);
			log.info("Live patient option is clicked");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void live() {
		try {
			Thread.sleep(500);
			click(smart);
			click(sitedd);
			Thread.sleep(200);
			List<WebElement> st = findWebElements(sitelist);
			st.get(1).click();
//			for(int i=1;i<st.size();i++) {
//				if(i>1) {
//					click(sitedd);
//				}
//				st.get(i).click();			)
				click(apply);
				if(findWebElements(table).size()>0) {
					System.out.println("Live patient record displayed");
					click(notes);
					Thread.sleep(300);
					click(back);
					System.out.println("Click to notes button is checked");
					Thread.sleep(200);
					click(alarm);
					Thread.sleep(1000);
					click(back);
					System.out.println("Alarm setting button is checked");
					Thread.sleep(200);
					click(chat);
					Thread.sleep(300);
					click(arrow);
					System.out.println("Chat button is clicked");
					Thread.sleep(300);
					click(doctor);
					System.out.println("Doctor option is clicked");
					click(pres);
					Thread.sleep(200);
					click(add);
					EnterText(ordername, "Dolo");
					EnterText(dose, "650");
					EnterText(unit, "50");
					EnterText(freq, "3times");
					EnterText(route, "xyz");
					EnterText(duration, "3");
					EnterText(notess, "After lunch");
					click(cancel);
					System.out.println("Prescription is checked");
				}else {
					log.info("No record found for live patients in "+gettext(text));
				}
//			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
public void device() {
	try {
		click(dev);
		Thread.sleep(1000);
		click(sitedd);
		List<WebElement> st = findWebElements(sitelist);
		for(int i=1;i<st.size();i++) {
			if(i>1) {
				click(sitedd);
			}
			st.get(i).click();
			click(apply);
			if(findWebElements(card).size()>0) {
				System.out.println("Bed monitor status displayed");
				List<WebElement> c = findWebElements(colour);
				for(int j=0;j<c.size();j++) {
				String cssValue = c.get(j).getCssValue("background-color");
		//		Color color = Color.fromString(cssValue);
				List<WebElement> e = driver.findElements(By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div[2]/div/div[1]/div"));
				if(cssValue.contains("239")) {
					log.info("Bed is inactive for "+e.get(j).getText());
				}else {
					System.out.println("Bed is Active for "+e.get(j).getText());
				}
				System.out.println(cssValue);
				System.out.println("-****");
				Thread.sleep(100);
				}
			}else {
				log.info("No record found for "+gettext(text)+" in device monitoring");
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

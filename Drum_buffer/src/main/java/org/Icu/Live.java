package org.Icu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	private By alarm = By.xpath("(//mat-icon[contains(@data-mat-icon-name,'cog')])[2]");
	private By table = By.xpath("//table/tbody");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By vital = By.xpath("//mat-card[contains(text(),'Vital')]");
	private By ip = By.xpath("//mat-card[contains(text(),'Input')]");
	private By fluid = By.xpath("//mat-card[contains(text(),'Fluid Balance')]");
	private By name = By.xpath("//label[@for='displayName']/following::div[1]/input");	
	private By report = By.xpath("//mat-card[contains(text(),'Report')]");
	private By trend = By.xpath("//mat-card[contains(text(),'Trend')]");
	private By trendchart = By.xpath("(//div[contains(@class,'tooltip fusioncharts')])[1]/*");
	private By pres = By.xpath("//mat-card[contains(text(),'Prescription')]");
	private By doctor = By.xpath("//table/tbody/tr[1]/td[7]");
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])");
	private By radiobtn = By.xpath("(//span[@class='mat-radio-inner-circle'])[1]");
	private By card = By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div/div");
	private By colour = By.xpath("//span[contains(text(),'Apply')]/following::div[1]/div[2]/div/div[1]");
	private By back = By.xpath("//span[contains(text(),'Back')]");
	private By next = By.xpath("//span[contains(text(),'Next')]");
	private By caldate = By.xpath("(//*[local-name()='text'])[3]");
	private By next2 = By.xpath("(//span[contains(text(),'Next')])[2]");
	private By submit = By.xpath("//span[contains(text(),'Submit')]");
	private By arrow = By.xpath("//mat-icon[contains(@data-mat-icon-name,'arrow-narrow-left')]");
	private By text = By.xpath("//mat-select[@role='combobox']/descendant::span[2]");
	private By airplane = By.xpath("//mat-icon[@data-mat-icon-name='paper-airplane']");
	private By ordername = By.xpath("//input[contains(@formcontrolname,'drugName')]");
	private By notestosend = By.xpath("//textarea[contains(@formcontrolname,'notes')]");
	private By whatsapp = By.xpath("//textarea[contains(@formcontrolname,'message')]");
	private By dose = By.xpath("//input[contains(@formcontrolname,'dose')]");
	private By unit= By.xpath("//input[contains(@formcontrolname,'totalQuantity')]");
	private By freq = By.xpath("//input[contains(@formcontrolname,'frequency')]");
	private By route = By.xpath("//input[contains(@formcontrolname,'route')]");
	private By duration = By.xpath("//input[contains(@formcontrolname,'duration')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");
	private By delete2 = By.xpath("(//span[contains(text(),'Delete')])[2]");
	private By notess = By.xpath("//textarea[contains(@formcontrolname,'notes')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");	
	private By pulse = By.xpath("//table/tr[3]/td[3]");
	private By iv = By.xpath("//table/tbody/tr[1]/td[3]");
	private By dots = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='path']");
	private By slider = By.xpath("(//div[contains(@class,'mat-slider-thumb-label')])[1]");
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
				click(apply);
				if(findWebElements(table).size()>0) {
					System.out.println("Live patient record displayed");
//					click(notes);
//					Thread.sleep(300);
//					EnterText(notestosend, "Critical");
//					click(airplane);
//					Thread.sleep(200);
//					click(back);
//					System.out.println("Click to notes button is checked");
//					Thread.sleep(200);
//					click(alarm);
//					Thread.sleep(1000);
//					click(back);
//					System.out.println("Alarm setting button is checked");
//					Thread.sleep(200);
//					click(chat);
//					Thread.sleep(300);
//					EnterText(whatsapp, "hi");
//					click(airplane);
//					Thread.sleep(200);
//					JavascriptExecutor j = (JavascriptExecutor)driver;
//					j.executeScript("arguments[0].scrollIntoView(false);", findWebElement(arrow));
//					click(arrow);
//					System.out.println("Chat button is clicked");
//					Thread.sleep(300);
//					click(video);
//					Thread.sleep(4000);
//			//		clear(name);
//					EnterText(name, "oviya");
//					click(next);
//					Thread.sleep(6000);
//					click(back);
//					click(doctor);
//					System.out.println("Doctor option is clicked");
//					click(pres);
//					Thread.sleep(200);
//					click(add);
//					EnterText(ordername, "Dolo");
//					EnterText(dose, "650");
//					EnterText(unit, "50");
//					EnterText(freq, "3times");
//					EnterText(route, "xyz");
//					EnterText(duration, "3");
//					EnterText(notess, "After lunch");
//					click(save);
//					System.out.println("Prescription is checked");
//					Thread.sleep(500);
//					click(radio);
//					click(view);
//					click(cancel);
//					Thread.sleep(300);
//					click(radio);
//					click(delete);
//					click(delete2);
//					Thread.sleep(500);
//					System.out.println("Prescription is deleted");
//					click(back);
//					Thread.sleep(1000);
//					click(doctor);
//					click(trend);
//					Thread.sleep(1000);
//					if(findWebElements(trendchart).size()>0) {
//						System.out.println("Trend chart displayed");
//					}else {
//						log.info("Trend chart doesn't displayed");
//					}
//					click(back);
//					Thread.sleep(1000);
//					click(doctor);
//					click(report);
//					WebElement f = findWebElement(pulse);
//					if(f.getText().isBlank()==true) {
//					log.info("No data displayed inside the table for reports");
//					}else {
//						System.out.println("data displayed for reports");
//					}
//					click(back);
//					Thread.sleep(1000);
					click(doctor);
					click(ip);
					Actions a = new Actions(driver);
					a.dragAndDropBy(findWebElement(slider), 50, 20);
					waittobeclickable(next, 10);
					click(next);
					waittobeclickable(next2, 10);
					click(next2);
					Thread.sleep(500);
					click(radiobtn);
					click(submit);				
					Thread.sleep(1000);
					click(doctor);
					click(fluid);
					List<WebElement> i = findWebElements(iv);
					if(i.get(0).getText().isEmpty()==true) {
						log.info("No data displayed inside the table for fluids");
						}else {
							System.out.println("data displayed for fluids");
						}
					click(back);
					Thread.sleep(1000);
					click(doctor);
					click(vital);
					if(findWebElements(dots).size()>1) {
						System.out.println("vital chart displayed");
					}else {
						log.info("Vital chart not displayed");
					}
					click(back);
					Thread.sleep(1000);
					click(doctor);
					click(alarm);
					WebElement date = findWebElement(caldate);
					String data = new SimpleDateFormat("MMM dd,yyyy").format(new Date());
					if(date.getText().contains(data)) {
						System.out.println("Date is corrrect in alarm settings");
					}else {
						log.info("Date is not correct in alarm settings");
					}
					click(back);
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

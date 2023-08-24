package org.quality;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Masters_ReferenceData extends BasePage{

	public Masters_ReferenceData(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By quality = By.xpath("//div[text()='Quality']/parent::div/button");
	private By master = By.xpath("//span[contains(text(),'Masters')]");
	private By ref= By.xpath("//span[contains(text(),'Reference Data')]");
	private By charact = By.xpath("//div[contains(text(),'Characteristics')]");
	private By frequ = By.xpath("//div[contains(text(),'Frequency')]");
	private By ctrl = By.xpath("//div[contains(text(),'Control Methods')]");
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])");	
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By instrument= By.xpath("//input[@formcontrolname='description']");
	private By uom= By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By uomdd= By.xpath("//span[text()='Select UOM']/parent::mat-option/parent::div/mat-option");
	private By category= By.xpath("//table/tbody/tr/td[2]/span");
	private By lists= By.xpath("//table/tbody/tr/td[2]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			Thread.sleep(2000);
			click(quality);
			System.out.println("Quality option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for quality home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void reference() {
		try {
			waittobeclickable(master, 10);
			click(master);
			System.out.println("Master menu is clicked");
			waittobeclickable(ref, 10);
			click(ref);
			System.out.println("Reference data option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/masters";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Master->Reference data page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void instrument() {
		try {
			click(add);
			EnterText(instrument, "sonogram");
			String getattribute = getattribute(instrument);
			click(save);
			click(add);
			EnterText(instrument, "sonogram");		
			click(save);
			click(cancelbtn);
			List<WebElement> list = findWebElements(category);
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).getText()).contains(getattribute)) {
					System.out.println(list.get(i).getText() + " is added instrument");
					List<WebElement> rad = findWebElements(radio);
				   rad.get(i).click();				
					click(view);
					click(cancelbtn);
					System.out.println("View option is checked");
					List<WebElement> rad2 = findWebElements(radio);
					   rad2.get(i).click();	
					click(edit);
					clear(instrument);
					EnterText(instrument, "xylophone");
					click(update);
					System.out.println("Edit and update option is checked");
					break;
				}
			}
				Thread.sleep(500);
					List<WebElement> list2 = findWebElements(category);
					for (int j = 0; j < list2.size(); j++) {
						if((list2.get(j).getText()).contains("xylophone")) {
					List<WebElement> rad3 = findWebElements(radio);
					   rad3.get(j).click();					
					click(delete);				
					click(delete2);	
					System.out.println("Delete option is checked");
					break;
			}									
}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	public void characteristics() {		
		try {
			Thread.sleep(500);
			click(charact);
			Thread.sleep(500);
			click(add);
			EnterText(instrument, "Length");
			String getattribute = getattribute(instrument);
			click(uom);
			List<WebElement> l = findWebElements(uomdd);
			l.get(1).click();
			click(save);		
			click(add);
			EnterText(instrument, "Length");
			click(uom);	
			List<WebElement> l2 = findWebElements(uomdd);
			l2.get(1).click();
			click(save);
			click(cancelbtn);
			System.out.println("Duplicate Characteristics is checked");
			List<WebElement> list = findWebElements(lists);
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).getText()).contains(getattribute)) {
					System.out.println(list.get(i).getText() + " is added characteristics");
					List<WebElement> rad = findWebElements(radio);
				   rad.get(i).click();				
					click(view);
					click(cancelbtn);
					System.out.println("View option is checked");
					List<WebElement> rad2 = findWebElements(radio);
					   rad2.get(i).click();	
					click(edit);
					clear(instrument);
					Thread.sleep(500);
					EnterText(instrument, "Breadth");
					click(update);
					System.out.println("Edit and update option is checked");
					break;
				}
			}
				Thread.sleep(500);
					List<WebElement> list2 = findWebElements(lists);
					for (int j = 0; j < list2.size(); j++) {
						if((list2.get(j).getText()).contains("Breadth")) {
					List<WebElement> rad3 = findWebElements(radio);
					   rad3.get(j).click();					
					click(delete);				
					click(delete2);	
					System.out.println("Delete option is checked");
					break;
			}									
}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void frequency() {
		try {
			Thread.sleep(500);
			click(frequ);
			click(add);
			EnterText(instrument, "Every day");
			String getattribute = getattribute(instrument);		
			click(save);		
			click(add);
			EnterText(instrument, "Every day");
			click(save);
			click(cancelbtn);
			System.out.println("Duplicate frequency is checked");
			List<WebElement> list = findWebElements(category);
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).getText()).contains(getattribute)) {
					System.out.println(list.get(i).getText() + " is added Frequency");
					List<WebElement> rad = findWebElements(radio);
				   rad.get(i).click();				
					click(view);
					click(cancelbtn);
					System.out.println("View option is checked");
					Thread.sleep(1000);
					List<WebElement> rad2 = findWebElements(radio);
				    rad2.get(i).click();	
					click(edit);
					clear(instrument);
					EnterText(instrument, "Everyday");
					click(update);
					System.out.println("Edit and update option is checked");
					break;
				}
			}
				Thread.sleep(500);
					List<WebElement> list2 = findWebElements(category);
					for (int j = 0; j < list2.size(); j++) {
						if((list2.get(j).getText()).contains("Everyday")) {
					List<WebElement> rad3 = findWebElements(radio);
					   rad3.get(j).click();					
					click(delete);				
					click(delete2);	
					System.out.println("Delete option is checked");
					break;
			}									
}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void control() {
			try {
				Thread.sleep(500);
				click(ctrl);
				click(add);
				EnterText(instrument, "Every day inspections");
				String getattribute = getattribute(instrument);		
				click(save);		
				click(add);
				EnterText(instrument, "Every day inspections");
				click(save);
				click(cancelbtn);
				System.out.println("Duplicate control method is checked");
				List<WebElement> list = findWebElements(category);
				for (int i = 0; i < list.size(); i++) {
					if((list.get(i).getText()).contains(getattribute)) {
						System.out.println(list.get(i).getText() + " is added control methods");
						List<WebElement> rad = findWebElements(radio);
					   rad.get(i).click();				
						click(view);
						click(cancelbtn);
						System.out.println("View option is checked");
						Thread.sleep(1000);
						List<WebElement> rad2 = findWebElements(radio);
					    rad2.get(i).click();	
						click(edit);
						clear(instrument);
						Thread.sleep(500);
						EnterText(instrument, "Every month inspection");
						click(update);
						System.out.println("Edit and update option is checked");
						break;
					}
				}
					Thread.sleep(500);
						List<WebElement> list2 = findWebElements(category);
						for (int j = 0; j < list2.size(); j++) {
							if((list2.get(j).getText()).contains("Every month inspection")) {
						List<WebElement> rad3 = findWebElements(radio);
						   rad3.get(j).click();					
						click(delete);				
						click(delete2);	
						System.out.println("Delete option is checked");
						break;
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

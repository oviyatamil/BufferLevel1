package org.sqa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Parts extends BasePage {

	public Parts(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By sqa = By.xpath("//div[contains(text(),'SQA')]/parent::div/child::button");
	private By part = By.xpath("//span[contains(text(),'Parts')]");
	private By parts = By.xpath("//div[contains(text(),'Part Listing')]");
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])");
	private By radbtn = By.xpath("//table/tbody/tr/td[1]/descendant::span[1]/span[2]");
	private By supmap = By.xpath("//span[contains(text(),'Supplier Mapping')]");
	private By add = By.xpath("//span[text()='Add']");
	private By partno= By.xpath("//input[@formcontrolname='partNumber']");
	private By desc= By.xpath("//input[@formcontrolname='partDescription']");
	private By parttype= By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By parttypedd= By.xpath("//span[text()='Select Part Type']/parent::mat-option/parent::div/mat-option");
	private By uom= By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By file = By.xpath("//input[@type='file']");
	private By uomdd= By.xpath("//span[text()='Select UOM']/parent::mat-option/parent::div/mat-option");
	private By mc= By.xpath("//span[text()='Select SC']/parent::mat-option/parent::div/mat-option");
	private By drawno= By.xpath("//input[@formcontrolname='drawingNumber']");
	private By parttier= By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By tierdd= By.xpath("//mat-label[contains(text(),'Part Tier')]/following::div[@role='listbox']/mat-option");
	private By partchar= By.xpath("//span[text()='Select Part Characteristic']/parent::mat-option/parent::div/mat-option/span");
	private By classi= By.xpath("(//mat-select[@role='combobox'])[4]/descendant::div[4]");
	private By controlmethod= By.xpath("(//mat-select[@role='combobox'])[5]/descendant::div[4]");
	private By classdd= By.xpath("//span[text()='Select Classification']/parent::mat-option/parent::div/mat-option");
	private By cmdd= By.xpath("//span[text()='Select Contol Method']/parent::mat-option/parent::div/mat-option");
	private By category= By.xpath("//input[@formcontrolname='category']");
	private By subcategory= By.xpath("//input[@formcontrolname='subCategory']");
	private By category2= By.xpath("//table/tbody/tr/td[3]/span");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By actions = By.xpath("//mat-icon[@mattooltip='Click to Add']");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[2]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]/parent::button");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By submit = By.xpath("//button[@type='submit']");
	private By trash = By.xpath("//button[@mattooltip='Click to Delete']");
	private By usl= By.xpath("//input[@formcontrolname='usl']");
	private By median= By.xpath("//input[@formcontrolname='median']");
	private By lsl= By.xpath("//input[@formcontrolname='lsl']");
	private By size= By.xpath("//input[@formcontrolname='sampleSize']");
	private By supplier = By.xpath("//span[text()='Select Supplier']/parent::mat-option/parent::div/mat-option");
	private By ins= By.xpath("//span[text()='Select Instrument']/parent::mat-option/parent::div/mat-option");
	private By freq= By.xpath("//span[text()='Select Frequency']/parent::mat-option/parent::div/mat-option");
	private By arr = By.xpath("//table/thead/tr[1]/th[7]/div/child::div[2]");
	private By save = By.xpath("//span[text()=' Save ']");
	private By subchar = By.xpath("//span[text()='Charactertics']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");


	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(sqa, 20);
			click(sqa);
			System.out.println("SQA option is clicked");
			Thread.sleep(2000);
			System.out.println("Assert verification is done for SQA home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void parts() {
		try {
			waittobeclickable(part, 20);
			click(part);
			System.out.println("Parts menu is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.drumbuffer.io/#/SQA/parts-masterdata";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Parts page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void add() {
		try {
			click(add);
			EnterText(partno, "Abc");
			EnterText(desc, "ads");
			click(parttype);
			List<WebElement> p = findWebElements(parttypedd);
			p.get(1).click();
			click(uom);
			List<WebElement> u = findWebElements(uomdd);
			u.get(1).click();
			EnterText(drawno, "Asd123");
			Thread.sleep(500);
			calendar(calendar,yeardd, year, startdate);
			Thread.sleep(1000);
			click(parttier);
			List<WebElement> t = findWebElements(tierdd);
			t.get(1).click();
			Thread.sleep(200);
			EnterText(file, "C:\\Users\\oviya\\Downloads\\OEEMaintanance (1).pdf");
			log.info("File is attached");
			Thread.sleep(200);
			click(classi);
			List<WebElement> c = findWebElements(classdd);
			c.get(1).click();
			EnterText(category, "Industry");
			EnterText(subcategory, "material");
			click(save);
			Thread.sleep(500);	
			click(add);
			EnterText(partno, "Abc");
			EnterText(desc, "ads");
			click(parttype);
			List<WebElement> p2 = findWebElements(parttypedd);
			p2.get(1).click();
			click(uom);
			List<WebElement> u2 = findWebElements(uomdd);
			u2.get(1).click();
			EnterText(drawno, "Asd123");
			calendar(calendar,yeardd, year, startdate);	
			waittobeclickable(parttier, 10);
			click(parttier);
			Thread.sleep(500);
			List<WebElement> t2 = findWebElements(tierdd);
			t2.get(1).click();
			click(classi);
			List<WebElement> c2 = findWebElements(classdd);
			c2.get(1).click();
			EnterText(category, "Industry");
			EnterText(subcategory, "material");
			click(save);
			click(cancelbtn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void plan() {
		try {
			Thread.sleep(500);
			click(arr);
			click(arr);
			List<WebElement> list = findWebElements(category2);
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).getText()).contains("Abc")) {
					WebElement act = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[9]/button"));				
					act.click();
					click(supmap);
					Thread.sleep(500);
					break;
				}
			}
			takescreenshots("supplier");
			click(parttype);
			List<WebElement> s = findWebElements(supplier);
			s.get(1).click();			
			click(submit);
			Thread.sleep(500);
			takescreenshots("supplier2");
//			click(trash);
//			click(delete2);
			click(parts);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void characteristics() {
		try {
			Thread.sleep(1000);
					List<WebElement> lists = findWebElements(category2);
					for (int i = 0; i < lists.size(); i++) {
						if((lists.get(i).getText()).contains("Abc")) {
							List<WebElement> r = findWebElements(radio);
							r.get(i).click();
							click(delete);
							click(delete2);
					break;
					
		}
					}
		}
			
		catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
	public void check() {
		try {
			Thread.sleep(2000);
			click(radbtn);
			click(view);
			click(cancelbtn);
			System.out.println("View option is checked");
			click(arr);
			click(arr);
			List<WebElement> list = findWebElements(category2);
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).getText()).contains("Abc")) {
					System.out.println(list.get(i).getText() + " is added Partlist");
					List<WebElement> rad = findWebElements(radio);
				   rad.get(i).click();									
					click(edit);			
					clear(drawno);
					Thread.sleep(500);
					EnterText(drawno, "Asdfgh");
					click(update);
					System.out.println("Edit and update option is checked");
					break;
			
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

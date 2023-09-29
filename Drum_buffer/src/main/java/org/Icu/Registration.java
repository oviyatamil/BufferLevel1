package org.Icu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Registration extends BasePage {

	public Registration(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");	
	private By icu = By.xpath("//div[contains(text(),'Digital ICU')]/parent::div/button");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[1]/child::div[1]/div[2]");	
	private By sitelist = By.xpath("//span[text()='Select site']/parent::mat-option/parent::div/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By monitor = By.xpath("//span[contains(text(),'Monitor Movement')]");	
	private By register = By.xpath("//span[contains(text(),'Patient Registration')]");
	private By table = By.xpath("//table/tbody");
	private By text = By.xpath("//mat-select[@role='combobox']/descendant::span[2]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By hosdd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By warddd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By beddd = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By genderdd = By.xpath("(//mat-select[@role='combobox'])[4]/descendant::div[4]");
	private By doctordd = By.xpath("(//mat-select[@role='combobox'])[5]/descendant::div[4]");
	
	private By hoslist = By.xpath("//span[text()='Select Hospital']/parent::mat-option/parent::div/mat-option");
	private By warlist= By.xpath("//span[text()='Select Ward']/parent::mat-option/parent::div/mat-option");
	private By bedlist = By.xpath("//span[text()='Select Bed']/parent::mat-option/parent::div/mat-option");
	private By genderlist = By.xpath("//span[text()='Select Gender']/parent::mat-option/parent::div/mat-option");
	private By doctorlist = By.xpath("//span[text()='Select Doctor']/parent::mat-option/parent::div/mat-option");
	private By calendar = By.xpath("//mat-label[contains(text(),'DOA')]/following::span[2]");
	private By monitorlist = By.xpath("//span[text()='Select Monitor Movement']/parent::mat-option/parent::div/mat-option");
	private By yeardd = By.xpath("(//span[contains(text(),'2023')])");
	private By year = By.xpath("//div[text()=' 2023 ']");
	private By startdate = By.xpath("//div[contains(text(),'1')]/parent::button");
	
	private By radio = By.xpath("(//span[@class='mat-radio-inner-circle'])");
	private By ipno = By.xpath("//input[@formcontrolname='ipno']");
	private By name = By.xpath("//input[@formcontrolname='patientName']");
	private By age = By.xpath("//input[@formcontrolname='age']");
	private By casename = By.xpath("//textarea[@formcontrolname='tags']");	
	private By patientname = By.xpath("//table/tbody/tr/td[2]");
	private By discharge = By.xpath("(//span[contains(text(),'Discharge')])[1]");
	private By discharge2 = By.xpath("(//span[contains(text(),'Discharge')])[2]");
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
	
	public void patient() {
		try {
			List<WebElement> st = findWebElements(sitelist);
			for(int i=1;i<st.size();i++) {
				if(i>1) {
					click(sitedd);
				}
				st.get(i).click();
				click(apply);
				if(findWebElements(table).size()>0) {
					System.out.println("Patient registration record displayed");										
				}else {
					log.info("No record found for patient registration in "+gettext(text));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void radio() {
		try {
//			List<WebElement> st = findWebElements(sitelist);
//			for(WebElement x:st) {
//				if(x.getText().equals("Tirunelveli")) {
//					x.click();
//					break;
//				}
//			}
//			click(apply);
			Thread.sleep(300);
			click(add);
			click(hosdd);
			List<WebElement> h = findWebElements(hoslist);
			h.get(1).click();
			Thread.sleep(100);
			click(warddd);
			List<WebElement> w = findWebElements(warlist);
			w.get(1).click();
			Thread.sleep(100);
			click(beddd);
			List<WebElement> b = findWebElements(bedlist);
			b.get(2).click();
			Thread.sleep(100);
			EnterText(ipno, "4545");
			EnterText(name, "Aaaa");
			EnterText(age, "89");
			click(genderdd);
			List<WebElement> g = findWebElements(genderlist);
			g.get(1).click();
			Thread.sleep(100);
			click(calendar);
			click(yeardd);
			click(year);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			String[] split = data.split(" ");
			String sp = split[0].toUpperCase();
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + sp + "')]/parent::button"));
			mon.click();
			click(startdate);
			click(doctordd);
			List<WebElement> d = findWebElements(doctorlist);
			d.get(1).click();
			Thread.sleep(100);
			EnterText(casename, "XYZ");
			click(save);
			Thread.sleep(500);
			click(cancelbtn);
			Thread.sleep(1000);
			click(radio);
			click(view);
			click(cancelbtn);	
			List<WebElement> r = findWebElements(patientname);
			for(int i=0;i<r.size();i++) {
				if(r.get(i).getText().equals("Aaaa")) {
					List<WebElement> rad = findWebElements(radio);
					rad.get(i).click();
					Thread.sleep(500);
					click(discharge);
					click(discharge2);
					break;
				}
			}
			System.out.println("Checked adding patient record is working or not");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}	
	public void monitor() {
		try {			
			click(monitor);
			Thread.sleep(1000);
			click(hosdd);
			List<WebElement> h = findWebElements(sitelist);
			h.get(1).click();
			Thread.sleep(100);
			click(warddd);
			List<WebElement> w = findWebElements(monitorlist);
			w.get(1).click();
			Thread.sleep(100);			
			click(radio);
			click(cancelbtn);
			System.out.println("Monitor movement option is checked");
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

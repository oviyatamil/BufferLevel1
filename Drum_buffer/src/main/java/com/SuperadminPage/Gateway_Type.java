package com.SuperadminPage;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Gateway_Type extends BasePage {

	public Gateway_Type(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By superadmin = By.xpath("//div[text()='Super Admin']");
	private By device = By.xpath("//span[contains(text(),'Devices')]");
	private By gateway = By.xpath("//div[contains(text(),'Gateway Type')]");
	private By gatewaytype = By.xpath("(//div[contains(text(),'Gateway')])[2]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By type = By.xpath("//input[@formcontrolname='gatewayType']");
	private By desc = By.xpath("//input[@formcontrolname='description']");
	private By gatelist = By.xpath("//table/tbody/tr/td[2]/span");
	private By sid = By.xpath("//span[contains(text(),'SID')]");
	private By note = By.xpath("//span[contains(text(),'Notification')]");
	private By sim = By.xpath("//span[contains(text(),'SIM')]");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By sl = By.xpath("//table/tbody/tr/td[2]/span");
	private By view = By.xpath("//span[text()='View']");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By box = By.xpath("(//input)[1]");
	private By cusdd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By cuslist = By.xpath("(//span[text()='Select customer'])/ancestor::div[1]/mat-option/span");
	private By sitedd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By sitelist = By.xpath("(//span[text()='Select site'])/ancestor::div[1]/mat-option/span");
	private By proddd = By.xpath("(//mat-select[@role='combobox'])[3]/descendant::div[4]");
	private By prodlist = By.xpath("(//span[text()='Select Product'])/ancestor::div[1]/mat-option/span");
	private By gatedd = By.xpath("(//mat-select[@role='combobox'])[4]/descendant::div[4]");
	private By gatlist = By.xpath("(//span[text()='Select Gateway Type'])/ancestor::div[1]/mat-option/span");
	private By netdd = By.xpath("(//mat-select[@role='combobox'])[5]/descendant::div[4]");
	private By netlist = By.xpath("(//span[text()='Select Network'])/ancestor::div[1]/mat-option/span");
	private By datadd = By.xpath("(//mat-select[@role='combobox'])[6]/descendant::div[4]");
	private By datalist = By.xpath("(//span[text()='Select Data'])/ancestor::div[1]/mat-option/span");
	private By commdd = By.xpath("(//mat-select[@role='combobox'])[7]/descendant::div[4]");
	private By comlist = By.xpath("(//span[text()='Select Communication'])/ancestor::div[1]/mat-option/span");
	private By devdd = By.xpath("(//mat-select[@role='combobox'])[8]/descendant::div[4]");
	private By devlist = By.xpath("(//span[text()='Select Device'])/ancestor::div[1]/mat-option/span");
	private By freq = By.xpath("//input[@formcontrolname='frequency']");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date Range')]/following::div[1]/descendant::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By slave = By.xpath("//input[@formcontrolname='siD_Name']");
	private By simnum = By.xpath("//input[@formcontrolname='siM_Number']");
	private By topgate = By.xpath("//div[contains(text(),'Gateway Listing')]");
	private By maillist = By.xpath("(//span[text()='None'])/ancestor::div[1]/mat-option/span");
	private By sms = By.xpath("(//span[text()='None'])/ancestor::div[1]/mat-option/span");
	private By calllist = By.xpath("(//span[text()='None'])/ancestor::div[1]/mat-option/span");
	private By network = By.xpath("(//span[text()='Select Network'])/ancestor::div[1]/mat-option/span");
	private By rema = By.xpath("(//span[text()='Select Remainder'])/ancestor::div[1]/mat-option/span");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By gatearrow = By.xpath("//table/thead/tr/th[2]/descendant::div[3]");
	private By descsarrow = By.xpath("//table/thead/tr/th[3]/descendant::div[3]");
	private By statusarrow = By.xpath("//table/thead/tr/th[4]/descendant::div[3]");
	private By threedots = By.xpath("//table/tbody/tr/td[9]/button/span");

	public void home() {
		try {
			waittobeclickable(ninedots, 20);		
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(superadmin, 20);
			click(superadmin);
			System.out.println("Super admin menu option is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	public void device_gateway() {
		try {
			click(device);
			System.out.println("device module is clicked");
			Thread.sleep(1000);
			log.info("Assert verification done for device module");
			click(gateway);
			System.out.println("gateway type is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void add() {
		try {
			click(add);
			System.out.println("add button is clicked");
			EnterText(type, "Azure 01");
			System.out.println("Gateway type is entered");
			EnterText(desc, "asd");
			System.out.println("Descripton is entered");
			click(save);
			System.out.println("save button is clicked");
			Thread.sleep(500);
			click(add);
			EnterText(type, "Azure 01");
			System.out.println("same Gateway type is entered");
			EnterText(desc, "asd");
			click(save);
			System.out.println("Name already exists msg displayed");
			click(cancel);
			System.out.println("Cancel button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void radio() {
		try {
			Thread.sleep(1000);
			click(radiobtn);
			System.out.println("radio button is clicked");
			click(view);
			System.out.println("view button is clicked");
			click(cancel);
			System.out.println("cancel button is clicked after clicking view option");
			Thread.sleep(1000);
			List<WebElement> gate2 = findWebElements(gatelist);
			for(int i=0;i<gate2.size();i++) {
				if(gate2.get(i).getText().equals("Azure 01")) {
					List<WebElement> rad = findWebElements(radiobtn);
					rad.get(i).click();
					Thread.sleep(500);
			click(edit);
			System.out.println("edit button is clicked");
			clear(desc);
			System.out.println("description is cleared");
			EnterText(desc, "tesla");	
			click(update);
			System.out.println("update button is clicked");
			break;
				}
				else {
					continue;
				}
			}
			Thread.sleep(1000);
			click(radiobtn);
			click(cancel);
			log.info("cancel button is clicked after clicking radio button");
			Thread.sleep(500);
			List<WebElement> gate = findWebElements(gatelist);
			for(int j=0;j<gate.size();j++) {
				if(gate.get(j).getText().equals("Azure 01")) {
					List<WebElement> rad = findWebElements(radiobtn);
					rad.get(j).click();
					click(delete);
					System.out.println("delete button is clicked");
					click(delete2);
					System.out.println("confirm delete button is clicked");
					break;
				}
				else {
					continue;
				}
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void gatelist() {
		try {
			Thread.sleep(1000);
			List<WebElement> list = findWebElements(gatelist);
			List<String> l = new LinkedList<>();
			for (WebElement x : list) {
				String text = x.getText();
				l.add(text);
			}
			for (int k = 0; k < 1000; k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");

				if (att.contains("disabled")) {
					break;
				} else {
					click(nextpage);
					Thread.sleep(1000);
					List<WebElement> list2 = findWebElements(gatelist);
					for (WebElement x2 : list2) {
						String text = x2.getText();
						l.add(text);
					}
				}
			}
			Map<String,String> m = new LinkedHashMap<>();
			for(int i=0;i<l.size();i++) {
				if(m.containsKey(l.get(i))) {
					m.put(l.get(i), "more than 1");
				}else {
					m.put(l.get(i), "1");
				}
			}
			System.out.println(m.entrySet());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Duplicate gateway type is checked");
	}
	public void gateway() {
		try {
			click(gatewaytype);
			Thread.sleep(1000);
			click(add);
			click(cusdd);
			List<WebElement> cu = findWebElements(cuslist);
			for(WebElement x:cu) {
				if(x.getText().equals("Kaviya")) {
					x.click();
					break;
				}
			}
			click(sitedd);
			Thread.sleep(200);
			List<WebElement> s = findWebElements(sitelist);
			s.get(s.size()-1).click();
			Thread.sleep(200);
			click(proddd);
			List<WebElement> s2 = findWebElements(prodlist);
			s2.get(1).click();
			Thread.sleep(200);
			click(gatedd);
			List<WebElement> s3 = findWebElements(gatlist);
			s3.get(1).click();
			Thread.sleep(200);
			click(netdd);
			List<WebElement> s4 = findWebElements(netlist);
			s4.get(1).click();
			Thread.sleep(200);
			click(datadd);
			List<WebElement> s5 = findWebElements(datalist);
			s5.get(1).click();
			Thread.sleep(200);
			EnterText(freq, "60");
			click(commdd);
			List<WebElement> s6 = findWebElements(comlist);
			s6.get(1).click();
			Thread.sleep(200);
			click(devdd);
			List<WebElement> s7 = findWebElements(devlist);
			s7.get(1).click();
			Thread.sleep(200);
			click(save);		
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void gatecheck() {
		try {
			click(radiobtn);
			System.out.println("radio button is clicked");
			click(view);
			System.out.println("view button is clicked");
			click(cancel);
			System.out.println("cancel button is clicked after clicking view option");
			click(radiobtn);
			click(cancel);
			System.out.println("cancel button is clicked after clicking radio button");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pagination() {
			try {
				Thread.sleep(1000);
				click(pagedd);
				System.out.println("page dropdown is selected");
				click(pagesize);
				System.out.println("page size is selected");
				click(nextpage);
				System.out.println("nextpage is clicked");
				click(previous);
				System.out.println("previouspage is clicked");
				click(lastpage);
				System.out.println("lastpage is clicked");
				click(firstpage);
				System.out.println("firstpage is clicked");
				takescreenshots("pagination");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	public void arrow() {
		click(gatearrow);
		System.out.println("gateway type arrow is clicked");
		click(descsarrow);
		System.out.println("description arrow is clicked");
		click(statusarrow);
		System.out.println("status arrow is clicked");
	}
	public void search() {
		try {
			Thread.sleep(1000);
			EnterText(search, "Gat");
			System.out.println("searchtext is entered");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dots() {
	try {
		Actions a = new Actions(driver);
		EnterText(box, "tha");
		Thread.sleep(1000);
		click(threedots);
		click(sid);
		Thread.sleep(500);
		click(add);
		EnterText(slave, "77");
		click(save);
		Thread.sleep(500);
		click(radiobtn);
		click(view);
		click(cancel);	
		System.out.println("cancel button is clicked after clicking view option");
		Thread.sleep(500);
		List<WebElement> s = findWebElements(sl);
		for(int i=0;i<s.size();i++) {
			List<WebElement> r = findWebElements(radiobtn);
			if(s.get(i).getText().equals("77")) {
				r.get(i).click();
				click(delete);
				click(delete2);
				System.out.println("confirm delete button is clicked");
				break;
			}
		}		
		Thread.sleep(500);
		click(topgate);
		EnterText(box, "tha");
		Thread.sleep(1000);
		click(threedots);
		click(note);
		Thread.sleep(500);
		click(add);
		click(cusdd);
		List<WebElement> m = findWebElements(maillist);
		Thread.sleep(200);
		m.get(1).click();
		a.moveToElement(findWebElement(sitedd)).click().perform();
		Thread.sleep(200);
		click(sitedd);
		List<WebElement> sm = findWebElements(sms);
		sm.get(1).click();
		a.moveToElement(findWebElement(proddd)).click().perform();
		Thread.sleep(200);
		click(proddd);
		List<WebElement> c= findWebElements(calllist);
		c.get(1).click();
		Thread.sleep(200);
		a.moveToElement(findWebElement(save)).click().perform();		
		click(save);
		Thread.sleep(500);
		click(topgate);
		EnterText(box, "tha");
		Thread.sleep(1000);
		click(threedots);
		click(sim);
		Thread.sleep(200);
		click(add);
		EnterText(simnum, "8798786900");
		click(cusdd);
		List<WebElement> n = findWebElements(network);
		n.get(1).click();
		calendar(calendar, yeardd, year, startdate);
		click(sitedd);
		List<WebElement> l = findWebElements(rema);
		l.get(1).click();
		click(save);
		Thread.sleep(500);
		click(topgate);
		Thread.sleep(500);
		EnterText(box, "tha");
		Thread.sleep(1000);
		click(radiobtn);
		click(delete);
		click(delete2);
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



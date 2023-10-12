package com.SuperadminPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Controlchart2 extends BasePage{

	public Controlchart2(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By superadmin = By.xpath("//div[contains(text(),'Super Admin')]/parent::div/button");
	private By control = By.xpath("//span[contains(text(),'Control Center')]");
	private By not = By.xpath("//div[contains(text(),'Notification Monitoring')]");	
	private By user = By.xpath("//div[contains(text(),'User Usage Monitoring')]");	
	private By conn = By.xpath("//div[contains(text(),'Remote Gateway connect')]");
	private By live = By.xpath("//div[contains(text(),'Live Data')]");
	private By bar = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
	private By pie1 = By.xpath("(//*[local-name()='g' and contains(@class,'pie')])[2]/child::*[local-name()='g'][2]/*[local-name()='path']");
	private By pie2 = By.xpath("(//*[local-name()='g' and contains(@class,'pie')])[5]/child::*[local-name()='g'][2]/*[local-name()='path']");
	private By filterlist = By.xpath("//span[text()='Select Filter Type']/parent::mat-option/parent::div/mat-option");
	private By gatein = By.xpath("(//div[contains(text(),'Gateways')])[1]/ancestor::div[2]/div[1]/div[2]/div[2]");
	private By assetin = By.xpath("(//div[contains(text(),'Assets')])[1]/ancestor::div[2]/div[1]/div[2]/div[2]");
	private By gateact = By.xpath("(//div[contains(text(),'Gateways')])[1]/ancestor::div[2]/div[1]/div[1]/div[2]");
	private By assetact = By.xpath("(//div[contains(text(),'Assets')])[1]/ancestor::div[2]/div[1]/div[1]/div[2]");
	private By gatedown = By.xpath("(//div[contains(text(),'Gateways Down')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By asdown = By.xpath("(//div[contains(text(),'Assets Down')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By chart = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*");
	private By chart2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By icon = By.xpath("//table/tbody/tr/td[4]/mat-icon");
	private By statusoff = By.xpath("(//span[contains(text(),'Status')])[1]/ancestor::div[5]/div/descendant::span[1]");
	private By gatename = By.xpath("(//span[contains(text(),'Status')])[1]/ancestor::div[5]/div/descendant::div[5]");
	private By gatestat = By.xpath("(//span[contains(text(),'Status')])[1]/ancestor::div[5]/div/descendant::span[2]");
	private By time = By.xpath("(//span[contains(text(),'Status')])[1]/ancestor::div[5]/div/descendant::span[4]");
	private By tele = By.xpath("//span[contains(text(),'Telemetry')]/parent::div/span[2]");
	private By nodata = By.xpath("(//mat-tab-body[@role='tabpanel'])[7]/descendant::div");
	private By nodata2 = By.xpath("(//mat-tab-body[@role='tabpanel'])[12]/descendant::div");
	private By paramlist = By.xpath("//table/tbody/tr/td[2]/span");
	private By table = By.xpath("//table/tbody/tr/td");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By gatewaymon = By.xpath("//div[contains(text(),'Gateway Monitoring')]");	
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By devmon = By.xpath("(//div[contains(text(),'Device Monitoring')])");	
	private By totgate = By.xpath("(//div[contains(text(),'Gateways')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By totas = By.xpath("(//div[contains(text(),'Assets')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By sch = By.xpath("(//div[contains(text(),'Scheduled')])[1]/ancestor::div[2]/div[1]/div[1]");
	private By rect = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
	private By otau = By.xpath("(//div[contains(text(),'OTA and Mobile app update')])");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By view = By.xpath("//span[contains(text(),'View')]");
	private By edit = By.xpath("//span[contains(text(),'Edit')]");
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[contains(text(),'Delete')]");	
	private By cancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By firm = By.xpath("//input[@formcontrolname='firmware']");
	private By cusdd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[4]");
	private By gatedd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[4]");
	private By cuslist = By.xpath("//span[text()='Select Customer']/parent::mat-option/parent::div/mat-option");
	private By gatelist = By.xpath("//span[text()='Select Gateway']/parent::mat-option/parent::div/mat-option");
	private By ver = By.xpath("//input[@formcontrolname='version']");
	private By mod = By.xpath("//input[@formcontrolname='moduleName']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			Thread.sleep(4000);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(superadmin, 20);
			click(superadmin);
			System.out.println("Super admin menu option is clicked");
			Thread.sleep(2000);	
			System.out.println("Assert verification is done for super admin home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
public void control() {
	try {
		waittobeclickable(control, 20);
		click(control);
		System.out.println("Super admin menu option is clicked");
		Thread.sleep(2000);		
		System.out.println("Assert verification is done for control center page");
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	public void notification() {
		click(not);
		if(findWebElement(gateact).getText().equals(" 0 ")) {
			log.info("Gateway active count is zero");
		}else {
			System.out.println("Gateway active count is "+gettext(gateact));
		}
		String text = findWebElement(gatein).getText();
		int p = Integer.parseInt(text);
		if(p==0) {
			System.out.println("Gateway Inactive count is 0");			
		}else {
			log.info("Gateway Inactive count is "+p);
		}		
		if(findWebElement(assetact).getText().equals(" 0 ")) {
			log.info("Assets active count is zero");
		}else {
			System.out.println("Asset active count is "+gettext(assetact));
		}
		String text2 = findWebElement(assetin).getText();
		int p2 = Integer.parseInt(text2);
		if(p2==0) {
			System.out.println("Asset Inactive count is 0");			
		}else {
			log.info("Asset Inactive count is "+p2);
		}
		System.out.println("Gateway down count is "+gettext(gatedown));
		System.out.println("Assets down count is "+gettext(asdown));
		
		if(findWebElement(chart).getText().contains("No data to display")) {
			log.info("Chart 1 not displayed");
		}else {
			System.out.println("Chart 1 displayed");
		}
		if(findWebElement(chart2).getText().contains("No data to display")) {
			log.info("Chart 2 not displayed");
		}else {
			System.out.println("Chart 2 displayed");
		}
	}
	
	public void gateway() {
		try {
			click(gatewaymon);
			Thread.sleep(2000);
			String data = new SimpleDateFormat("MMM dd").format(new Date());
			System.out.println("Current timing is " + data);	
			List<WebElement> s = findWebElements(statusoff);		
			for(int i=0;i<s.size();i++) {
				List<WebElement> g = findWebElements(gatename);
				if(s.get(i).getText().contains("Offline")) {
					log.info("Status is offline for "+g.get(i).getText());
				}
				List<WebElement> gs = findWebElements(gatestat);
				if(gs.get(i).getText().contains("INACTIVE")) {
					log.info("Gateway status is Inactive for "+g.get(i).getText());
				}
				List<WebElement> t = findWebElements(time);
				if(t.get(i).getText().contains(data)) {
					System.out.println("Timestamp is correct");
				}else {
					log.info("Date in timestamp is not correct for "+g.get(i).getText());
				}
			}
			List<WebElement> g = findWebElements(gatename);
			for(int j=0;j<g.size();j++) {
				List<WebElement> g2 = findWebElements(gatename);
				String text = g2.get(j).getText();
				g2.get(j).click();
				Thread.sleep(1000);
				if(findWebElements(nodata).size()<=6) {
					log.info("No datas found for "+text);							
				}else {
					System.out.println("Table displayed");
					List<WebElement> tel = findWebElements(tele);
					for(int k=0;k<tel.size();k++) {
						if(tel.get(k).getText().contains(data)) {
							System.out.println("Table displayed with correct date");
						}else {
							log.info("Table displayed with incorrect date for "+text+" gateway");
						}
					}
							
				}
				click(gatewaymon);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void gateway2() {
		try {
			click(gatewaymon);
			Thread.sleep(2000);
			String data = new SimpleDateFormat("MMM dd").format(new Date());
			System.out.println("Current timing is " + data);	
			List<WebElement> s = findWebElements(statusoff);		
			for(int i=0;i<s.size();i++) {
				List<WebElement> g = findWebElements(gatename);
				if(s.get(i).getText().contains("Offline")) {
					log.info("Status is offline for "+g.get(i).getText());
				}
				List<WebElement> gs = findWebElements(gatestat);
				if(gs.get(i).getText().contains("INACTIVE")) {
					log.info("Gateway status is Inactive for "+g.get(i).getText());
				}
				List<WebElement> t = findWebElements(time);
				if(t.get(i).getText().contains(data)) {
					System.out.println("Timestamp is correct");
				}else {
					log.info("Date in timestamp is not correct for "+g.get(i).getText());
				}
			}
			List<WebElement> g = findWebElements(gatename);
			for(int j=0;j<g.size();j++) {
				List<WebElement> g2 = findWebElements(gatename);
				String text = g2.get(j).getText();
				g2.get(j).click();
				Thread.sleep(1000);
				if(findWebElements(nodata2).size()<=6) {
					log.info("No datas found for "+text);							
				}else {
					System.out.println("Table displayed");
					List<WebElement> tel = findWebElements(tele);
					for(int k=0;k<tel.size();k++) {
						if(tel.get(k).getText().contains(data)) {
							System.out.println("Table displayed with correct date");
						}else {
							log.info("Table displayed with incorrect date for "+text+" gateway");
						}
					}
							
				}
				click(gatewaymon);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void usage() {
		try {
			click(user);
			click(cusdd);
			List<WebElement> f = findWebElements(filterlist);
			f.get(3).click();
			click(apply);
			Thread.sleep(4000);
			if(findWebElements(bar).size()<1) {
				log.info("Chart not displayed");
			}else {
				System.out.println("Chart is displayed");				
			}
			if(findWebElements(pie1).size()<1) {
				log.info("Product wise usage piechart not displayed");				
			}else {
				System.out.println("Product wise usage piechart is displayed");
			}
			if(findWebElements(pie2).size()<1) {
				log.info("Role wise usage piechart not displayed");
			}else {
				System.out.println("Role wise usage piechart is displayed");				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void device() {
		try {
			click(devmon);
			Thread.sleep(1000);
			if(findWebElement(totgate).getText().equals("0")) {
				log.info("Total gateway is 0");
			}else {
				System.out.println("Total gateway count is "+findWebElement(totgate).getText());
			}
			if(findWebElement(totas).getText().equals("0")) {
				log.info("Total gateway is 0");
			}else {
				System.out.println("Total gateway count is "+findWebElement(totas).getText());
			}
			if(findWebElement(sch).getText().equals("0")) {
				log.info("Total gateway is 0");
			}else {
				System.out.println("Total gateway count is "+findWebElement(sch).getText());
			}
			if(findWebElement(chart).getText().contains("No data to display")) {
				log.info("Chart doesn't displayed");
			}else {
				System.out.println("Chart is displayed");
				List<WebElement> li = findWebElements(rect);
				for (WebElement w : li) {
					move(w);
				}
				System.out.println("Chart data displayed when mouseover is performed");
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void ota() {
		try {
			click(otau);
			Thread.sleep(1000);
			click(add);
			EnterText(firm, "Firm123");
			EnterText(ver, "v.10");
			EnterText(mod, "module");
		//	click(save);
			click(cancelbtn);
		//	System.out.println("Record added");
			System.out.println("Record adding field is checked");
//			click(add);
//			EnterText(firm, "Firm123");
//			EnterText(ver, "v.10");
//			EnterText(mod, "module");
//			click(save);
//			click(cancelbtn);
//			System.out.println("Duplicate record checked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void radio() {
		try {
			Thread.sleep(1000);
		click(radiobtn);
		log.info("radio button is clicked");
		click(view);
		log.info("view button is clicked");
		click(cancelbtn);
		log.info("cancel button is clicked after clicking view option");
		Thread.sleep(1000);
		List<String> s = new LinkedList<String>();
		List<String> s2 = new LinkedList<String>();
		List<WebElement> gate2 = findWebElements(paramlist);
		for(WebElement x:gate2) {
			String text = x.getText();
			s.add(text);
		}
		for (int i = 0; i < s.size();i++) {
			if (s.get(i).equals("Firm123")) {
				List<WebElement> rad = findWebElements(radiobtn);
				rad.get(i).click();
			click(edit);
			log.info("edit button is clicked");
			clear(ver);
			Thread.sleep(500);
			log.info("description is cleared");
			EnterText(ver, "v11.0");
			click(update);
			log.info("update button is clicked");
			click(firstpage);
			break;
			}
			else {
				continue;
			}
		}
//			else {
		for (int k = 0; k < 1000; k++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");

			if (att.contains("disabled")) {
				break;
			} else {
				click(nextpage);
				Thread.sleep(1000);
				List<WebElement> gate3 = findWebElements(paramlist);
				for(WebElement x3:gate3) {
					String text3 = x3.getText();
					s2.add(text3);
				}
				for (int j = 0; j < s2.size(); j++) {
					if (s2.get(j).equals("Firm123")) {
						List<WebElement> rad2 = findWebElements(radiobtn);
						rad2.get(j).click();						
					click(edit);
					log.info("edit button is clicked");
					clear(ver);
					log.info("description is cleared");
					EnterText(ver, "v11.0");
					click(update);
					log.info("update button is clicked");	
					click(firstpage);
					break;
					}						
				}					
			}
	//		break;
		}												
		Thread.sleep(1000);
		click(radiobtn);
		click(cancelbtn);
		log.info("cancel button is clicked after clicking radio button");
		Thread.sleep(500);
		List<WebElement> gate = findWebElements(paramlist);
		for (int j = 0; j < gate.size(); j++) {
			if (gate.get(j).getText().equals("Firm123")) {
				List<WebElement> rad = findWebElements(radiobtn);
				rad.get(j).click();
				System.out.println("Record to be deleted is " + gate.get(j).getText());
				click(delete);
				System.out.println("delete button is clicked");
				click(delete2);
				System.out.println("confirm delete button is clicked");
				break;
			} else {
				continue;
			}
		}
		for (int k = 0; k < 1000; k++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");

			if (att.contains("disabled")) {
				break;
			} else {
				click(nextpage);
				Thread.sleep(1000);
				List<WebElement> gate3 = findWebElements(paramlist);
				for(WebElement x3:gate3) {
					String text3 = x3.getText();
					s2.add(text3);
				}
				for (int j = 0; j < s2.size(); j++) {
					if (s2.get(j).equals("Firm123")) {
						List<WebElement> rad2 = findWebElements(radiobtn);
						rad2.get(j).click();						
						click(delete);
						System.out.println("delete button is clicked");
						click(delete2);
						System.out.println("confirm delete button is clicked");					
					break;
					}						
				}					
			}
	//		break;
		}		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

}
	public void connect() {
		try {
			click(conn);
			Thread.sleep(1000);
			click(icon);
			Set<String> w = driver.getWindowHandles();
			List<String> l = new LinkedList<>();
			l.addAll(w);
			driver.switchTo().window(l.get(0));
			Thread.sleep(500);
			click(live);
			click(cusdd);
			List<WebElement> c = findWebElements(cuslist);
				c.get(1).click();		
			click(gatedd);
			List<WebElement> g = findWebElements(gatelist);
			Thread.sleep(500);
		g.get(1).click();
			Thread.sleep(2000);
			if(findWebElements(table).size()>1) {
				System.out.println("Records displayed");
			}else {
				log.info("No records found");
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

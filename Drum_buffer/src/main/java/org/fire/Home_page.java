package org.fire;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Home_page extends BasePage {

	public Home_page(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By fire = By.xpath("//div[contains(text(),'Fire Safety Monitoring')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By btn = By.xpath("//div[contains(@class,'grid md:grid')]/div/div[1]/div[2]/button/span[1]");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[3]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By text = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By location = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[3]");
	private By loclist = By.xpath("(//span[text()='All'])[2]/ancestor::div[1]/mat-option");
	private By table = By.xpath("//div[contains(@class,'grid md:grid')]/div/div[1]/div[1]/div");
	private By fault = By.xpath("//span[text()='Fault']/parent::div/span[2]");
	private By disable = By.xpath("//span[text()='Disable']/parent::div/span[2]");
	private By status = By.xpath("//table/tbody/tr/td/span");
	private By loc = By.xpath("//table/tbody/tr/td[2]");
	private By timestamp = By.xpath("//div[contains(@class,'grid md:grid')]/div/div[6]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By record = By.xpath("//table/tbody/tr");
	public void fire() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(fire, 20);
			click(fire);
			System.out.println("Fire monitoring option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Fire home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void home() {
		try {
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			for(int t=0;t<list.size();t++) {
				list.get(t).click();
				Thread.sleep(1000);
				click(location);
				List<WebElement> list2 = findWebElements(loclist);
				List<String> s = new LinkedList<String>();
				for(int i=1;i<list2.size();i++) {
					String text = list2.get(i).getText();
					s.add(text);
					
				}
				System.out.println(s);				
				list2.get(0).click();				
				click(apply);
				Thread.sleep(4000);
				List<WebElement> list3 = findWebElements(table);
				for(int i=0;i<list3.size();i++) {
					List<WebElement> f = findWebElements(fault);
					if(f.get(i).getText().equals("0")) {
						System.out.println("No device is fault in "+ list3.get(i).getText()+"---"+gettext(text));
					}else {
						log.info("Number of fault device in "+list3.get(i).getText()+"---"+gettext(text)+" is"+f.get(i).getText());
					}
				
			}
				for(int i=0;i<list3.size();i++) {
					List<WebElement> f = findWebElements(disable);
					if(f.get(i).getText().equals("0")) {
						System.out.println("No device is diasbled in "+ list3.get(i).getText()+"---"+gettext(text));
					}else {
						log.info("Number of disabled device in "+list3.get(i).getText()+"---"+gettext(text)+" is"+f.get(i).getText());
					}
				
			}
				Thread.sleep(1000);
				List<WebElement> time = findWebElements(timestamp);
				List<WebElement> list4 = findWebElements(table);
				String data = new SimpleDateFormat("MMM dd,yyyy").format(new Date());
				for(int i=0;i<time.size();i++) {
					if(time.get(i).getText().contains(data)) {
						System.out.println("Timestamp is correct");
					}else {
						log.info("Timestamp in table is not current date for "+list4.get(i).getText()+"----"+gettext(text));
					}
				}
				Map<String,Integer> m = new LinkedHashMap<>();
				for(int k=0;k<s.size();k++) {
					if(m.containsKey(s.get(k))) {
						m.put(s.get(k), 2);
					}else {
						m.put(s.get(k), 1);
					}
					
				}
				List<WebElement> loc = findWebElements(table);
				List<String> s1 = new LinkedList<String>();
				for(int i=0;i<loc.size();i++) {
					String text = loc.get(i).getText();
					s1.add(text);
					
				}
				Map<String,Integer> m2 = new LinkedHashMap<>();
				for(int k=0;k<s1.size();k++) {
					if(m2.containsKey(s1.get(k))) {
						m2.put(s1.get(k), 2);
					}else {
						m2.put(s1.get(k), 1);
					}
					
				}
				Thread.sleep(1000);
				if(s.size()==s1.size()) {
					System.out.println("All locations are displayed");
				}else {
					log.info("Location in dropdown mismatches with table displayed in homepage for "+gettext(text));
				}
				System.out.println(m.entrySet());
				m.clear();
				s.clear();
				list3.clear();
			Thread.sleep(2000);	
			if(t==list.size()-1) {
				break;
			}else {
			click(dd);	
			}
}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


}
	public void checklist() {
		List<WebElement> list = findWebElements(btn);
		System.out.println(driver.getWindowHandle());
		int ncount =0;
		int fc =0;
		int faultc =0;
		int dis=0;
		for(int i=0;i<list.size();i++) {
			list.get(i).click();
			if(findWebElement(record).isDisplayed()==true) {
				System.out.println("Table displayed");
				List<WebElement> stat = findWebElements(status);
				for(int j=0;j<stat.size();j++) {
					if(stat.get(i).getText().contains("Normal")) {
						ncount=ncount++;
					}else if(stat.get(i).getText().contains("Fire")) {
						List<WebElement> locat = findWebElements(loc);
						log.info("Fire device is at "+locat.get(i).getText());
						fc=fc++;
					}
					else if(stat.get(i).getText().contains("Disable")){
						List<WebElement> locat = findWebElements(loc);
						log.info("Device condition at "+locat.get(i).getText()+" is disable");
						dis=dis++;
					}else {
						List<WebElement> locat = findWebElements(loc);
						log.info("Device condition at "+locat.get(i).getText()+" is fault");
						faultc=faultc++;
					}
				}
				}
				else {
					log.info("Table not displayed");
				
				}
	}
	}

	public void profile() {
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
	}

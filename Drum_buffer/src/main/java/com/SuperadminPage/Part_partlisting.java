package com.SuperadminPage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Part_partlisting extends BasePage {

	public Part_partlisting(WebDriver driver) {
		super(driver);
	}

	private By partners = By.xpath("//span[contains(text(),'Partners')]");
	private By add = By.xpath("//span[text()='Add']");
	private By pname = By.xpath("//input[contains(@formcontrolname,'partner')]");
	private By contact = By.xpath("//input[contains(@formcontrolname,'erson')]");
	private By phno = By.xpath("//input[contains(@formcontrolname,'mobile')]");
	private By email = By.xpath("//input[contains(@formcontrolname,'email')]");
	private By pwd = By.xpath("//input[contains(@formcontrolname,'password')]");
	private By address1 = By.xpath("//input[contains(@formcontrolname,'address1')]");
	private By address2 = By.xpath("//input[contains(@formcontrolname,'address2')]");
	private By coudd = By.xpath("(//mat-select[@role='combobox'])[1]/child::div[1]/div[2]");
	private By statedd = By.xpath("(//mat-select[@role='combobox'])[2]/child::div[1]/div[2]");
	private By citydd = By.xpath("(//mat-select[@role='combobox'])[3]/child::div[1]/div[2]");
	private By couselect = By.xpath("//span[contains(text(),'Select Country')]/ancestor::div[1]/mat-option/span");
	private By statesel = By.xpath("//span[contains(text(),'Select State')]/ancestor::div[1]/mat-option/span");
	private By citysel = By.xpath("//span[contains(text(),'Select City')]/ancestor::div[1]/mat-option/span");
	private By zip = By.xpath("//input[contains(@formcontrolname,'postal_Code')]");
	private By save = By.xpath("//span[contains(text(),'Save')]");
	private By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By view = By.xpath("//span[text()='View']");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By namelist = By.xpath("//table/tbody/tr/td[2]/span");
	private By maillist = By.xpath("//table/tbody/tr/td[4]/span");

	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By namearrow = By.xpath("//table/thead/tr/th[2]/div[1]/div[2]");
	private By addressarrow = By.xpath("//table/thead/tr/th[3]/div[1]/div[2]");
	private By emailarr = By.xpath("//table/thead/tr/th[4]/div[1]/div[2]");
	private By contactarr = By.xpath("//table/thead/tr/th[5]/div[1]/div[2]");
	private By statusarr = By.xpath("//table/thead/tr/th[6]/div[1]/div[2]");

	public void partners() {
		try {
			click(partners);
			Thread.sleep(1000);
			String expectedurl = "http://20.204.188.25/#/superadmin/partner";
			String ActualURL = getCurrentURL();
			assertEquals(expectedurl, ActualURL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		try {
			
			click(add);
			log.info("add button is clicked");
			EnterText(pname, "Aadav");
			log.info("Partner name entered");
			EnterText(contact, "nilan");
			log.info("contact name entered");
			EnterText(phno, "9500239828");
			log.info("Phno is entered");
			EnterText(email, "aadav@gmail.com");
			log.info("email id is entered");
			EnterText(pwd, "Admin@123");
			log.info("password is entered");
			EnterText(address1, "Bangalore");
			log.info("address1 is entered");
			EnterText(address2, "Chennai");
			log.info("address2 is entered");
			click(coudd);
			log.info("country dropdown is clicked");
			List<WebElement> cou2 = findWebElements(couselect);
			cou2.get(1).click();
			log.info("country is selected");
			click(statedd);
			log.info("state dropdown is clicked");
			List<WebElement> sta2 = findWebElements(statesel);
			sta2.get(1).click();
			log.info("state is selected");
			click(citydd);
			log.info("city dropdown is clicked");
			List<WebElement> cit2 = findWebElements(citysel);
			cit2.get(1).click();
			log.info("city is selected");
			EnterText(zip, "656656");
			log.info("zipcode is entered");	
			click(save);
			log.info("save button is clicked");
			click(add);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			EnterText(pname, "Aadav");
			EnterText(contact, "nilan");
			EnterText(phno, "9500239828");
			EnterText(email, "aadav@gmail.com");
			EnterText(pwd, "Admin@123");
			EnterText(address1, "Bangalore");
			EnterText(address2, "Chennai");
			click(coudd);
			List<WebElement> cou = findWebElements(couselect);
			cou.get(1).click();
			click(statedd);
			List<WebElement> sta = findWebElements(statesel);
			sta.get(1).click();
			click(citydd);
			List<WebElement> cit = findWebElements(citysel);
			cit.get(1).click();
			click(cancel);
			log.info("All fields are added and cancel button is clicked");
		} catch (Exception e) {
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
			click(cancel);
			log.info("cancel button is clicked after clicking view option");
			Thread.sleep(1000);
			click(radiobtn);
			click(edit);
			log.info("edit button is clicked");
			clear(address1);
			log.info("address1 is cleared");
			EnterText(address1, "Coorg");
			log.info("address1 is changed");
			clear(address2);
			log.info("address2 is cleared");
			EnterText(address2, "ooty");
			log.info("address2 is changed");
			click(update);
			log.info("update button is clicked");
			Thread.sleep(1000);
			click(radiobtn);
			click(cancel);
			log.info("cancel button is clicked after clicking radio button");
			Thread.sleep(1000);
			click(radiobtn);
			click(delete);
			log.info("delete button is clicked");
			click(delete2);
			log.info("confirm delete button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void duplicate() {
		try {
			Thread.sleep(1000);
			List<WebElement> name = findWebElements(namelist);
			Thread.sleep(1000);
			List<String> l = new LinkedList<String>();
			List<String> l2 = new LinkedList<String>();
			for (int i = 0;i < name.size();i++) {
//				List<WebElement> list = new LinkedList<WebElement>();
//				list.addAll(name);
				String text = name.get(i).getText();
				l.add(text);
				List<WebElement> mail = findWebElements(maillist);
				String text2 = mail.get(i).getText();
				l2.add(text2);
			}
			for (int k = 0; k < 1000; k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");

				if (att.contains("disabled")) {
					break;
				} else {
					click(nextpage);
					Thread.sleep(1000);
					List<WebElement> name2 = findWebElements(namelist);
					for (int i = 0; i < name2.size(); i++) {
						String text = name2.get(i).getText();
						l.add(text);
						List<WebElement> mail = findWebElements(maillist);
						String text2 = mail.get(i).getText();
						l2.add(text2);
					}
				}
			}
			
			Map<String,String> m = new LinkedHashMap<>();
			for(int i=0;i<l.size();i++) {
				
					if(m.containsKey(l.get(i))){
						if(m.containsValue(l2.get(i))) {
							m.put(l.get(i), "2");
							System.out.println("duplicate entry is "+l.get(i) +" --- "+l2.get(i));
						}
						else {
							break;
						}
			}
			else {
				m.put(l.get(i), l2.get(i));
				System.out.println(l.get(i)+" --- "+l2.get(i)+"--- is single entry");

			}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pagination() {
		try {
			Thread.sleep(1000);
			click(pagedd);
			log.info("page dropdown is selected");
			click(pagesize);
			log.info("page size is selected");
			click(nextpage);
			log.info("nextpage is clicked");
			click(previous);
			log.info("previouspage is clicked");
			click(lastpage);
			log.info("lastpage is clicked");
			click(firstpage);
			log.info("firstpage is clicked");
			takescreenshots("pagination");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void arrow() {
		click(namearrow);
		log.info("name arrow is clicked");
		click(addressarrow);
		log.info("address arrow is clicked");
		click(emailarr);
		log.info("email arrow is clicked");
		click(contactarr);
		log.info("contact arrow is clicked");
		click(statusarr);
		log.info("status arrow is clicked");
	}
	public void search() {
		try {
			Thread.sleep(1000);
			EnterText(search, "ama");
			log.info("searchtext is entered");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void profile() {
		click(profile);
		log.info("profile button is clicked");
		click(signout);
		log.info("signout button is clicked");
	}

}

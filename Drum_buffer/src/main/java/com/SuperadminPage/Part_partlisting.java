package com.SuperadminPage;

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
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By superadmin = By.xpath("//div[contains(text(),'Super Admin')]/parent::div/button");
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
	private By update = By.xpath("//span[contains(text(),'Update')]");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
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
	private By roles = By.xpath("//table/tbody/tr/td[2]/span");
	private By mail = By.xpath("//table/tbody/tr/td[4]/span");
	
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

	public void partners() {
		try {
			click(partners);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		try {
			
			click(add);
			System.out.println("add button is clicked");
			EnterText(pname, "Aadav");
			System.out.println("Partner name entered");
			EnterText(contact, "nilan");
			System.out.println("contact name entered");
			EnterText(phno, "7888888764");
			System.out.println("Phno is entered");
			EnterText(email, "aadav@outlook.com");
			System.out.println("email id is entered");
			EnterText(pwd, "Admin@123");
			System.out.println("password is entered");
			EnterText(address1, "Bangalore");
			System.out.println("address1 is entered");
			EnterText(address2, "Chennai");
			System.out.println("address2 is entered");
			click(coudd);
			System.out.println("country dropdown is clicked");
			List<WebElement> cou2 = findWebElements(couselect);
			cou2.get(1).click();
			System.out.println("country is selected");
			click(statedd);
			System.out.println("state dropdown is clicked");
			List<WebElement> sta2 = findWebElements(statesel);
			sta2.get(1).click();
			System.out.println("state is selected");
			click(citydd);
			System.out.println("city dropdown is clicked");
			List<WebElement> cit2 = findWebElements(citysel);
			cit2.get(cit2.size()-1).click();
			System.out.println("city is selected");
			EnterText(zip, "656656");
			System.out.println("zipcode is entered");	
			click(save);
			System.out.println("save button is clicked");
		} catch (Exception e) {
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
			click(radiobtn);
			click(cancel);
			System.out.println("cancel button is clicked after clicking radio button");
			Thread.sleep(1000);
			List<WebElement> r = findWebElements(roles);
			for(int i=0;i<r.size();i++) {
				if(r.get(i).getText().equals("Aadav")) {
					List<WebElement> m = findWebElements(mail);
					if(m.get(i).getText().equals("aadav@outlook.com")) {
						List<WebElement> rad = findWebElements(radiobtn);
						rad.get(i).click();
						click(edit);
						System.out.println("edit button is clicked");
						clear(address1);
						System.out.println("address1 is cleared");
						EnterText(address1, "Coorg");
						click(update);
						System.out.println("update button is clicked");
						Thread.sleep(1000);
						break;
					}else {
						log.info("Added record is missing");
					}
				}else {
					continue;
				}
			}					
			List<WebElement> r2 = findWebElements(roles);
			for(int i=0;i<r2.size();i++) {
				if(r2.get(i).getText().equals("Aadav")) {
					List<WebElement> m = findWebElements(mail);
					if(m.get(i).getText().equals("aadav@outlook.com")) {
						List<WebElement> rad = findWebElements(radiobtn);
						rad.get(i).click();
						click(delete);
						System.out.println("delete button is clicked");
						click(delete2);
						System.out.println("confirm delete button is clicked");
						Thread.sleep(1000);
						break;
					}else {
						log.info("Added record is missing");
					}
				}else {
					continue;
				}
			}		
//			Thread.sleep(1000);
//			click(radiobtn);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void duplicate() {
		try {
			Thread.sleep(1000);
			List<WebElement> name = findWebElements(roles);
			Thread.sleep(1000);
			List<String> l = new LinkedList<String>();
			List<String> l2 = new LinkedList<String>();
			for (int i = 0;i < name.size();i++) {
//				List<WebElement> list = new LinkedList<WebElement>();
//				list.addAll(name);
				String text = name.get(i).getText();
				l.add(text);
				List<WebElement> mails = findWebElements(mail);
				String text2 = mails.get(i).getText();
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
					List<WebElement> name2 = findWebElements(roles);
					for (int i = 0; i < name2.size(); i++) {
						String text = name2.get(i).getText();
						l.add(text);
						List<WebElement> mails = findWebElements(mail);
						String text2 = mails.get(i).getText();
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
							m.put(l.get(i), l2.get(i));
							System.out.println(l.get(i)+" --- "+l2.get(i)+"--- is single entry");
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
		click(namearrow);
		System.out.println("name arrow is clicked");
		click(addressarrow);
		System.out.println("address arrow is clicked");
		click(emailarr);
		System.out.println("email arrow is clicked");
		click(contactarr);
		System.out.println("contact arrow is clicked");
		click(statusarr);
		System.out.println("status arrow is clicked");
	}
	public void search() {
		try {
			Thread.sleep(1000);
			EnterText(search, "ama");
			System.out.println("searchtext is entered");
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

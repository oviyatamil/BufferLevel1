package com.Pages;

import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Master_menu extends BasePage {
	public Master_menu(WebDriver driver) {
		super(driver);
	}

	private By master = By.xpath("//span[text()=' Master ']");
	private By menu = By.xpath("//span[text()=' Menu Permission ']");
	private By product = By.xpath("//span[text()=' Product ']");
	private By productcategory=By.xpath("//span[text()=' Product Category ']");
	private By pnamearr = By.xpath("//table/thead/tr[1]/th[1]/div/child::div[2]");
	private By rourarr = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By statusarr = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By threedots = By.xpath("//tbody/tr[5]/td[9]/button/span");
	private By threedots2 = By.xpath("//tbody/tr[1]/td[9]/button/span[1]");
	private By t3 = By.xpath("//tbody/tr[2]/td[9]/button/span[1]");
	private By productlist2 = By.xpath("//tbody/tr/td[2]/span");
	private By addmenu = By.xpath("//span[text()='Add Menu']");
	private By submenu = By.xpath("//span[text()='Add Sub Menu']");
	private By add = By.xpath("//span[text()='Add']");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By menuname = By.xpath("//input[contains(@formcontrolname,'menu_Name')]");
	private By weburl = By.xpath("//input[contains(@formcontrolname,'page_URL')]");
	private By mobileurl = By.xpath("//input[contains(@formcontrolname,'mobile_URL')]");
	private By classdd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[3]");
	private By classlist = By.xpath("//span[text()='Select Class Icons']/ancestor::div[1]/mat-option/span");
	private By save = By.xpath("//span[text()=' Save ']");
	private By cancel = By.xpath("//span[text()=' Cancel ']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By productlist = By.xpath("//table[@role='table']/tbody/tr/td[2]/span");
	private By homeprolist = By.xpath("//table[@role='table']/tbody/tr/td[2]/span");
	private By mapping = By.xpath("//table[@role='table']/tbody/tr/td[1]/span");
	private By deltext = By.xpath("//tbody/tr[1]/td[2]/span");
	private By menulist = By.xpath("//div[contains(text(),'Menu Listing')]");
	private By productlink = By.xpath("//div[contains(text(),'Product')]");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By cancelbtn = By.xpath("//span[text()='Cancel']");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By profile = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By menunamearr = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By statusarr2 = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By orderarr = By.xpath("//table/thead/tr[1]/th[4]/div/child::div[2]");
	private By credatearr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	private By modibyarr = By.xpath("//table/thead/tr[1]/th[7]/div/child::div[2]");
	private By modidatearr = By.xpath("//table/thead/tr[1]/th[8]/div/child::div[2]");
	private By creabyarr = By.xpath("//table/thead/tr[1]/th[5]/div/child::div[2]");

	public void menu() {
		click(master);
		log.info("Master module is clicked");
		click(menu);
		log.info("Menu sub module is clicked");
	}

	public void arrow() {
		try {
			click(pnamearr);
			log.info("product name arrow is clicked");
			click(rourarr);
			log.info("routing url arrow is clicked");
			click(statusarr);
			log.info("status arrow is clicked");
			click(pnamearr);
			Thread.sleep(3000);
			String expectedurl = "http://20.204.188.25/#/platform/menu";
			String url = getCurrentURL();
			assertEquals(expectedurl, url);
			log.info("assert verification for user module is done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void dots() {
		try {
			Thread.sleep(1000);
			click(threedots);
			log.info("three dots button is clicked");
			click(addmenu);
			log.info("addmenu is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void add() {
		try {
			Thread.sleep(2000);
			click(add);
			log.info("add button is clicked");
			EnterText(menuname, "product");
			log.info("menuname is entered");
			click(classdd);		
			log.info("class dropdown is clicked");
			List<WebElement> l = findWebElements(classlist);
			l.get(15).click();
			log.info("icon is selected");
			click(save);
			click(add);
			EnterText(menuname, "product");
			click(classdd);
			List<WebElement> l1 = findWebElements(classlist);
			l1.get(15).click();
			click(save);
			log.info("cant add already entered menuname");
			click(cancel);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void add2() {
		try {
			click(add);
			EnterText(menuname, "cost");
			log.info("2nd menuname is entered");
			EnterText(weburl, "home");
			log.info("weburl for 2nd is entered");
			EnterText(mobileurl, "home");
			log.info("mobileurl for 2nd is entered");
			click(classdd);
			log.info("class dropdown for 2nd is clicked");
			List<WebElement> l = findWebElements(classlist);
			l.get(15).click();
			log.info("icon for 2nd is selected");
			click(save);
			Thread.sleep(1000);
			click(menunamearr);
			log.info("menuname arrow is clicked");
			click(statusarr);
			log.info("status arrow is clicked");
			click(orderarr);
			log.info("order arrow is clicked");
			click(creabyarr);
			log.info("createdby arrow is clicked");
			click(credatearr);
			log.info("created date arrow is clicked");
			click(modibyarr);
			log.info("modifiedby arrow is clicked");
			click(modidatearr);
			log.info("modified date arrow is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void submenu() {
		try {
			Thread.sleep(1000);
			click(threedots2);
			log.info("threedots for submenu is clicked");
			click(submenu);
			log.info("submenu is clicked");
			Thread.sleep(2000);
			click(add);
			EnterText(menuname, "apps");
			log.info("submenuname is entered");
			EnterText(weburl, "home/url");
			log.info("web url for submenu is entered");
			EnterText(mobileurl, "home");
			log.info("mobile url for submenu is entered");
			click(classdd);
			log.info("class dropdown for submenu is clicked");
			List<WebElement> l = findWebElements(classlist);
			l.get(10).click();
			log.info("icon for submenu is selected");
			click(save);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void submenu2() {
		try {
			Thread.sleep(2000);
			click(menulist);
			click(t3);
			click(submenu);
			click(add);
			EnterText(menuname, "rupees");
			log.info("2nd submenu is entered");
			click(classdd);
			log.info("class dropdown for 2nd submenu is clicked");
			List<WebElement> l = findWebElements(classlist);
			l.get(8).click();
			log.info("icon is selected");
			click(save);
			Thread.sleep(1000);
			EnterText(weburl, "home/url");
			EnterText(mobileurl, "home");
			click(save);
			Thread.sleep(2000);
			click(menulist);
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
			click(cancel);
			log.info("cancel button is clicked");
			Thread.sleep(1000);
			click(radiobtn);
			click(cancelbtn);
			
			log.info("top cancel button is clicked");
			Thread.sleep(1000);
			click(radiobtn);
			
			click(edit);
			Thread.sleep(1000);
			log.info("edit button is clicked");
			clear(menuname);
			EnterText(menuname, "lions");
			click(update);
			log.info("update button is clicked");
			Thread.sleep(1000);
			click(radiobtn);
			String txt = gettext(deltext);
			System.out.println("Record to be deleted is " + txt);
			Thread.sleep(500);
			click(delete);
			log.info("delete button is clicked");
			click(delete2);
			log.info("delete2 button is clicked");
			Thread.sleep(500);
			click(radiobtn);
			String txt2 = gettext(deltext);
			System.out.println("Record to be deleted is " + txt2);
			Thread.sleep(1000);
			click(delete);
			click(delete2);		
			Thread.sleep(1000);
			List<String> l2 = new LinkedList<>();
			List<WebElement> list = findWebElements(productlist);
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				l2.add(text);
			}
			for(int k=0;k<1000;k++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");
			
			if(att.contains("disabled")) {
				break;
			}
			else {
				click(nextpage);
				Thread.sleep(1000);
				List<WebElement> list2 = findWebElements(productlist);
				for (int i = 0; i < list2.size(); i++) {
					String text2 = list2.get(i).getText();
					l2.add(text2);
				}
			}
			}
			Thread.sleep(2000);
			for (String x : l2) {
				if (x.equals(txt)) {
					System.out.println("Record not deleted");
				} else {
					System.out.println(x);
				}
			}
			Map<String, Integer> m = new LinkedHashMap<>();
			for (String x2 : l2) {
				if (m.containsKey(x2)) {
					m.put(x2, 2);
					System.out.println("duplicates present is " + m);
				} else {
					m.put(x2, 1);
				}
			}
			for (Map.Entry<String, Integer> e : m.entrySet()) {
				System.out.println(e.getKey() + " : " + e.getValue());
			}

		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void productdup() {
		try {
			Thread.sleep(2000);
			click(productlink);
			List<String> l2 = new LinkedList<>();
			List<WebElement> list = findWebElements(homeprolist);
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				l2.add(text);
			}
			List<String> pc =new LinkedList<String>();
			List<WebElement> pc2 = findWebElements(mapping);
			for(int j=0;j<pc2.size();j++) {
				String text = pc2.get(j).getText();
				pc.add(text);
			}
			for(int k=0;k<100;k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");
				
				if(att.contains("disabled")) {
					break;
				}
				else  {
				click(nextpage);
				Thread.sleep(1000);
				List<WebElement> list2 = findWebElements(homeprolist);
				for (int i = 0; i < list2.size(); i++) {
					String text2 = list2.get(i).getText();
					l2.add(text2);
				}
				Thread.sleep(1000);
				List<WebElement> pc3 = findWebElements(mapping);
				for(int j=0;j<pc3.size();j++) {
					String text = pc3.get(j).getText();
					pc.add(text);
				}
				
			}
			}
			Map<String,String> map = new LinkedHashMap<String, String>();
			for(int i=0;i<l2.size();i++) {
				
			map.put(l2.get(i), pc.get(i));
			}
			//System.out.println(map.entrySet());
			Thread.sleep(2000);
			click(product);
			click(productcategory);
			Thread.sleep(2000);
			List<String> l1 = new LinkedList<>();
			List<WebElement> list1 = findWebElements(productlist2);
			for (int i = 0; i < list1.size(); i++) {
				String text3 = list1.get(i).getText();
				l1.add(text3);
			}

			for(int s=0;s<100;s++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");
				
				if(att.contains("disabled")) {
					break;
				}
				else  {
				click(nextpage);
				Thread.sleep(2000);
				List<WebElement> list3 = findWebElements(productlist2);
				for (int i = 0; i < list3.size(); i++) {
					String text4 = list3.get(i).getText();
					l1.add(text4);
				}
			}
			}
		//	for (int i = 0; i < l2.size(); i++) {
				System.out.println("Product list size in product module is--"+l1.size()+"  Product list size in menu permission--"+l2.size());
		//	}
			
		 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pagination() {
		try {
			Thread.sleep(2000);
			
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
	
	public void search() {
		try {
			Thread.sleep(2000);
			EnterText(search, "ecg");
			log.info("searchtext is entered");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void signout() {
		click(profile);
		log.info("profile button is clicked");
		click(signout);
		log.info("signout button is clicked");
	}
}



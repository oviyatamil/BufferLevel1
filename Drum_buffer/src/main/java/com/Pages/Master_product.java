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

public class Master_product extends BasePage {

	public Master_product(WebDriver driver) {
		super(driver);
	}

	private By master = By.xpath("//span[text()=' Master ']");
	private By product = By.xpath("(//span[text()=' Product '])[2]");
	private By add = By.xpath("//span[text()='Add']");
	private By productname = By.xpath("//input[contains(@formcontrolname,'products_Name')]");
	private By prourl = By.xpath("//input[contains(@formcontrolname,'products_Web_URL')]");
	private By moburl = By.xpath("//input[contains(@formcontrolname,'products_Mobile_URL')]");
	private By classdd = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[3]");
	private By classlist = By.xpath("//span[text()='Select Class Icons']/ancestor::div[1]/mat-option/span");
	private By protypelist = By.xpath("//span[text()='Select Product Type']/ancestor::div[1]/mat-option/span");
	private By protypedd = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[3]");
	private By save = By.xpath("//span[text()=' Save ']");
	private By cancel = By.xpath("//span[text()=' Cancel ']");

	// private By active=By.xpath("//span[@class='mat-checkbox-inner-container']");
	private By cancelbtn = By.xpath("//span[text()='Cancel']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By productlist = By.xpath("//table[@role='table']/tbody/tr/td[2]/span");
	private By deltext = By.xpath("//tbody/tr[1]/td[2]/span");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");

	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By profile = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By proarr = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By routarr = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By crebyarr = By.xpath("//table/thead/tr[1]/th[4]/div/child::div[2]");
	private By credatearr = By.xpath("//table/thead/tr[1]/th[5]/div/child::div[2]");
	private By modibyarr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	private By modidatearr = By.xpath("//table/thead/tr[1]/th[7]/div/child::div[2]");
	private By moniarr = By.xpath("//table/thead/tr[1]/th[8]/div/child::div[2]");
	private By statusarr = By.xpath("//table/thead/tr[1]/th[9]/div/child::div[2]");

	public void master() {
		try {
			click(master);
			log.info("Master module is clicked");
			click(product);
			log.info("product submodule is clicked");
			Thread.sleep(3000);
			String expectedurl = "http://20.204.188.25/#/platform/productmaster";
			String url = getCurrentURL();
			assertEquals(expectedurl, url);
			log.info("assert verification for user module is done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void arrow() {
		try {
			Thread.sleep(2000);
			takescreenshots("Before clicking arrow");
			click(proarr);
			log.info("product arrow  is clicked");
			click(routarr);
			takescreenshots("routing arrow is clicked");
			click(crebyarr);
			log.info("created by arrow  is clicked");
			click(credatearr);
			log.info("created date arrow  is clicked");
			click(modibyarr);
			log.info("modified by arrow  is clicked");
			click(modidatearr);
			log.info("modified date arrow  is clicked");
			click(moniarr);
			log.info("monitoring arrow  is clicked");
			click(statusarr);
			log.info("status arrow  is clicked");
			click(proarr);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addingfields() {
		click(add);
		log.info("add button is clicked");
		EnterText(productname, "Absara");
		log.info("product name is entered");
		EnterText(prourl, "absara/home");
		log.info("product url is entered");
		EnterText(moburl, "absara/home");
		log.info("mobile url is entered");
		click(classdd);
		log.info("class dropdown is clicked");
		List<WebElement> l = findWebElements(classlist);
		l.get(5).click();
		log.info("icon is selected");
		click(protypedd);
		log.info("product type dropdown is clicked");
		List<WebElement> l2 = findWebElements(protypelist);
		l2.get(1).click();
		log.info("product type is selected");
		click(save);
		log.info("save button is clicked");

	}

	public void radiobutton() {
		try {
			Thread.sleep(2000);
			click(radiobtn);
			log.info("radio button is clicked");
			click(view);
			Thread.sleep(2000);
			log.info("view button is clicked");
			click(cancel);
			log.info("cancel button is clicked");
			Thread.sleep(2000);
			click(radiobtn);
			click(cancelbtn);
			log.info("top cancel button is clicked");
			Thread.sleep(2000);
			click(radiobtn);

			click(edit);
			Thread.sleep(1000);
			log.info("edit button is clicked");
			clear(prourl);
			EnterText(prourl, "adidas");
			click(update);
			log.info("update button is clicked");
			Thread.sleep(3000);

			click(radiobtn);
			String txt = gettext(deltext);
			System.out.println("Record to be deleted is " + txt);
			click(delete);
			log.info("delete button is clicked");
			click(delete2);
			log.info("record is deleted");
			Thread.sleep(2000);
			List<String> l2 = new LinkedList<>();
			List<WebElement> list = findWebElements(productlist);
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				if (text.equals("Adidas")) {
					List<WebElement> ra = findWebElements(radiobtn);
					ra.get(i).click();
					click(delete);
					click(delete2);
				} else {
					l2.add(text);
				}
			}
			for (int k = 0; k < 100; k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");

				if (!att.contains("disabled")) {
					click(nextpage);
					Thread.sleep(3000);
					List<String> l3 = new LinkedList<>();
					List<WebElement> list2 = findWebElements(productlist);
					for (int i = 0; i < list2.size(); i++) {
						String text = list2.get(i).getText();
						l3.add(text);
					}
					l2.addAll(l3);
				} else {
					break;
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
			Thread.sleep(2000);
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
//			List<String> Inactive = new LinkedList<>();
//			List<String> active = new LinkedList<>();
//			for(int k=0;k<l2.size();k++) {
//				
//				 List<WebElement> status = findWebElements(statuscollection);
//				 System.out.println("1");
//				 String st = status.get(k).getText();
//				if(st.equalsIgnoreCase("InActive")) {
//					System.out.println("2");
//					WebElement element = findWebElement(statuscollection2);
//					
//					Inactive.add(element.getText());
//				}
//				else {
//					WebElement element = findWebElement(statuscollection2);
//					
//					active.add(element.getText());
//				}
//				System.out.println(Inactive.get(k));
//				System.out.println(active.get(k));
//			}
//				

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void pagination() {
		try {
			Thread.sleep(3000);
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

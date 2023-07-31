package com.SuperadminPage;

import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Uom extends BasePage {

	public Uom(WebDriver driver) {
		super(driver);
	}

	private By master = By.xpath("//span[contains(text(),'Master Data')]");
	private By uom = By.xpath("(//div[contains(text(),'UOM')])[1]");
	private By add = By.xpath("//span[contains(text(),'Add')]");
	private By uomname = By.xpath("//input[@formcontrolname='uom']");
	private By desc = By.xpath("//input[@formcontrolname='description']");
	private By uomlist = By.xpath("//table/tbody/tr/td[2]/span");
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

	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By uomarrow = By.xpath("//table/thead/tr/th[2]/descendant::div[3]");
	private By descsarrow = By.xpath("//table/thead/tr/th[3]/descendant::div[3]");
	private By statusarrow = By.xpath("//table/thead/tr/th[4]/descendant::div[3]");

	public void uom() {
		try {
			click(master);
			Thread.sleep(1000);
			String expectedurl = "http://20.204.188.25/#/superadmin/masterdata";
			String actualurl = getCurrentURL();
			assertEquals(expectedurl, actualurl);
			click(uom);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void add() {
		click(add);
		EnterText(uomname, "Current");
		EnterText(desc, "voltz");
		click(save);
		click(add);
		EnterText(uomname, "Current");
		EnterText(desc, "voltz");
		click(save);
		click(cancel);

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
			List<WebElement> gate2 = findWebElements(uomlist);
			for (int i = 0; i < gate2.size(); i++) {
				if (gate2.get(i).getText().equals("Current")) {
					List<WebElement> rad = findWebElements(radiobtn);
					rad.get(i).click();
					Thread.sleep(500);
					click(edit);
					log.info("edit button is clicked");
					clear(desc);
					log.info("description is cleared");
					EnterText(desc, "volt");
					click(update);
					log.info("update button is clicked");
					break;
				} else {
					continue;
				}
			}
			Thread.sleep(1000);
			click(radiobtn);
			click(cancel);
			log.info("cancel button is clicked after clicking radio button");
			Thread.sleep(500);
			List<WebElement> gate = findWebElements(uomlist);
			for (int j = 0; j < gate.size(); j++) {
				if (gate.get(j).getText().equals("Current")) {
					List<WebElement> rad = findWebElements(radiobtn);
					rad.get(j).click();
					System.out.println("Record to be deleted is " + gate.get(j).getText());
					click(delete);
					log.info("delete button is clicked");
					click(delete2);
					log.info("confirm delete button is clicked");
					break;
				} else {
					continue;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void duplicate() {
		try {
			Thread.sleep(1000);
			List<WebElement> list = findWebElements(uomlist);
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
					List<WebElement> list2 = findWebElements(uomlist);
					for (WebElement x2 : list2) {
						String text = x2.getText();
						l.add(text);
					}
				}
			}
			Map<String, String> m = new LinkedHashMap<>();
			for (int i = 0; i < l.size(); i++) {
				if (m.containsKey(l.get(i))) {
					m.put(l.get(i), "more than 1");
				} else {
					m.put(l.get(i), "1");
				}
			}
			System.out.println(m.entrySet());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("Duplicate uom is checked");
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
		click(uomarrow);
		log.info("gateway type arrow is clicked");
		click(descsarrow);
		log.info("description arrow is clicked");
		click(statusarrow);
		log.info("status arrow is clicked");
	}

	public void search() {
		try {
			Thread.sleep(1000);
			EnterText(search, "Cur");
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

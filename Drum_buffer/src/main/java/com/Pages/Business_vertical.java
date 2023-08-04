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

public class Business_vertical extends BasePage {
	public Business_vertical(WebDriver driver) {
		super(driver);
	}
	
	private By product =By.xpath("//span[text()=' Product ']");
	private By businessvertical =By.xpath("//span[text()=' Business Vertical ']");
	private By colour = By.cssSelector("//table/tbody/tr/td[2]");
	private By colour2 = By.cssSelector("//table/tbody/tr/td[6]/span[1]/span");
	private By colour3 = By.cssSelector("//table/tbody/tr/td[6]/span[1]");
	
	private By add=By.xpath("//span[text()='Add']");
	private By businessname= By.xpath("//input[@formcontrolname='business_Name']");
	private By bnamelist = By.xpath("//table/tbody/tr/td[2]");
	private By save=By.xpath("//span[text()=' Save ']");
	private By cancel=By.xpath("//span[text()=' Cancel ']");
	private By active=By.xpath("//span[@class='mat-checkbox-inner-container']");
	private By description=By.xpath("//input[@formcontrolname='business_Description']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By deltext = By.xpath("//table/tbody/tr[1]/td[2]");
	
	private By cancelbtn = By.xpath("//span[text()='Cancel']");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By profile = By.xpath("//span[contains(text(),'Master')]/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By bnarr = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By descarr = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By modibyarr = By.xpath("//table/thead/tr[1]/th[4]/div/child::div[2]");
	private By modidatearr = By.xpath("//table/thead/tr[1]/th[5]/div/child::div[2]");
	private By statusarr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	
	
	
	
	public void product() {
		click(product);
		log.info("Clicked on the product button ");
	}
	public void businessvertical() {
		try {
		click(businessvertical);
		log.info("clicked on the Businessvertical button");
		Thread.sleep(5000);
		String ExpectedURL="http://20.204.188.25/#/platform/business-vertical";
	        String ActualURL=getCurrentURL();
	        assertEquals(ExpectedURL, ActualURL);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void arrow() {
		try {
			Thread.sleep(2000);
//			String getattribute = findWebElement(colour).getAttribute("background-color");
//			System.out.println(getattribute);
//			String getattribute2 = findWebElement(colour2).getAttribute("background-color");
//			System.out.println(getattribute2);
//			String getattribute3 = findWebElement(colour3).getAttribute("background-color");
//			System.out.println(getattribute3);
			click(bnarr);
			log.info("Business name arrow is clicked");
			click(descarr);
			log.info("Description arrow is clicked");
			click(modibyarr);
			log.info("ModifiedBy arrow is clicked");
			click(modidatearr);
			log.info("ModifiedDate arrow is clicked");
			click(statusarr);
			log.info("Status arrow is clicked");
			click(bnarr);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void business_add() {
		click(add);
		log.info("add button on business vertical is clicked");
	}
	public void businessname() {
		EnterText(businessname, "AAA");
		String att = getattribute(businessname);
		System.out.println(att);
		log.info("business name is clicked");
	}
	public void save() {
		try {
			click(save);
			log.info("save button is clicked");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void cancel() {
		click(cancel);
		log.info("cancel button is clicked");
	}

	public void active() {
		click(active);
		log.info("active button is clicked");
	}
	public void description() {
		EnterText(description, "Trading");
		log.info("description is entered");
		
	}
	public void radiobtn() {
	    try {
			Thread.sleep(2000);
			click(radiobtn);
			log.info("radiobutton is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void view() {
		click(view);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("viewbutton is clicked");
	}
	public void edit() {
		try {
			click(edit);
			log.info("editbutton is clicked");
				Thread.sleep(1000);
//				click(description);
				clear(description);
				EnterText(description, "Technology");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//			String att = getattribute(businessname);
//			System.out.println("Updated business name is " +att);
	}
	public void update() {
		click(update);
		log.info("updatebutton is clicked");
		takescreenshots("update");
	}
	public void cancelbtn() {
		click(cancelbtn);
		log.info("cancel btn is clicked");
	}
	public void delete() {
		try {
			String txt = gettext(deltext);
			System.out.println("RECORD TO BE DELETED IS " + txt);
			click(delete);
			log.info("deletebutton is clicked");
			click(delete2);
			log.info("Record is deleted");
			takescreenshots("Delete bn");
			Thread.sleep(3000);

			List<String> l2 = new LinkedList<>();
			List<WebElement> list = findWebElements(bnamelist);
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				List<String> l1 = new LinkedList<>();
				l1.add(text);
				l2.addAll(l1);

			}
			for(int i=0;i<100;i++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");
			
			if(att.contains("disabled")) {
				break;
			}
			else {
				click(nextpage);
				Thread.sleep(2000);
				List<WebElement> list2 = findWebElements(bnamelist);
				for (int k = 0; k < list2.size(); k++) {
					String text2 = list2.get(k).getText();
					l2.add(text2);
				}
			}
			}
			
			
//			if (findWebElement(nextpage).isSelected()) {
//				click(nextpage);
//				Thread.sleep(2000);
//				List<WebElement> list2 = findWebElements(bnamelist);
//				for (int i = 0; i < list2.size(); i++) {
//					String text = list2.get(i).getText();
//					List<String> l = new LinkedList<>();
//					l.add(text);
//
//					l2.addAll(l);
//
//				}
//				System.out.println(l2);
//
//			} else {
//				System.out.println("nextpage is not enabled");
//			}

//			for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).getText());
//			}

			
			Thread.sleep(5000);
			for (String x : l2) {
				if (x.equals(txt)) {
					System.out.println("Record not deleted");
				} else {
					System.out.println("Recods present are " + x);
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

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void pagedrop() {
		click(pagedd);
		log.info("pagedropdown is clicked");
	}

	public void pagesize() {
		click(pagesize);
		log.info("pagesize is clicked");
	}

	public void next() {
		try {
			Thread.sleep(1000);
			if (findWebElement(nextpage).isEnabled()) {
				click(nextpage);
				log.info("nextpage is clicked");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void previous() {
		try {
			Thread.sleep(1000);
			if (findWebElement(previous).isEnabled()) {
				click(previous);
				log.info("previous page is clicked");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void last() {
		try {
			Thread.sleep(1000);
			if (findWebElement(lastpage).isEnabled()) {
				click(lastpage);
				log.info("lastpage is clicked");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void first() {
		try {
			Thread.sleep(1000);
			if (findWebElement(firstpage).isEnabled()) {
				click(firstpage);
				log.info("firstpage is clicked");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void search() {
		try {
			Thread.sleep(2000);
			EnterText(search, "inf");
			takescreenshots("Search result");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void profile() {
		click(profile);
		log.info("profile button is clicked");
	}

	public void signout() {
		click(signout);
		log.info("signout button is clicked");
	}
}

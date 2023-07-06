package com.Pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Product_Pcategory extends BasePage{
	public Product_Pcategory(WebDriver driver) {
		super(driver);
		
	}
	private By product =By.xpath("//span[text()=' Product ']");
	private By productcategory=By.xpath("//span[text()=' Product Category ']");
	private By category = By.xpath("//div[@class='mat-chip-list-wrapper']/mat-chip");
	private By add =By.xpath("(//span[text()='Add'])[1]");
	private By add2 =By.xpath("(//span[text()='Add'])[2]");
	private By addproductcategory =By.xpath("//mat-label[text()='Product Category']/parent::label/parent::span/parent::div/child::input"); 
	private By save=By.xpath("//span[text()=' Save ']");
	private By cancel=By.xpath("//span[text()=' Cancel ']");
	private By active=By.xpath("//span[@class='mat-checkbox-inner-container']");
	private By pcdropdown = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::div[3]");
	private By pcdroplist = By.xpath("//span[text()='Select Category']/ancestor::div[1]/mat-option[@role='option']/span");
	private By pnamedrop = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[3]");
	private By pnamelist = By.xpath("//span[text()='Select Product']/ancestor::div[1]/mat-option[@role='option']/span");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By view = By.xpath("//span[text()='View']");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By row = By.xpath("//tbody/tr");
	private By delpro = By.xpath("//tbody/tr[1]/td[2]/span");
	private By delpc = By.xpath("//tbody/tr[1]/td[3]/span");
	private By productlist = By.xpath("//tbody/tr/td[2]/span");
	private By productcategorylist = By.xpath("//tbody/tr/td[3]/span");
	
	private By cancelbtn = By.xpath("//span[text()='Cancel']");
	private By delete2 = By.xpath("(//span[contains(text(),'elete')])[2]");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By productarrow = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By pcarrow = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By createdbyarr = By.xpath("//table/thead/tr[1]/th[4]/div/child::div[2]");
	private By createddatearr = By.xpath("//table/thead/tr[1]/th[5]/div/child::div[2]");
	private By modifiedbyarr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	private By modifieddate = By.xpath("//table/thead/tr[1]/th[7]/div/child::div[2]");
	private By status = By.xpath("//table/thead/tr[1]/th[8]/div/child::div[2]");
	private By profile = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");


	public void product() {
		click(product);
		log.info("Clicked on the product button ");
	}
	public void procategory() {
		try {
		click(productcategory);
		log.info("Clicked on the productcategory button");
		Thread.sleep(3000);
		String ExpectedURL="http://20.204.188.25/#/platform/product";
	        String ActualURL=getCurrentURL();
	        assertEquals(ExpectedURL, ActualURL);
	        takescreenshots("Product category");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void categorylist() {
		try {
			Thread.sleep(2000);
			List<WebElement> list = findWebElements(category);
			for(WebElement x:list) {
				System.out.println(x.getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void add() {
		click(add);
		takescreenshots("PC add field");
		log.info("add button in product category is clicked");
	}

	public void add2() {
		click(add2);
		takescreenshots("PC mapping");
		log.info("add button in product mapping listing is clicked");
	}
	public void pcdrop() {
		click(pcdropdown);
		log.info("product category dropdown is clicked");
		List<WebElement> pcdrop = findWebElements(pcdroplist);
		pcdrop.get(1).click();
		log.info("Product category is selected");
	}
	
//	public void pcdroplist() {
//		click(pcdroplist);
//		log.info("Getting product category dropdown list");
//	}
	
	
	public void pnamedrop() {
		click(pnamedrop);
		log.info("product name dropdown is clicked");
		List<WebElement> pname = findWebElements(pnamelist);
		pname.get(1).click();
		log.info("Product name is selected");
	}
	
public void addpc() {
	EnterText(addproductcategory, "Sweets");
	String getattribute = getattribute(addproductcategory);
	System.out.println("Added product category is " +getattribute);
	log.info("product category is entered");
		click(save);
		takescreenshots("Record inserted");
		log.info("save button is clicked");
		try {
			Thread.sleep(2000);
			List<WebElement> list = findWebElements(category);
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).getText()).equals(getattribute)) {
					System.out.println(list.get(i).getText() + " is added product");
			}else {
				System.out.println("Other product categories are " + list.get(i).getText());
			}
			
		}
			List<WebElement> list2 = findWebElements(category);
			for (int i = 0; i < list2.size(); i++) {
				if((list2.get(i).getText()).equals("Sweets")) {
					list2.get(i).click();
					click(delete);
					click(delete2);
				}
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void save() {
		click(save);
		takescreenshots("Record inserted");
		log.info("save button is clicked");
	}
	public void cancel() {
		click(cancel);
		log.info("cancel button is clicked");
	}

//	public void active() {
//		click(active);
//		log.info("active button is clicked");
//	}
	public void radiobtn() {
	    try {
			Thread.sleep(1000);
			click(radiobtn);
			log.info("radiobutton is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void view() {
		click(view);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("viewbutton is clicked");
	}
	public void edit() {
		click(edit);
		log.info("editbutton is clicked");
		click(pnamedrop);
		List<WebElement> pname = findWebElements(pnamelist);
		pname.get(4).click();
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
		String deleteproduct = gettext(delpro);
		String deletepc = gettext(delpc);
		Map<String,String> del = new LinkedHashMap<>();
		del.put(deletepc, deleteproduct);
		System.out.println("deleted product is " +del);
		click(delete);
		log.info("deletebutton is clicked");
		try {
			click(delete2);
			
			log.info("delete2button is clicked");
			takescreenshots("Delete");
			Thread.sleep(2000);
			List<WebElement> list = findWebElements(productlist);
			List<String> l = new LinkedList<String>();
			for(WebElement x:list) {
				String txt = x.getText();
				l.add(txt);
				
			}		
			List<WebElement> list2 = findWebElements(productcategorylist);
			List<String> l2 = new LinkedList<String>();
			for(WebElement x2:list2) {
				String txt2 = x2.getText();
				l2.add(txt2);
			}
			for(int k=0;k<100;k++) {
			WebElement element = findWebElement(nextdisable);
			String att = element.getAttribute("class");
			
			
			if(att.contains("disabled")) {
				break;
			}
			else {
				click(nextpage);
				Thread.sleep(3000);
				List<WebElement> list3 = findWebElements(productlist);
				List<String> l3 = new LinkedList<String>();
				for(WebElement x3:list3) {
					String txt3 = x3.getText();
					l3.add(txt3);
				}
				l.addAll(l3);
				List<WebElement> list4 = findWebElements(productcategorylist);
				List<String> l4 = new LinkedList<String>();
				for(WebElement x4:list4) {
					String txt4 = x4.getText();
					l4.add(txt4);
				}
				l2.addAll(l4);
			}
			}
		
//			for(String s :l) {
//				if(s.equals(deleteproduct)) {
//					System.out.println("Record is not deleted");
//				}
//			}
			Thread.sleep(2000);
			Map<String,Integer> m = new LinkedHashMap<>();
			
			for(int i=0;i<l.size();i++) {
			String t =	(l2.get(i) +"------" + l.get(i));
			
			if(m.containsKey(t)) {
				m.put(t, 2);
			}else {
				m.put(t, 1);
			}
			}
			System.out.println(m.entrySet());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pagedrop() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		click(pagedd);
	}
	public void pagesize() {
		click(pagesize);
	}
	public void next() {
		try {
			Thread.sleep(2000);
			click(nextpage);
			log.info("nextpage is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void previous() {
		try {
			Thread.sleep(2000);
			click(previous);
			log.info("previous page is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void last() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		click(lastpage);
		log.info("lastpage is clicked");
	}
	public void first() {
		try {
			Thread.sleep(2000);
			click(firstpage);
			log.info("firstpage is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void search() {
		EnterText(search, "nov");
		takescreenshots("Search record");
	}

	public void order() {
		click(productarrow);
		log.info("product arrow is clicked");
		click(pcarrow);
		log.info("product category arrow is clicked");
		click(createdbyarr);
		log.info("created by arrow is clicked");
		click(createddatearr);
		log.info("created date arrow is clicked");
		click(modifiedbyarr);
		log.info("modifiedby arrow is clicked");
		click(modifieddate);
		log.info("modifieddate arrow is clicked");
		click(status);
		log.info("status arrow is clicked");
		click(productarrow);
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

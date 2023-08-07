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

public class Master_user extends BasePage {
	public Master_user(WebDriver driver) {
		super(driver);
	}

	private By master = By.xpath("//span[text()=' Master ']");
	private By user = By.xpath("//span[text()=' User ']");
	private By add = By.xpath("//span[text()='Add']");
	private By role = By.xpath("//mat-label[text()='Role Name']/ancestor::div[1]/descendant::div[3]");
	private By rolelist = By.xpath("//mat-option[@role='option']/span");
	private By fullname = By.xpath("//input[contains(@formcontrolname,'userName')]");
	private By address = By.xpath("//input[contains(@formcontrolname,'address1')]");
	private By phno = By.xpath("//input[contains(@formcontrolname,'user_Mobile')]");
	private By email = By.xpath("//input[contains(@formcontrolname,'user_Email')]");
	private By pwd = By.xpath("//input[contains(@formcontrolname,'user_Password')]");
	private By save = By.xpath("//span[text()=' Save ']");
	private By cancel = By.xpath("//span[text()=' Cancel ']");
	private By nextdisable = By.xpath("//button[@aria-label='Next page']");
	private By active = By.xpath("//table[@role='table']/tbody/tr/td[9]/span/span");
	private By authenticate = By.xpath("//span[@class='mat-slide-toggle-bar']/input");
	private By cancelbtn = By.xpath("//span[text()='Cancel']");
	private By radiobtn = By.xpath("//span[@class='mat-radio-inner-circle']");
	private By userlist = By.xpath("//table/tbody/tr/td[2]");
	private By rolenamelist = By.xpath("//table/tbody/tr/td[3]");
	private By view = By.xpath("//span[text()='View']");
	private By edit = By.xpath("//span[text()='Edit']");
	private By update = By.xpath("//span[text()=' Update ']");
	private By delete = By.xpath("//span[text()='Delete']");
	private By delete2 = By.xpath("//span[text()=' Delete ']");
	private By fnarrow = By.xpath("//table/thead/tr[1]/th[2]/div/child::div[2]");
	private By rolearrow = By.xpath("//table/thead/tr[1]/th[3]/div/child::div[2]");
	private By creabyarr = By.xpath("//table/thead/tr[1]/th[4]/div/child::div[2]");
	private By creadatearr = By.xpath("//table/thead/tr[1]/th[5]/div/child::div[2]");
	private By modibyarr = By.xpath("//table/thead/tr[1]/th[6]/div/child::div[2]");
	private By modidatearr = By.xpath("//table/thead/tr[1]/th[7]/div/child::div[2]");
	private By twofactorarr = By.xpath("//table/thead/tr[1]/th[8]/div/child::div[2]");
	private By statusarr = By.xpath("//table/thead/tr[1]/th[9]/div/child::div[2]");
	private By pagedd = By.xpath("//mat-select[@role='combobox']/descendant::div[3]");
	private By pagesize = By.xpath("//span[text()=' 5 ']");
	private By nextpage = By.xpath("//button[@aria-label='Next page']/span");
	private By firstpage = By.xpath("//button[@aria-label='First page']/span");
	private By lastpage = By.xpath("//button[@aria-label='Last page']/span");
	private By previous = By.xpath("//button[@aria-label='Previous page']/span");
	private By search = By.xpath("//input[contains(@placeholder,'earch')]");
	private By profile = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");

	public void master() {
		try {
			click(master);
			log.info("Master module is clicked");
			click(user);
			log.info("user submodule is clicked");
			Thread.sleep(3000);
			String expectedurl = "http://20.204.188.25/#/platform/user";
			String url = getCurrentURL();
			assertEquals(expectedurl, url);
			log.info("assert verification for user module is done");
			takescreenshots("masteruser");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		click(add);
		log.info("add button is clicked");
	}

	public void authenticate() {
		click(authenticate);
	}

	public void role() {
		click(role);
		log.info("role dropdown is selected");
		List<WebElement> pcdrop = findWebElements(rolelist);
		pcdrop.get(2).click();
		log.info("Product category is selected");
	}

	public void fn() {
		EnterText(fullname, "Aadav");
		log.info("fullname is entered");
	}

	public void address() {
		EnterText(address, "coorg");
		log.info("address is entered");
	}

	public void phno() {
		EnterText(phno, "9447651111");
		log.info("phno is entered");
	}

	public void email() {
		EnterText(email, "aaradhana@gmail.com");
		log.info("email is entered");
	}

	public void pwd() {
		EnterText(pwd, "Asdfgh234$");
		log.info("password is entered");
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

	public void active() {
		click(active);
		log.info("active button is clicked");
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
		click(edit);
		log.info("editbutton is clicked");
		clear(address);
		EnterText(address, "madurai");
	}

	public void update() {
		try {
			Thread.sleep(2000);
			click(update);
			log.info("updatebutton is clicked");
			takescreenshots("update");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void cancelbtn() {
		click(cancelbtn);
		log.info("cancel btn is clicked");
	}

	public void delete() {
		try {
			List<WebElement> r1 = findWebElements(radiobtn);
			for (int i = 0; i < r1.size(); i++) {
				r1.get(i).click();
				click(view);
				Thread.sleep(500);
				String fn = getattribute(fullname);
				String mail = getattribute(email);
				if (fn.equals("Aadav")) {
					if (mail.equals("aaradhana@gmail.com")) {
						click(cancel);
						List<WebElement> r2 = findWebElements(radiobtn);
						r2.get(i).click();
						click(delete);
						click(delete2);
						break;

					} else {
						continue;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void list() {
		try {
//			click(delete2);
//			log.info("delete2button is clicked");
//			takescreenshots("Delete");
			Thread.sleep(2000);
			Map<String, String> m2 = new LinkedHashMap<>();
			List<WebElement> list = findWebElements(userlist);
			List<String> l = new LinkedList<String>();
			for (WebElement x : list) {
				String txt = x.getText();
				l.add(txt);

			}
			List<WebElement> list2 = findWebElements(rolenamelist);
			List<String> l2 = new LinkedList<String>();
			for (WebElement x2 : list2) {
				String txt2 = x2.getText();
				l2.add(txt2);
			}
			Thread.sleep(2000);
			for (int k = 0; k < 100; k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");

				if (att.contains("disabled")) {
					break;
				} else {
					click(nextpage);
					Thread.sleep(2000);
					List<WebElement> list3 = findWebElements(userlist);
					List<String> l3 = new LinkedList<String>();
					for (WebElement x3 : list3) {
						String txt3 = x3.getText();
						l3.add(txt3);
					}
					l.addAll(l3);
					List<WebElement> list4 = findWebElements(rolenamelist);
					List<String> l4 = new LinkedList<String>();
					for (WebElement x4 : list4) {
						String txt4 = x4.getText();
						l4.add(txt4);
					}
					l2.addAll(l4);
				}
			}
			for (int i = 0; i < l.size(); i++) {
				m2.put(l.get(i), l2.get(i));
			}
			System.out.println(m2);
			click(firstpage);
			Map<String, String> map = new LinkedHashMap<>();

			Thread.sleep(500);

			for (int i = 0; i < list.size(); i++) {
				List<WebElement> r1 = findWebElements(radiobtn);
				r1.get(i).click();
				click(view);
				Thread.sleep(1000);
				String fn = getattribute(fullname);
				String mail = getattribute(email);
				if (map.containsKey(mail)) {
					map.put(mail, "2");
					System.out.println("duplicate mail id is " + mail);
				} else if ((fn.equals("Aadav")) && (mail.equals("aaradhana@gmail.com"))) {
					System.out.println("Record not deleted");
				} else {
					map.put(fn, mail);
				}

				System.out.println(fn + " ------------ " + mail);
				click(cancel);
				Thread.sleep(500);
			}
			for (int k = 0; k < 1000; k++) {
				WebElement element = findWebElement(nextdisable);
				String att = element.getAttribute("class");

				if (att.contains("disabled")) {
					break;
				} else {
					click(nextpage);
					Thread.sleep(2000);
					List<WebElement> r2 = findWebElements(active);
					for (int i = 0; i < r2.size(); i++) {
						Thread.sleep(500);
						List<WebElement> r3 = findWebElements(radiobtn);
						r3.get(i).click();
						click(view);
						Thread.sleep(1000);
						String fn = getattribute(fullname);
						String mail = getattribute(email);
						if (map.containsKey(mail)) {
							map.put(mail, "2");
							System.out.println("duplicate mail id is " + mail);
						} else if ((fn.equals("Aadav")) && (mail.equals("aaradhana@gmail.com"))) {
							System.out.println("Record not deleted");
						} else {
							map.put(fn, mail);
						}

						System.out.println(fn + " ------------ " + mail);
						click(cancel);
						Thread.sleep(500);
					}
				}
			}

//			for(String s :l) {
//				if(s.equals(deletefullname)) {
//					System.out.println("Record is not deleted = " +s);
//				}
//			}

//			if((fn.equals("Aadav"))) {
//					if(mail.equals("aaradhana@gmail.com")){
//				click(cancel);
//				r1.get(i).click();
//				click(delete);
//				click(delete2);
//				break;
//			}
//			}

//			if(m.containsKey(t)) {
//				List<WebElement> r = findWebElements(radiobtn);
//				r.get(i).click();
//				click(view);
//				Thread.sleep(1000);
//				String fn = getattribute(fullname);
//				String mail = getattribute(email);
//				System.out.println(fn+" ------------ "+mail);
//				m.put(t, 2);
//			}else {
//				m.put(t, 1);
//			}
//			}

			// System.out.println(m.entrySet());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void arrow() {
		click(fnarrow);
		log.info("fullname arrow is clicked");
		click(rolearrow);
		log.info("rolename arrow is clicked");
		click(modibyarr);
		log.info("modified by arrow is clicked");
		click(modidatearr);
		log.info("modified date arrow is clicked");
		click(creabyarr);
		log.info("created by arrow is clicked");
		click(creadatearr);
		log.info("created date arrow clicked");
		click(twofactorarr);
		log.info("two factor authentication arrow is clicked");
		click(statusarr);
		log.info("status arrow is clicked");
		click(fnarrow);
	}

	public void pagination() {
		try {
			Thread.sleep(1000);
			click(pagedd);
			log.info("Page dropdown is clicked");
			waittobeclickable(pagesize, 5);
			click(pagesize);
			log.info("Pagesize is clicked");
			click(nextpage);
			log.info("nextpage is clicked");
			click(previous);
			log.info("previouspage is clicked");
			click(lastpage);
			log.info("lastpage is clicked");
			click(firstpage);
			log.info("firstpage is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void search() {
		try {
			Thread.sleep(1000);
			EnterText(search, "ilan");
			takescreenshots("Search record");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void profile() {
		try {
			Thread.sleep(2000);
			click(profile);
			log.info("profile button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void signout() {
		click(signout);
		log.info("signout button is clicked");
	}

}

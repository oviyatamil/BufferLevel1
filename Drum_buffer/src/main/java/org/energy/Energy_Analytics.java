package org.energy;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Energy_Analytics extends BasePage{

	public Energy_Analytics(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[text()='Energy Monitoring']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By consumption = By.xpath("//span[contains(text(),'Consumption')]");
	private By heat = By.xpath("//span[contains(text(),'Heat Map')]");
	private By pareto = By.xpath("//span[contains(text(),'Pareto Analysis')]");	
	private By equip = By.xpath("(//mat-select[@role='combobox'])[1]/ancestor::div[1]/descendant::div[4]");
	private By bar = By.xpath("(//*[local-name()='g' and contains(@class,'manager-anchor-group')])[1]/*[local-name()='g'][3]/*[local-name()='rect']");
	private By map = By.xpath("//*[local-name()='g' and contains(@class,'plot-group')]/*[local-name()='rect']");
	private By floor = By.xpath("(//*[local-name()='g' and contains(@class,'manager-anchor-group')])[2]/*[local-name()='g'][3]/*[local-name()='rect']");
	private By pie1 = By.xpath("(//*[local-name()='g' and contains(@class,'pie-label')])[1]/*[local-name()='g']/*");
	private By pie2 = By.xpath("(//*[local-name()='g' and contains(@class,'pie-label')])[2]/*[local-name()='g']/*");
	private By charts = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[1]/*[local-name()='text']");
	private By chart = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[2]/*[local-name()='text']");
	private By chartss = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[3]/*[local-name()='text']");
	private By chartss2 = By.xpath("(//*[local-name()='g' and contains(@class,'messageGroup')])[4]/*[local-name()='text']");
	private By parchar1 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*");
	private By parchar2 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[5]/*");
	private By back = By.xpath("//span[text()='Back']");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	private By txt2 = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::span[2]");
	private By slider = By.xpath("(//*[local-name()='g' and contains(@class,'slider')])[1]/*[3]");
	private By catlist = By.xpath("//span[text()='Select Category']/ancestor::div[1]/mat-option");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("//span[text()='Select Site']/ancestor::div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By legend = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[2]/*[local-name()='g']/*[local-name()='rect']");
	private By legend2 = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[4]/*[local-name()='g']/*[local-name()='rect']");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");	
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");
	private By table = By.xpath("//table/tbody/tr/td[2]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(energy, 20);
			click(energy);
			System.out.println("Energy monitoring option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/Home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Energy monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void analytic() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(consumption, 20);
			click(consumption);
			System.out.println("Consumption option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/consumtion";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Analytics -> consumption page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dd() {
		try {
			Actions a = new Actions(driver);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + s + "')]/parent::button"));
			mon.click();
			click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m = split3[1];

			int n = (Integer.parseInt(m)) - 1;

			WebElement end = driver	.findElement(By.xpath("//div[contains(text(),'" + n + "')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			click(equip);
			List<WebElement> l = findWebElements(ddlist);
			for(int i=1;i<l.size();i++) {
				if (i>1) {
					Thread.sleep(500);
					click(equip);
				}
					l.get(i).click();				
				click(apply);
				Thread.sleep(2000);
				if (findWebElement(bar).isDisplayed()) {					
					System.out.println("Category wise energy consumption Chart is displayed for "+ gettext(txt));					
				} else {
					log.info("Category wise energy consumption Chart is not displayed for"+ gettext(txt));
				}
				Thread.sleep(1000);
				if (findWebElement(floor).isDisplayed()) {					
					System.out.println("Floor wise energy consumption Chart is displayed for "+ gettext(txt));				
				} else {
					log.info("Floor wise energy consumption Chart is not displayed for"+ gettext(txt));
				}
				Thread.sleep(2000);
				if(findWebElement(chartss).getText().contains("No data to display")) {
					log.info("No chart displayed for category wise consumption pie chart for "+ gettext(txt));
				}
					else if (findWebElement(pie1).isDisplayed()) {
					System.out.println("Category wise consumption pie chart is displayed for "+ gettext(txt));
					Thread.sleep(1000);
					List<WebElement> p1 = findWebElements(pie1);
					for(WebElement y: p1) {
						a.moveToElement(y).perform();
					}
					System.out.println("Mouseover is working properly in category wise consumption chart");
				} else {
					log.info("Cataegory wise consumption is not displayed for"+ gettext(txt));
				}
				if(findWebElement(chartss2).getText().contains("No data to display")) {
					log.info("No chart displayed for floor wise consumption pie chart for "+ gettext(txt));
				}
				else if (findWebElement(pie2).isDisplayed()) {
				System.out.println("Floor wise consumption pie chart is displayed for "+ gettext(txt));
				Thread.sleep(1000);
				List<WebElement> p2 = findWebElements(pie2);
				for(WebElement y: p2) {
					a.moveToElement(y).perform();
				}
				System.out.println("Mouseover is working properly in floor wise consumption chart");
			} else {
				log.info("Floor wise consumption is not displayed for"+ gettext(txt));
			}
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(false);", findWebElement(export));
		}						
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void chart() {
		try {
			if (findWebElement(bar).isDisplayed()) {
//				click(bar);
//				Thread.sleep(1000);
//				click(back);
				System.out.println("Chart navigates to another chart when particular catagory is clicked");			
			}
			Thread.sleep(1000);
			if (findWebElement(floor).isDisplayed()) {
//				click(floor);
//				Thread.sleep(1000);
//				click(back);
				System.out.println("Chart navigates to another chart when particular floor is clicked");			
			}
			Thread.sleep(500);
			if(findWebElement(legend).isDisplayed()) {
			List<WebElement> leg = findWebElements(legend);
			for (WebElement x : leg) {
				x.click();
				Thread.sleep(100);
			}
			System.out.println("Legend is working properly in category wise energy consumption");
			}
			if(findWebElement(legend2).isDisplayed()) {
			List<WebElement> leg2 = findWebElements(legend2);
			for (WebElement x : leg2) {
				x.click();
				Thread.sleep(100);
			}
			System.out.println("Legend is working properly in floor wise energy consumption");
			}
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(false);", findWebElement(apply));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void heatmaphome() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(heat, 20);
			click(heat);
			System.out.println("Heatmap option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/consumption-heat-map";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for anlytics heatmap  page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void heatmap() {
		try {
			Thread.sleep(2000);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);			
			calendar(calendar, yeardd, year, startdate);
			Thread.sleep(1000);
			click(equip);			
			List<WebElement> sites = findWebElements(ddlist);
			for (int i = 1; i < sites.size(); i++) {
				if (i>1) {
					click(equip);
				}
					sites.get(i).click();
					click(apply);
				click(dd);
				List<WebElement> list = findWebElements(catlist);
				for (int j = 1; j < list.size(); j++) {
					Thread.sleep(1000);
					if (j>1) {
						click(dd);
					} 
					Thread.sleep(500);
						list.get(j).click();
					click(apply);
					Thread.sleep(2000);
					if(findWebElement(charts).getText().contains("No data to display")) {
						log.info("No data to display is shown for "+ gettext(txt));
					}
					else if (findWebElement(charts).isDisplayed()!=true) {
						log.info("No heatmap is displayed for "+gettext(txt)+" -- "+gettext(txt2));						
					} else {						
						System.out.println("heatmap is displayed");				
					}
				
			}
			Thread.sleep(500);
			}
			if(findWebElement(charts).getText().contains("No data to display")) {
				System.out.println("------");
			}
			else if (findWebElement(map).isDisplayed()!=true) {
				System.out.println("------");						
			}else {
				draganddrop(slider);
				System.out.println("Slider is working properly");
			}
			
			
			Thread.sleep(1000);
			
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void paret() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(pareto, 20);
			click(pareto);
			System.out.println("Pareto analysis option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/energy/pareto-analysis";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Pareto analysis page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void paretchart() {
		try {
			Actions a = new Actions(driver);
			Thread.sleep(2000);
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
			System.out.println("Current timing is " + data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + s + "')]/parent::button"));
			mon.click();
			click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m = split3[1];
			int n = (Integer.parseInt(m)) - 1;
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'" + n + "')]/parent::button"));
			end.click();
			Thread.sleep(1000);
			click(equip);
			List<WebElement> sites = findWebElements(ddlist);
			for (int i = 1; i < sites.size(); i++) {
				if (i>1) {
					click(equip);
				} 
				sites.get(i).click();
				
				click(apply);
				Thread.sleep(2000);
				if(findWebElement(charts).getText().contains("No data to display")) {
					log.info("No datas displayed");
				}
				else if(findWebElement(parchar1).isDisplayed()) {
					System.out.println("ParetoChart for category wise is displayed for "+gettext(txt));
					List<WebElement> par1 = findWebElements(parchar1);
					for(WebElement y: par1) {
						a.moveToElement(y).perform();
					}
					System.out.println("Datas displayed in ParetoChart for category wise when mouseover action is performed");
				} else {
					log.info("ParetoChart for category wise is not displayed for "+gettext(txt));					
				}
				
				Thread.sleep(500);
				if(findWebElement(chart).getText().contains("No data to display")) {
					log.info("No datas displayed");
				}
				else if (findWebElement(parchar2).isDisplayed()) {
					System.out.println("ParetoChart for floor wise is displayed for "+gettext(txt));
					List<WebElement> par2 = findWebElements(parchar2);
					for(WebElement y: par2) {
						a.moveToElement(y).perform();
					}
					System.out.println("Datas displayed in ParetoChart for floor wise when mouseover action is performed");
				} else {
					log.info("ParetoChart for floor wise is not displayed for "+gettext(txt));					
				}
				
				if(findWebElement(table).isDisplayed()) {
					System.out.println("Location wise consumption table is displayed");				
				}else {
					log.info("Location wise consumption table is not displayed/no data is displayed");	
				}
			}
			
			Thread.sleep(500);

		} catch (NumberFormatException | InterruptedException e) {
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

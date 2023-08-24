package org.Dialysis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class Analytics extends BasePage{

	public Analytics(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By dial = By.xpath("//div[text()='Dialysis Monitoring']");
	private By analytics = By.xpath("//span[contains(text(),'Analytics')]");
	private By dialysis = By.xpath("//span[contains(text(),'Dialysis Trend')]");
	private By heat = By.xpath("//span[contains(text(),'Heat Map')]");
	private By heatmap1 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]");
	private By heatmap2 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[3]");
	private By heatmap3 = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[5]");
	private By diasum = By.xpath("//span[contains(text(),'Dialysis Summary')]");
	private By slider = By.xpath("(//*[local-name()='g' and contains(@class,'slider')])[1]/*[3]");
	private By dd = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	private By ddlist = By.xpath("(//div[@role='listbox'])[1]/ancestor::div[1]/div[1]/mat-option");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By legendrun = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[2]/*[local-name()='g']/*[local-name()='rect']");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[1]");
	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 1 ']/parent::button");		
	private By legenddia = By.xpath("(//*[local-name()='g' and contains(@class,'legend')])[4]/*[local-name()='g']/*[local-name()='rect']");	
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By export = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By jpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By export2 = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[2]/*[local-name()='rect'][2]");
	private By jpg2 = By.xpath("(//span[text()='Export As JPG'])[2]");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By charts = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[1]/*[local-name()='g']/*[2]/*[local-name()='text']");
	private By charts2 = By.xpath("(//*[local-name()='g' and contains(@class,'plots')])[2]");

	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(dial, 20);
			click(dial);
			System.out.println("Dialysis monitoring option is clicked");
			Thread.sleep(2000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Home";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			System.out.println("Assert verification is done for Dialysis monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void analytic() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(dialysis, 20);
			click(dialysis);
			System.out.println("Dialysis trend option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Trend";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for analytics trend page page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			Thread.sleep(1000);
			click(dd);
			List<WebElement> list = findWebElements(ddlist);
			list.get(0).click();
			String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());	
			System.out.println("Current timing is "+data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'"+s+"')]/parent::button"));
			mon.click();	
			click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m =split3[1];			
			int n = (Integer.parseInt(m))-1;	
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'"+n+"')]/parent::button"));
			end.click();
			click(apply);
			Thread.sleep(3000);
			if(findWebElement(charts).isDisplayed()!=true) {
				log.info("Total run hour chart doesn't displayed");
			}else {
				System.out.println("Total run hour chart displayed");
			}
			if(findWebElement(charts2).isDisplayed()!=true) {
				log.info("Total number of dialysis chart doesn't displayed");
			}else {
				System.out.println("Total number of dialysis chart displayed");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void chart() {
		try {
			Thread.sleep(500);
			click(export);
			click(jpg);
			List<WebElement> leg = findWebElements(legendrun);
			for(WebElement x: leg) {
				x.click();
				Thread.sleep(100);
			}
			System.out.println("Legend is working in Total run hour chart");
			Thread.sleep(500);
			click(export2);
			click(jpg2);
			List<WebElement> dia = findWebElements(legenddia);
			for(WebElement x: dia) {
				x.click();
				Thread.sleep(100);
			}
			System.out.println("Legend is working in Total number of dialysis chart");
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
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/HeatMap";
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
			System.out.println("Current timing is "+data);
			String[] split = data.split(" ");
			String s = split[0].toUpperCase();
			click(calendar);
			click(yeardd);
			click(year);
			WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'"+s+"')]/parent::button"));
			mon.click();	
			click(startdate);
			String[] split2 = data.split(",");
			String[] split3 = split2[0].split(" ");
			String m =split3[1];
			int n = (Integer.parseInt(m))-1;
			WebElement end = driver.findElement(By.xpath("//div[contains(text(),'"+n+"')]/parent::button"));
			end.click();
			click(apply);
			Thread.sleep(1000);
			if(findWebElement(heatmap1).isDisplayed()!=true) {
				log.info("Heatmap doesn't displayed");
			}else {
				System.out.println("Heatmap displayed");
			}
			click(pdf);		
			System.out.println("Pdf is exported");
			click(export);			
			click(jpg);	
			System.out.println("Chart is Exported");
			draganddrop(slider);
			System.out.println("Slider is working properly");
			Thread.sleep(2000);
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
	public void diasumhome() {
		try {
			waittobeclickable(analytics, 20);
			click(analytics);
			System.out.println("analytics menu is clicked");
			waittobeclickable(diasum, 20);
			click(diasum);
			System.out.println("Dialysis summary option is clicked");
			Thread.sleep(1000);
//			String ExpectedURL = "https://portal.careworx.in/#/dialysis/Summary";
//			String ActualURL = getCurrentURL();
//			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for dialysis summary page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void map() {
		try {
			Thread.sleep(500);
			if(findWebElement(heatmap1).isDisplayed()!=true) {
				log.info("Dialysis Heatmap not displayed");
			}else {
				System.out.println("Dialysis heatmap displayed");
			}
			if(findWebElement(heatmap2).isDisplayed()!=true) {
				log.info("Dialysis machine percentages chart not displayed");
			}else {
				System.out.println("Dialysis machine percentages chart  displayed");
			}
			if(findWebElement(heatmap3).isDisplayed()!=true) {
				log.info("Dialysis machine FTM AND FTD chart doesn't displayed");
			}else {
				System.out.println("Dialysis machine FTM AND FTD chart displayed");
			}
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



package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import com.BasePage.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[text()='OEE Monitoring']");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By sitedd = By.xpath("//div[@class='cursor-pointer']/button");
	private By oeepercent = By.xpath("//div[text()='OEE for last 30 days ']/following::mat-icon[1]/parent::div/div");
	private By availability = By.xpath("//div[text()='OEE for last 30 days ']/following::mat-icon[2]/parent::div/div");
	private By performance = By.xpath("//div[text()='OEE for last 30 days ']/following::mat-icon[3]/parent::div/div");
	private By quality = By.xpath("//div[text()='OEE for last 30 days ']/following::mat-icon[4]/parent::div/div");
	private By plot = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*");
	private By mouse = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[1]/*[1]");
	private By slide = By.xpath("(//*[local-name()='g' and contains(@class,'fc-gl-slider')])[1]/*[local-name()='circle'][3]");
	private By machlist = By.xpath("(//*[local-name()='g' and contains(@class,'dataset-Label-group')])[1]/*[local-name()='g']/*");
	private By percent = By.xpath("(//*[local-name()='g' and contains(@class,'fusioncharts-datalabels')])[4]/*");
	private By ftm = By.xpath("(//*[local-name()='g'])[229]/*[local-name()='path']");
	private By ftmchart = By.xpath("(//*[local-name()='g' and contains(@class,'plot-group')])[5]/*");
	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']");
	private By heatmap = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[1]/*[local-name()='rect'][2]");
	private By heatjpg = By.xpath("(//span[text()='Export As JPG'])[1]");
	private By machineexport = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[2]/*[local-name()='rect'][2]");
	private By ftmjpg = By.xpath("(//span[text()='Export As JPG'])[3]");
	private By machjpg = By.xpath("(//span[text()='Export As JPG'])[2]");
	private By ftmexport = By.xpath("(//*[local-name()='g' and @stroke-linecap='round'])[3]/*[local-name()='rect'][2]");
	private By legends = By.xpath("(//*[local-name()='g'])[272]/*[local-name()='rect']");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void oee() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(Oee, 20);
			click(Oee);
			System.out.println("Oee option is clicked");
			Thread.sleep(2000);
			String ExpectedURL = "https://portal.drumbuffer.io/#/oee/home";
			String ActualURL = getCurrentURL();
			assertEquals(ExpectedURL, ActualURL);
			log.info("Assert verification is done for Oee home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void displaycards() {
		try {
			Thread.sleep(3000);
			if(findWebElement(plot).isDisplayed()) {
				System.out.println("OEE heatmap for last 30 days is displayed");
			}else {
				log.info("OEE heatmap for last 30 days is not displayed");
			}
			if(gettext(oeepercent).equals("0%")){
				log.info("Oee percentage shows 0% for last 30 days");
			}else {
			System.out.println("Last 30 days OEE percentage is "+gettext(oeepercent));
			}
			if(gettext(availability).equals("0%")){
				log.info("Availability percentage shows 0% for last 30 days");
			}else {
				System.out.println("Last 30 days Availability percentage is "+gettext(availability));
			}
			if(gettext(performance).equals("0%")){
				log.info("Performance percentage shows 0% for last 30 days");
			}else {
				System.out.println("Last 30 days Performance percentage is "+gettext(performance));
			}
			if(gettext(quality).equals("0%")){
				log.info("Quality percentage shows 0% for last 30 days");
			}else {
				System.out.println("Last 30 days Quality percentage is "+gettext(quality));
			}		
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Last 30 days OEE,Availability,Performance and Quality percentage is displayed");
	}
	public void mouseover() {
		try {
			Thread.sleep(3000);
			Actions(mouse);
			System.out.println("Mouse over in chart is working");
			click(pdf);
			System.out.println("heatmap is exported");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void slider() {
		try {
			Thread.sleep(1000);
			draganddrop(slide);
			System.out.println("slider is working properly");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void graph() {
		try {
			List<WebElement> list = findWebElements(machlist);
			List<String> l = new LinkedList<>();
			for(WebElement x:list) {
				String text = x.getText();
				l.add(text);
				
			}
			System.out.println("Machines list is "+l);
			if(findWebElement(percent).isDisplayed()) {
			List<WebElement> list2 = findWebElements(percent);
			List<String> l2 = new LinkedList<>();
			for(WebElement x2:list2) {
				String text2 = x2.getText();
				l2.add(text2);
				
			}
			System.out.println("OEE percentages are "+l2);
			}else {
				log.info("Oee of machines chart doesn't displayed");
			}
			Thread.sleep(1000);
			click(machineexport);
			click(machjpg);
			System.out.println("OEE of machines chart is exported as jpg");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void Ftm() {
		try {
			Thread.sleep(1000);
			if(findWebElement(ftmchart).isDisplayed()) {
				System.out.println("FTM chart is displayed");
			}else {
				log.info("FTM chart is not displayed");
			}
			List<WebElement> elements = findWebElements(ftm);
			Actions a = new Actions(driver);
			for(int i=0;i<elements.size();i++) {
				a.moveToElement(elements.get(i));
			}
			Thread.sleep(1000);
			click(ftmexport);
			click(ftmjpg);
			System.out.println("FTM and FTD analysis chart is exported as jpg");
			List<WebElement> list = findWebElements(legends);
			for(WebElement x2:list) {
				x2.click();			
			}
			log.info("Legends working properly");
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


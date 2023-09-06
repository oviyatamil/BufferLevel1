package com.Pages;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BasePage.BasePage;

public class Home_Page extends BasePage{
	public Home_Page(WebDriver driver) {
		super(driver);
		
	}
	private By toggle = By.xpath("//span[text()=' Master ']/following::button[1]/span[1]/mat-icon");
	private By help = By.xpath("//span[text()=' Master ']/following::button[2]/span[1]/mat-icon");
	private By profileicon = By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon");
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By platform = By.xpath("//div[text()='Platform']");
	private By arrow = By.xpath("//div[text()='Drumbuffer']/following::span[1]/mat-icon");
	private By guides = By.xpath("//span[text()='Check guides']/parent::a");
	private By contact = By.xpath("//span[text()='Contact us']/parent::a");
	private By name = By.xpath("//input[@formcontrolname='name']");
	private By subject = By.xpath("//input[@formcontrolname='subject']");
	private By msg = By.xpath("//textarea[@formcontrolname='message']");
	private By file = By.xpath("//input[@type='file']");
	private By back = By.xpath("//span[text()='Back to Help Center']/parent::span/mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By search = By.xpath("//input[contains(@placeholder,'Enter')]");
	private By profile = By.xpath("//span[text()='Profile']/parent::button/mat-icon");
	private By edit = By.xpath("//p[text()='Edit Profile']/ancestor::span/mat-icon");
	private By status = By.xpath("//span[text()='Status']");
	private By away = By.xpath("//span[text()='Away']");
	private By user = By.xpath("//input[@formcontrolname='userName']");
	private By phno = By.xpath("//input[@formcontrolname='mobileNumber']");
	private By update = By.xpath("//span[contains(text(),'pdate')]");
	private By aws = By.xpath("//div[text()='Cost across AWS']/following::div[1]/div");
	private By azure = By.xpath("//div[text()='Azure']/following::div[1]/div");
	private By cloud = By.xpath("//div[text()=' Google Cloud']/following::div[1]/div");
	private By close = By.xpath("//mat-icon[text()='cancel']");
	private By azurecount = By.xpath("(//div[contains(text(),'Azure')])[1]/following::div[1]/div");
	private By awscount = By.xpath("(//div[contains(text(),'AWS')])[1]/following::div[1]/div");
	private By cloudcount = By.xpath("(//div[contains(text(),'Google Cloud')])[1]/following::div[1]/div");
	private By azurecost = By.xpath("(//div[contains(text(),'Azure')])[2]/following::div[1]/div");
	private By awscost = By.xpath("(//div[contains(text(),'AWS')])[2]/following::div[1]/div");
	private By cloudcost= By.xpath("(//div[contains(text(),'Google Cloud')])[2]/following::div[1]/div");
	private By premise = By.xpath("(//div[contains(text(),'Premise Instances')])[1]/following::div[1]/div");
	private By custcount = By.xpath("(//div[contains(text(),'Customers')])[1]/following::div[1]/div");
	private By partcount = By.xpath("(//div[contains(text(),'Partners')])[1]/following::div[1]/div");
	private By userscount = By.xpath("(//div[contains(text(),'Users')])[1]/following::div[1]/div");
	private By jobcount = By.xpath("(//div[contains(text(),'Jobs')])[1]/following::div[1]/div");
	private By reset = By.xpath("//button[@mattooltip='Click to Reset']/span[1]/mat-icon");
	private By smartdrum = By.xpath("//mat-icon[@mattooltip='Click to Filter']");
	
	
	
	public void ninedots() {
		try {
			Thread.sleep(500);
			click(ninedots);
			log.info("ninedots button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void ninedotsarrow() {
		click(arrow);
		log.info("ninedotsarrow button is clicked");
	}
	public void ninedotsplatform() {
		click(platform);
		log.info("ninedotsplatform button is clicked");
	}
	public void smartdrum() {
		click(smartdrum);
		log.info("smart drum is clicked");
	}
	public void count() {
		try {
			String azcou = getattribute(azurecount);
			System.out.println("Azure count is "+ azcou);
			log.info("Got Azure count");
			String awcou = getattribute(awscount);
			System.out.println("Aws count is "+ awcou);
			log.info("Got Aws count");
			String clcou = getattribute(cloudcount);
			System.out.println("cloud count is "+ clcou);
			log.info("Got Google cloud count");
			String premcou = getattribute(premise);
			System.out.println("On premise instances count is "+ premcou);
			Thread.sleep(1000);
			log.info("Got On premise instances count");
			String azcos = getattribute(azurecost);
			System.out.println("Azure cost is "+ azcos);
			log.info("Got Azure cost");
			String awcos = getattribute(awscost);
			System.out.println("Aws cost is "+ awcos);
			log.info("Got Aws cost");
			String clcos = getattribute(cloudcost);
			System.out.println("Cloud cost is "+ clcos);
			log.info("Got Google cloud cost");
			Thread.sleep(1000);
			String partcou = getattribute(partcount);
			System.out.println("Partner count is "+ partcou);
			log.info("Got Partner count");
			String uscou = getattribute(userscount);
			System.out.println("User count is "+ uscou);
			log.info("Got User count");
			String custcou = getattribute(custcount);
			System.out.println("Customer count is "+ custcou);
			log.info("Got Customer count");
			String jcount = getattribute(jobcount);
			System.out.println("Job count is "+ jcount);
			log.info("Got Job count");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	public void toggle() {
		try {
			Thread.sleep(1000);
			click(toggle);
			log.info("toggle button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void help() {
		try {
			click(help);
			log.info("help button is clicked");
			Thread.sleep(2000);
			String expectedurl = "http://20.204.188.25/#/platform/help-center";
			String url = getCurrentURL();
			assertEquals(expectedurl,url);
			log.info("Assert verification for help is done");
			click(search);
			EnterText(search, "ECG");
			log.info("search text is entered");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void cost() {
		try {
			click(aws);
			log.info("aws dialog box appears");
			click(close);
			click(azure);
			log.info("azure dialog box appears");
			click(close);
			waittobeclickable(cloud, 10);
			click(cloud);
			log.info("cloud dialog box appears");
			click(close);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void contact() {
		try {
			click(contact);
			log.info("contact us is clicked");
			Thread.sleep(2000);
			String expectedurl = "http://20.204.188.25/#/platform/help-center/support";
			String url =getCurrentURL();
			assertEquals(expectedurl,url);
			log.info("Assert verification for contact us is done");
			EnterText(name, "admin");
			log.info("name is entered");
			EnterText(subject, "bug");
			log.info("Subject is entered");
			EnterText(msg, "Kindly solve the issue");
			log.info("Message is entered");
			EnterText(file, "C:\\Users\\oviya\\Downloads\\OEEMaintanance (1).pdf");
			log.info("File is attached");
			Thread.sleep(1000);
			click(reset);
			log.info("Reset option is clicked");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void guide() {
		try {
			
			click(guides);
			log.info("check guide is clicked");
			Thread.sleep(2000);
			String expectedurl = "http://20.204.188.25/#/platform/help-center/guides";
			String url = getCurrentURL();
			assertEquals(expectedurl,url);
			log.info("Assert verification for guide is done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void profile() {
		try {
			Thread.sleep(2000);
			click(profile);
			log.info("profile button is clicked");
			click(edit);
			log.info("edit button is clicked");
			clear(user);
			EnterText(user, "Veera Pandian");
			EnterText(phno, "9476543280");
			click(update);
			log.info("update button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void status() {
		try {
			click(status);
			log.info("status option is clicked");
			Thread.sleep(500);
			click(away);
			log.info("away option is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void back() {
		
		click(back);
		log.info("back arrow is clicked");
	}
	public void signout() {
		click(signout);
		log.info("signout button is clicked");
	}
	public void profileicon() {
		try {
			Thread.sleep(2000);
			click(profileicon);
			log.info("profile icon button is clicked");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package org.OeeMonitoring;

import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.BasePage.BasePage;
import com.BasePage.ReportSetup;
import com.aventstack.extentreports.Status;

public class Monkey extends BasePage {

	public Monkey(WebDriver driver) {
		super(driver);
	}

	private By Username = By.xpath("//*[@id='email']");
	private By Password = By.xpath("//*[@type='password']");
	private By Login = By.xpath("//span[contains(text(),'Sign in')]");
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button/img");
	private By superadmin = By.xpath("//div[contains(text(),'Super Admin')]/parent::div/button");
	private By permission = By.xpath("//span[contains(text(),'Permission')]");
	private By assets = By.xpath("//div[contains(text(),'Assets')]");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	private By menu = By.xpath("//div[contains(@class,'horizontal-navigation-wrapper')]/descendant::mat-icon/following::div[2]/span");

	public void Login() {
		try {
			Thread.sleep(2000);
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://portal.drumbuffer.io/#/admin/login");
			String parent = driver.getWindowHandle();

			Set<String> s = driver.getWindowHandles();
			List<String> l = new LinkedList<>();
			l.addAll(s);
			int i = driver.getWindowHandles().size();
			if (i > 1) {
				driver.switchTo().window(l.get(i - 1));

			}
			waittobeclickable(profile, 20);
			click(profile);
			System.out.println("Profile button is clicked");
			waittobeclickable(signout, 20);
			click(signout);
			System.out.println("Signout option is clicked");
			Thread.sleep(7000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			EnterText(Username, "admin@drumbuffer.com");
			System.out.println("Entered the username");
			Thread.sleep(1000);
			EnterText(Password, "Admin@123");
			System.out.println("Entered the Password");
			Thread.sleep(10000);
			click(Login);
			System.out.println("Clicked on the Login");
			Thread.sleep(3000);

			click(ninedots);
			Thread.sleep(1000);
			click(superadmin);
			Thread.sleep(1000);
			click(permission);
			Thread.sleep(1000);
			driver.switchTo().window(l.get(0));
			Thread.sleep(500);
			click(ninedots);
			click(assets);
			if(findWebElement(menu).getText().contains("Equipment")) {
				System.out.println("No issues");
			}else {
				log.info("Cant navigate to asset screen");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

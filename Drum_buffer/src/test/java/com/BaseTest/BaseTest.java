package com.BaseTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.BasePage.BasePage;
import com.BasePage.ReportSetup;

import com.Pages.Pages_TC_001;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	protected BasePage basepage;
	
	@BeforeSuite
	public void BrowserSetup() {
		ReportSetup.intialize();
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
}
	@BeforeClass
	public void onetimelogin() {
		basepage = new BasePage(driver);
		basepage.setdriver(driver);
		ReportSetup.test =ReportSetup.report.createTest("Before class Executed");
//		driver.get("http://20.204.188.25/#/sign-in");
//		ReportSetup.test.log(Status.INFO,"Entered the URL");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Pages_TC_001 loged =new Pages_TC_001(driver);
		loged.Login17();
//		LoginPage l = new LoginPage(driver);
//		l.Login();
	}

	@AfterMethod()
	public void afterMerhod(ITestResult tr) {
		ReportSetup.result(tr,driver);
       BasePage.screenshot(tr);
	}
	
	@AfterClass
	public void afterclass() {
		//ReportSetup.result(tr);
		try {
			Thread.sleep(5000);
			driver.manage().deleteAllCookies();
			Thread.sleep(5000);
//			driver.navigate().to("https://devdrumbufferv5.azurewebsites.net/#/sign-in");
//			Thread.sleep(5000);
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void teardown() {
		driver.quit();
		ReportSetup.flush();
	}

}

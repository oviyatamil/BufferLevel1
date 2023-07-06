package com.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Pages_TC_001;

public class TC_001 extends BaseTest{

 Pages_TC_001 tc_001;
	@Test(dataProvider = "login")
	protected void tc_001(String user,String pwd) {
		
		ReportSetup.test =ReportSetup.report.createTest("login");
	//	ReportSetup.test.log(Status.INFO, "Started the test XXXXX: "+ ReportSetup.test.getStatus());
		
		ReportSetup.test.assignCategory("P1");
		//tc_001 = new Pages_TC_001(driver);
		WebElement us = driver.findElement(By.xpath("//*[@id='email']"));
		try {
			us.clear();
			us.sendKeys(user);
			Thread.sleep(2000);
			WebElement pw = driver.findElement(By.xpath("//*[@type='password']"));
			pw.sendKeys(pwd);
			Thread.sleep(50000);
			WebElement log = driver.findElement(By.xpath("//button[@type='submit']"));
			log.click();
			Thread.sleep(3000);
			
			}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@DataProvider(name="login")
	private Object[][] data(){
		Object[][] a = new Object[][] {
			{"qwerty@drum.com","Admin@123"},
			{"veerapandian.r@drumbuffer.com","admin@123"},
			{"qwerty@drum.com","admin123"},
			{"veerapandian.r@drumbuffer.com","Admin@123"},
		};
		return a;
		}

}

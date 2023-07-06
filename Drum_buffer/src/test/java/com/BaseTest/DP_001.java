package com.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.Pages.Pages_TC_001;

public class DP_001 extends BaseTest{
	Pages_TC_001 tc_001;
	@Test(dataProvider = "login",priority=1)
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
			Thread.sleep(2000);
			WebElement log = driver.findElement(By.xpath("//button[@type='submit']"));
			log.click();
			Thread.sleep(3000);
			
			
			}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		@Test(dataProvider = "BV",priority=2)
//		protected void tc_001(String bname, String desc) {
//			WebElement product =driver.findElement(By.xpath("//span[text()=' Product ']"));
//			WebElement businessvertical =driver.findElement(By.xpath("//span[text()=' Business Vertical ']"));
//			
//			WebElement add=driver.findElement(By.xpath("//span[text()='Add']"));
//			WebElement businessname=driver.findElement( By.xpath("//input[@id='mat-input-3']"));
//			WebElement save=driver.findElement(By.xpath("//span[text()=' Save ']"));
//			WebElement description= driver.findElement(By.xpath("//input[@id='mat-input-4']"));
//			WebElement profile = driver.findElement(By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon"));
//			WebElement signout = driver.findElement(By.xpath("//span[text()='Sign out']"));
//			product.click();
//			businessvertical.click();
//			add.click();
//			businessname.clear();
//			businessname.sendKeys(bname);
//			description.clear();
//			description.sendKeys(desc);
//			save.click();
//			profile.click();
//			signout.click();
//		}
		
		
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
//	@DataProvider(name="BV")
//	private Object[][] data2(){
//		Object[][] a = new Object[][] {
//			{"DELL","AS"},
//			{"@QW","techno"},
//			{"@qw","AS"},
//			{"DELL","INDUSTRY"},
//			
//		};
//		return a;
//		}

}



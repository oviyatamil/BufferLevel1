package com.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.BasePage;
import com.BasePage.ReportSetup;
import com.Pages.Business_vertical;

public class DP_002 extends BaseTest {
	
 Business_vertical tc_002;
 BasePage b ;	
	
	@Test(dataProvider = "BV")
	protected void tc_002(String bname,String desc){
		ReportSetup.test =ReportSetup.report.createTest("Business vertical data propabilities");
		
			
			ReportSetup.test.assignCategory("P1");
			
			
			
			try {
				WebElement product =driver.findElement(By.xpath("//span[text()=' Product ']"));
				product.click();
				WebElement businessvertical =driver.findElement(By.xpath("//span[text()=' Business Vertical ']"));
				businessvertical.click();
				WebElement add=driver.findElement(By.xpath("//span[text()='Add']"));
				add.click();
				WebElement businessname=driver.findElement( By.xpath("//input[@id='mat-input-3']"));
				businessname.clear();
				businessname.sendKeys(bname);
				
				WebElement description= driver.findElement(By.xpath("//input[@id='mat-input-4']"));
				description.clear();
				description.sendKeys(desc);
				WebElement save=driver.findElement(By.xpath("//span[text()=' Save ']"));
				save.click();
				WebElement profile = driver.findElement(By.xpath("//span[text()=' Master ']/following::button[3]/span[1]/span/mat-icon"));
				profile.click();
				WebElement signout = driver.findElement(By.xpath("//span[text()='Sign out']"));
				signout.click();
				Thread.sleep(3000);
				
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
	
	
	
	
	

@DataProvider(name="BV")
private Object[][] data(){
	Object[][] a = new Object[][] {
		{"DELL","AS"},
		{"@QW","techno"},
		{"@qw","AS"},
		{"DELL","INDUSTRY"},
		
	};
	return a;
	}
}
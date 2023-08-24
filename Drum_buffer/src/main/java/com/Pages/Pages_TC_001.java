package com.Pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BasePage.BasePage;
import com.BasePage.ReportSetup;
import com.aventstack.extentreports.Status;
public class Pages_TC_001 extends BasePage {
  public Pages_TC_001(WebDriver driver) {
		super(driver);
		
	}

	
	private By Username =By.xpath("//*[@id='email']");
	private By Password =By.xpath("//*[@type='password']");
	private By Login =By.xpath("//span[contains(text(),'Sign in')]");
	
	public void Login() {
		
		try {
			driver.get("http://20.204.188.25/#/sign-in");
			ReportSetup.test.log(Status.INFO,"Entered the URL");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			EnterText(Username,"veerapandian.r@drumbuffer.com");		
			System.out.println("Entered the username");
			Thread.sleep(1000);
			EnterText(Password,"Admin@123");
			System.out.println("Entered the Password");
			Thread.sleep(1000);
			click(Login);
			System.out.println("Clicked on the Login");
			Thread.sleep(2000);
		
			String ExpectedURL="http://20.204.188.25/#/platform/home";
   	        String ActualURL=getCurrentURL();
   	        assertEquals(ExpectedURL, ActualURL);
   	       
   	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void Login2() {
		try {
			driver.get("https://portal.careworx.in/#/sign-in");
			ReportSetup.test.log(Status.INFO,"Entered the URL");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			EnterText(Username,"ramkumar.j@kauveryhospital.com");
			System.out.println("Entered the username");
			Thread.sleep(1000);
			EnterText(Password,"Kauvery!@#$120");
			System.out.println("Entered the Password");
			Thread.sleep(2000);
			click(Login);
			System.out.println("Clicked on the Login");
			Thread.sleep(2000);
		
			String ExpectedURL="https://portal.careworx.in/#/superadmin/home";
   	        String ActualURL=getCurrentURL();
   	        assertEquals(ExpectedURL, ActualURL);
   	       
   	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public void Login3() {
		try {
			driver.get("https://portal.drumbuffer.io/#/sign-in");
			ReportSetup.test.log(Status.INFO,"Entered the URL");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
					EnterText(Username,"admin@texelq.com");
					//		EnterText(Username,"admin@indomim.com");
			System.out.println("Entered the username");
			Thread.sleep(1000);
				EnterText(Password,"!@#$Texelq20");
				//	EnterText(Password,"Admin@123");
			System.out.println("Entered the Password");
			Thread.sleep(1000);
			click(Login);
			System.out.println("Clicked on the Login");
			Thread.sleep(3000);
		
			String ExpectedURL="https://portal.drumbuffer.io/#/superadmin/home";
   	        String ActualURL=getCurrentURL();
   	        assertEquals(ExpectedURL, ActualURL);
   	       
   	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	public void Login4() {
		try {
			driver.get("https://portal.drumbuffer.io/#/sign-in");
			ReportSetup.test.log(Status.INFO,"Entered the URL");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			EnterText(Username,"admin@qualitydemo.com");
			System.out.println("Entered the username");
			Thread.sleep(1000);
			EnterText(Password,"Admin@123");
			System.out.println("Entered the Password");
			Thread.sleep(1000);
			click(Login);
			System.out.println("Clicked on the Login");
			Thread.sleep(3000);
		
			String ExpectedURL="https://portal.drumbuffer.io/#/superadmin/home";
   	        String ActualURL=getCurrentURL();
   	        assertEquals(ExpectedURL, ActualURL);
   	       
   	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
public void Login5() {
		
		try {
			driver.get("http://20.204.188.25/#/sign-in");
			ReportSetup.test.log(Status.INFO,"Entered the URL");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			EnterText(Username,"ramkumar.j@kauverhospital.com");		
			System.out.println("Entered the username");
			Thread.sleep(1000);
			EnterText(Password,"Admin@123");
			System.out.println("Entered the Password");
			Thread.sleep(10000);
			click(Login);
			System.out.println("Clicked on the Login");
			Thread.sleep(2000);
		
			String ExpectedURL="http://20.204.188.25/#/admin/login";
   	        String ActualURL=getCurrentURL();
   	        assertEquals(ExpectedURL, ActualURL);
   	       
   	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
public void Login6() {
	try {
		driver.get("http://20.204.188.25/#/sign-in");
		ReportSetup.test.log(Status.INFO,"Entered the URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		EnterText(Username,"superadmin@drumbuffer.com");		
		System.out.println("Entered the username");
		Thread.sleep(1000);
		EnterText(Password,"Admin@123");
		System.out.println("Entered the Password");
		Thread.sleep(10000);
		click(Login);
		System.out.println("Clicked on the Login");
		Thread.sleep(2000);
	
		String ExpectedURL="http://20.204.188.25/#/superadmin/home";
	        String ActualURL=getCurrentURL();
	        assertEquals(ExpectedURL, ActualURL);
	       
	        
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
public void Login7() {
	try {
		driver.get("http://20.204.188.25/#/sign-in");
		ReportSetup.test.log(Status.INFO,"Entered the URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		EnterText(Username,"peter@gmail.com");		
		System.out.println("Entered the username");
		Thread.sleep(1000);
		EnterText(Password,"Admin@123");
		System.out.println("Entered the Password");
		Thread.sleep(10000);
		click(Login);
		System.out.println("Clicked on the Login");
		Thread.sleep(2000);	       	        
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
public void Login8() {
	try {
		driver.get("http://retailworx.azurewebsites.net/#/sign-in");
		ReportSetup.test.log(Status.INFO,"Entered the URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ReportSetup.test.log(Status.INFO,"Waiting For 10 sec");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		EnterText(Username,"jeya@jeyachandran.com");
		System.out.println("Entered the username");
		Thread.sleep(1000);
		EnterText(Password,"Admin@123");
		System.out.println("Entered the Password");
		Thread.sleep(2000);
		click(Login);
		System.out.println("Clicked on the Login");
		Thread.sleep(2000);	       	        
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

	}
	


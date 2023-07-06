package com.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BasePage.BasePage;
public class Pages_TC_001 extends BasePage {
  public Pages_TC_001(WebDriver driver) {
		super(driver);
		
	}

	
	private By Username =By.xpath("//*[@id='email']");
	private By Password =By.xpath("//*[@type='password']");
	private By Login =By.xpath("//button[@type='submit']");
	private By launch = By.xpath("//span[text()='Launch the App']/parent::span");
	
	public void Login() {
		
		try {
			
			EnterText(Username,"veerapandian.r@drumbuffer.com");
			log.info("Entered the username");
			Thread.sleep(1000);
			EnterText(Password,"Admin@123");
			log.info("Entered the Password");
			Thread.sleep(1000);
			click(Login);
			log.info("Clicked on the Login");
			Thread.sleep(3000);
		//	click(launch);
//			String ExpectedURL="http://20.204.188.25/#/platform/home";
//   	        String ActualURL=getCurrentURL();
//   	        assertEquals(ExpectedURL, ActualURL);
   	        takescreenshots("afterlogin");
   	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
//	@DataProvider(name="login")
//	private Object[][] data(){
//		Object[][] a = new Object[][] {
//			{"qwerty@drum.com","Admin@123"},
//			{"veerapandian.r@drumbuffer.com","admin@123"},
//			{"qwerty@drum.com","admin123"},
//			{"veerapandian.r@drumbuffer.com","Admin@123"},
//		};
//		return a;
//		}
	
	}
	


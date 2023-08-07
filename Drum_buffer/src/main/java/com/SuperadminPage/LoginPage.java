package com.SuperadminPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BasePage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By Username =By.xpath("//*[@id='email']");
	private By Password =By.xpath("//*[@type='password']");
	private By Login =By.xpath("//button[@type='submit']");
	
	
public void Login() {
		
		try {
			
			EnterText(Username,"superadmin@drumbuffer.com");
			log.info("Entered the username");
			Thread.sleep(1000);
			EnterText(Password,"Admin@123");
			log.info("Entered the Password");
			Thread.sleep(1000);
			click(Login);
			log.info("Clicked on the Login");
			Thread.sleep(3000);
		      
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}

}

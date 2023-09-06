package org.OeeMonitoring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class LiveMonitoring extends BasePage {

	public LiveMonitoring(WebDriver driver) {
		super(driver);
	}

	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By monitoring = By.xpath("//span[contains(text(),'Monitoring')]");
	private By live = By.xpath("//span[text()=' Live Monitoring ']");
	private By table = By.xpath("//div[@id='element-to-export']/div[4]/div/div[1]/div");
	private By time = By.xpath("//div[@id='element-to-export']/div[4]/div/div[2]/div[1]/span[2]");
	private By oee = By.xpath("//span[text()='Last Telemetry']/parent::div/parent::div/parent::div/div/div[2]/span[2]");
	private By availability = By
			.xpath("//span[text()='Last Telemetry']/parent::div/parent::div/parent::div/div/div[3]/span[2]");
	private By quality = By
			.xpath("//span[text()='Last Telemetry']/parent::div/parent::div/parent::div/div/div[5]/span[2]");
	private By performance = By
			.xpath("//span[text()='Last Telemetry']/parent::div/parent::div/parent::div/div/div[4]/span[2]");
	private By partcount = By
			.xpath("//span[text()='Last Telemetry']/parent::div/parent::div/parent::div/div/div[6]/span[2]");
	private By pgm = By.xpath("//span[text()='Last Telemetry']/parent::div/parent::div/parent::div/div/div[7]/span[2]");
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
			System.out.println("Assert verification is done for Oee home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void livemonitor() {
		try {
			waittobeclickable(monitoring, 10);
			click(monitoring);
			System.out.println("Monitoring button is clicked");
			waittobeclickable(live, 20);
			click(live);
			System.out.println("oee monitor option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Live monitoring page");		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void table() {
		try {
			if(findWebElements(table).size()<=1) {
				log.info("No table displayed");
			}else {					
			List<WebElement> list = findWebElements(table);
			for (int i = 0; i < list.size(); i++) {
				System.out.println("EQUIPMENT IS " + list.get(i).getText());
				List<WebElement> timestamp = findWebElements(time);
				String text = timestamp.get(i).getText();
				String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
				String[] sp = data.split(",");
				if (text.contains(sp[0])) {
					System.out.println("Timestamp in machine is " + timestamp.get(i).getText());
				} else {
					log.info("Timestamp in machine mismatches with actual date for " + list.get(i).getText());
				}
				List<WebElement> oeepercentage = findWebElements(oee);
				System.out.println("Oee percentage is " + oeepercentage.get(i).getText());
				List<WebElement> avail = findWebElements(availability);
				System.out.println("Availability is " + avail.get(i).getText());
				List<WebElement> perf = findWebElements(performance);
				System.out.println("Performance is " + perf.get(i).getText());
				List<WebElement> quali = findWebElements(quality);
				System.out.println("Quality is " + quali.get(i).getText());
				List<WebElement> part = findWebElements(partcount);
				System.out.println("Part number is " + part.get(i).getText());
				List<WebElement> prog = findWebElements(pgm);
				System.out.println("Program is " + prog.get(i).getText());
				System.out.println("*******************");
				Thread.sleep(500);
				if(oeepercentage.get(i).getText().equals("0%")) {
					if(avail.get(i).getText().equals("0%")){
						if(perf.get(i).getText().equals("0")){
							if(part.get(i).getText().equals("0")){
								if(prog.get(i).getText().equals("0")){
									log.info("All datas in equipment is 0% except quality for "+list.get(i).getText());
								}
							}
						}
					}
				}
			}
			}
		} catch (

		InterruptedException e) {
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

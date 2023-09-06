package org.OeeMonitoring;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.BasePage.BasePage;

public class SpindleMonitor extends BasePage{

	public SpindleMonitor(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By monitoring = By.xpath("//span[contains(text(),'Monitoring')]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By spindle = By.xpath("//span[text()=' Spindle Monitoring ']");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[4]");
	private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
	private By export = By.xpath("//*[local-name()='g' and contains(@class,'toolbar-master')]/*[1]/*[2]/*[3]");
	private By jpg = By.xpath("//span[text()='Export As JPG']");
	private By msg = By.xpath("//*[local-name()='g' and contains(@class,'messageGroup')]");
	private By txt = By.xpath("(//mat-select)[2]/descendant::span[2]");
	private By timestamp = By.xpath("//*[local-name()='g' and contains(@class,'range-selector-text')]/*[local-name()='text']");
	private By drag = By.xpath("//*[local-name()='g' and contains(@class,'brush-group')]/*[local-name()='rect'][2]");
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

	public void spindlemonitor() {
		try {
			waittobeclickable(monitoring, 10);
			click(monitoring);
			System.out.println("Monitoring button is clicked");
			waittobeclickable(spindle, 20);
			click(spindle);
			System.out.println("oee monitor option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for spindle monitoring page");			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void chart() {
		try {
			click(equipdd);
			List<WebElement> list = findWebElements(equiplist);
			for(int i=1;i<list.size();i++){
				if(i>1) {
					click(equipdd);
				}
				list.get(i).click();
				Thread.sleep(1000);
				click(apply);
		if(findWebElement(msg).getText().contains("No data")) {
			log.info("No data to display");
		}else {
		WebElement list2 = findWebElement(timestamp);
		System.out.println("Current timing is "+new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date()));
		System.out.println("Timestamp is "+list2.getText());
		String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
		String[] split2 = data.split(",");
		if((list2.getText()).contains(split2[0]))
		{
			System.out.println("Timestamp displayed is correct");
		}else {
			log.info("Timestamp is not correct for "+gettext(txt));
		}
		Thread.sleep(5000);
		
			click(export);
			click(jpg);
			}
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void dd() {
		try {
			Thread.sleep(1000);
			if(findWebElement(msg).getText().contains("No data")) {
				log.info("No charts to perform drag and drop");
			}else {
		//	Actions a = new Actions(driver);
		//	WebElement element = findWebElement(drag);
			draganddrop(drag);
			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void profile() {
		
		waittobeclickable(profile, 10);
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}
}


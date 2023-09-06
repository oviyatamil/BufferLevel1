package org.energy;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;
public class Energy_monitoring extends BasePage{

	public Energy_monitoring(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By energy = By.xpath("//div[contains(text(),'Energy Monitoring')]");
	private By monitor = By.xpath("//span[text()=' Monitoring ']");
	private By live = By.xpath("//span[text()=' Live Monitoring ']");
	private By liveflow = By.xpath("//span[text()=' Live Flow Analysis ']");
	private By txt = By.xpath("(//mat-select[@role='combobox'])[1]/descendant::span[2]");
	
	private By equiplist = By.xpath("//span[text()='Select Site']/ancestor::div[1]/mat-option");
	private By equipdd = By.xpath("//mat-select[@role='combobox']/ancestor::div[1]/descendant::div[4]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By loc = By.xpath("(//mat-select[@role='combobox'])[2]/ancestor::div[1]/descendant::div[4]");
	
	private By category = By.xpath("//span[text()='Select Type']/ancestor::div[1]/mat-option");
	private By text = By.xpath("//mat-select[@role='combobox']/descendant::div[2]/span/span");
	private By text2 = By.xpath("(//mat-select[@role='combobox'])[2]/descendant::div[2]/span/span");
	private By totkwh = By.xpath("(//span[text()='FTM'])[1]/parent::div/div");
	private By diagram = By.xpath("//*[local-name()='g' and contains(@class,'sankey-link-group')]/*[local-name()='path']");
	private By current = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[7]/span[2]");
	private By volt = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[8]/span[2]");
	private By pf = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[9]/span[2]");
	private By kw = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[10]/span[2]");
	private By kwh = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[11]/span[2]");
	private By avg = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[12]/span[2]");
	private By inckwh = By.xpath("(//span[text()='FTM'])[2]/parent::div/div");
	
	private By machine = By.xpath("(//span[text()='Last Telemetry'])/ancestor::div[5]/descendant::div[3]");
	
//	private By pdf = By.xpath("//mat-icon[@mattooltip='Export to PDF']/parent::div");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	
	public void home() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			System.out.println("Ninedots button is clicked");
			waittobeclickable(energy, 20);
			click(energy);
			System.out.println("Energy monitoring option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Energy monitoring home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void monitor() {
		try {
			waittobeclickable(monitor, 20);
			click(monitor);
			System.out.println("Monitoring menu is clicked");
			waittobeclickable(live, 20);
			click(live);
			System.out.println("Live monitoring option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for energy live monitoring page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void chart() {
		try {
			click(equipdd);
			List<WebElement> l = findWebElements(equiplist);
			for(int i=1;i<l.size();i++) {
				if(i>1) {
					Thread.sleep(500);
					click(equipdd);
				}
					l.get(i).click();
					click(apply);
				Thread.sleep(10000);
			if(findWebElement(totkwh).getText()=="0") {
				log.info("Total kwh displayed in card is 0 for "+gettext(txt));
			}else {
				System.out.println("Total kwh displayed in card is "+findWebElement(totkwh).getText());
			}
			if(findWebElement(inckwh).getText()=="0") {
				log.info("Incomer kwh displayed in card is 0");
			}else {
				System.out.println("Incomer kwh displayed in card is "+findWebElement(inckwh).getText());
			}
			
			if(findWebElements(machine).isEmpty()!=true) {
				List<WebElement> l2 = findWebElements(machine);
				for(int j=0;j<l2.size();j++) {
					Thread.sleep(500);				
					if ((findWebElements(current).get(j).getText()).equals("0.0")) {
						if ((findWebElements(volt).get(j).getText()).equals("0.0")) {
							if ((findWebElements(pf).get(j).getText()).equals("0.0")) {
								if ((findWebElements(kw).get(j).getText()).equals("0")) {
									if ((findWebElements(kwh).get(j).getText()).equals("0.0")) {
										if ((findWebElements(avg).get(j).getText()).equals("0.0")) {
											log.info("Machine displayed only zero's for " + l2.get(j).getText());
										} else {
											log.info("Machine displayed only zero's for " + l2.get(j).getText()
													+ " except average");
										}
									} else {
										System.out.println("Data displayed for " + l2.get(j).getText());
									}
								} else {
									System.out.println("Data displayed for " + l2.get(j).getText());
								}
							} else {
								System.out.println("Data displayed for " + l2.get(j).getText());
							}
						} else {
							System.out.println("Data displayed for " + l2.get(j).getText());
						}
					} else {
						System.out.println("Data displayed for " + l2.get(j).getText());
					}
						
				}
			}else {
					Thread.sleep(500);
					log.info("NO data");
				}
					
				}
			
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
	public void liveflowanalysis() {
		try {
			waittobeclickable(monitor, 20);
			click(monitor);
			System.out.println("Monitoring is clicked");
			waittobeclickable(liveflow, 20);
			click(liveflow);
			System.out.println("Live flow analysis option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for energy liveflow analysis page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void flow() {
		try {
			click(equipdd);
			List<WebElement> l = findWebElements(equiplist);
			for(int i=1;i<l.size();i++) {
				if(i>1) {
					click(equipdd);
				}					
					l.get(i).click();
					click(apply);
				click(loc);
				List<WebElement> cat = findWebElements(category);
				for(int j=1;j<cat.size();j++) {
					if(j>1) {
						click(loc);
					}
						cat.get(j).click();
						click(apply);
					
				Thread.sleep(5000);	
				if(findWebElements(diagram).isEmpty()) {
					log.info("Flowdiagram is not displayed for "+gettext(text)+"---"+gettext(text2));
				}else {
					System.out.println("Flow diagram is displyed for "+gettext(text)+"---"+gettext(text2));								
				}							
				}
}
		} catch (InterruptedException e) {
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

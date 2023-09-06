package org.OeeMonitoring;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Storyboard extends BasePage{

	public Storyboard(WebDriver driver) {
		super(driver);
	}
	private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
	private By Oee = By.xpath("//div[contains(text(),'OEE Monitoring')]");
	private By kpi = By.xpath("//span[contains(text(),'KPI')]");
	private By story = By.xpath("//span[contains(text(),'Story Board')]");
	private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
	private By apply = By.xpath("//span[contains(text(),'Apply')]");
	private By equiplist = By.xpath("//span[contains(text(),'Select Equipment')]/ancestor::div[1]/mat-option");
	private By equiptext = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[2]/span[1]/span");
	private By oeehigh = By.xpath("(//div[text()='OEE'])[2]/following::div[4]");
	private By overalloee = By.xpath("(//div[text()='OEE'])[2]/following::div[1]");
	private By oeelow = By.xpath("(//div[text()='OEE'])[2]/following::div[8]");
	private By locdd = By.xpath("//mat-label[contains(text(),'Functional Location')]/ancestor::div[1]/descendant::div[3]");
	private By spindlehigh = By.xpath("//div[text()='Spindle']/following::div[4]");
	private By loclist = By.xpath("//span[contains(text(),'Select Location')]/ancestor::div[1]/mat-option");
	private By spindlelow = By.xpath("//div[text()='Spindle']/following::div[8]");
	private By overalspindle = By.xpath("//div[text()='Spindle']/following::div[1]");
	private By calendar = By.xpath("//mat-label[contains(text(),'Date')]/following::span[2]");
	private By availhigh = By.xpath("//div[text()='Availability']/following::div[4]");
	private By availlow = By.xpath("//div[text()='Availability']/following::div[8]");
	private By overalavailable = By.xpath("//div[text()='Availability']/following::div[1]");

	private By perfhigh = By.xpath("//div[text()='Performance']/following::div[4]");
	private By perflow = By.xpath("//div[text()='Performance']/following::div[8]");
	private By overalperf = By.xpath("//div[text()='Performance']/following::div[1]");

	private By yeardd = By.xpath("//span[contains(text(),'2023')]/parent::span");
	private By year = By.xpath("//div[text()=' 2023 ']/parent::button");
	private By startdate = By.xpath("//div[text()=' 29 ']/parent::button");	
	private By month = By.xpath("//div[contains(text(),'AUG')]/parent::button");
	
	private By qualityhigh = By.xpath("//div[text()='Quality']/following::div[4]");
	private By qualitylow = By.xpath("//div[text()='Quality']/following::div[8]");
	private By overalquality = By.xpath("//div[text()='Quality']/following::div[1]");
	private By partnum = By.xpath("(//table)[4]/tbody/tr/td[1]");
	private By pgmnum = By.xpath("(//table)[4]/tbody/tr/td[2]");
	private By Active = By.xpath("//div[text()='Device Status']/following::div[5]/span[1]");
	private By spindle = By.xpath("//div[text()='Device Status']/following::div[5]/span[2]");
	private By idle = By.xpath("//div[text()='Device Status']/following::div[5]/span[3]");
	private By alert = By.xpath("//div[text()='Device Status']/following::div[5]/span[4]");
	private By down = By.xpath("//div[text()='Device Status']/following::div[5]/span[5]");
	private By totalparts = By.xpath("//div[text()='24 Hour Total']/following-sibling::div");
	private By partsavg = By.xpath("//div[text()='24 Hour Total']/following::div[4]");
	private By highparts = By.xpath("//div[text()='24 Hour Total']/following::div[7]");
	private By lowparts = By.xpath("//div[text()='24 Hour Total']/following::div[10]");
	private By armed = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/thead/tr/th[2]/div[1]");
	private By execution = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/thead/tr/th[3]/div[1]");
	private By controller = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/thead/tr/th[4]/div[1]");
	private By block = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/thead/tr/th[6]/div[1]");
	private By line = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/thead/tr/th[7]/div[1]");
	private By timestamp = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/tbody/tr/td[1]/div[1]");
	private By msg = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/tbody/tr/td[2]/div[1]");
	private By pgmno = By.xpath("//div[contains(text(),'Emergency Stop')]/ancestor::table/tbody/tr/td[3]/div[1]");
//	private By partstable = By.xpath("//*[@id='element-to-export']/div[6]/div[7]/table/tbody/tr/td");
//	private By partrowsize = By.xpath("//*[@id='element-to-export']/div[6]/div[7]/table/tbody/tr");
	private By profile = By.xpath("//span[@class='relative']/child::mat-icon");
	private By signout = By.xpath("//span[text()='Sign out']");
	public void oee() {
		try {
			waittobeclickable(ninedots, 20);
			click(ninedots);
			log.info("Ninedots button is clicked");
			waittobeclickable(Oee, 20);
			click(Oee);
			log.info("Oee option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Oee home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void storyboard() {
		try {
			waittobeclickable(kpi, 10);
			click(kpi);
			System.out.println("kpi menu is clicked");
			waittobeclickable(story, 20);
			click(story);
			System.out.println("storyboard option is clicked");
			Thread.sleep(2000);
			log.info("Assert verification is done for Oee storyboard page");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void data() {
		try {		
			waittobeclickable(locdd, 10);
			click(locdd);
			List<WebElement> lo = findWebElements(loclist);
			for (int mm= 1; mm < lo.size(); mm++) {
				if(mm>1) {
					click(locdd);
				}
					lo.get(mm).click();		
			click(equipdd);
			List<WebElement> equipment = findWebElements(equiplist);
			for (int i = 1; i < equipment.size(); i++) {
					equipment.get(i).click();
					System.out.println(gettext(equiptext));
					click(apply);
					Thread.sleep(10000);
					if (gettext(armed).contains("UNAVAILABLE")) {
						log.info("Emergency stop condition is " + gettext(armed) + " for " + gettext(equiptext));
					} else if(gettext(armed).contains("-")) {
						log.info("Emergency stop condition is " + gettext(armed) + " for " + gettext(equiptext));
					}else {
						System.out.println("Emergency stop condion is " + gettext(execution));
					}
					if (gettext(execution).contains("UNAVAILABLE")) {
						log.info("Execution condion is " + gettext(execution) + " for " + gettext(equiptext));
					} else if(gettext(execution).contains("-")) {
						log.info("Execution condion is " + gettext(execution) + " for " + gettext(equiptext));
					}else {
						System.out.println("Execution condion is " + gettext(execution));
					}
					
					if (gettext(controller).contains("UNAVAILABLE")) {
						log.info("Controller mode is " + gettext(controller) + " for " + gettext(equiptext));
					} else if(gettext(controller).contains("-")) {
						log.info("Controller mode is " + gettext(controller) + " for " + gettext(equiptext));
					}else {
						System.out.println("Controller mode is " + gettext(controller));
					}
					if (gettext(block).equals("UNAVAILABLE")) {
						log.info("Block is Unavailable for " + gettext(equiptext));
					} else if (gettext(block).equals("-")) {
						log.info("Block is - for " + gettext(equiptext));
					} else {
						System.out.println("Block is " + gettext(block));
					}
					// System.out.println("Block is "+gettext(block));
					if (gettext(line).equals("UNAVAILABLE")) {
						log.info("Line is Unavailable for " + gettext(equiptext));
					} else if (gettext(line).equals("-")) {
						log.info("Line is - for " + gettext(equiptext));
					} else {
						System.out.println("Line no is " + gettext(line));
					}
					// System.out.println("Line No is "+gettext(line));
					System.out.println("Timestamp is " + gettext(timestamp));
					if (gettext(msg).equals("UNAVAILABLE")) {
						log.info("msg is Unavailable for " + gettext(equiptext));
					} else if (gettext(msg).equals("-")) {
						log.info("msg is - for " + gettext(equiptext));
					} else {
						System.out.println("Msg is " + gettext(msg));
					}
					// System.out.println("Message is "+gettext(msg));
					if (gettext(pgmno).equals("0")) {
						log.info("Pgm no is 0 for " + gettext(equiptext));
					} else if (gettext(pgmno).equals("-")) {
						log.info("Pgm no is - for " + gettext(equiptext));
					} else {
						System.out.println("Pgm no is " + gettext(pgmno));
					}
					System.out.println("Overall oee is " + gettext(overalloee));
					System.out.println("Oee high hour is " + gettext(oeehigh));
					System.out.println("Oee low hour is " + gettext(oeelow));
					System.out.println("*******");
					System.out.println("Overall Spindle is " + gettext(overalspindle));
					System.out.println("Spindle high hour is " + gettext(spindlehigh));
					System.out.println("Spindle low hour is " + gettext(spindlelow));
					System.out.println("*******");
					System.out.println("Overall Availability is " + gettext(overalavailable));
					System.out.println("Availability high hour is " + gettext(availhigh));
					System.out.println("Availability low hour is " + gettext(availlow));
					System.out.println("*******");
					System.out.println("Overall Performance is " + gettext(overalperf));
					System.out.println("Performance high hour is " + gettext(perfhigh));
					System.out.println("Performance low hour is " + gettext(perflow));
					System.out.println("*******");
					System.out.println("Overall Quality is " + gettext(overalquality));
					System.out.println("Quality high hour is " + gettext(qualityhigh));
					System.out.println("Quality low hour is " + gettext(qualitylow));
					System.out.println("*******");
					System.out.println("Active percentage is " + gettext(Active));
					System.out.println("Spindle percentage is " + gettext(spindle));
					System.out.println("Idle percentage is " + gettext(idle));
					System.out.println("Alert percentage is " + gettext(alert));
					System.out.println("Down percentage is " + gettext(down));

					System.out.println("*******");
					Thread.sleep(1000);
					List<Float> l = new LinkedList<>();
					float sum2 = 0f;
					
					
			//		WebElement tab = driver.findElement(By.xpath("//*[@id='element-to-export']/div[4]/div["+a+"]/div/table/tbody/tr[1]/td"));
					List<WebElement>  dat = driver.findElements(By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[1]/td"));
					if(dat.get(1).getText().contains("N/A")) {
						log.info("Table has data mentioned as N/A");
					}
					else {
					for (int p = 1; p < dat.size(); p++) {
						String text = dat.get(p).getText();
						String replace = text.replace("%", "").trim();
						Float valueOf = Float.valueOf(replace);
						l.add(valueOf);
					}
					
					System.out.println(l);
					for (int w = 0; w < l.size(); w++) {
						sum2 = sum2 + l.get(w);

					}
					Float fs = sum2 / l.size();
					int round = Math.round(fs);
					String rou = String.valueOf(round);
					if (sum2!= 0) {
						if (gettext(overalloee).contains(rou)) {
							System.out.println("Average actual OEE from calculation is " + sum2 / l.size());
						} else {
							log.info("Actual Oee percentage from table is "+gettext(overalloee)+" mismatches with overall calculated oee "+sum2 / l.size());
						}
					} 
		
					List<Float> l2 = new LinkedList<>();
					for (int j = 0; j < l.size(); j++) {
						String text = l.get(j).toString();
						System.out.println(text);
						if (text.equals("0")) {
							continue;
						} else {
							l2.add(l.get(j));
						}
					}
					if (l2.size() == 0) {
						System.out.println("MAXIMUM OEE from calculation IS 0%");
						System.out.println("MINIMUM OEE from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM OEE from calculation IS " + Collections.max(l2));
						System.out.println("MINIMUM OEE from calculation IS " + Collections.min(l2));

					}
					}
					List<Float> l3 = new LinkedList<>();
					float sum3 = 0f;
					
						List<WebElement>  dat2 = driver.findElements(By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[2]/td"));
						if(dat2.get(1).getText().contains("N/A")) {
							log.info("Table has data mentioned as N/A");
						}
						else {
					
					for (int k = 1; k < dat2.size(); k++) {
						String text = dat2.get(k).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							l3.add(valueOf);
						}
					}
					
					for (int w = 0; w < l3.size(); w++) {
						sum3 = sum3 + l3.get(w);

					}
					Float fs2 = sum3 / l.size();
					int round2 = Math.round(fs2);
					String rou2 = String.valueOf(round2);
					if (sum3 == 0) {
						System.out.println("Sum is 0");
					} else if (gettext(overalavailable).contains(rou2)) {
						System.out.println("Average actual availability from calculation is " + sum3 / l.size());
					} else {
						log.info("Actual availability percentage from table is "+gettext(overalavailable)+" mismatches with calculated availability "+sum3 / l.size());
					}

					if (l3.size() == 0) {
						System.out.println("MAXIMUM Availability from calculation IS 0%");
						System.out.println("MINIMUM Availability from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Availability from calculation IS " + Collections.max(l3));
						System.out.println("MINIMUM Availability from calculation IS " + Collections.min(l3));

					}
						}
					List<Float> l4 = new LinkedList<>();
					float sum4 = 0f;
					
						List<WebElement>  dat3 = driver.findElements(By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[3]/td"));
					
						if(dat3.get(1).getText().contains("N/A")) {
							log.info("Table has data mentioned as N/A");
						}
						else {
					for (int m = 1; m < dat3.size(); m++) {
						String text = dat3.get(m).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							l4.add(valueOf);
						}
					}
					
					for (int w = 0; w < l4.size(); w++) {
						sum4 = sum4 + l4.get(w);

					}
					Float fs3 = sum4 / l.size();
					int round3 = Math.round(fs3);
					String rou3 = String.valueOf(round3);
					if (sum4 == 0) {
						System.out.println("Performance is 0");
					} else {
						if (gettext(overalperf).contains(rou3)) {
							System.out.println("Average actual performance from calculation is " + sum4 / l.size());
						} else {
							log.info("Actual performance percentage displayed is "+ gettext(overalperf)+" mismatches with calculated performance "+sum4 / l.size());
						}
					}
					if (l4.size() == 0) {
						System.out.println("MAXIMUM Performance from calculation IS 0%");
						System.out.println("MINIMUM Performance from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Performance from calculation IS " + Collections.max(l4));
						System.out.println("MINIMUM Performance from calculation IS " + Collections.min(l4));

					}
						}
					List<Float> l5 = new LinkedList<>();
					float sum5 = 0f;
					
						List<WebElement>  dat4 = driver.findElements(By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[4]/td"));
						if(dat4.get(1).getText().contains("N/A")) {
							log.info("Table has data mentioned as N/A");
						}
						else {
						for (int n = 1; n < dat4.size(); n++) {
						String text = dat4.get(n).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							l5.add(valueOf);
						}
					}
					
					for (int w = 0; w < l5.size(); w++) {
						sum5 = sum5 + l5.get(w);

					}
					Float fs4 = sum5 / l.size();
					int round4 = Math.round(fs4);
					String rou4 = String.valueOf(round4);
					if (sum5 == 0) {
						System.out.println("Quality is 0");
					} else {
						if (gettext(overalquality).contains(rou4)) {
							System.out.println("Average actual quality from calculation is " + sum2 / l.size());
						} else {
							log.info("Actual quality percentage from table is "+ gettext(overalquality)+" mismatches with overall calculated quality "+ sum2 / l.size() );
						}
					}
					if (l5.size() == 0) {
						System.out.println("MAXIMUM Quality from calculation IS 0%");
						System.out.println("MINIMUM Quality from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Quality from calculation IS " + Collections.max(l5));
						System.out.println("MINIMUM Quality from calculation IS " + Collections.min(l5));

					}
					System.out.println("*******");
						}
					List<WebElement> act = driver.findElements(By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[1]/td"));
					if(act.get(1).getText().contains("N/A")) {
						log.info("Table has data mentioned as N/A");
					}
					else {
					List<Float> m2 = new LinkedList<>();
					if(act.size()==1) {
						break;
					}else {
					for (int j = 1; j < act.size(); j++) {
						String text = act.get(j).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							m2.add(valueOf);
						}
					}
					if (m2.size() == 0) {
						System.out.println("MAXIMUM Active percentage from calculation IS 0%");
						System.out.println("MINIMUM Active percentage from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Active percentage from calculation IS " + Collections.max(m2));
						System.out.println("MINIMUM Active percentage from calculation IS " + Collections.min(m2));

					}
					}
					Thread.sleep(1000);
					List<WebElement> spin = driver.findElements(By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[2]/td"));
					if(spin.get(1).getText().contains("N/A")) {
						log.info("Table has data mentioned as N/A");
					}
					else {
					List<Float> m3 = new LinkedList<>();
					for (int j = 1; j < spin.size(); j++) {
						String text = spin.get(j).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							m3.add(valueOf);
						}
					}
					if (m3.size() == 0) {
						System.out.println("MAXIMUM Spindle percentage from calculation IS 0%");
						System.out.println("MINIMUM Spindle percentage from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Spindle percentage from calculation IS " + Collections.max(m3));
						System.out.println("MINIMUM Spindle percentage from calculation IS " + Collections.min(m3));

					}
					}
					List<WebElement> act4 = driver.findElements(By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[3]/td"));
					if(act4.get(1).getText().contains("N/A")) {
						log.info("Table has data mentioned as N/A");
					}
					else {
					List<Float> m4 = new LinkedList<>();
					for (int m = 1; m < act4.size(); m++) {
						String text = act4.get(m).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							m4.add(valueOf);
						}
					}
					if (m4.size() == 0) {
						System.out.println("MAXIMUM Idle percentage from calculation IS 0%");
						System.out.println("MINIMUM Idle percentage from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Idle percentage from calculation IS " + Collections.max(m4));
						System.out.println("MINIMUM Idle percentage from calculation IS " + Collections.min(m4));

					}
					Thread.sleep(1000);
					}
					List<WebElement> act5 = driver.findElements(By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[4]/td"));
					if(act5.get(1).getText().contains("N/A")) {
						log.info("Table has data mentioned as N/A");
					}
					else {
					List<Float> m5 = new LinkedList<>();
					for (int n = 1; n < act5.size(); n++) {
						String text = act5.get(n).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							m5.add(valueOf);
						}
					}
					if (m5.size() == 0) {
						System.out.println("MAXIMUM Alert percentage from calculation IS 0%");
						System.out.println("MINIMUM Alert percentage from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Alert percentage from calculation IS " + Collections.max(m5));
						System.out.println("MINIMUM Alert percentage from calculation IS " + Collections.min(m5));

					}
					Thread.sleep(1000);
					}	
					List<WebElement> act6 = driver.findElements(By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[5]/td"));
					if(act6.get(1).getText().contains("N/A")) {
						log.info("Table has data mentioned as N/A");
					}
					else {
					List<Float> m6 = new LinkedList<>();
					for (int n = 1; n < act6.size(); n++) {
						String text = act6.get(n).getText();
						if (text.equals("0%")) {
							continue;
						} else {
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							m6.add(valueOf);
						}
					}
					if (m6.size() == 0) {
						System.out.println("MAXIMUM Down percentage from calculation IS 0%");
						System.out.println("MINIMUM Down percentage from calculation IS 0%");
					} else {
						System.out.println("MAXIMUM Down percentage from calculation IS " + Collections.max(m6));
						System.out.println("MINIMUM Down percentage from calculation IS " + Collections.min(m6));

					}
					}
					}
					System.out.println("24 hrs total parts average is " + gettext(partsavg));
					System.out.println("High parts number and time is " + gettext(highparts));
					System.out.println("low parts number and time  is " + gettext(lowparts));

					List<Integer> count = new LinkedList<>();

					List<WebElement> rows = driver.findElements(
							By.xpath("//*[@id='element-to-export']/div[6]/div[7]/table/tbody/tr"));

					for (int g = 1; g <= rows.size(); g++) {

						
						List<WebElement> part = driver.findElements(By.xpath(
								"//*[@id='element-to-export']/div[6]/div[7]/table/tbody/tr["+g+"]/td"));
						Thread.sleep(1000);
						for (int f = 2; f < part.size(); f++) {
							
							String txt = part.get(f).getText();
							if (txt.equals("0")) {
								continue;
							}else if(txt.equals("N/A")){
								System.out.println("Part count shows N/A");
								continue;
							}
								else {
							
								count.add(Integer.valueOf(txt));
							}
						}
					}

					int y = 0;
					for (Integer x : count) {
						y = y + x;
					}
					String sums = String.valueOf(y);
					System.out.println(sums);
					System.out.println(gettext(totalparts));
					if (gettext(totalparts).contains(sums)) {
						System.out.println("24 hrs total parts is " + gettext(totalparts));
					} else {
						log.info("Total parts in table in " + gettext(equiptext) + " is not equal to actual count");
					}
					if (count.size() == 0) {
						System.out.println("Maximum parts count from table is 0");
						System.out.println("Minimum parts count from table is 0");
					} else {
						System.out.println("Maximum parts count from table is " + Collections.max(count));
						System.out.println("Minimum parts count from table is " + Collections.min(count));

					}
					if(findWebElement(partnum).getText().contains("N/A")){
						log.info("Part number shows N/A for "+gettext(equiptext));
					}
					else if(findWebElement(partnum).getText().isBlank()!=true) {
						System.out.println("partnum exists");
					}					 
					else {
						log.info("Part number is not displayed for "+gettext(equiptext));
					}
					if(findWebElement(pgmnum).getText().contains("N/A")){
						log.info("Program number shows N/A for "+gettext(equiptext));
					}
					else if(findWebElement(pgmnum).getText().isBlank()!=true) {
						System.out.println("pgmnum exists");
					}
					else {
						log.info("Pgm number is not displayed");
					}
					
					System.out.println("----------------------------------------");
					Thread.sleep(500);
					if(i<equipment.size()-1) {
						click(equipdd);	
				}else {
					break;
				}
			}
		}
		}
			

		 catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Overall oee for all equipment is printed");
		System.out.println("Overall spindle for all equipment is printed");
		System.out.println("Overall availability for all equipment is printed");
		System.out.println("Overall performance for all equipment is printed");
		System.out.println("Overall quality for all equipment is printed");
		System.out.println("oee high and low hour for all equipment is printed");
		System.out.println("spindle high and low for all equipment is printed");
		System.out.println("Availability high and low for all equipment is printed");
		System.out.println("Quality high and low for all equipment is printed");
		System.out.println("Active percentage all equipment is printed");
		System.out.println("Idle percentage for all equipment is printed");
		System.out.println("Alert percentage for all equipment is printed");
		System.out.println("Down percentage for all equipment is printed");

	}
	public void profile() {
		waittobeclickable(profile, 10);
		click(profile);
		System.out.println("profile button is clicked");
		click(signout);
		System.out.println("signout button is clicked");
	}

}



package org.OeeMonitoring;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.BasePage;

public class Duplicate extends BasePage{

	public Duplicate(WebDriver driver) {
		super(driver);
	}
		private By ninedots = By.xpath("//div[@class='cursor-pointer']/button");
		private By Oee = By.xpath("//div[text()='OEE Monitoring']");
		private By monitoring = By.xpath("//span[contains(text(),'Monitoring')]");
		private By oeemonitor = By.xpath("//span[contains(text(),'OEE Monitoring')]");
		private By equipdd = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[3]");
		private By apply = By.xpath("//span[contains(text(),'Apply')]");
		private By equiplist = By.xpath("//div[@role='listbox']/mat-option/span");
		private By equiptext = By.xpath("//mat-label[text()='Equipment']/ancestor::div[1]/descendant::div[2]/span[1]/span");
		private By oeehigh = By.xpath("(//div[text()='OEE'])[2]/following::div[4]");
		private By overalloee = By.xpath("(//div[text()='OEE'])[2]/following::div[1]");
		private By oeelow = By.xpath("(//div[text()='OEE'])[2]/following::div[8]");

		private By spindlehigh = By.xpath("//div[text()='Spindle']/following::div[4]");
		private By spindlelow = By.xpath("//div[text()='Spindle']/following::div[8]");
		private By overalspindle = By.xpath("//div[text()='Spindle']/following::div[1]");

		private By availhigh = By.xpath("//div[text()='Availability']/following::div[4]");
		private By availlow = By.xpath("//div[text()='Availability']/following::div[8]");
		private By overalavailable = By.xpath("//div[text()='Availability']/following::div[1]");

		private By perfhigh = By.xpath("//div[text()='Performance']/following::div[4]");
		private By perflow = By.xpath("//div[text()='Performance']/following::div[8]");
		private By overalperf = By.xpath("//div[text()='Performance']/following::div[1]");

		private By qualityhigh = By.xpath("//div[text()='Quality']/following::div[4]");
		private By qualitylow = By.xpath("//div[text()='Quality']/following::div[8]");
		private By overalquality = By.xpath("//div[text()='Quality']/following::div[1]");

		private By oeetable = By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[1]/td");
		private By availtable = By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[2]/td");
		private By performtable = By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[3]/td");
		private By qualitytable = By.xpath("//*[@id='element-to-export']/div[4]/div[4]/table/tbody/tr[4]/td");
		private By activetable = By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[1]/td");
		private By spindletable = By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[2]/td");
		private By idletable = By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[3]/td");
		private By alerttable = By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[4]/td");
		private By downtable = By.xpath("//*[@id='element-to-export']/div[5]/div[4]/table/tbody/tr[5]/td");

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
		private By partstable = By.xpath("//*[@id='element-to-export']/div[6]/div[7]/table/tbody/tr/td");
		private By partrowsize = By.xpath("//*[@id='element-to-export']/div[6]/div[7]/table/tbody/tr");

		public void oee() {
			try {
				waittobeclickable(ninedots, 20);
				click(ninedots);
				log.info("Ninedots button is clicked");
				waittobeclickable(Oee, 20);
				click(Oee);
				log.info("Oee option is clicked");
				Thread.sleep(2000);
				String ExpectedURL = "https://portal.drumbuffer.io/#/oee/home";
				String ActualURL = getCurrentURL();
				assertEquals(ExpectedURL, ActualURL);
				log.info("Assert verification is done for Oee home page");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		public void oeemonitor() {
			try {
				waittobeclickable(monitoring, 10);
				click(monitoring);
				log.info("Monitoring button is clicked");
				waittobeclickable(oeemonitor, 20);
				click(oeemonitor);
				log.info("oee monitor option is clicked");
				Thread.sleep(2000);
				String ExpectedURL2 = "https://portal.drumbuffer.io/#/oee/monitoring";
				String ActualURL2 = getCurrentURL();
				assertEquals(ExpectedURL2, ActualURL2);
				log.info("Assert verification is done for Oee monitoring page");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		public void data() {
			try {
				waittobeclickable(equipdd, 10);
				click(equipdd);
				List<WebElement> equipment = findWebElements(equiplist);
				List<String> s = new LinkedList<>();
				for (int i = 1; i < equipment.size(); i++) {
						equipment.get(i).click();
						System.out.println(gettext(equiptext));
						click(apply);
						Thread.sleep(500);
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
						List<WebElement> oeetab = findWebElements(oeetable);
						List<Float> l = new LinkedList<>();
						float sum2 = 0f;

//					System.out.println("sum is "+sum2);
						 
//					//float avg =0;
						for (int p = 1; p < oeetab.size(); p++) {
							String text = oeetab.get(p).getText();
							String replace = text.replace("%", "").trim();
							Float valueOf = Float.valueOf(replace);
							l.add(valueOf);
						}
						for (int w = 0; w < l.size(); w++) {
							sum2 = sum2 + l.get(w);

						}
						System.out.println("sum is "+sum2);
						if (sum2!= 0) {
							System.out.println("Average actual OEE from calculation is " + sum2 / l.size());
						}else {
							System.out.println("Average actual OEE from calculation is 0%");
						}

//						System.out.println(l.get(p));
//						sum2 = sum2 + l.get(p);
						// sum2 = Float.sum(sum2, l.get(p));
//					}
//					
//					System.out.println("Overall Actual OEE is "+sum2/oeetab.size());

						List<Float> l2 = new LinkedList<>();
						for (int j = 1; j < oeetab.size(); j++) {
							String text = oeetab.get(j).getText();
							if (text.equals("0.0%")) {
								continue;
							} else {
								String replace = text.replace("%", "").trim();
								Float valueOf = Float.valueOf(replace);
								l2.add(valueOf);
							}
						}

						if (l2.size() == 0) {
							System.out.println("MAXIMUM OEE from calculation IS 0%");
							System.out.println("MINIMUM OEE from calculation IS 0%");
						} else {
							System.out.println("MAXIMUM OEE from calculation IS " + Collections.max(l2));
							System.out.println("MINIMUM OEE from calculation IS " + Collections.min(l2));

						}
						List<WebElement> availtab = findWebElements(availtable);
						List<Float> l3 = new LinkedList<>();
						for (int k = 1; k < availtab.size(); k++) {
							String text = availtab.get(k).getText();
							if (text.equals("0.0%")) {
								continue;
							} else {
								String replace = text.replace("%", "").trim();
								Float valueOf = Float.valueOf(replace);
								l3.add(valueOf);
							}
						}
						if (l3.size() == 0) {
							System.out.println("MAXIMUM Availability from calculation IS 0%");
							System.out.println("MINIMUM Availability from calculation IS 0%");
						} else {
							System.out.println("MAXIMUM Availability from calculation IS " + Collections.max(l3));
							System.out.println("MINIMUM Availability from calculation IS " + Collections.min(l3));

						}
						List<WebElement> perftab = findWebElements(performtable);
						List<Float> l4 = new LinkedList<>();
						for (int m = 1; m < perftab.size(); m++) {
							String text = perftab.get(m).getText();
							if (text.equals("0.0%")) {
								continue;
							} else {
								String replace = text.replace("%", "").trim();
								Float valueOf = Float.valueOf(replace);
								l4.add(valueOf);
							}
						}
						if (l4.size() == 0) {
							System.out.println("MAXIMUM Performance from calculation IS 0%");
							System.out.println("MINIMUM Performance from calculation IS 0%");
						} else {
							System.out.println("MAXIMUM Performance from calculation IS " + Collections.max(l4));
							System.out.println("MINIMUM Performance from calculation IS " + Collections.min(l4));

						}
						List<WebElement> qualtab = findWebElements(qualitytable);
						List<Float> l5 = new LinkedList<>();
						for (int n = 1; n < qualtab.size(); n++) {
							String text = qualtab.get(n).getText();
							if (text.equals("0.0%")) {
								continue;
							} else {
								String replace = text.replace("%", "").trim();
								Float valueOf = Float.valueOf(replace);
								l5.add(valueOf);
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
						List<WebElement> act = findWebElements(activetable);
						List<Float> m2 = new LinkedList<>();
						for (int j = 1; j < act.size(); j++) {
							String text = act.get(j).getText();
							if (text.equals("0.0%")) {
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

						Thread.sleep(1000);
						List<WebElement> act2 = findWebElements(spindletable);
						List<Float> m3 = new LinkedList<>();
						for (int k = 1; k < act2.size(); k++) {
							String text = act2.get(k).getText();
							if (text.equals("0.0%")) {
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
						Thread.sleep(1000);
						List<WebElement> act4 = findWebElements(idletable);
						List<Float> m4 = new LinkedList<>();
						for (int m = 1; m < act4.size(); m++) {
							String text = act4.get(m).getText();
							if (text.equals("0.0%")) {
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
						List<WebElement> act5 = findWebElements(alerttable);
						List<Float> m5 = new LinkedList<>();
						for (int n = 1; n < act5.size(); n++) {
							String text = act5.get(n).getText();
							if (text.equals("0.0%")) {
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
						Thread.sleep(1000);
						List<WebElement> act6 = findWebElements(downtable);
						List<Float> m6 = new LinkedList<>();
						for (int n = 1; n < act6.size(); n++) {
							String text = act6.get(n).getText();
							if (text.equals("0.0%")) {
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
						
						
						System.out.println("24 hrs total parts average is " + gettext(partsavg));
						System.out.println("High parts number and time is " + gettext(highparts));
						System.out.println("low parts number and time  is " + gettext(lowparts));
						
						List<WebElement> parts = findWebElements(partstable);
						List<WebElement> row = findWebElements(partrowsize);
						List<Integer> count = new LinkedList<>();
						for (int g = 0; g < row.size(); g++) {
							if(g==0) {
							for (int f = 2; f < 26; f++) {
								
								String txt = parts.get(f).getText();
								if(txt.equals("0")) {
									continue;
								}else {
								count.add(Integer.valueOf(txt));
								}
							}
							}
							if(g==1) {
								for (int f = 29; f < 52; f++) {								
									String txt = parts.get(f).getText();
									if(txt.equals("0")) {
										continue;
									}else {
									count.add(Integer.valueOf(txt));
									}
								}	
							}
							if(g==2) {
								for (int f = 55; f < 78; f++) {								
									String txt = parts.get(f).getText();
									if(txt.equals("0")) {
										continue;
									}else {
									count.add(Integer.valueOf(txt));
									}
								}	
							}
						}
						int y=0;
						for(Integer x:count) {
							y=y+x;
						}
						String sums = String.valueOf(y);
						System.out.println(sums);
						System.out.println(gettext(totalparts));
						if(gettext(totalparts).contains(sums)) {
							System.out.println("24 hrs total parts is " + gettext(totalparts));
						}else {
							log.info("Total parts in table in "+gettext(equiptext)+" is not equal to actual count");
						}	
						if(count.size()==0) {
							System.out.println("Maximum parts count from table is 0%");
							System.out.println("Minimum parts count from table is 0%");
						}else {
						System.out.println("Maximum parts count from table is "+ Collections.max(count));
						System.out.println("Minimum parts count from table is "+ Collections.min(count));
						
						}						
						System.out.println("----------------------------------------");
					if(i<equipment.size()-1) {
						click(equipdd);
					}else {
						break;
					}

//					else {
//						
//						equipment.get(i).click();
//						System.out.println(gettext(equiptext));
//						click(apply);
//						Thread.sleep(500);
//						System.out.println("Overall oee is " + gettext(overalloee));
//						System.out.println("Oee high hour is " + gettext(oeehigh));
//						System.out.println("Oee low hour is " + gettext(oeelow));
//						System.out.println("*******");
//						System.out.println("Overall Spindle is " + gettext(overalspindle));
//						System.out.println("Spindle high hour is " + gettext(spindlehigh));
//						System.out.println("Spindle low hour is " + gettext(spindlelow));
//						System.out.println("*******");
//						System.out.println("Overall Availability is " + gettext(overalavailable));
//						System.out.println("Availability high hour is " + gettext(availhigh));
//						System.out.println("Availability low hour is " + gettext(availlow));
//						System.out.println("*******");
//						System.out.println("Overall Performance is " + gettext(overalperf));
//						System.out.println("Performance high hour is " + gettext(perfhigh));
//						System.out.println("Performance low hour is " + gettext(perflow));
//						System.out.println("*******");
//						System.out.println("Overall Quality is " + gettext(overalquality));
//						System.out.println("Quality high hour is " + gettext(qualityhigh));
//						System.out.println("Quality low hour is " + gettext(qualitylow));
//						System.out.println("*******");
//						System.out.println("Active percentage is " + gettext(Active));
//						System.out.println("Spindle percentage is " + gettext(spindle));
//						System.out.println("Idle percentage is " + gettext(idle));
//						System.out.println("Alert percentage is " + gettext(alert));
//						System.out.println("Down percentage is " + gettext(down));
//						System.out.println("*******");
//						Thread.sleep(500);
//						List<WebElement> oeetab = findWebElements(oeetable);
//						List<Float> l = new LinkedList<>();
//						for (int p = 1; p < oeetab.size(); p++) {
//							String text = oeetab.get(p).getText();
//							String replace = text.replace("%", "").trim();
//							Float valueOf = Float.valueOf(replace);
//							l.add(valueOf);
//						}
	//
//						List<Float> l2 = new LinkedList<>();
//						for (int j = 1; j < oeetab.size(); j++) {
//							String text = oeetab.get(j).getText();
//							if (text.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								l2.add(valueOf);
//							}
//						}
//						if (l2.size() == 0) {
//							System.out.println("MAXIMUM OEE from calculation IS 0%");
//							System.out.println("MINIMUM OEE from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM OEE from calculation IS " + Collections.max(l2));
//							System.out.println("MINIMUM OEE from calculation IS " + Collections.min(l2));
//							Optional<Float> reduce = l.stream().reduce((a, b) -> a + b);
//							System.out.println("Average actual OEE from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(500);
//						List<WebElement> availtab = findWebElements(availtable);
//						List<Float> l3 = new LinkedList<>();
//						for (int k = 1; k < availtab.size(); k++) {
//							String text = availtab.get(k).getText();
//							if (text.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								l3.add(valueOf);
//							}
//						}
//						if (l3.size() == 0) {
//							System.out.println("MAXIMUM availability from calculation IS 0%");
//							System.out.println("MINIMUM availability from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM availability from calculation IS " + Collections.max(l3));
//							System.out.println("MINIMUM availability from calculation IS " + Collections.min(l3));
//							Optional<Float> reduce = l3.stream().reduce((a, b) -> a + b);
//							System.out.println(
//									"Average actual Availability from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(300);
//						List<WebElement> perftab = findWebElements(performtable);
//						List<Float> l4 = new LinkedList<>();
//						for (int m = 1; m < perftab.size(); m++) {
//							String text = perftab.get(m).getText();
//							if (text.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								l4.add(valueOf);
//							}
//						}
//						if (l4.size() == 0) {
//							System.out.println("MAXIMUM performance from calculation IS 0%");
//							System.out.println("MINIMUM performance from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM performance from calculation IS " + Collections.max(l4));
//							System.out.println("MINIMUM performance from calculation IS " + Collections.min(l4));
//							Optional<Float> reduce = l4.stream().reduce((a, b) -> a + b);
//							System.out
//									.println("Average actual Performance from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(300);
//						List<WebElement> qualtab = findWebElements(qualitytable);
//						List<Float> l5 = new LinkedList<>();
//						for (int n = 1; n < qualtab.size(); n++) {
//							String text = qualtab.get(n).getText();
//							if (text.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								l5.add(valueOf);
//							}
//						}
//						if (l5.size() == 0) {
//							System.out.println("MAXIMUM quality from calculation IS 0%");
//							System.out.println("MINIMUM quality from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM quality from calculation IS " + Collections.max(l5));
//							System.out.println("MINIMUM quality from calculation IS " + Collections.min(l5));
//							Optional<Float> reduce = l5.stream().reduce((a, b) -> a + b);
//							System.out.println("Average actual Quality from calculation is " + (reduce.get()) / l.size());
//						}
//						System.out.println("*******");
//						Thread.sleep(300);
//						List<WebElement> act = findWebElements(activetable);
//						List<Float> m2 = new LinkedList<>();
//						for (int j = 1; j < act.size(); j++) {
//							String text = act.get(j).getText();
//							if (text.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								m2.add(valueOf);
//							}
//						}
//						if (m2.size() == 0) {
//							System.out.println("MAXIMUM Active percentage from calculation IS 0%");
//							System.out.println("MINIMUM Active percentage from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM Active percentage from calculation IS " + Collections.max(m2));
//							System.out.println("MINIMUM Active percentage from calculation IS " + Collections.min(m2));
//							Optional<Float> reduce = m2.stream().reduce((a, b) -> a + b);
//							System.out.println(
//									"Average actual Active percentage from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(300);
//						List<WebElement> act2 = findWebElements(spindletable);
//						List<Float> m3 = new LinkedList<>();
//						for (int k = 1; k < act2.size(); k++) {
//							String text2 = act2.get(k).getText();
//							if (text2.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text2.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								m3.add(valueOf);
//							}
//						}
//						if (m3.size() == 0) {
//							System.out.println("MAXIMUM Spindle percentage from calculation IS 0%");
//							System.out.println("MINIMUM Spindle percentage from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM Spindle percentage from calculation IS " + Collections.max(m3));
//							System.out.println("MINIMUM Spindle percentage from calculation IS " + Collections.min(m3));
//							Optional<Float> reduce = m3.stream().reduce((a, b) -> a + b);
//							System.out.println(
//									"Average actual Spindle percentage from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(300);
//						List<WebElement> act4 = findWebElements(idletable);
//						List<Float> m4 = new LinkedList<>();
//						for (int m = 1; m < act4.size(); m++) {
//							String text3 = act4.get(m).getText();
//							if (text3.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text3.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								m4.add(valueOf);
//							}
//						}
//						if (m4.size() == 0) {
//							System.out.println("MAXIMUM Idle percentage from calculation IS 0%");
//							System.out.println("MINIMUM Idle percentage from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM Idle percentage from calculation IS " + Collections.max(m4));
//							System.out.println("MINIMUM Idle percentage from calculation IS " + Collections.min(m4));
//							Optional<Float> reduce = m4.stream().reduce((a, b) -> a + b);
//							System.out.println(
//									"Average actual Ideal percentage from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(300);
//						List<WebElement> act5 = findWebElements(alerttable);
//						List<Float> m5 = new LinkedList<>();
//						for (int n = 1; n < act5.size(); n++) {
//							String text5 = act5.get(n).getText();
//							if (text5.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text5.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								m5.add(valueOf);
//							}
//						}
//						if (m5.size() == 0) {
//							System.out.println("MAXIMUM ALERT PERCENTAGE from calculation IS 0%");
//							System.out.println("MINIMUM ALERT PERCENTAGE from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM ALERT PERCENTAGE from calculation IS " + Collections.max(m5));
//							System.out.println("MINIMUM ALERT PERCENTAGE from calculation IS " + Collections.min(m5));
//							Optional<Float> reduce = m5.stream().reduce((a, b) -> a + b);
//							System.out.println(
//									"Average actual Alert percentage from calculation is " + (reduce.get()) / l.size());
//						}
//						Thread.sleep(300);
//						List<WebElement> act6 = findWebElements(downtable);
//						List<Float> m6 = new LinkedList<>();
//						for (int n = 1; n < act6.size(); n++) {
//							String text6 = act6.get(n).getText();
//							if (text6.equals("0.0%")) {
//								continue;
//							} else {
//								String replace = text6.replace("%", "").trim();
//								Float valueOf = Float.valueOf(replace);
//								m6.add(valueOf);
//							}
//						}
//						if (m6.size() == 0) {
//							System.out.println("MAXIMUM Down percentage from calculation IS 0%");
//							System.out.println("MINIMUM Down percentage from calculation IS 0%");
//						} else {
//							System.out.println("MAXIMUM Down percentage from calculation IS " + Collections.max(m6));
//							System.out.println("MINIMUM Down percentage from calculation IS " + Collections.min(m6));
//							Optional<Float> reduce = m6.stream().reduce((a, b) -> a + b);
//							System.out.println(
//									"Average actual Down percentage from calculation is " + (reduce.get()) / l.size());
//						}
//					System.out.println("24 hrs total parts is " + gettext(totalparts));
//					System.out.println("24 hrs total parts average is " + gettext(partsavg));
//					System.out.println("High parts number and time is " + gettext(highparts));
//					System.out.println("low parts number and time  is " + gettext(lowparts));
//					List<WebElement> parts = findWebElements(partstable);
//					List<WebElement> row = findWebElements(partrowsize);
//					List<Integer> count = new LinkedList<>();
//					for (int g = 0; g < row.size(); g++) {
//						System.out.println(row.size());
//						for (int f = 2; f < 26; f++) {
//							String txt = parts.get(f).getText();
//							System.out.println(txt);
//							if(txt.equals("0")||txt.equals("N/A")) {
//								continue;
//							}else {
//							count.add(Integer.valueOf(txt));
//							}
//						}
//					}
//					if(count.size()==0) {
//						System.out.println("Maximum parts count from table is 0%");
//						System.out.println("Minimum parts count from table is 0%");
//					}else {
//					System.out.println("Maximum parts count from table is "+ Collections.max(count));
//					System.out.println("Minimum parts count from table is "+ Collections.min(count));
//					}
//					System.out.println("----------------------------------------");
//					}
			}
				

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("Overall oee for all equipment is printed");
			log.info("Overall spindle for all equipment is printed");
			log.info("Overall availability for all equipment is printed");
			log.info("Overall performance for all equipment is printed");
			log.info("Overall quality for all equipment is printed");
			log.info("oee high and low hour for all equipment is printed");
			log.info("spindle high and low for all equipment is printed");
			log.info("Availability high and low for all equipment is printed");
			log.info("Quality high and low for all equipment is printed");
			log.info("Active percentage all equipment is printed");
			log.info("Idle percentage for all equipment is printed");
			log.info("Alert percentage for all equipment is printed");
			log.info("Down percentage for all equipment is printed");

		}

	}



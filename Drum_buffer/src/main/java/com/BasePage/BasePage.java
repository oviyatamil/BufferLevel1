package com.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.openqa.selenium.interactions.*;


public class BasePage extends ReportSetup{
	
	    public static WebDriver driver;
	    public static ReportSetup setup;
	    
	    public  BasePage(WebDriver driver) {
	    	this.driver = driver;
	    }
	    public void setdriver(WebDriver driver) {
	    	this.driver=driver;
	    }
	    protected WebElement findWebElement(By locator) {
	    	return driver.findElement(locator);
	    	
	    }
//	    public static String getSelectorAsString(String locator) {
//	        String str = locator.toString();
//	        return str.substring(str.indexOf(" ") , str.length());
//	      }
	    protected List<WebElement> findWebElements(By locator) {
	    	List<WebElement> element=driver.findElements(locator);
	    	return element;
	    }
	    protected void click(By locator) {
	    
	    	try {
				findWebElement(locator).click();
				setup = new ReportSetup();
				//testStepInfo("Entered into the username");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    protected void EnterText(By locator,String Input) {
	    	
	    	try {
				findWebElement(locator).clear();
				findWebElement(locator).sendKeys(Input);
				//testStepInfo("Entered into the username");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    protected String getCurrentURL() {
	    	return driver.getCurrentUrl();
	    }
	    
	    public  String takescreenshots(String SSName) {
			String destination = null;
			try {
				TakesScreenshot ss=(TakesScreenshot)driver;
				String data = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
				File scren=ss.getScreenshotAs(OutputType.FILE);
				destination = System.getProperty("user.dir")+"/screenShot/"+SSName+data+".png";

				File dest = new File(destination);
				FileHandler.copy(scren, dest);
				return destination;
				//FileUtils.copyFile(scren,dest);Jul 14,2023"Mmm dd,yyyy"
			} catch (Exception e) {
				e.printStackTrace();
			}
			return destination;

		}
	    public static void screenshot(ITestResult tr) {
			TakesScreenshot t =(TakesScreenshot)driver;
			String MethodName=tr.getMethod().getMethodName();
			File src = t.getScreenshotAs(OutputType.FILE);
			File des = new File(System.getProperty("user.dir")+"\\screenshot\\"+MethodName+".png");
			try {
				FileUtils.copyFile(src, des);
			} catch (Exception e) {
				e.printStackTrace();
			}

	    }
	   public String gettext(By locator) {
		   String text = findWebElement(locator).getText();
		   return text;
		
		   
	   }
	   public String getattribute(By locator) {
		   String attribute = findWebElement(locator).getAttribute("value");
		   return attribute;
	   }
	   public void select(By locator,String text) {
		   Select s = new Select(findWebElement(locator));
		   s.selectByVisibleText(text);
	}
         public static String excel(String heading,int index,String no) {
        	 String value = null;
        	 try {
				File f = new File("./XLdata/Testdata.xlsx");
				 FileInputStream fs = new FileInputStream(f);
				 Workbook w = new XSSFWorkbook(fs);
				 Sheet sheet = w.getSheetAt(index);
				 int rows = sheet.getPhysicalNumberOfRows();
				 for(int i=1;i<rows;i++) {
					 String num = sheet.getRow(i).getCell(0).toString();
					 if(num.equals(no)) {
						 switch(heading) {
						 case "username":
							 value = sheet.getRow(i).getCell(1).toString();
							 break;
						 case "Password":
							 value = sheet.getRow(i).getCell(2).toString();
							 break;
						default :
							value = sheet.getRow(i).getCell(3).toString();
							break;
						 }
					 }
				 }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	 
			return value;
        	 
         }
         public void waittobeclickable(By locator,int time) {
        	 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(time));
				 w.until(ExpectedConditions.elementToBeClickable(locator));
			
			}
         public void clear(By locator) {
        	 findWebElement(locator).clear();
         }
         public void Actions(By locator) {
        	Actions a = new Actions(driver);
        //	a.dragAndDropBy(findWebElement(locator), 50, 0).perform();
        	
        	 a.moveToElement(findWebElement(locator)).perform();
        	 
         }
         public void move(WebElement x) {
        	 Actions a = new Actions(driver);
        	 a.moveToElement(x).perform();
         }
         public void draganddrop(By locator) {
         	Actions a = new Actions(driver);
         	a.dragAndDropBy(findWebElement(locator), 50, 0).perform();
         	
         	 
          }
         public void calendar(By locator1,By locator2,By locator3,By locator4) {
        	 try {
				String data = new SimpleDateFormat("MMM dd,yyyy,hh:mm").format(new Date());
				String[] split = data.split(" ");
				String s = split[0].toUpperCase();
				Thread.sleep(1000);
				click(locator1);
				click(locator2);
				click(locator3);
				WebElement mon = driver.findElement(By.xpath("//div[contains(text(),'" + s + "')]/parent::button"));
				mon.click();
				click(locator4);
				String[] split2 = data.split(",");
				String[] split3 = split2[0].split(" ");
				String m = split3[1];
				int p = Integer.parseInt(m);
				WebElement end = driver.findElement(By.xpath("//div[contains(text(),'" + p + "')]/parent::button"));
				end.click();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
         }
//         public void draganddrophorizontal(By locator) {
//          	Actions a = new Actions(driver);
//          	a.dragAndDropBy(findWebElement(locator), 20, 0).perform();
//          	
//          	 
//           }

         }


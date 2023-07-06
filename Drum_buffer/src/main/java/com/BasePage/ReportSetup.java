package com.BasePage;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportSetup extends Listners {
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter  spark;
	
	
	public SimpleDateFormat data;
	
	//public  Logger log =LogManager.getLogger(getClass());
		
//   static {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
//		    System.setProperty("current.date.time", dateFormat.format(new Date()));
//			}
//	static { 
//   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//   String currentTime = dateFormat.format(new Date());
//   String logFilePath = String.format("logs/Log4jDemo_%s.log", currentTime);
//    System.setProperty("log",logFilePath);
//	}
   
	
	public  static void intialize() {
		try {
			//To load Extend Report
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = timestamp+".html";
			spark =new ExtentSparkReporter(System.getProperty("user.dir")+"./target/"+repName);
			spark.loadXMLConfig(System.getProperty("user.dir")+"/Config/extent-report.xml");
			spark.config().setDocumentTitle("Buffer Testing");
			spark.config().setReportName("Functional Testing");
			spark.config().setTheme(Theme.DARK);
			spark.config().setProtocol(Protocol.HTTPS);
			
			report =new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("HostName", "LocalHost");
			report.setSystemInfo("Port", "4444");
			report.setSystemInfo("OS", "Windows10");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testStepInfo(String Message, ITestResult tr) {
		String MethodName=tr.getMethod().getMethodName();
	//	ITestResult result = org.testng.Reporter.getCurrentTestResult();
    //    String trr=result.getMethod().getMethodName();
		test =report.createTest(MethodName);
		log.info(Message);
		test.log(Status.INFO,Message);
	}
	public void testStepPass(String Message) {
		log.info(Message);
		//test.log(Status.PASS,Message);
	}
	public  void testStepFail(String Message) {
		log.info(Message);
		//test.log(Status.FAIL,Message);
	}
	
	public static void result(ITestResult tr, WebDriver driver) {
		
			try {
				String MethodName=tr.getMethod().getMethodName();
				if(tr.getStatus()==ITestResult.FAILURE) {
					String expectedMsg =Arrays.toString(tr.getThrowable().getStackTrace());
					ReportSetup.test.fail("<details><summary><b><font color=red>Exception accured Please click here to see the detail.</font></b><summary>"+
							expectedMsg.replace(",", "<br>")+"</details> \n");
					
					BasePage basepage= new BasePage(driver);
					String path= basepage.takescreenshots(tr.getMethod().getMethodName());
					//System.out.println(path);
					ReportSetup.test.fail("<b><font color=red>"+"ScreenShot of Failure"+"</font><b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
					//Setup.test.addScreenCaptureFromPath(path);
					//Setup.test.fail("<b><font color=red>"+"ScreenShot of Failure"+"</font><b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
					String logText="<b> Test Method"+MethodName+"Failed</b>";
					Markup markup=MarkupHelper.createLabel(logText, ExtentColor.RED);
					ReportSetup.test.log(Status.FAIL, markup);
				}else if(tr.getStatus()==ITestResult.SUCCESS) {
					String logText="<b> Test Method "+MethodName+" Successfull</b>";
					Markup markup=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
					ReportSetup.test.log(Status.PASS, markup);
					
				}else if(tr.getStatus()==ITestResult.SKIP) {
					String logText="<b> Test Method"+MethodName+"Skipped</b>";
					Markup markup=MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
					ReportSetup.test.log(Status.SKIP, markup);
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	public static void flush() {
	  report.flush();
	}
	
	
	
	
	

}

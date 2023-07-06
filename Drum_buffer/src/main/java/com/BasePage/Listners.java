package com.BasePage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listners implements ITestListener {
	
//	public static ExtentReports report;
//	public static ExtentTest test;
//	public static ExtentSparkReporter  spark;
	public SimpleDateFormat data;
	public  Logger log =LogManager.getLogger(getClass());
	
	//public  Logger log =LogManager.getLogger(getClass());
		
//   static {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
//		    System.setProperty("current.date.time", dateFormat.format(new Date()));
//			}
	static { 
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
   String currentTime = dateFormat.format(new Date());
   String logFilePath = String.format("logs/Log4jDemo_%s.log", currentTime);
    System.setProperty("log",logFilePath);
	}
   @Override
	public  void onTestStart(ITestResult result) {
		String methodname =result.getMethod().getMethodName();
	    // not implemented
		log.info("#########################"+methodname+"Execution is started ################");
		System.out.println("#########################"+methodname+"Execution is started ################");
		
		
		
	}  
	@Override   
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		String methodname =result.getMethod().getMethodName();
	    // not implemented
		log.info("#########################"+methodname+" has been Sucessfully Completed ################");
//		BasePage ut =new BasePage();
//		test =report.createTest(result.getName());
//		System.out.println(result.getName());
//		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
//		ut.takescrenshots(methodname);
	  }

	  
	@Override
	public void onTestFailure(ITestResult result) {
		String methodname =result.getMethod().getMethodName();
	    // not implemented
//	  String Method= result.getMethod().getMethodName();
		log.info("#########################"+methodname+" has been Failed ################");
//		BasePage ut =new BasePage();
//		ut.takescrenshots(result.getMethod().getMethodName());
//		test =report.createTest(result.getName());
//		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
//		String ScrenShot =System.getProperty("user.dir")+"\\ScreenShot\\"+result.getName()+".png";
//		File finalDestination =new File(ScrenShot);
//		if(finalDestination.exists()) {
//			try {
//				test.fail("ScreenShot Below: "+test.addScreenCaptureFromPath(ScrenShot));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//takescrenshots(result.getMethod().getMethodName());
	  }

	  
	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		String methodname =result.getMethod().getMethodName();
	    // not implemented
		log.info("#########################"+methodname+" has been Skipped ################");
//		BasePage ut =new BasePage();
//		ut.takescrenshots(methodname);
//		test =report.createTest(result.getName());
//		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}	  
	@Override
	public void onStart(ITestContext context) {
	    // not implemented
		log.info("################ Test Scripts Execution as Started ###################");
		System.out.println("################ Test Scripts Execution as Started ###################");
		
		
	  }


	@Override
	public void onFinish(ITestContext context) {
	    // not implemented
		System.out.println("################ Test Scripts Execution as Finished ###################");
		log.info("################ Test Scripts Execution as Finished ###################");
		
		
	  }
	

}

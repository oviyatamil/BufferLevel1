package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Controlchart2;
import com.aventstack.extentreports.Status;

public class SA_007 extends BaseTest{
Controlchart2 cc;

@Test
protected void controlcenter() {
	ReportSetup.test=ReportSetup.report.createTest("Control center page 2");
	ReportSetup.test.assignCategory("SA6");
	cc = new Controlchart2(driver);
	cc.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
	cc.control();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to control chart page");
	cc.notification();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Notification monitoring and check data and charts");
	cc.gateway();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Notification->gateway monitoring and check status of gateways and its timestamp");
	cc.usage();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to User usage monitoring and check status of gateways and its timestamp");
	cc.device();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to device monitoring and checked card counts and chart");
	cc.gateway2();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Device monitoring->gateway monitoring and check status of gateways and its timestamp");
	cc.ota();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to OTA mobile and add a record");
	cc.radio();
	ReportSetup.test.log(Status.PASS, "Successfully check duplicate listing,add,view,edit,delete,cancel functions");
	cc.connect();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Remote gateway connect and check function and then navigated to live data and check records");
	cc.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");

}
}

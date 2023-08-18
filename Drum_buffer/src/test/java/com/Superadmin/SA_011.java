package com.Superadmin;

import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Support;
import com.aventstack.extentreports.Status;

public class SA_011 extends BaseTest{

Support s;

@Test
protected void support() {
	ReportSetup.test=ReportSetup.report.createTest("Support screen");
	ReportSetup.test.assignCategory("SA-11");
	s = new Support(driver);
	s.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to home page");
	s.errordash();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Support->error dashboard page");
	s.data();
	ReportSetup.test.log(Status.PASS, "Successfully get datas and check charts");
	s.errorlog();
	ReportSetup.test.log(Status.PASS, "Successfully naviagted to error log page and checked actions option");
	s.help();
	ReportSetup.test.log(Status.PASS, "Successfully raised a ticket");
	s.ticket();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to ticket listing page and checked all actions");
	s.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	
}
}

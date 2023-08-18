package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Gateway_Type;
import com.aventstack.extentreports.Status;

public class SA_010 extends BaseTest{
Gateway_Type g;

@Test
protected void device() {
	ReportSetup.test=ReportSetup.report.createTest("Device->Gateway screen");
	ReportSetup.test.assignCategory("SA-10");
	g = new Gateway_Type(driver);
	g.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
//	p.prod();
}
}

package com.Iot;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class I_05 extends BaseTest{

	Report a;
	@Test
	protected void report() {
		ReportSetup.test=ReportSetup.report.createTest("Report page");
		ReportSetup.test.assignCategory("I-5");
		a = new Report(driver);
		a.home();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to report page");
//		a.report();
//		ReportSetup.test.log(Status.PASS, "Successfully add a report and check all functions");
		a.radio();
		a.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

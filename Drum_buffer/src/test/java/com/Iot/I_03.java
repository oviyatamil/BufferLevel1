package com.Iot;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class I_03 extends BaseTest{

	Assets a;
	@Test
	protected void asset() {
		ReportSetup.test=ReportSetup.report.createTest("Assets page");
		ReportSetup.test.assignCategory("I-3");
		a = new Assets(driver);
		a.home();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to Assets page");
		a.assets();
		ReportSetup.test.log(Status.PASS, "Successfully add equipment listing and check all functions");
		a.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

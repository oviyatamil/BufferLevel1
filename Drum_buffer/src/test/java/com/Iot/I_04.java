package com.Iot;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class I_04 extends BaseTest{

	Device a;
	@Test
	protected void device() {
		ReportSetup.test=ReportSetup.report.createTest("Device page");
		ReportSetup.test.assignCategory("I-3");
		a = new Device(driver);
		a.home();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to Assets page");
		a.device();
		ReportSetup.test.log(Status.PASS, "Successfully add equipment listing and check all functions");
		a.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

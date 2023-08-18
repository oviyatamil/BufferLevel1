package com.Iot;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;

import com.aventstack.extentreports.Status;

public class I_01 extends BaseTest{
Admin a;

@Test
protected void org() {
	ReportSetup.test=ReportSetup.report.createTest("ADMIN/ORGANISATION SCREEN");
	ReportSetup.test.assignCategory("I-1");
	a = new Admin(driver);
	a.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Admin page");
	a.loc();
	ReportSetup.test.log(Status.PASS, "Successfully add a location,department and zone");
	a.shift();
	ReportSetup.test.log(Status.PASS, "Successfully add a shift");
	a.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}
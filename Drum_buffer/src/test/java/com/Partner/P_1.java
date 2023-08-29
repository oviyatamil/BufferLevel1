package com.Partner;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class P_1 extends BaseTest{

	Home h;
	
	@Test
	protected void home() {
		ReportSetup.test=ReportSetup.report.createTest("Home screen");
		ReportSetup.test.assignCategory("P-1");
		h = new Home(driver);
		h.home();
		ReportSetup.test.log(Status.PASS, "Navigated to home page");
		h.cards();
		ReportSetup.test.log(Status.PASS, "Successfully checked card count and table values");
		h.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
	
}

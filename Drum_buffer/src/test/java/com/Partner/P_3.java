package com.Partner;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class P_3 extends BaseTest{

	Supplier c;
	
	@Test
	protected void home() {
		ReportSetup.test=ReportSetup.report.createTest("Home screen");
		ReportSetup.test.assignCategory("P-1");
		c = new Supplier(driver);
		c.home();
		ReportSetup.test.log(Status.PASS, "Navigated to home page");
		c.add();
		ReportSetup.test.log(Status.PASS, "Successfully added a buyer,supplier and checked functions like cancel and delete");
		c.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

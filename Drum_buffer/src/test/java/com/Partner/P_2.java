package com.Partner;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class P_2 extends BaseTest {

	Customer c;
	@Test
	protected void home() {
		ReportSetup.test=ReportSetup.report.createTest("Customer screen");
		ReportSetup.test.assignCategory("P-1");
		c = new Customer(driver);
		c.home();
		ReportSetup.test.log(Status.PASS, "Navigated to home page");
		c.add();
		ReportSetup.test.log(Status.PASS, "Successfully added a customer,sie,subscription and checked all functions like view,edit,cancel and delete");
		c.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

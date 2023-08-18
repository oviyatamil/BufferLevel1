package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Home;
import com.aventstack.extentreports.Status;

public class SA_005 extends BaseTest {
Home h;


@Test
protected void Home() {
	ReportSetup.test=ReportSetup.report.createTest("Home page");
	ReportSetup.test.assignCategory("SA5");
	h = new Home(driver);
	h.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
	h.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked card count,charts and table");
	h.pagination();
	ReportSetup.test.log(Status.PASS, "Successfully checked the pagination");
	h.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

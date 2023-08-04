package org.Oee;


import org.OeeMonitoring.Reports_loss;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_011 extends BaseTest{
Reports_loss r;

@Test
protected void lossreport() {
	r = new Reports_loss(driver);
	ReportSetup.test = ReportSetup.report.createTest("REPORTS LOSS PAGE");
	ReportSetup.test.assignCategory("Oee-11");
	r.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	r.rep();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to loss time reports page");
	r.dd();
	ReportSetup.test.log(Status.PASS, "Successfully selected all dropdowns and checked record and all dropdowns");
	r.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

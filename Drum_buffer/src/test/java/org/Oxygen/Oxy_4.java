package org.Oxygen;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Oxy_4 extends BaseTest{
Oxygen_reports r;

@Test
protected void report() {
	r= new Oxygen_reports(driver);
	ReportSetup.test = ReportSetup.report.createTest("OXYGEN REPORTS SCREEN");
	ReportSetup.test.assignCategory("OXY-4");
	r.home();
	ReportSetup.test.log(Status.PASS, "Navigates to oxygen home page");
	r.report();
	ReportSetup.test.log(Status.PASS, "Navigates to reports->monthly page");	
	r.dd2();
	ReportSetup.test.log(Status.PASS, "Successfully handled dropdown and calendar and check table");
	r.report2();
	ReportSetup.test.log(Status.PASS, "Navigates to reports->hourly page");	
	r.dd();
	ReportSetup.test.log(Status.PASS, "Successfully handled dropdown and calendar and check table");
	r.report3();
	ReportSetup.test.log(Status.PASS, "Navigates to reports->daily page");	
	r.dd2();
	ReportSetup.test.log(Status.PASS, "Successfully handled dropdown and calendar and check table");
	r.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

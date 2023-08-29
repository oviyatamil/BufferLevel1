package org.Energy;

import org.energy.Energy_reports;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_4 extends BaseTest{
Energy_reports r;


@Test(groups="Energy")
protected void report() {
	r= new Energy_reports(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY REPORTS SCREEN");
	ReportSetup.test.assignCategory("E-4");
	r.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
	r.report();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy reports page");
	r.dd();
	ReportSetup.test.log(Status.PASS, "Successfully checked the tables and date");
	r.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

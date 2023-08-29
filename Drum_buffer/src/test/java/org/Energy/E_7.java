package org.Energy;

import org.energy.Energy_rep;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_7 extends BaseTest{
Energy_rep r;

@Test(groups="Energy")
protected void customreport() {
	r= new Energy_rep(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY REPORTS and CUSTOM REPORT SCREEN");
	ReportSetup.test.assignCategory("E-5");
	r.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
	r.report2();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy  reports page");
	r.dd2();
	ReportSetup.test.log(Status.PASS, "Successfully checked the reporttable and date");
	r.report();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy custom reports page");
	r.dd();
	ReportSetup.test.log(Status.PASS, "Successfully checked the reporttable and date");
	r.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

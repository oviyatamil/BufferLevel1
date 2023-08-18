package org.Energy;

import org.energy.Energy_custom;
import org.energy.Energy_rep;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_7 extends BaseTest{
Energy_rep r;

@Test
protected void customreport() {
	r= new Energy_rep(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY CUSTOM REPORTS SCREEN");
	ReportSetup.test.assignCategory("E-5");
	r.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
	r.report();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy custom reports page");
	r.dd2();
	ReportSetup.test.log(Status.PASS, "Successfully checked the reporttable and date");
	r.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

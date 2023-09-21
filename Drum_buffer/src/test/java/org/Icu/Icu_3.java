package org.Icu;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Icu_3 extends BaseTest{

	Registration r;
	@Test
	protected void home() {
		r= new Registration(driver);
		ReportSetup.test=ReportSetup.report.createTest("Digital ICU Patient registration and monitor movement screen");
		ReportSetup.test.assignCategory("D-3");
		r.home();
		ReportSetup.test.log(Status.PASS, "Navigates to Home page");
		r.digital();
		ReportSetup.test.log(Status.PASS, "Navigates to Live patient screen");
		r.patient();
		ReportSetup.test.log(Status.PASS, "Navigates to oee home page");
		r.radio();
		ReportSetup.test.log(Status.PASS, "Patient is added and view,cancel option is checked");
		r.monitor();
		ReportSetup.test.log(Status.PASS, "Monitor movement option is clicked and checked");
		r.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

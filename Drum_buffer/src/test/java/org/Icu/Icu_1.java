package org.Icu;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Icu_1 extends BaseTest{
Home h;


@Test
protected void home() {
	h= new Home(driver);
	ReportSetup.test=ReportSetup.report.createTest("Digital ICU home screen");
	ReportSetup.test.assignCategory("D-1");
	h.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Home page");
	h.digital();
	ReportSetup.test.log(Status.PASS, "Navigates to digital screen");
	h.admit();
	ReportSetup.test.log(Status.PASS, "successfully get admit count and check patient data in home page");
	h.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

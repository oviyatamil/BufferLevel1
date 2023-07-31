package org.Fire;

import org.fire.Home_page;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class F_1 extends BaseTest{
Home_page h;

@Test
protected void home() {
	h= new Home_page(driver);
	ReportSetup.test = ReportSetup.report.createTest("HOME SCREEN");
	ReportSetup.test.assignCategory("Fire-1");
	h.fire();
	ReportSetup.test.log(Status.PASS, "Navigates to fire home page");
	h.home();
	ReportSetup.test.log(Status.PASS, "Checks all location tables present in home page");
//	h.checklist();
	h.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

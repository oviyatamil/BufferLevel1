package org.quality;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_5 extends BaseTest{
Quality_ProductionEntry pe;



@Test
protected void production_inspection() {
	pe = new Quality_ProductionEntry(driver);
	ReportSetup.test = ReportSetup.report.createTest("QUALITY PRODUCTION and INSPECTION SCREEN");
	ReportSetup.test.assignCategory("Q-5");
	pe.home();
	ReportSetup.test.log(Status.PASS, "Navigates to quality home page");
	pe.production();
	ReportSetup.test.log(Status.PASS, "Navigates to production page");
	pe.add();
	ReportSetup.test.log(Status.PASS, "Succesfully added production entry");
	pe.inspection();
	ReportSetup.test.log(Status.PASS, "Navigates to Inspection entry page");
	pe.dd();
	ReportSetup.test.log(Status.PASS, "Succesfully added characteristics listing and checked view,edit,delete and cancel button");
	pe.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

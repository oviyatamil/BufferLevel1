package org.Sqa;


import org.sqa.Parts;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class S_4 extends BaseTest{

	Parts qp;
	
	@Test
	protected void qualityparts() {
		qp = new Parts(driver);
		ReportSetup.test = ReportSetup.report.createTest("PARTS SCREEN");
		ReportSetup.test.assignCategory("Q-4");
		qp.home();
		ReportSetup.test.log(Status.PASS, "Navigates to sqa home page");
		qp.parts();
		ReportSetup.test.log(Status.PASS, "Navigates to Parts page");
		qp.add();
		ReportSetup.test.log(Status.PASS, "Succesfully added parts listing");
		qp.check();
		ReportSetup.test.log(Status.PASS, "Successfully checked view,edit,delete and cancel button");
		qp.plan();
		ReportSetup.test.log(Status.PASS, "Successfully added inspection plan");
		qp.characteristics();
		ReportSetup.test.log(Status.PASS, "Succesfully added characteristics listing and checked view,edit,delete and cancel button");
		qp.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

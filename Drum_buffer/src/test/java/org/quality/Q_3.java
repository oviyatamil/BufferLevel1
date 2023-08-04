package org.quality;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_3 extends BaseTest{
Quality_Plant qp;

@Test
protected void qualityplantmanager() {
	qp = new Quality_Plant(driver);
	ReportSetup.test = ReportSetup.report.createTest("PLANT MANAGER SCREEN");
	ReportSetup.test.assignCategory("Q-3");
	qp.home();
	ReportSetup.test.log(Status.PASS, "Navigates to quality home page");
	qp.plantmanager();
	ReportSetup.test.log(Status.PASS, "Navigates to Plant manager page");
	qp.dd();
	ReportSetup.test.log(Status.PASS, "Handled dropdown and checked card count and charts");
	qp.exports();
	ReportSetup.test.log(Status.PASS, "Successfully checked exports and pdf options");
	qp.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}



}

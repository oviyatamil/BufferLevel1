package org.quality;


import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_1 extends BaseTest{
Quality_Control qc;

@Test
protected void qualitycontrol() {
	qc = new Quality_Control(driver);
	ReportSetup.test = ReportSetup.report.createTest("CONTROL CHART SCREEN");
	ReportSetup.test.assignCategory("Q-1");
	qc.home();
	ReportSetup.test.log(Status.PASS, "Navigates to quality home page");
	qc.controlchart();
	ReportSetup.test.log(Status.PASS, "Navigates to control chart page");
	qc.dd();
	ReportSetup.test.log(Status.PASS, "Handled dropdown and checked card count and charts");
	qc.exports();
	ReportSetup.test.log(Status.PASS, "Successfully checked exports and pdf options");
	qc.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}



}

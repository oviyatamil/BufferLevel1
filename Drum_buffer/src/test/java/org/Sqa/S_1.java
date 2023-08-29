package org.Sqa;

import org.sqa.Control;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class S_1 extends BaseTest{
	
	Control c;
	
	@Test
	protected void qualitycontrol() {
		c = new Control(driver);
		ReportSetup.test = ReportSetup.report.createTest("CONTROL CHART SCREEN");
		ReportSetup.test.assignCategory("Q-1");
		c.home();
		ReportSetup.test.log(Status.PASS, "Navigates to sqa home page");
		c.controlchart();
		ReportSetup.test.log(Status.PASS, "Navigates to control chart page");
		c.dd();
		ReportSetup.test.log(Status.PASS, "Handled dropdown and checked card count and charts");
		c.exports();
		ReportSetup.test.log(Status.PASS, "Successfully checked exports and pdf options");
		c.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

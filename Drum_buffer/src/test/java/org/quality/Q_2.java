package org.quality;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_2 extends BaseTest{
Quality_Analytics qa;

	@Test
	protected void qualityanalytic() {
		qa = new Quality_Analytics(driver);
		ReportSetup.test = ReportSetup.report.createTest("ANALYTICS SCREEN");
		ReportSetup.test.assignCategory("Q-2");
		qa.home();
		ReportSetup.test.log(Status.PASS, "Navigates to quality home page");
		qa.controlchart();
		ReportSetup.test.log(Status.PASS, "Navigates to Analytics page");
		qa.dd();
		ReportSetup.test.log(Status.PASS, "Handled dropdown and checked card count and charts");
		qa.exports();
		ReportSetup.test.log(Status.PASS, "Successfully checked exports and pdf options");
		qa.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}



}

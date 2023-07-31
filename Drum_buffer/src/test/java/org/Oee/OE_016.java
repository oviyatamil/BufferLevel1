package org.Oee;

import org.OeeMonitoring.OeeMonitoring;
import org.OeeMonitoring.Storyboard;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_016 extends BaseTest{
Storyboard s;


@Test
protected void storyboard() {
	
	s = new Storyboard(driver);
	ReportSetup.test = ReportSetup.report.createTest("STORY BOARD SCREEN");
	ReportSetup.test.assignCategory("Oee-16");
	s.oee();
	ReportSetup.test.log(Status.PASS, "Navigates to oee home page");
	s.storyboard();
	ReportSetup.test.log(Status.PASS, "Navigates to oee monitoring page");
	s.data();
	ReportSetup.test.log(Status.PASS, "Navigates to oee monitoring page");
	ReportSetup.test.log(Status.PASS, "Successfully click equipment dropdown and get status of Overall OEE,Spindle,Availability,Performance,Quality ");
	ReportSetup.test.log(Status.PASS, "Get status of OEE,Spindle,Availability,Performance,Quality High and low hour percentages in both record and in table");
	ReportSetup.test.log(Status.PASS, "Get status of Overall Active,Idle,alert,down percentages ");
	s.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


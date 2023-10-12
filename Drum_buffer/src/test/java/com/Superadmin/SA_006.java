package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Controlchart;
import com.aventstack.extentreports.Status;

public class SA_006 extends BaseTest{
Controlchart c;

@Test
protected void controlcenter() {
	ReportSetup.test=ReportSetup.report.createTest("Control center page");
	ReportSetup.test.assignCategory("SA6");
	c = new Controlchart(driver);
	c.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
	c.control();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to control chart page");
	c.submenu();
	ReportSetup.test.log(Status.PASS, "Successfully checked card counts and table");
	c.api();
	ReportSetup.test.log(Status.PASS, "Successfully checked card counts and charts");
	c.jobmon();
	ReportSetup.test.log(Status.PASS, "Successfully checked card counts");
//	c.add();
//	ReportSetup.test.log(Status.PASS, "Successfully add a job");
	c.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked chart");
//	c.radio();
//	ReportSetup.test.log(Status.PASS, "Successfully checked view,edit,cancel and delete option");
	c.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

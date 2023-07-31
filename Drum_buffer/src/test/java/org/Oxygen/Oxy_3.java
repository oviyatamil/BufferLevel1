package org.Oxygen;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Oxy_3 extends BaseTest{
Oxygen_analytics oa;


@Test
protected void analytics() {
	oa= new Oxygen_analytics(driver);
	ReportSetup.test = ReportSetup.report.createTest("OXYGEN ANALYTICS SCREEN");
	ReportSetup.test.assignCategory("OXY-3");
	oa.home();
	ReportSetup.test.log(Status.PASS, "Navigates to oxygen home page");
	oa.analytic();
	ReportSetup.test.log(Status.PASS, "Navigates to oxygen analytics page");	
	oa.dd();
	ReportSetup.test.log(Status.PASS, "Successfully handled dropdown and calendar and check charts");
	oa.heatmaphome();
	ReportSetup.test.log(Status.PASS, "Navigated to oxygen monitoring analytics heatmap page");
	oa.heatmap();
	ReportSetup.test.log(Status.PASS, "Successfully checked charts,legends and slider");
	oa.equipment();
	ReportSetup.test.log(Status.PASS, "Navigated to oxygen monitoring analytics equipment wise consumption page");
	oa.equipchart();
	ReportSetup.test.log(Status.PASS, "Successfully checked charts and legends");
	oa.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

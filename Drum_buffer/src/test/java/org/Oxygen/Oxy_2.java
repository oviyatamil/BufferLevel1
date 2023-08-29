package org.Oxygen;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Oxy_2 extends BaseTest{
Oxygen_monitoring om;

@Test(groups="Oxygen")
protected void monitor() {
	om= new Oxygen_monitoring(driver);
	ReportSetup.test = ReportSetup.report.createTest("OXYGEN MONITORING SCREEN");
	ReportSetup.test.assignCategory("OXY-2");
	om.home();
	ReportSetup.test.log(Status.PASS, "Navigates to oxygen home page");
	om.monitor();		
	ReportSetup.test.log(Status.PASS, "Navigates to oxygen monitoring page");	
	om.dd();
	ReportSetup.test.log(Status.PASS, "Successfully handled dropdown and calendar and check charts");	
	
	om.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked charts and legends");
	om.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

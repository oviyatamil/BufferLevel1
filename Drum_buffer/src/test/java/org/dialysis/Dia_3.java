package org.dialysis;

import org.Dialysis.Monitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Dia_3 extends BaseTest{
Monitoring m;

@Test
protected void monitor() {
	m= new Monitoring(driver);
	ReportSetup.test = ReportSetup.report.createTest("DIALYSIS MONITORING SCREEN");
	ReportSetup.test.assignCategory("Dia-3");
	m.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Dialysis home page");
	m.monitor();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to dialysis monitoring page");
	m.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked chart and legend");
	m.dd();
	ReportSetup.test.log(Status.PASS, "Successfully selected dropdown and calendar option");	
	m.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

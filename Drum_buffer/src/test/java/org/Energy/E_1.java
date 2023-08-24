package org.Energy;

import org.energy.Energy_home;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_1 extends BaseTest{
Energy_home e;
@Test
protected void home() {
	e= new Energy_home(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY HOME AND KPI SCREEN");
	ReportSetup.test.assignCategory("E-1");
	e.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
	e.epi();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy kpi page");
	e.chart2();
	ReportSetup.test.log(Status.PASS, "Successfully checked all charts");
	e.charts();
	ReportSetup.test.log(Status.PASS, "Successfully checked all charts and mouseover");	
	e.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


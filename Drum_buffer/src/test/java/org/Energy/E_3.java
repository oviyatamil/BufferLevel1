package org.Energy;


import org.energy.Energy_Analytics;
import org.energy.Energy_monitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_3 extends BaseTest{
Energy_Analytics ea;

@Test
protected void analytic() {
	ea= new Energy_Analytics(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY ANALYTICS SCREEN");
	ReportSetup.test.assignCategory("E-3");
	ea.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
//	ea.analytic();
//	ReportSetup.test.log(Status.PASS, "Navigates to Energy live monitoring page");
//	ea.dd();
//	ReportSetup.test.log(Status.PASS, "Successfully checked all tables and card count");
//	ea.chart();
//	ReportSetup.test.log(Status.PASS, "Navigates to Energy liveflow analysis page");
	ea.heatmaphome();
	ReportSetup.test.log(Status.PASS, "Successfully checked all flow diagram");
	ea.heatmap();
	ReportSetup.test.log(Status.PASS, "Successfully checked all heatmap for all loctaion");
	ea.paret();
	ReportSetup.test.log(Status.PASS, "Navigates to Pareto analysis page");
	ea.paretchart();
	ReportSetup.test.log(Status.PASS, "Successfully checked all charts and table");
	ea.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}



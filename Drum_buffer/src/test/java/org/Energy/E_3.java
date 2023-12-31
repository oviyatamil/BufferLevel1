package org.Energy;


import org.energy.Energy_Analytics;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_3 extends BaseTest{
Energy_Analytics ea;

@Test(groups="Energy")
protected void analytic() {
	ea= new Energy_Analytics(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY ANALYTICS SCREEN");
	ReportSetup.test.assignCategory("E-3");
	ea.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
	ea.analytic();
	ReportSetup.test.log(Status.PASS, "Navigates to Analytics-> consumption page");		
	ea.dd();
	ReportSetup.test.log(Status.PASS, "Successfully checked all charts and mouseover action");
	ea.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked legends");
	ea.heatmaphome();
	ReportSetup.test.log(Status.PASS, "Navigates to Analytics-> heatmap page");
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



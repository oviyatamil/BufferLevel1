package org.dialysis;

import org.Dialysis.Analytics;
import org.Dialysis.Kpi_dialysis;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Dia_4 extends BaseTest{
Analytics a;

@Test
protected void analytics() {
	a= new Analytics(driver);
	ReportSetup.test = ReportSetup.report.createTest("DIALYSIS ANALYTICS SCREEN");
	ReportSetup.test.assignCategory("Dia-4");
	a.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Dialysis home page");
	a.analytic();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to analytics trend page");
	a.dd();
	ReportSetup.test.log(Status.PASS, "Successfully selected dropdown and handled calendar");
	a.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked legends in charts and export option");
	a.heatmaphome();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to heatmap page");
	a.heatmap();
	ReportSetup.test.log(Status.PASS, "Successfully checked heatmap mouseover and slider option in heatmap page");
	a.diasumhome();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to dialysis summary page");
	a.heatmap();
	ReportSetup.test.log(Status.PASS, "Successfully checked heatmap mouseover and slider option in dialysis summary page");
	a.map();
	ReportSetup.test.log(Status.PASS, "Successfully checked Diaysis machine percentage chart and FTM,FTD chart in dialysis summary page");
	a.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

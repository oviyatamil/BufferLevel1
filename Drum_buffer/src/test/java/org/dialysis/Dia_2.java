package org.dialysis;

import org.Dialysis.Dialysis;
import org.Dialysis.Kpi_dialysis;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Dia_2 extends BaseTest{
Kpi_dialysis kd;

@Test
protected void kpi() {
	kd= new Kpi_dialysis(driver);
	ReportSetup.test = ReportSetup.report.createTest("KPI MACHINE UTILIZATION SCREEN");
	ReportSetup.test.assignCategory("Dia-2");
	kd.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Dialysis home page");
	kd.kpi();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to kpi page");
	kd.table();
	ReportSetup.test.log(Status.PASS, "Successfully checked timestamp and running hours");
	kd.percent();
	ReportSetup.test.log(Status.PASS, "Successfully checked active and inactive percentages for each equipment");
	kd.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


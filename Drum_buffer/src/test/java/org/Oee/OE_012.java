package org.Oee;

import org.OeeMonitoring.Kpi_oee;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_012 extends BaseTest{
	Kpi_oee k;
	@Test
	protected void kpioee() {
		
		k = new Kpi_oee(driver);
		ReportSetup.test = ReportSetup.report.createTest("KPI OEE ANALYSIS SCREEN");
		ReportSetup.test.assignCategory("Oee-12");
		k.oee();
		ReportSetup.test.log(Status.PASS, "Navigates to oee home page");
		k.kpi();
		ReportSetup.test.log(Status.PASS, "Navigates to kpi page");
		k.data();
		ReportSetup.test.log(Status.PASS, "Successfully checked all datas");
	}
}

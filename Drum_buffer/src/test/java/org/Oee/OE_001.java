package org.Oee;

import java.io.PrintStream;

import org.OeeMonitoring.OeeMonitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Master_menu;
import com.aventstack.extentreports.Status;

public class OE_001 extends BaseTest {
	OeeMonitoring om;

	@Test
	protected void oeemonitoring() {
		
		om = new OeeMonitoring(driver);
		ReportSetup.test = ReportSetup.report.createTest("OEE MONITORING SCREEN");
		ReportSetup.test.assignCategory("Oee-1");
		om.oee();
		ReportSetup.test.log(Status.PASS, "Navigates to oee home page");
		om.oeemonitor();
		ReportSetup.test.log(Status.PASS, "Navigates to oee monitoring page");
		om.data();
		ReportSetup.test.log(Status.PASS, "Successfully click equipment dropdown and get status of Overall OEE,Spindle,Availability,Performance,Quality ");
		ReportSetup.test.log(Status.PASS, "Get status of OEE,Spindle,Availability,Performance,Quality High and low hour percentages in both record and in table");
		ReportSetup.test.log(Status.PASS, "Get status of Overall Active,Idle,alert,down percentages ");
	}
}

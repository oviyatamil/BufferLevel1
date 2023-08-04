package org.Oee;

import org.OeeMonitoring.LiveMonitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_003 extends BaseTest {
LiveMonitoring live;

@Test
protected void livemonitor() {

	live = new LiveMonitoring(driver);
	ReportSetup.test = ReportSetup.report.createTest("Live MONITORING SCREEN");
	ReportSetup.test.assignCategory("Oee-3");
	live.oee();
	ReportSetup.test.log(Status.PASS, "Navigates to oee home page");
	live.livemonitor();
	ReportSetup.test.log(Status.PASS, "Navigates to live monitoring page");
	live.table();
	ReportSetup.test.log(Status.PASS, "Successfully get all datas from table and checked the timestamp");
	live.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logged out from application");
}
}

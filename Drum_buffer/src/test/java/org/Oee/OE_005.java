package org.Oee;

import org.OeeMonitoring.Analytics_Production;
import org.OeeMonitoring.SpindleMonitor;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_005 extends BaseTest{
Analytics_Production ap;
@Test
protected void analytics_prod() {
	ap = new Analytics_Production(driver);
	ReportSetup.test = ReportSetup.report.createTest("ANALYTICS PRODUCTION SCREEN");
	ReportSetup.test.assignCategory("Oee-5");
	ap.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	ap.analytics();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to  analytics production page");
	ap.calendar();
	ReportSetup.test.log(Status.PASS, "Successfully select the equipment and date");
	ap.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked chart values");
	ap.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logged out from application");
}
}

package org.Oee;

import org.OeeMonitoring.HomePage;
import org.OeeMonitoring.SpindleMonitor;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_004 extends BaseTest {
SpindleMonitor sp;
@Test
protected void spindle() {
	sp = new SpindleMonitor(driver);
	ReportSetup.test = ReportSetup.report.createTest("Spindle Monitoring Screen");
	ReportSetup.test.assignCategory("Oee-4");
	sp.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	sp.spindlemonitor();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to spindle monitor page");
	sp.chart();
	ReportSetup.test.log(Status.PASS, "Successfully checked charts timestamp");
	sp.dd();
	ReportSetup.test.log(Status.PASS, "Successfully checked the slider in graph");
	sp.profile();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	
	
}
}

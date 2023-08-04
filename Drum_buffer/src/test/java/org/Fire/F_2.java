package org.Fire;
import org.fire.Monitor;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class F_2 extends BaseTest {
Monitor m;

@Test
protected void fire() {
	m= new Monitor(driver);
	ReportSetup.test = ReportSetup.report.createTest("FIRE MONITORING SCREEN");
	ReportSetup.test.assignCategory("Fire-2");
	m.fire();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to fire monitoring home page");
	m.monitor();
	ReportSetup.test.log(Status.PASS, "Navigated to monitoring page and check if chart is displayed or not");
	m.report();
	ReportSetup.test.log(Status.PASS, "Navigated to reports page and check reports are displayed or not");
	m.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


package org.Oee;

import org.OeeMonitoring.Alerts;
import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_007 extends BaseTest {
	Alerts a;

	@Test
	protected void alerts() {
		a = new Alerts(driver);
		ReportSetup.test = ReportSetup.report.createTest("ALERTS PAGE");
		ReportSetup.test.assignCategory("Oee-7");
		a.oee();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
		a.alerts();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to alerts page");
		a.calendar();
		ReportSetup.test.log(Status.PASS, "Successfully get all alert messages for all equipments");
		a.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logot from the application");
	}
}

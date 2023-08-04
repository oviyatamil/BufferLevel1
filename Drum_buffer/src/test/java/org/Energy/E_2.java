package org.Energy;
import org.energy.Energy_monitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_2 extends BaseTest {

	Energy_monitoring em;
	@Test
	protected void monitoring() {
		em= new Energy_monitoring(driver);
		ReportSetup.test = ReportSetup.report.createTest("ENERGY MONITORING SCREEN");
		ReportSetup.test.assignCategory("E-2");
		em.home();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
		em.monitor();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy live monitoring page");
		em.chart();
		ReportSetup.test.log(Status.PASS, "Successfully checked all tables and card count");
		em.liveflowanalysis();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy liveflow analysis page");
		em.flow();
		ReportSetup.test.log(Status.PASS, "Successfully checked all flow diagram");
		em.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

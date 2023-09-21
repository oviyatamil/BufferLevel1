package org.Icu;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Icu_2 extends BaseTest{

	Live l;
	@Test
	protected void home() {
		l= new Live(driver);
		ReportSetup.test=ReportSetup.report.createTest("Digital ICU live patient and device monitoring screen");
		ReportSetup.test.assignCategory("D-2");
		l.home();
		ReportSetup.test.log(Status.PASS, "Navigates to Home page");
		l.digital();
		ReportSetup.test.log(Status.PASS, "Navigates to Live patient screen");
		l.live();
		ReportSetup.test.log(Status.PASS, "Navigates to oee home page");
		l.device();
		ReportSetup.test.log(Status.PASS, "Navigates to Device monitoring page");
		l.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

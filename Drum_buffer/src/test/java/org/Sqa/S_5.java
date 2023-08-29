package org.Sqa;
import org.sqa.Reports;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class S_5 extends BaseTest{

	Reports r;
	
	@Test
	protected void Report() {
		r= new Reports(driver);
		ReportSetup.test = ReportSetup.report.createTest("REPORTS SCREEN");
		ReportSetup.test.assignCategory("Q-6");
		r.home();
		ReportSetup.test.log(Status.PASS, "Navigates to sqa home page");
		r.usage();
		ReportSetup.test.log(Status.PASS, "Navigates to Reports->Usage page");
		r.use();
		ReportSetup.test.log(Status.PASS, "Successfully check data");
		r.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
		
	}
}

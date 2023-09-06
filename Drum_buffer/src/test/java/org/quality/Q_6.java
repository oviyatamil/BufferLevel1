package org.quality;


import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_6 extends BaseTest{
Reports_Inspection r;

@Test
protected void Report() {
	r= new Reports_Inspection(driver);
	ReportSetup.test = ReportSetup.report.createTest("REPORTS SCREEN");
	ReportSetup.test.assignCategory("Q-6");
	r.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Quality home page");
//	r.inspection();
//	ReportSetup.test.log(Status.PASS, "Navigates to Reports->Inspection page");
//	r.data();
//	ReportSetup.test.log(Status.PASS, "Successfully check data");
	r.usage();
	ReportSetup.test.log(Status.PASS, "Navigates to Reports->Usage page");
	r.use();
	ReportSetup.test.log(Status.PASS, "Successfully check data");
	r.audit();
	ReportSetup.test.log(Status.PASS, "Navigates to Reports->Audit page");
	r.aud();
	ReportSetup.test.log(Status.PASS, "Successfully check data");
	r.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	
}
}

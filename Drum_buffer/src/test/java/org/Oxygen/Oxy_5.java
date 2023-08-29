package org.Oxygen;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Oxy_5 extends BaseTest{

	
	Oxy_custom r;
	
	@Test
	protected void report() {
		r= new Oxy_custom(driver);
		ReportSetup.test = ReportSetup.report.createTest("OXYGEN REPORTS SCREEN");
		ReportSetup.test.assignCategory("OXY-4");
		r.home();
		ReportSetup.test.log(Status.PASS, "Navigates to oxygen home page");
		r.report();
		ReportSetup.test.log(Status.PASS, "Navigates to reports->monthly page");	
		r.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");	
}
}

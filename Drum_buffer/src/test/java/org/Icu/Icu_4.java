package org.Icu;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Icu_4 extends BaseTest{
	Settings r;
	@Test
	protected void home() {
		r= new Settings(driver);
		ReportSetup.test=ReportSetup.report.createTest("Settings screen");
		ReportSetup.test.assignCategory("D-4");
		r.home();
		ReportSetup.test.log(Status.PASS, "Navigates to Home page");
		r.bed();
		ReportSetup.test.log(Status.PASS, "Navigates to Bed allocation screen");
		r.add();
		ReportSetup.test.log(Status.PASS, "Add a bed and checked view,edit,delete option");		
		r.shiftlist();
		ReportSetup.test.log(Status.PASS, "Add a shift and checked view,edit,delete option");		
		r.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}
	
	


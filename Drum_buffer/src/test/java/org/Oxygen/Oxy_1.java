package org.Oxygen;

import org.Dialysis.Dialysis;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Oxy_1 extends BaseTest{
Oxygen o;

@Test
protected void home() {
	o= new Oxygen(driver);
	ReportSetup.test = ReportSetup.report.createTest("OXYGEN HOME SCREEN");
	ReportSetup.test.assignCategory("OXY-1");
	o.oxygen();
	ReportSetup.test.log(Status.PASS, "Navigates to oxygen home page");
	o.home();
	ReportSetup.test.log(Status.PASS, "Successfully check home page tables");	
	
	o.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


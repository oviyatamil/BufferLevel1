package org.Energy;


import org.energy.Energy_Analytics2;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_6 extends BaseTest{
Energy_Analytics2 ea2;


@Test
protected void analytic() {
	ea2= new Energy_Analytics2(driver);
	ReportSetup.test = ReportSetup.report.createTest("ENERGY ANALYTICS SCREEN 2");
	ReportSetup.test.assignCategory("E-6");
	ea2.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");
	ea2.analytic();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy->analytics->energy flow analysis page");
	ea2.eflows();
	ReportSetup.test.log(Status.PASS, "Successfully checked the floor wise chart");
	ea2.analytic2();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy->analytics->Variance analysis page");
	ea2.var();	
	ReportSetup.test.log(Status.PASS, "Successfully checked the bar diagram page");
	ea2.analytic3();
	ReportSetup.test.log(Status.PASS, "Navigates to Energy->analytics->Peak demand analysis page");
	ea2.peakdemand();
	ReportSetup.test.log(Status.PASS, "successfully checked the charts");
	ea2.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

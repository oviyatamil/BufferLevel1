package org.Energy;

import org.energy.Energy_custom;
import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class E_5 extends BaseTest{
Energy_custom ec;
	
@Test(groups="Energy")
	protected void customreport() {
		ec= new Energy_custom(driver);
		ReportSetup.test = ReportSetup.report.createTest("ENERGY CUSTOM REPORTS SCREEN");
		ReportSetup.test.assignCategory("E-5");
		ec.home();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy home page");	
		ec.report3();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy custom reports->daily page");
		ec.dd2();
		ReportSetup.test.log(Status.PASS, "Successfully checked the tables and date");
		ec.report4();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy custom reports->yearly page");
		ec.dd3();
		ReportSetup.test.log(Status.PASS, "Successfully checked the tables and date");
		ec.report5();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy custom reports->monthly page");
		ec.dd2();
		ReportSetup.test.log(Status.PASS, "Successfully checked the tables and date");
		ec.report2();
		ReportSetup.test.log(Status.PASS, "Navigates to Energy custom reports->hourly page");
		ec.dd4();
		ReportSetup.test.log(Status.PASS, "Successfully checked the tables and date");
		ec.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}


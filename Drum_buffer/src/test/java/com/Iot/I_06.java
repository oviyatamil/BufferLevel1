package com.Iot;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class I_06 extends BaseTest{

	
	Rule a;
	@Test
	protected void rule_engine() {
		ReportSetup.test=ReportSetup.report.createTest("Rule engine page");
		ReportSetup.test.assignCategory("I-6");
		a = new Rule(driver);
		a.home();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to rule engine page");
		a.rule();
		ReportSetup.test.log(Status.PASS, "Successfully checked the table records");
		a.rulelist();
		ReportSetup.test.log(Status.PASS, "Successfully added the rule list");
		a.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
}

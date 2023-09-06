package org.Oee;

import org.OeeMonitoring.Monkey;
import org.OeeMonitoring.OeeMonitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Monkey_1 extends BaseTest{
Monkey m;

@Test
protected void monkey() {
	
	m = new Monkey(driver);
	ReportSetup.test = ReportSetup.report.createTest("Monkey testing");
	ReportSetup.test.assignCategory("Mon-1");
	m.Login();
	ReportSetup.test.log(Status.PASS, "login to superadmin page");
	
}
	
	
	
}

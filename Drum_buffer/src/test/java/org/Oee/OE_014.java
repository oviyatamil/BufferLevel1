package org.Oee;

import org.OeeMonitoring.Reports_daily;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_014 extends BaseTest{
Reports_daily rd;
@Test
protected void dailyreport() {
	rd = new Reports_daily(driver);
	ReportSetup.test = ReportSetup.report.createTest("DAILY REPORTS PAGE");
	ReportSetup.test.assignCategory("Oee-14");
	rd.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	rd.rep();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to daily reports page");
	rd.dd();
	ReportSetup.test.log(Status.PASS, "Successfully selected all dropdown");
//	rd.table();
//	ReportSetup.test.log(Status.PASS, "Successfully get values from table");
	rd.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


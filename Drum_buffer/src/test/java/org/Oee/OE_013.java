package org.Oee;

import org.OeeMonitoring.Reports_spindle;
import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_013 extends BaseTest {
Reports_spindle rs;
@Test
protected void spindlereport() {
	rs = new Reports_spindle(driver);
	ReportSetup.test = ReportSetup.report.createTest("SPINDLE REPORTS PAGE");
	ReportSetup.test.assignCategory("Oee-13");
	rs.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	rs.rep();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to spindle time reports page");
	rs.dd();
	ReportSetup.test.log(Status.PASS, "Successfully select all dropdowns");
	rs.table();
	ReportSetup.test.log(Status.PASS, "Successfully checked table date");
	rs.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from the application");
}
}

package org.Oee;


import org.OeeMonitoring.Reports_prod;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_015 extends BaseTest{
	Reports_prod rp;
	
	@Test
	protected void prodreport() {
		rp = new Reports_prod(driver);
		ReportSetup.test = ReportSetup.report.createTest("REPORTS PRODUCTION PAGE");
		ReportSetup.test.assignCategory("Oee-15");
		rp.oee();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
		rp.rep();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to daily reports page");		
		rp.table2();
		ReportSetup.test.log(Status.PASS, "Successfully compares values from table table");
		rp.loss();
		ReportSetup.test.log(Status.PASS, "Successfully get loss table values from table");
		rp.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
		

}

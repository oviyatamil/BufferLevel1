package com.Superadmin;

import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Monitor_Device;
import com.aventstack.extentreports.Status;

public class SA_013 extends BaseTest{

	Monitor_Device m;
	@Test
	protected void monitor_device() {
		ReportSetup.test=ReportSetup.report.createTest("Monitor device screen");
		ReportSetup.test.assignCategory("SA13");
		m = new Monitor_Device(driver);
		m.home();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
		m.mondev();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to monitoring device screen");
		m.add();
		ReportSetup.test.log(Status.PASS, "Successfully added a device list");
		m.radio();
		ReportSetup.test.log(Status.PASS, "Successfully checked view,edit,delete and cancel option in Monitoring device list");	
		m.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
		
	}
	
}

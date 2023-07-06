package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Deploy;
import com.aventstack.extentreports.Status;

public class TC_009 extends BaseTest {
	Deploy deploy;
	
	@Test
	protected void platformdeploy() {
		ReportSetup.test =ReportSetup.report.createTest("PLATFORM DEPLOY SCREEN");
		//	ReportSetup.test.log(Status.INFO, "Started the test XXXXX: "+ ReportSetup.test.getStatus());
			
			ReportSetup.test.assignCategory("P8");
		deploy = new Deploy(driver);
		deploy.deploy();
		ReportSetup.test.log(Status.PASS, "successfully entered on the deploy module");
//		deploy.add();
//		ReportSetup.test.log(Status.PASS, "successfully add all the fields");
		deploy.other();
		ReportSetup.test.log(Status.PASS, "successfully entered on the listing page");
		deploy.listarrow();
		ReportSetup.test.log(Status.PASS, "successfully clicked all arrows");
		deploy.arrow();
		ReportSetup.test.log(Status.PASS, "successfully entered on the deploy module");
		deploy.pagination();
		ReportSetup.test.log(Status.PASS, "successfully verified pagination");
		deploy.search();
		ReportSetup.test.log(Status.PASS, "successfully entered the search text");
		deploy.signout();
		ReportSetup.test.log(Status.PASS,"signing out");
	}
	
	
	
}

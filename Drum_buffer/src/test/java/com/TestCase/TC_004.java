package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Home_Page;
import com.aventstack.extentreports.Status;

public class TC_004 extends BaseTest {
	Home_Page tc_005;
	@Test
	protected void tc_004() {
         ReportSetup.test=ReportSetup.report.createTest("HOME PAGE");
		
		ReportSetup.test.assignCategory("P3");
		tc_005 = new Home_Page(driver);
		tc_005.cost();
		ReportSetup.test.log(Status.PASS, "Successfully clicked costs option");
		tc_005.count();
		ReportSetup.test.log(Status.PASS, "Successfully get counts and cost of all fields");
		tc_005.ninedots();
		ReportSetup.test.log(Status.PASS, "Successfully clicked ninedots button");
		tc_005.ninedotsarrow();
		ReportSetup.test.log(Status.PASS, "Successfully clicked ninedotsarrow button");
		tc_005.help();
		ReportSetup.test.log(Status.PASS, "Successfully clicked help button");
		tc_005.guide();
		ReportSetup.test.log(Status.PASS, "Successfully clicked check guides option");
		tc_005.back();
		ReportSetup.test.log(Status.PASS, "Successfully clicked back button");
		tc_005.contact();
		ReportSetup.test.log(Status.PASS, "Successfully clicked contact us button");
	//	tc_005.back();
		
		tc_005.profileicon();
		ReportSetup.test.log(Status.PASS, "Successfully clicked profileicon button");
		tc_005.profile();
		ReportSetup.test.log(Status.PASS, "Successfully clicked profile button");
		tc_005.profileicon();
		tc_005.status();
		ReportSetup.test.log(Status.PASS, "Successfully clicked status button");
		tc_005.toggle();
		ReportSetup.test.log(Status.PASS, "Successfully clicked toggle button");
		tc_005.profileicon();
		tc_005.signout();
		ReportSetup.test.log(Status.PASS, "Successfully clicked signout button");
		
		
	}
}

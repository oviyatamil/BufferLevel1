package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Permission2;
import com.SuperadminPage.Uom;
import com.aventstack.extentreports.Status;

public class SA_012 extends BaseTest {
	Permission2 p;
	@Test
	protected void Permissioncheck() {
		ReportSetup.test = ReportSetup.report.createTest("Permission checking screen");
		ReportSetup.test.assignCategory("SA-12");
		p = new Permission2(driver);
	    p.home();
		p.permission();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to permission->role screen and add a role list");
		p.users();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to user screen and add a user list");
		p.profile();
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
		p.login();
		ReportSetup.test.log(Status.PASS, "Successfullyogin with newly created user login");
	    p.home();
	    p.check();
	    
	}
}

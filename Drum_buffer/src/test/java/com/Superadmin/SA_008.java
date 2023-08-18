package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Permission;
import com.aventstack.extentreports.Status;

public class SA_008 extends BaseTest{
Permission p;
@Test
protected void permission() {
	ReportSetup.test=ReportSetup.report.createTest("Permission");
	ReportSetup.test.assignCategory("SA7");
	p = new Permission(driver);
	p.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
	p.permission();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Permission page and added a role list");
	p.users();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to user page and added a user list");
	p.useradd();
	ReportSetup.test.log(Status.PASS, "Successfully checked view,edit,delete and cancel option in user list");
	p.perm();
	ReportSetup.test.log(Status.PASS, "Successfully checked view,edit,delete and cancel option in role list");
	p.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
//	p.login();
//	p.perm();
	
}
}

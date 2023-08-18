package com.Iot;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class I_02 extends BaseTest{
Admin_user au;
@Test
protected void user() {
	ReportSetup.test=ReportSetup.report.createTest("ADMIN/ORGANISATION->User management and master data SCREEN");
	ReportSetup.test.assignCategory("I-2");
	au = new Admin_user(driver);
	au.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Admin page");
//	au.user();
//	ReportSetup.test.log(Status.PASS, "Successfully add a role and user and check functions like view,edit,delete and cancel");
	au.equipcat();
	ReportSetup.test.log(Status.PASS, "Successfully go to master screen and add checked all functions in equipment category list,equipment type list and department list");
	au.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}

}

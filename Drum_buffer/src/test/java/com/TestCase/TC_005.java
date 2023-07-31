package com.TestCase;



import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Master_user;
import com.aventstack.extentreports.Status;

public class TC_005 extends BaseTest {
	Master_user tc_006;
	
	@Test
	protected void tc_005() {
		tc_006 = new Master_user(driver);
		ReportSetup.test=ReportSetup.report.createTest("MASTER USER SCREEN");
		ReportSetup.test.assignCategory("P3");
		tc_006.master();
		ReportSetup.test.log(Status.PASS, "successfully clicked the master button");
		tc_006.add();
		ReportSetup.test.log(Status.PASS, "successfully clicked the add button");
		tc_006.fn();
		ReportSetup.test.log(Status.PASS, "successfully entered the fullname");
		tc_006.role();
		ReportSetup.test.log(Status.PASS, "successfully clicked the rolename");
		tc_006.address();
		ReportSetup.test.log(Status.PASS, "successfully clicked the add button");
		tc_006.phno();
		ReportSetup.test.log(Status.PASS, "successfully entered the phno");
		tc_006.email();
		ReportSetup.test.log(Status.PASS, "successfully entered the email");
		tc_006.pwd();
		ReportSetup.test.log(Status.PASS, "successfully entered the password");
	//	tc_006.cancel();
		tc_006.save();
		ReportSetup.test.log(Status.PASS, "successfully clicked the save button");
		tc_006.arrow();
		ReportSetup.test.log(Status.PASS, "arrow clicked successfully");
		tc_006.radiobtn();
		ReportSetup.test.log(Status.PASS, "successfully clicked the radio button");
		tc_006.view();
		ReportSetup.test.log(Status.PASS, "successfully clicked on the view button");
		tc_006.cancel();
		ReportSetup.test.log(Status.PASS, "succesfully clicked on the cancel button");
		tc_006.radiobtn();
		tc_006.edit();
		ReportSetup.test.log(Status.PASS, "succesfully clicked on the edit button");
		tc_006.update();
		ReportSetup.test.log(Status.PASS, "succesfully clicked on update button");
		tc_006.radiobtn();
		tc_006.cancelbtn();
		ReportSetup.test.log(Status.PASS, "succesfully clicked on top cancel button");
		tc_006.radiobtn();
		tc_006.delete();
		ReportSetup.test.log(Status.PASS, "Record deleted successfully");
		//tc_006.list();
		tc_006.pagination();
		ReportSetup.test.log(Status.PASS, "Pagination done successfully");
		tc_006.search();
		ReportSetup.test.log(Status.PASS, "succesfully clicked on search button");
		tc_006.profile();
		ReportSetup.test.log(Status.PASS, "Successfully clicked profile button");
		tc_006.signout();
		ReportSetup.test.log(Status.PASS, "Successfully clicked signout button");
	}
}

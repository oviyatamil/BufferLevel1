package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;

import com.Pages.Master_product;
import com.aventstack.extentreports.Status;

public class TC_006 extends BaseTest {
Master_product tc_007;
	
	@Test
	protected void tc_005() {
		tc_007 = new Master_product(driver);
		ReportSetup.test=ReportSetup.report.createTest("MASTER PRODUCT SCREEN");
		ReportSetup.test.assignCategory("P4");
		tc_007.master();
		ReportSetup.test.log(Status.PASS,"Navigates to master product page");
		tc_007.arrow();
		ReportSetup.test.log(Status.PASS,"All arrow buttons are clicked");
		tc_007.addingfields();
		ReportSetup.test.log(Status.PASS,"All fields are added");
		tc_007.radiobutton();
		ReportSetup.test.log(Status.PASS,"Radio button is clicked");
		tc_007.pagination();
		ReportSetup.test.log(Status.PASS,"Pagedrop,page size,next page,previous page,last page,first page are clicked");
		tc_007.search();
		ReportSetup.test.log(Status.PASS,"Search text is entered and result was shown");
		tc_007.signout();
		ReportSetup.test.log(Status.PASS,"User signout from application");
}
}

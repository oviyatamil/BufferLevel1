package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Duplicate;
import com.aventstack.extentreports.Status;

public class TC_008 extends BaseTest{
	Duplicate d;
	
	
	@Test
	protected void tc_008() {
ReportSetup.test=ReportSetup.report.createTest("ACTIVE ELEMENTS CHECKING");
		
		ReportSetup.test.assignCategory("P6");
		d = new Duplicate(driver);
		d.active();
		ReportSetup.test.log(Status.PASS, "successfully check the Inactive and active elements in both master-product and product-product cateory screen");
		d.signout();
		ReportSetup.test.log(Status.PASS, "successfully signed out ");
	}
}

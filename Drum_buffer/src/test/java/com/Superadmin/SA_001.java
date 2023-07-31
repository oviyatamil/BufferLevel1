package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Part_partlisting;
import com.aventstack.extentreports.Status;

public class SA_001 extends BaseTest {
	Part_partlisting part;
	
	@Test
	protected void partlisting() {
		ReportSetup.test=ReportSetup.report.createTest("PARTNER - PART LISTING");
		ReportSetup.test.assignCategory("SA1");
		part = new Part_partlisting(driver);
		part.partners();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to Partner listing page");
		part.add();
		ReportSetup.test.log(Status.PASS, "Successfully add all the fields");
		part.radio();
		ReportSetup.test.log(Status.PASS, "Successfully done all actions like view,edit,cancel and delete");
		part.duplicate();
		ReportSetup.test.log(Status.PASS, "Successfully check duplicate entries");
		part.arrow();
		ReportSetup.test.log(Status.PASS, "Successfully clicked all arrows");
		part.pagination();
		ReportSetup.test.log(Status.PASS, "Successfully checked pagination");
		part.profile();
		ReportSetup.test.log(Status.PASS, "Successfully sign out");
		
	}
	
	
}

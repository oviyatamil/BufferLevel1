package org.quality;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_8 extends BaseTest{

Masters_ReferenceData mr;

@Test
protected void reference() {
	mr = new Masters_ReferenceData(driver);
	ReportSetup.test = ReportSetup.report.createTest("MASTER REFERENCE DATA SCREEN");
	ReportSetup.test.assignCategory("Q_8");
	mr.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Quality home page");
	mr.reference();
	ReportSetup.test.log(Status.PASS, "Navigates to Master->Reference data page");
	mr.instrument();
	ReportSetup.test.log(Status.PASS, "Successfully add instrument and checked duplicates and all options like view,edit,cancel and delete ");
	mr.characteristics();
	ReportSetup.test.log(Status.PASS, "Successfully add characteristics and checked duplicates and all options like view,edit,cancel and delete ");
	mr.frequency();
	ReportSetup.test.log(Status.PASS, "Successfully add frequency and checked duplicates and all options like view,edit,cancel and delete ");
	mr.control();
	ReportSetup.test.log(Status.PASS, "Successfully add control methods and checked duplicates and all options like view,edit,cancel and delete ");
	mr.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	
	
}
	
}

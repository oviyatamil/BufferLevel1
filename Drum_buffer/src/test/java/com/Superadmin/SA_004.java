package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Monitoring_Parameter;
import com.aventstack.extentreports.Status;

public class SA_004 extends BaseTest {
Monitoring_Parameter mp;



@Test
protected void monitoringParameter() {
	ReportSetup.test = ReportSetup.report.createTest("MASTER MONITORING PARAMETER SCREEN");
	ReportSetup.test.assignCategory("SA-4");
	mp = new Monitoring_Parameter(driver);
	mp.home();
	mp.monpar();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Master monitoring parameter screen");
	mp.add();
	ReportSetup.test.log(Status.PASS, "Successfully entered text into the fields");
	mp.radio();
	ReportSetup.test.log(Status.PASS,"Successfully checked view,edit,cancel and delete option");
	mp.duplicate();
	ReportSetup.test.log(Status.PASS,"Successfully checked the duplicates");
	mp.pagination();
	ReportSetup.test.log(Status.PASS,"Successfully done pagination");
	mp.arrow();
	ReportSetup.test.log(Status.PASS,"Successfully checked the arrows order");
	mp.search();
	ReportSetup.test.log(Status.PASS,"Successfully checked search field");
	mp.profile();
	ReportSetup.test.log(Status.PASS,"Successfully logout from this screen");




}
}

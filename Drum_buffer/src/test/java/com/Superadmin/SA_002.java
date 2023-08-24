package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Gateway_Type;
import com.aventstack.extentreports.Status;

public class SA_002 extends BaseTest{
	Gateway_Type g;
	
	@Test
	protected void gateway_type() {
		ReportSetup.test=ReportSetup.report.createTest("GATEWAY TYPE SCREEN");
		ReportSetup.test.assignCategory("SA2");
		g = new Gateway_Type(driver);
		g.home();
		g.device_gateway();
		ReportSetup.test.log(Status.PASS,"Successfully navigated to Device gateway type screen");
		g.add();
		ReportSetup.test.log(Status.PASS,"Successfully add all the fields");
		g.radio();
		ReportSetup.test.log(Status.PASS,"Successfully checked view,edit,cancel and delete option");
		g.gatelist();
		ReportSetup.test.log(Status.PASS,"Successfully checked the duplicates");
		g.gateway();
		ReportSetup.test.log(Status.PASS,"Successfully navigated to Device gateway screen");
		g.gatecheck();
		ReportSetup.test.log(Status.PASS,"Successfully checked view,edit,cancel and delete option");
		g.dots();
		ReportSetup.test.log(Status.PASS,"Successfully checked Sid,Sim and Notification submenus");
		g.pagination();
		ReportSetup.test.log(Status.PASS,"Successfully done pagination");
		g.arrow();
		ReportSetup.test.log(Status.PASS,"Successfully checked the arrows order");
		g.search();
		ReportSetup.test.log(Status.PASS,"Successfully checked search field");
		g.profile();
		ReportSetup.test.log(Status.PASS,"Successfully logout from this screen");
	}
}

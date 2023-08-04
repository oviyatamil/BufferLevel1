package org.tool;

import org.Toollife.Home_page;
import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class T_01 extends BaseTest {
Home_page h;
@Test
protected void home() {
	
	h = new Home_page(driver);
	ReportSetup.test = ReportSetup.report.createTest("TOOLLIFE HOME SCREEN");
	ReportSetup.test.assignCategory("T-1");
	h.tool();
	ReportSetup.test.log(Status.PASS, "Navigates to toollife home page");
	h.table();
	ReportSetup.test.log(Status.PASS, "Successfully click equipment dropdown and get status of Overall OEE,Availability,Performance,Quality,Part count,Program for all equipments ");
	h.sear();
	ReportSetup.test.log(Status.PASS, "Successfully checked all equipments search boxes ");
	h.profile();	
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}


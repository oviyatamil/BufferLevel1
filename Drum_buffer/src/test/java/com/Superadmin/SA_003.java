package com.Superadmin;

import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Uom;
import com.aventstack.extentreports.Status;

public class SA_003 extends BaseTest {
	Uom u;

	@Test
	protected void uom() {
		ReportSetup.test = ReportSetup.report.createTest("MASTER UOM SCREEN");
		ReportSetup.test.assignCategory("SA3");
		u = new Uom(driver);
		u.home();
		u.uom();
		ReportSetup.test.log(Status.PASS, "Successfully navigated to Master uom screen");
		u.add();
		ReportSetup.test.log(Status.PASS, "Successfully entered text into the fields");
		u.radio();
		ReportSetup.test.log(Status.PASS,"Successfully checked view,edit,cancel and delete option");
		u.duplicate();
		ReportSetup.test.log(Status.PASS,"Successfully checked the duplicates");
		u.pagination();
		ReportSetup.test.log(Status.PASS,"Successfully done pagination");
		u.arrow();
		ReportSetup.test.log(Status.PASS,"Successfully checked the arrows order");
		u.search();
		ReportSetup.test.log(Status.PASS,"Successfully checked search field");
		u.profile();
		ReportSetup.test.log(Status.PASS,"Successfully logout from this screen");
	}
}

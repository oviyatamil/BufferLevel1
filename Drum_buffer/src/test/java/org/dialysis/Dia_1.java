package org.dialysis;

import org.Dialysis.Dialysis;
import org.fire.Home_page;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Dia_1 extends BaseTest{
Dialysis d;


@Test
protected void home() {
	d= new Dialysis(driver);
	ReportSetup.test = ReportSetup.report.createTest("HOME SCREEN");
	ReportSetup.test.assignCategory("Dia-1");
	d.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Dialysis home page");
	d.monitor();
	ReportSetup.test.log(Status.PASS, "Successfully get all card counts");
	d.table();
	ReportSetup.test.log(Status.PASS, "Successfully checked timestamp and running hours");
	d.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

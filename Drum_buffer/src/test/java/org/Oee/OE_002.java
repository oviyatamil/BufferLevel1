package org.Oee;

import org.OeeMonitoring.HomePage;
import org.OeeMonitoring.OeeMonitoring;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_002 extends BaseTest{
HomePage home;


@Test
protected void homepage() {
	home = new HomePage(driver);
	ReportSetup.test = ReportSetup.report.createTest("HOME PAGE");
	ReportSetup.test.assignCategory("Oee-2");
	home.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	home.displaycards();
	ReportSetup.test.log(Status.PASS, "Successfully displayed the cards count");
	home.mouseover();
	ReportSetup.test.log(Status.PASS, "MOuseover in heatmap is done successfully");
	home.slider();
	ReportSetup.test.log(Status.PASS, "Successfully checked the slider");
	home.graph();
	ReportSetup.test.log(Status.PASS, "Successfully get graph datas");
	home.Ftm();
	ReportSetup.test.log(Status.PASS, "Successfully checked FTM and FTD analysis");
	home.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logged out from application");
}
}

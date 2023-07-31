package org.Oee;

import org.OeeMonitoring.Analytics_Maintenance;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_010 extends BaseTest{
Analytics_Maintenance am;


@Test
protected void maintenance() {
	am = new Analytics_Maintenance(driver);
	ReportSetup.test = ReportSetup.report.createTest("ANALYTICS MAINTENANCE PAGE");
	ReportSetup.test.assignCategory("Oee-10");
	am.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	am.main();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to analytics maintenance page");
	am.cards();
	ReportSetup.test.log(Status.PASS, "Successfully get display cards count");
	am.calendar();
	ReportSetup.test.log(Status.PASS, "Successfully checked all the charts for all equipments");
	am.chart();
	ReportSetup.test.log(Status.PASS, "Successfully downloaded overall page");
	am.mouseover();
	ReportSetup.test.log(Status.PASS, "Mouseover is working fine");
	am.slider();
	ReportSetup.test.log(Status.PASS, "Slider is working fine");
			
	am.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logot from the application");


}







}

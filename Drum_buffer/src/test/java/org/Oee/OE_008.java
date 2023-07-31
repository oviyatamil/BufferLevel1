package org.Oee;


import org.OeeMonitoring.Analytics_device;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_008 extends BaseTest {
Analytics_device ad;
@Test
protected void devicestatus() {
	ad = new Analytics_device(driver);
	ReportSetup.test = ReportSetup.report.createTest("ANALYTICS DEVICE STATUS PAGE");
	ReportSetup.test.assignCategory("Oee-8");
	ad.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	ad.devices();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to analytics device status page");
	ad.mouseover();
	ReportSetup.test.log(Status.PASS, "Mouseover is working fine");
	ad.calendar();
	ReportSetup.test.log(Status.PASS, "Successfully checked all the charts for all equipments");
	ad.chart();
	ReportSetup.test.log(Status.PASS, "Successfully downloaded the chart and overall page");
	ad.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logot from the application");
}
}



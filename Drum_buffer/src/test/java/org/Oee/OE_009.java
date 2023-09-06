package org.Oee;


import org.OeeMonitoring.Analytics_quality;
import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_009 extends BaseTest{
Analytics_quality aq;
@Test
protected void quality() {
	aq = new Analytics_quality(driver);
	ReportSetup.test = ReportSetup.report.createTest("ANALYTICS QUALITY PAGE");
	ReportSetup.test.assignCategory("Oee-9");
	aq.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	aq.quality();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to analytics quality page");
	aq.displaycards();
	ReportSetup.test.log(Status.PASS, "Successfully get display cards count");
	aq.chart();
	ReportSetup.test.log(Status.PASS, "Successfully downloaded the chart and overall page");	
	aq.calendar();
	ReportSetup.test.log(Status.PASS, "Successfully checked all the charts for all equipments");
	aq.slider();
	ReportSetup.test.log(Status.PASS, "Slider is working fine");
	aq.pareto();
	ReportSetup.test.log(Status.PASS, "Successfully checked pareto chart machine wise");	
//	aq.paret();
//	ReportSetup.test.log(Status.PASS, "Successfully checked pareto chart reason wise");	
	aq.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logot from the application");
}



}

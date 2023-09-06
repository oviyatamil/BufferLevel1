package org.Oee;

import org.OeeMonitoring.Analytics_Oeeheatmap;
import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class OE_006 extends BaseTest{
Analytics_Oeeheatmap ao;
@Test
protected void analyticsoee() {
	ao = new Analytics_Oeeheatmap(driver);
	ReportSetup.test = ReportSetup.report.createTest("ANALYTICS OEE HEATMAP");
	ReportSetup.test.assignCategory("Oee-6");
	ao.oee();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to oee home page");
	ao.analytics();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to analytics oee heatmap page");
	ao.calendar();
	ReportSetup.test.log(Status.PASS,"Successfully checked all oee heatmap charts for all equipments");
	ao.slider();
	ReportSetup.test.log(Status.PASS,"Successfully checked working of slider");
	ao.profile();
	ReportSetup.test.log(Status.PASS,"Successfully logout from applictaion");
}
}

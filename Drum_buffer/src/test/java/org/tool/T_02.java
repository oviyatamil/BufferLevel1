package org.tool;

import org.Toollife.Analytics;
import org.testng.annotations.Test;
import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class T_02 extends BaseTest{

	Analytics a;
	@Test
	protected void toollife() {
		
		a = new Analytics(driver);
		ReportSetup.test = ReportSetup.report.createTest("TOOLLIFE ANALYTICS SCREEN");
		ReportSetup.test.assignCategory("T-2");
		a.tool();
		ReportSetup.test.log(Status.PASS, "Navigates to toollife home page");
		a.alert();
		ReportSetup.test.log(Status.PASS, "Navigates to toollife alert page");
		a.dd();
		ReportSetup.test.log(Status.PASS, "Successfully checked datas from alert table");
		a.management();
		ReportSetup.test.log(Status.PASS, "Navigates to toollife management page");
		a.data();
		ReportSetup.test.log(Status.PASS, "Successfully checked datas from management table");
		a.profile();	
		ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	}
	}


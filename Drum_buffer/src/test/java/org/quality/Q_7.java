package org.quality;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Q_7 extends BaseTest{
Masters_QualityDefects mq;

@Test
protected void qualitydefects() {
	mq = new Masters_QualityDefects(driver);
	ReportSetup.test = ReportSetup.report.createTest("MASTER QUALITY DEFECTS SCREEN");
	ReportSetup.test.assignCategory("Q_7");
	mq.home();
	ReportSetup.test.log(Status.PASS, "Navigates to Quality home page");
	mq.Qualdef();
	ReportSetup.test.log(Status.PASS, "Navigates to Master->Quality defects page");
	mq.add();
	ReportSetup.test.log(Status.PASS, "Successfully add defect and checked duplicates and all options like view,edit,cancel and delete ");
	mq.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
	
	
}


}

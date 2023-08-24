package com.Superadmin;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.SuperadminPage.Product_list;
import com.aventstack.extentreports.Status;

public class SA_009 extends BaseTest{
Product_list p;


@Test
protected void Product() {
	ReportSetup.test=ReportSetup.report.createTest("PRODUCT SCREEN");
	ReportSetup.test.assignCategory("SA-09");
	p = new Product_list(driver);
	p.home();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Home page");
	p.prod();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Product listing page");
	p.prodlist();
	ReportSetup.test.log(Status.PASS, "Successfully get product list");
	p.subscription();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Subscription listing page");
	p.uom();
	ReportSetup.test.log(Status.PASS, "Successfully navigated to Subscription uom page");
	p.profile();
	ReportSetup.test.log(Status.PASS, "Successfully logout from application");
}
}

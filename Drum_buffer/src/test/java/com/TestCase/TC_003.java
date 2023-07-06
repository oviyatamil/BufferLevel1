package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Product_Pcategory;
import com.aventstack.extentreports.Status;

public class TC_003 extends BaseTest {

	
	Product_Pcategory tc_004;
	@Test
	protected void tc_003() {
		ReportSetup.test=ReportSetup.report.createTest("PRODUCT CATEGORY SCREEN");
		
		ReportSetup.test.assignCategory("P2");
		tc_004 = new Product_Pcategory(driver);
		tc_004.product();
		ReportSetup.test.log(Status.PASS, "successfully clicked on the product button");
		tc_004.procategory();
		ReportSetup.test.log(Status.PASS, "successfully clicked on the productcategory button");
		tc_004.add();
		ReportSetup.test.log(Status.PASS, "successfully clicked the add button in product category");
		tc_004.addpc();
		ReportSetup.test.log(Status.PASS, "successfully entered the product category");
//		tc_004.categorylist();
//		ReportSetup.test.log(Status.PASS, "successfully get the list of categories");
		tc_004.add2();
		ReportSetup.test.log(Status.PASS, "successfully clicked the add button in product mapping listing");
		tc_004.pcdrop();
		ReportSetup.test.log(Status.PASS, "successfully clicked the product category dropdown");
		tc_004.pnamedrop();
		ReportSetup.test.log(Status.PASS, "successfully clicked the product name dropdown");
		tc_004.save();
		ReportSetup.test.log(Status.PASS, "successfully clicked the save button");
		tc_004.order();
		ReportSetup.test.log(Status.PASS,"Successfully clicked the arrows button");
		tc_004.radiobtn();
		ReportSetup.test.log(Status.PASS, "successfully clicked the radio button");
		tc_004.view();
		ReportSetup.test.log(Status.PASS, "successfully clicked on the view button");
		tc_004.cancel();
		ReportSetup.test.log(Status.PASS, "successfully clicked on the cancel button");
//		tc_004.radiobtn();
//		tc_004.edit();
//		ReportSetup.test.log(Status.PASS, "succesfully clicked on the edit button");
//		tc_004.update();
//		ReportSetup.test.log(Status.PASS, "succesfully clicked on update button");
		tc_004.radiobtn();
		tc_004.cancelbtn();
		ReportSetup.test.log(Status.PASS, "succesfully clicked on top cancel button");
		tc_004.radiobtn();
		tc_004.delete();
		ReportSetup.test.log(Status.PASS, "successfully clicked the delete button");
		tc_004.pagedrop();
		ReportSetup.test.log(Status.PASS, "succesfully clicked page dropdown");
		tc_004.pagesize();
		ReportSetup.test.log(Status.PASS, "succesfully selected page size");
		tc_004.next();
		ReportSetup.test.log(Status.PASS, "succesfully clicked next page");
		tc_004.previous();
		ReportSetup.test.log(Status.PASS, "succesfully clicked previous page");
		tc_004.last();
		ReportSetup.test.log(Status.PASS, "succesfully clicked last page");
		tc_004.first();
		ReportSetup.test.log(Status.PASS, "succesfully clicked first page");
		tc_004.search();
		ReportSetup.test.log(Status.PASS, "succesfully entered search text");
		tc_004.profile();
		ReportSetup.test.log(Status.PASS, "Successfully clicked profile button");
		tc_004.signout();
		ReportSetup.test.log(Status.PASS, "Successfully clicked signout button");
	}
}

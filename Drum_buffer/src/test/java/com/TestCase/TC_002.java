package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Business_vertical;
import com.aventstack.extentreports.Status;

public class TC_002 extends BaseTest{

	 Business_vertical tc_003;
		@Test
		protected void tc_002() {
			try {
			ReportSetup.test =ReportSetup.report.createTest("Business vertical screen");
		//	ReportSetup.test.log(Status.INFO, "Started the test XXXXX: "+ ReportSetup.test.getStatus());
			
			ReportSetup.test.assignCategory("P1");
			tc_003 = new Business_vertical(driver);
			tc_003.product();
			ReportSetup.test.log(Status.PASS, "successfully clicked on the product button");
			tc_003.businessvertical();
			ReportSetup.test.log(Status.PASS, "successfully clicked on the businessvertical button");
			tc_003.business_add();
			ReportSetup.test.log(Status.PASS, "successfully clicked on the business_add button");
			tc_003.businessname();
			ReportSetup.test.log(Status.PASS, "successfully entered the businessname field");
			tc_003.description();
			ReportSetup.test.log(Status.PASS, "successfully entered the description field");
			tc_003.active();
			ReportSetup.test.log(Status.PASS, "successfully clicked the active button");
			tc_003.save();
			ReportSetup.test.log(Status.PASS, "successfully clicked the save button");
			
			tc_003.arrow();
			ReportSetup.test.log(Status.PASS,"Successfully clicked arrow button");
			tc_003.pagedrop();
			ReportSetup.test.log(Status.PASS, "succesfully clicked page dropdown");
			tc_003.pagesize();
			ReportSetup.test.log(Status.PASS, "succesfully selected page size");
			tc_003.next();
			ReportSetup.test.log(Status.PASS, "succesfully clicked next page");
			tc_003.previous();
			ReportSetup.test.log(Status.PASS, "succesfully clicked previous page");
			tc_003.last();
			ReportSetup.test.log(Status.PASS, "succesfully clicked last page");
			tc_003.first();
			ReportSetup.test.log(Status.PASS, "succesfully clicked first page");
			
			
			tc_003.radiobtn();
			ReportSetup.test.log(Status.PASS, "successfully clicked the radio button");
			tc_003.view();
			ReportSetup.test.log(Status.PASS, "successfully clicked on the view button");
			tc_003.cancel();
			ReportSetup.test.log(Status.PASS, "succesfully clicked on the cancel button");
			tc_003.radiobtn();
			tc_003.edit();
			ReportSetup.test.log(Status.PASS, "succesfully clicked on the edit button");
			tc_003.update();
			ReportSetup.test.log(Status.PASS, "succesfully clicked on update button");
			tc_003.radiobtn();
			tc_003.cancelbtn();
			ReportSetup.test.log(Status.PASS, "succesfully clicked on top cancel button");
			tc_003.radiobtn();
			tc_003.delete();
			ReportSetup.test.log(Status.PASS, "succesfully deleted the record");
			tc_003.search();
			ReportSetup.test.log(Status.PASS, "succesfully entered search text");
			tc_003.profile();
			ReportSetup.test.log(Status.PASS, "Successfully clicked profile button");
			tc_003.signout();
			ReportSetup.test.log(Status.PASS, "Successfully clicked signout button");
			}catch (Exception e) {
				ReportSetup.test.log(Status.FAIL,e);
			}
			

}
}

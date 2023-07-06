package com.TestCase;

import org.testng.annotations.Test;

import com.BasePage.ReportSetup;
import com.BaseTest.BaseTest;
import com.Pages.Master_menu;
import com.Pages.Master_product;
import com.aventstack.extentreports.Status;

public class TC_007 extends BaseTest{
	Master_menu tc_008;
	@Test
	protected void tc_005() {
		tc_008 = new Master_menu(driver);
		ReportSetup.test=ReportSetup.report.createTest("MASTER MENU SCREEN");
		ReportSetup.test.assignCategory("P5");
		tc_008.menu();
		ReportSetup.test.log(Status.PASS,"Navigates to master menu page");
		tc_008.arrow();
		ReportSetup.test.log(Status.PASS,"All orders are clicked");
		
		tc_008.dots();
		ReportSetup.test.log(Status.PASS,"dot button is clicked");
		tc_008.add();
		ReportSetup.test.log(Status.PASS,"add button is clicked and data entered");
		tc_008.add2();
		ReportSetup.test.log(Status.PASS,"add2 button is clicked and data entered");
		tc_008.submenu();
		ReportSetup.test.log(Status.PASS,"submenu button is clicked and data entered");
		tc_008.submenu2();
		ReportSetup.test.log(Status.PASS,"submenu2 button is clicked and data entered");
		tc_008.radio();
		ReportSetup.test.log(Status.PASS,"Radio button is clicked and validation for view,edit,cancel and delete done");
		
		tc_008.productdup();
		ReportSetup.test.log(Status.PASS,"Compares product in master-menu and master-product");
		tc_008.menu();
		ReportSetup.test.log(Status.PASS,"Navigates to master menu page");
		tc_008.pagination();
		ReportSetup.test.log(Status.PASS,"Pagination is done");
		tc_008.search();
		ReportSetup.test.log(Status.PASS,"Search text is entered");
		tc_008.signout();
		ReportSetup.test.log(Status.PASS,"signing out");
}
}
